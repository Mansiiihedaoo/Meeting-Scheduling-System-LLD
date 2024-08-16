package models;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoom {
    private String roomId;
    private int capacity;
    private List<TimeInterval> bookedIntervals;

    public MeetingRoom(String roomId, int capacity) {
        this.roomId = roomId;
        this.capacity = capacity;
        this.bookedIntervals = new ArrayList<>();
    }

    public String getRoomId() {
        return roomId;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAvailable(TimeInterval interval) {
        for (TimeInterval booked : bookedIntervals) {
            if (booked.overlaps(interval)) {
                return false;
            }
        }
        return true;
    }

    public void bookRoom(TimeInterval interval) {
        bookedIntervals.add(interval);
    }
    public void releaseRoom(TimeInterval interval) {
        // Release the room for the specified interval
    }
}

