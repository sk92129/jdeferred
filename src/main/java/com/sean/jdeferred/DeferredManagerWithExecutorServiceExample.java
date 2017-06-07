package com.sean.jdeferred;

import org.jdeferred.DeferredManager;
import org.jdeferred.impl.DefaultDeferredManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 203293 on 6/7/2017.
 */
public class DeferredManagerWithExecutorServiceExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        DeferredManager dm = new DefaultDeferredManager(executorService);

        WebCrawler crawl1 = new WebCrawler();
        // [..]
    }
}
