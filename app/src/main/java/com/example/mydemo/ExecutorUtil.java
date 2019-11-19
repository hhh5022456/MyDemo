package com.example.mydemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author H.wr
 * @date 2019-11-11.
 * email：18514048800@sina.cn
 * description：
 */
public class ExecutorUtil {

    protected static ExecutorService mExecutor;
    /**
     * Executor service executor service.
     * 创建线程池管理异步线程 CachedThreadPool
     *
     * @return the executor service
     */

    public static ExecutorService executorService() {
        return mExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

    }

}
