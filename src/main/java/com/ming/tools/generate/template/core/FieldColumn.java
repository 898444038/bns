package com.ming.tools.generate.template.core;

/**
 * Created by Administrator on 2019/9/12 0012.
 */
public class FieldColumn {

    private String fieldName;//属性名

    private String fieldValue;//属性值

    private String fieldType;//属性类型

    private String fieldColumn;//列名

    private String jdbcType;//列类型

    private String length;

    private Boolean isPrimaryKey;//是否主键

    private String comment;

    public FieldColumn() {}

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldColumn() {
        return fieldColumn;
    }

    public void setFieldColumn(String fieldColumn) {
        this.fieldColumn = fieldColumn;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public Boolean getPrimaryKey() {
        return isPrimaryKey;
    }

    public void setPrimaryKey(Boolean primaryKey) {
        isPrimaryKey = primaryKey;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ClassField{" +
                "fieldName='" + fieldName + '\'' +
                ", fieldValue='" + fieldValue + '\'' +
                ", fieldType='" + fieldType + '\'' +
                ", fieldColumn='" + fieldColumn + '\'' +
                ", jdbcType='" + jdbcType + '\'' +
                ", isPrimaryKey='" + isPrimaryKey + '\'' +
                '}';
    }
}
