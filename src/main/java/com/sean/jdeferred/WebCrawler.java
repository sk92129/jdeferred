package com.sean.jdeferred;

import org.jdeferred.Deferred;
import org.jdeferred.Promise;
import org.jdeferred.impl.DeferredObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kangs on 6/7/2017.
 */
public class WebCrawler {

    private final Deferred<List<String>, String, Integer> deferred = new DeferredObject<>();
    private List<String> keywordsFound = new ArrayList<>();

    public void crawl(String url) {
        deferred.notify(10);
        initializeCrawler(); // fake
        fetchSiteContent(url);// fake
        deferred.notify(20);
        filterDuplicateKeywords();// fake
        deferred.notify(80);
        storeKeywords();// fake
        deferred.resolve(keywordsFound);
    }

    public Promise<List<String>, String, Integer> promise() {
        return deferred.promise();
    }

    private void storeKeywords() {
        System.out.println("storing keywords");
        keywordsFound.add("foo");
        keywordsFound.add("bar");
        keywordsFound.add("baz");
    }

    private void filterDuplicateKeywords() {
        System.out.println("filtering duplicate keywords");
    }

    private void fetchSiteContent(String url) {
        System.out.println("fetching site content for url: " + url);
    }

    private void initializeCrawler() {
        System.out.println("initializing crawler");
    }
}
