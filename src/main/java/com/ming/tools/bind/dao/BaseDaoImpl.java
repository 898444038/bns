package com.ming.tools.bind.dao;


import com.ming.tools.bind.anno.BindTable;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDaoImpl<T> {

    /** 操作常量 */
    public static final String SQL_INSERT = "insert";
    public static final String SQL_UPDATE = "update";
    public static final String SQL_DELETE = "delete";
    public static final String SQL_SELECT = "select";

    private PreparedStatement statement;

    private String sql;

    private Object argType[];

    private ResultSet rs;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {}

    public Long add(T t) {
        Long id = null;
        sql = this.getSql(SQL_INSERT,t);   //获取sql.
        try {
            argType = setArgs(t, SQL_INSERT);
            statement = JdbcDaoHelper.getPreparedStatementReturnKey(sql);  //实例化PreparedStatement.
            //为sql语句赋值.
            statement = JdbcDaoHelper.setPreparedStatementParam(statement,argType);
            statement.executeUpdate(); //执行语句.
            // 检索由于执行此 Statement 对象而创建的所有自动生成的键
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong(1);
                System.out.println("数据主键：" + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcDaoHelper.release(statement, null);  //释放资源.
        }
        return id;
    }

    public void delete(T t) {
        sql = this.getSql(SQL_DELETE,t);
        try {
            argType = this.setArgs(t, SQL_DELETE);
            statement = JdbcDaoHelper.getPreparedStatement(sql);
            statement = JdbcDaoHelper.setPreparedStatementParam(statement,argType);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcDaoHelper.release(statement, null);
        }
    }

    public void update(T t) {
        sql = this.getSql(SQL_UPDATE,t);
        try {
            argType = setArgs(t, SQL_UPDATE);
            statement = JdbcDaoHelper.getPreparedStatement(sql);
            statement = JdbcDaoHelper.setPreparedStatementParam(statement,argType);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcDaoHelper.release(statement, null);
        }
    }

    public T select(T t) {
        sql = this.getSql(SQL_SELECT,t);
        T obj = null;
        try {
            argType = setArgs(t, SQL_SELECT);
            statement = JdbcDaoHelper.getPreparedStatement(sql);
            statement = JdbcDaoHelper.setPreparedStatementParam(statement,argType);
            rs = statement.executeQuery();
            Field fields[] = t.getClass().getDeclaredFields();
            while (rs.next()) {
                obj = (T)t.getClass().newInstance();
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);
                    String type = fields[i].getGenericType().getTypeName();
                    if("java.lang.Boolean".equalsIgnoreCase(type)){
                        Integer flag = (Integer)rs.getObject(fields[i].getName());
                        if(flag == 0){
                            fields[i].set(obj, false);
                        }else if(flag == 1){
                            fields[i].set(obj, true);
                        }
                    }else{
                        fields[i].set(obj, rs.getObject(fields[i].getName()));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;

    }

    /*public T selectById(T t, Long key) {
        Class clazz = t.getClass();
        String tableName = null;
        if(clazz.isAnnotationPresent(BindTable.class)){
            BindTable bindTable = (BindTable)clazz.getAnnotation(BindTable.class);
            tableName = bindTable.tableName();
        }
        sql = "select * from " + tableName + " where id=?";
    }*/

    // sql拼接函数 形如 : insert into User(id,username,password,email,grade) values(?,?,?,?,?)
    private String getSql(String operator,T t) {
        Class clazz = t.getClass();
        StringBuffer sql = new StringBuffer();
        // 通过反射获取实体类中的所有变量
        Field fields[] = clazz.getDeclaredFields();
        String tableName = null;
        if(clazz.isAnnotationPresent(BindTable.class)){
            BindTable bindTable = (BindTable)clazz.getAnnotation(BindTable.class);
            tableName = bindTable.tableName();
        }

        // 插入操作
        if (operator.equals(SQL_INSERT)) {
            sql.append("insert into " + tableName);
            sql.append("(");
            for (int i = 0; fields != null && i < fields.length; i++) {
                fields[i].setAccessible(true);    //这句话必须要有,否则会抛出异常.
                String column = fields[i].getName();
                sql.append(column).append(",");
            }
            sql = sql.deleteCharAt(sql.length() - 1);
            sql.append(") values (");
            for (int i = 0; fields != null && i < fields.length; i++) {
                sql.append("?,");
            }
            sql.deleteCharAt(sql.length() - 1);
            // 是否需要添加分号
            sql.append(")");
        } else if (operator.equals(SQL_UPDATE)) {
            sql.append("update " + tableName + " set ");
            for (int i = 0; fields != null && i < fields.length; i++) {
                fields[i].setAccessible(true);
                String column = fields[i].getName();
                if (column.equals("id")) {
                    continue;
                }
                sql.append(column).append("=").append("?,");
            }
            sql.deleteCharAt(sql.length() - 1);
            sql.append(" where id=?");
        } else if (operator.equals(SQL_DELETE)) {
            sql.append("delete from " + tableName + " where id=?");
        } else if (operator.equals(SQL_SELECT)) {
            sql.append("select * from " + tableName + " where id=?");
        }
        System.out.println("执行"+operator+" : "+sql);
        return sql.toString();
    }

    // 获取参数.
    private Object[] setArgs(T entity, String operator)throws IllegalArgumentException, IllegalAccessException {
        Field fields[] = entity.getClass().getDeclaredFields();
        Object[] obj = null;
        if (operator.equals(SQL_INSERT)) {
            obj = new Object[fields.length];
            for (int i = 0; obj != null && i < fields.length; i++) {
                fields[i].setAccessible(true);
                obj[i] = fields[i].get(entity);
            }
            //return obj;
        } else if (operator.equals(SQL_UPDATE)) {
            Object Tempobj[] = new Object[fields.length];
            for (int i = 0; Tempobj != null && i < fields.length; i++) {
                fields[i].setAccessible(true);
                Tempobj[i] = fields[i].get(entity);
            }
            obj = new Object[fields.length];
            System.arraycopy(Tempobj, 1, obj, 0, Tempobj.length - 1);
            obj[obj.length - 1] = Tempobj[0];
            //return obj;
        } else if (operator.equals(SQL_DELETE)) {
            obj = new Object[1];
            fields[0].setAccessible(true);
            obj[0] = fields[0].get(entity);
            //return obj;
        } else if (operator.equals(SQL_SELECT)) {
            obj = new Object[1];
            fields[0].setAccessible(true);
            obj[0] = fields[0].get(entity);
            //return obj;
        }

        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (Object o : obj){
            sb.append(o+",");
        }
        sb.append("]");
        System.out.println("参数 : "+ sb.toString());
        return obj;
    }
}
