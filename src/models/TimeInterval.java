package models;

import java.time.LocalDateTime;

public class TimeInterval {
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public TimeInterval(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public boolean overlaps(TimeInterval other) {
        return !(this.endTime.isBefore(other.startTime) || this.startTime.isAfter(other.endTime));
    }
}
