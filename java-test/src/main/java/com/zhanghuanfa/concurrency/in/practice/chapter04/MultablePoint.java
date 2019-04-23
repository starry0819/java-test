package com.zhanghuanfa.concurrency.in.practice.chapter04;

/**
 * @author zhanghuanfa 2019-04-23 19:06
 */
public class MultablePoint {
    public int x, y;

    public MultablePoint() {
        x = 0;
        y = 0;
    }

    public MultablePoint(MultablePoint point) {
        this.x = point.x;
        this.y = point.y;
    }
}
