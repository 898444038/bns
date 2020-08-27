package com.ming.bns.admin.utils;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUtils {

    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 65; i++) {
            list.add(i);
        }
        List<List> result = averageAssign(list, 15,2);
        result.forEach(l -> {
            l.forEach(i ->
                    System.out.print(i + "\t")
            );
            System.out.println();
        });
        System.out.println("====================================================");
        result = averageAssign(list, 20,2);
        result.forEach(l -> {
            l.forEach(i ->
                    System.out.print(i + "\t")
            );
            System.out.println();
        });

        //System.out.println("====================================================");
        // Guava 实现不平均分组
        /*result = Lists.partition(list ,100);
        result.forEach(l -> {
            l.forEach(i ->
                    System.out.print(i + "\t")
            );
            System.out.println();
        });*/
    }

    /**
     * 将一个List均分成n个list,主要通过偏移量来实现的
     *
     * @param source 源集合
     * @param limit 最大值
     * @return
     */
    public static <T> List<List<T>> averageAssign(List<T> source, int limit,int type) {
        if (null == source || source.isEmpty()) {
            return Collections.emptyList();
        }
        List<List<T>> result = new ArrayList<>();
        int listCount = 0;
        if(type == 0){//最小任务数
            listCount = (source.size() - 1) / limit;
        }else if(type == 1){//固定几组
            listCount = limit;
        }else if(type == 2){//最大任务数
            listCount = (source.size() - 1) / limit + 1;
        }
        int remaider = source.size() % listCount; // (先计算出余数)
        int number = source.size() / listCount; // 然后是商
        int offset = 0;// 偏移量
        for (int i = 0; i < listCount; i++) {
            List<T> value;
            if (remaider > 0) {
                value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
                remaider--;
                offset++;
            } else {
                value = source.subList(i * number + offset, (i + 1) * number + offset);
            }
            result.add(value);
        }
        return result;
    }

    public static <T> List<List<T>> partition(final List<T> list, final int size) {
        if (list == null) {
            throw new NullPointerException("List must not be null");
        }
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        return new Partition<>(list, size);
    }

    private static class Partition<T> extends AbstractList<List<T>> {
        private final List<T> list;
        private final int size;

        private Partition(final List<T> list, final int size) {
            this.list = list;
            this.size = size;
        }

        @Override
        public List<T> get(final int index) {
            final int listSize = size();
            if (index < 0) {
                throw new IndexOutOfBoundsException("Index " + index + " must not be negative");
            }
            if (index >= listSize) {
                throw new IndexOutOfBoundsException("Index " + index + " must be less than size " +
                        listSize);
            }
            final int start = index * size;
            final int end = Math.min(start + size, list.size());
            return list.subList(start, end);
        }

        @Override
        public int size() {
            return (int) Math.ceil((double) list.size() / (double) size);
        }

        @Override
        public boolean isEmpty() {
            return list.isEmpty();
        }
    }
}
