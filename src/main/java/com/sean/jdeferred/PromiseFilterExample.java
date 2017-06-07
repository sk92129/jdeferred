package com.sean.jdeferred;

import org.jdeferred.DoneCallback;
import org.jdeferred.Promise;

import java.util.Collections;
import java.util.List;

/**
 * Created by kangs on 6/7/2017.
 */
public class PromiseFilterExample {
    public static void main(String[] args) {
        WebCrawler crawler = new WebCrawler();
        Promise<List<String>, String, Integer> promise;
        promise = crawler.promise()
                .progress((i) -> System.out.println("Progress: " + i + "%")).done((keywords) -> {
                    System.out.println("Done, " + keywords.size() + " keywords found: ");
                    keywords.forEach(System.out::println);
                });


        //promise.then
        // the "then" call is ambiguous.  Had to cast to DoneCallback<List<String>>
        //Promise<List<String>, String, Integer> filteredPromise = promise.then((keywords) -> Collections.sort(keywords));
        Promise<List<String>, String, Integer> filteredPromise = promise.then((DoneCallback<List<String>>) (keywords) -> Collections.sort(keywords));
        filteredPromise.done((keywords) -> {
            System.out.println("Done (sorted by filter), " + keywords.size() + " keywords found: ");
            keywords.forEach(System.out::println);
        });

        crawler.crawl("http://www.hascode.com/");
    }
}
