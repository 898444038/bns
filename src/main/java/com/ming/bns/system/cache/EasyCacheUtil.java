package com.ming.bns.system.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 缓存工具类
 */
public class EasyCacheUtil {
    /*缓存map*/
    private static Map<String,Object> cacheMap = new HashMap<String, Object>();
    /*缓存有效期map*/
    private static Map<String,Long> expireMap = new HashMap<String, Long>();

    /**
     * 通过key获取值
     * @param key
     * @param <T>
     * @return
     */
    public static <T> T get(String key){
        if(!cacheMap.containsKey(key)){
            return null;
        }
        if(expireMap.containsKey(key)){
            if(expireMap.get(key)<System.currentTimeMillis()){
                return null;
            }
        }
        Object obj = cacheMap.get(key);
        return obj == null ? null : (T)obj;
    }

    /**
     * 设置不过期的值
     * @param key
     * @param value
     */
    public static void set(String key, Object value){
        cacheMap.put(key, value);
    }

    /**
     * 设置过期的值
     * @param key
     * @param value
     * @param ms 毫秒
     */
    public static void set(final String key, Object value,int ms){
        final long expire = System.currentTimeMillis() + ms;
        cacheMap.put(key,value);
        expireMap.put(key,expire);
        // 清除过期数据
        if(cacheMap.size() > 2){
            new Thread(new Runnable() {
                public void run() {
                    Iterator<Map.Entry<String,Object>> iterator = cacheMap.entrySet().iterator();
                    while (iterator.hasNext()){
                        Map.Entry<String,Object> entry = iterator.next();
                        if(expireMap.containsKey(entry.getKey())){
                            long expireTime = expireMap.get(key);
                            if(System.currentTimeMillis() > expireTime){
                                iterator.remove();
                                expireMap.remove(entry.getKey());
                            }
                        }
                    }
                }
            }).start();
        }
    }

    /**
     * 通过key删除值
     * @param key
     */
    public static void del(String key){
        if(cacheMap.containsKey(key)){
            cacheMap.remove(key);
        }
        if(expireMap.containsKey(key)){
            expireMap.remove(key);
        }
    }

    /**
     * 判断key是否存在
     * @param key
     */
    public static boolean isExist(String key){
        return cacheMap.containsKey(key);
    }
}
