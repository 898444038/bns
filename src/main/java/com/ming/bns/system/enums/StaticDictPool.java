package com.ming.bns.system.enums;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StaticDictPool {

    private StaticDictPool() {}

    /**
     * 用于存储字典数据
     */
    private static final Map<IDictItem, DictItemBean> dictItemMap = new ConcurrentHashMap<>();

    /**
     * 往 map 中添加代码项
     */
    public static void putDictItem(IDictItem iCodeItem, String value, String label) {
        dictItemMap.put(iCodeItem, DictItemBean.of(value, label));
    }

    /**
     * 获取静态数据
     */
    static DictItemBean getDictItem(IDictItem iCodeItem) {
        return dictItemMap.get(iCodeItem);
    }
}
