package com.zhanghuanfa.concurrency.in.practice.chapter04;

import com.zhanghuanfa.concurrency.in.practice.annotation.ThreadSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 基于监视器（synchronized）实现的线程安全
 *
 * @author zhanghuanfa 2019-04-23 19:05
 */
@ThreadSafe
public class MonitorVehicleTracker {

    private final Map<String, MultablePoint> locations;

    public MonitorVehicleTracker(Map<String, MultablePoint> locations) {
        this.locations = locations;
    }

    public synchronized Map<String, MultablePoint> getLocations() {
        return deepCopy(locations);
    }

    public synchronized MultablePoint getLocation(String id) {
        MultablePoint multablePoint = locations.get(id);
        return multablePoint == null ? null : new MultablePoint(multablePoint);
    }

    public synchronized void setLocation(String id, int x, int y) {
        MultablePoint loc = locations.get(id);
        if (loc == null) {
            throw new IllegalArgumentException("No such ID: " + id);
        }
        loc.x = x;
        loc.y = y;
    }

    private static Map<String, MultablePoint> deepCopy(Map<String, MultablePoint> locations) {
        Map<String, MultablePoint> result = new HashMap<>();
        for (String id : locations.keySet()) {
            result.put(id, new MultablePoint(locations.get(id)));
        }
        return Collections.unmodifiableMap(result);
    }

}
