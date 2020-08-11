package com.ming.bns.system.enums;

public interface IDicTable {

    String getCode();

    String getText();

    /**
     * 通过 code 获取指定 枚举类型中的 枚举对象
     * @param enumClass
     * @param code
     * @param <T>
     * @return
     */
    static <T extends IDicTable> T getByCode(Class<T> enumClass, String code) {
        //通过反射取出Enum所有常量的属性值
        for (T each : enumClass.getEnumConstants()) {
            //利用code进行循环比较，获取对应的枚举
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }

    /**
     * 通过 code 获取指定 枚举类型中的 text
     *
     * @param enumClass
     * @param code
     * @param <T>
     * @return
     */
    static <T extends IDicTable> String getTextByCode(Class<T> enumClass, String code) {
        IDicTable byCode = getByCode(enumClass, code);
        if (null == byCode) {
            return null;
        }
        return byCode.getCode();
    }

    /**
     * 当前对象的 code 是否 和参数中的 code 相等
     *
     * @param code
     * @return
     */
    default boolean isCode(String code) {
        return this.getCode().equals(code);
    }

    /**
     * 当前对象是否和已知对象不等
     *
     * @param gender
     * @return
     */
    default boolean isNotEquals(IDicTable gender) {
        return this != gender;
    }
}
