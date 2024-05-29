package com.xiacong.common.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 时间范围操作类
 */
class TimeInterval {
    private long startTime;
    private long endTime;

    public TimeInterval(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public boolean overlaps(TimeInterval other) {
        return startTime <= other.getEndTime() && other.getStartTime() <= endTime;
    }

    public void merge(TimeInterval other) {
        startTime = Math.min(startTime, other.getStartTime());
        endTime = Math.max(endTime, other.getEndTime());
    }
}

public class TimeIntervalCollection {
    private List<TimeInterval> intervals;

    public TimeIntervalCollection() {
        intervals = new ArrayList<>();
    }

    public void addInterval(TimeInterval newInterval) {
        List<TimeInterval> mergedIntervals = new ArrayList<>();

        boolean merged = false;
        for (TimeInterval interval : intervals) {
            if (interval.overlaps(newInterval)) {
                interval.merge(newInterval);
                merged = true;
            }
            mergedIntervals.add(interval);
        }

        if (!merged) {
            mergedIntervals.add(newInterval);
        }

        mergedIntervals.sort(Comparator.comparingLong(TimeInterval::getStartTime));

        // 校验并融合时间范围重叠的元素
        List<TimeInterval> validatedIntervals = new ArrayList<>();
        for (TimeInterval interval : mergedIntervals) {
            boolean overlap = false;
            for (TimeInterval validatedInterval : validatedIntervals) {
                if (interval.overlaps(validatedInterval)) {
                    validatedInterval.merge(interval);
                    overlap = true;
                    break;
                }
            }
            if (!overlap) {
                validatedIntervals.add(interval);
            }
        }

        intervals = validatedIntervals;
    }

    public void union(TimeIntervalCollection otherCollection) {
        for (TimeInterval interval : otherCollection.getIntervals()) {
            addInterval(interval);
        }
    }

    public void subtract(TimeIntervalCollection otherCollection) {
        List<TimeInterval> subtractedIntervals = new ArrayList<>(intervals);

        for (TimeInterval interval : otherCollection.getIntervals()) {
            for (TimeInterval subtractedInterval : new ArrayList<>(subtractedIntervals)) {
                if (interval.getStartTime() <= subtractedInterval.getStartTime() && interval.getEndTime() >= subtractedInterval.getEndTime()) {
                    //完全覆盖
                    subtractedIntervals.remove(subtractedInterval);
                } else if (interval.getStartTime() > subtractedInterval.getStartTime() && interval.getEndTime() < subtractedInterval.getEndTime()) {
                    //被完全覆盖
                    long originalEndTime = subtractedInterval.getEndTime();
                    subtractedInterval.setEndTime(interval.getStartTime());
                    subtractedIntervals.add(new TimeInterval(interval.getEndTime(), originalEndTime));
                } else if (subtractedInterval.overlaps(interval)
                        && interval.getEndTime() >= subtractedInterval.getEndTime()) {
                    //后部分覆盖
                    subtractedInterval.setEndTime(interval.getStartTime());
                } else if (subtractedInterval.overlaps(interval)
                        && interval.getStartTime() <= subtractedInterval.getStartTime()) {
                    //前部分覆盖
                    subtractedInterval.setStartTime(interval.getEndTime());
                }
                //完全不覆盖
            }
        }
        subtractedIntervals.sort(Comparator.comparingLong(TimeInterval::getStartTime));
        intervals = subtractedIntervals;
    }

    public List<TimeInterval> getIntervals() {
        return intervals;
    }

}