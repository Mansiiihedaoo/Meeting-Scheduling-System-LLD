
package models;

import java.util.ArrayList;
import java.util.List;

public  class Calendar {
    private List<Meeting> meetings;

    public Calendar() {
        this.meetings = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
    }

    public boolean isAvailable(TimeInterval interval) {
        for (Meeting meeting : meetings) {
            if (meeting.getTimeInterval().overlaps(interval)) {
                return false;
            }
        }
        return true;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }
    public void removeMeeting(Meeting meeting) {
        // Remove the meeting from the user's calendar
        meetings.remove(meeting);
    }
}

