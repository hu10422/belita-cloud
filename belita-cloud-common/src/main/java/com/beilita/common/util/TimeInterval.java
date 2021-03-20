package com.beilita.common.util;

public class TimeInterval {

    private long start;

    public TimeInterval() {
        this.start = System.currentTimeMillis();
    }

    public long interval() {
        long l = System.currentTimeMillis();
        return l - start;
    }
}
