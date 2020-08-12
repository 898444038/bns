package com.ming.bns.system.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ThreadPool {
    //单个线程
    private static final ExecutorService singlePool = Executors.newSingleThreadExecutor();
    //固定数量线程池
    private static final ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private static ExecutorService getExecutor(){
        return singlePool;
    }

    /**
     * 提交任务执行
     * @param task
     */
    public static void execute(Runnable task){
        getExecutor().execute(task);
    }

}
