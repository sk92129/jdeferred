package com.sean.jdeferred;

import org.jdeferred.Deferred;
import org.jdeferred.Promise;
import org.jdeferred.impl.DeferredObject;

/**
 *
 * http://www.hascode.com/2015/09/using-deferred-objects-and-promises-with-java-8-and-jdeferred/
 *
 * Created by kangs on 6/7/2017.
 */
public class Multiplier {
    private final long factor;
    private final Deferred<Long, Long, String> deferred = new DeferredObject<>();

    public Multiplier(long factor) {
        this.factor = factor;
    }

    public long multiplyNTimes(int rounds) {
        long result = 1;
        for (int i = 1; i <= rounds; i++) {
            deferred.notify("status: " + (i * 100 / rounds) + "%");
            result *= factor;
        }
        deferred.resolve(result);
        return result;
    }

    public Promise<Long, Long, String> promise() {
        return deferred.promise();
    }
}
