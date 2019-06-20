package com.wei.first.log;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.rolling.AbstractTriggeringPolicy;
import org.apache.logging.log4j.core.appender.rolling.FileSize;
import org.apache.logging.log4j.core.appender.rolling.RollingFileManager;
import org.apache.logging.log4j.core.appender.rolling.TimeBasedTriggeringPolicy;
import org.apache.logging.log4j.core.config.plugins.*;
import org.apache.logging.log4j.core.util.Integers;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * FileName：SizeBasedTimeRollingPolicy
 * TODO
 *
 * @author 魏俊杰
 * @date 11:30 2019/4/11
 */
@Plugin(
        name = "SizeBasedTimeRollingPolicy",
        category = "Core",
        printObject = true
)
public class SizeBasedTimeRollingPolicy extends AbstractTriggeringPolicy {
    private long nextRolloverMillis;
    private final int interval;
    private final boolean modulate;
    //最大的随机延迟秒数
    private final long maxRandomDelayMillis;
    private RollingFileManager manager;

    private SizeBasedTimeRollingPolicy(int interval, boolean modulate, long maxRandomDelayMillis) {
        this.interval = interval;
        this.modulate = modulate;
        this.maxRandomDelayMillis = maxRandomDelayMillis;
    }

    public int getInterval() {
        return this.interval;
    }

    public long getNextRolloverMillis() {
        return this.nextRolloverMillis;
    }

    public void initialize(RollingFileManager aManager) {
        this.manager = aManager;
        long current = aManager.getFileTime();
        if (current == 0L) {
            current = System.currentTimeMillis();
        }

        aManager.getPatternProcessor().getNextTime(current, this.interval, this.modulate);
        this.nextRolloverMillis = ThreadLocalRandom.current().nextLong(0L, 1L + this.maxRandomDelayMillis) + aManager.getPatternProcessor().getNextTime(current, this.interval, this.modulate);
    }

    public boolean isTriggeringEvent(LogEvent event) {
        long nowMillis = event.getTimeMillis();
        if (nowMillis >= this.nextRolloverMillis) {
            this.nextRolloverMillis = ThreadLocalRandom.current().nextLong(0L, 1L + this.maxRandomDelayMillis) + this.manager.getPatternProcessor().getNextTime(nowMillis, this.interval, this.modulate);
            this.manager.getPatternProcessor().setCurrentFileTime(System.currentTimeMillis());
            return true;
        } else {
            return false;
        }
    }

    /** @deprecated */
    @Deprecated
    public static SizeBasedTimeRollingPolicy createPolicy(@PluginAttribute("interval") String interval,
                                                          @PluginAttribute(".") String modulate) {
        return newBuilder().withInterval(Integers.parseInt(interval, 1)).withModulate(Boolean.parseBoolean(modulate)).build();
    }

    @PluginBuilderFactory
    public static SizeBasedTimeRollingPolicy.Builder newBuilder() {
        return new SizeBasedTimeRollingPolicy.Builder();
    }

    public String toString() {
        return "TimeBasedTriggeringPolicy(nextRolloverMillis=" + this.nextRolloverMillis + ", interval=" + this.interval + ", modulate=" + this.modulate + ")";
    }

    public static class Builder implements org.apache.logging.log4j.core.util.Builder<SizeBasedTimeRollingPolicy> {
        @PluginBuilderAttribute
        private int interval = 1;
        @PluginBuilderAttribute
        private boolean modulate = false;
        @PluginBuilderAttribute
        private int maxRandomDelay = 0;

        public Builder() {
        }

        public SizeBasedTimeRollingPolicy build() {
            long maxRandomDelayMillis = TimeUnit.SECONDS.toMillis((long)this.maxRandomDelay);
            return new SizeBasedTimeRollingPolicy(this.interval, this.modulate, maxRandomDelayMillis);
        }

        public int getInterval() {
            return this.interval;
        }

        public boolean isModulate() {
            return this.modulate;
        }

        public int getMaxRandomDelay() {
            return this.maxRandomDelay;
        }

        public SizeBasedTimeRollingPolicy.Builder withInterval(int interval) {
            this.interval = interval;
            return this;
        }

        public SizeBasedTimeRollingPolicy.Builder withModulate(boolean modulate) {
            this.modulate = modulate;
            return this;
        }

        public SizeBasedTimeRollingPolicy.Builder withMaxRandomDelay(int maxRandomDelay) {
            this.maxRandomDelay = maxRandomDelay;
            return this;
        }
    }
}
