package models;

import java.util.List;

public class Meeting {
    private String meetingId;
    private User organizer;
    private List<User> attendees;
    private MeetingRoom room;
    private TimeInterval timeInterval;

    public Meeting(String meetingId, User organizer, List<User> attendees, MeetingRoom room, TimeInterval timeInterval) {
        this.meetingId = meetingId;
        this.organizer = organizer;
        this.attendees = attendees;
        this.room = room;
        this.timeInterval = timeInterval;
    }

    public void notifyAttendees() {
        for (User attendee : attendees) {
            attendee.getCalendar().addMeeting(this);
        }
    }

    public TimeInterval getTimeInterval() {
        return timeInterval;
    }

    public MeetingRoom getRoom() {
        return room;
    }

    public void setRoom(MeetingRoom room) {
        this.room = room;
    }

    public void setTimeInterval(TimeInterval interval) {
        this.timeInterval = interval;
    }

    public List<User> getAttendees() {
        return attendees;
    }

    public void notifyAttendeesUpdate() {
        for (User attendee : attendees) {
            // Logic to notify each attendee of the update
        }
    }

    public void notifyAttendeesCancellation() {
        for (User attendee : attendees) {
            // Logic to notify each attendee of the cancellation
        }
    }
}
