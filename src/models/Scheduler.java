package models;

import java.util.List;

public class Scheduler {
    private List<MeetingRoom> meetingRooms;

    public Scheduler(List<MeetingRoom> meetingRooms) {
        this.meetingRooms = meetingRooms;
    }

    public Meeting scheduleMeeting(String meetingId, User organizer, List<User> attendees, TimeInterval interval) {
        // Check availability of all attendees
        for (User attendee : attendees) {
            if (!attendee.getCalendar().isAvailable(interval)) {
                System.out.println("Attendee " + attendee.getName() + " is not available.");
                return null;
            }
        }

        // Find an available room
        for (MeetingRoom room : meetingRooms) {
            if (room.isAvailable(interval) && room.getCapacity() >= attendees.size()) {
                Meeting meeting = new Meeting(meetingId, organizer, attendees, room, interval);
                room.bookRoom(interval);
                meeting.notifyAttendees();
                return meeting;
            }
        }

        System.out.println("No available room for the specified time interval.");
        return null;
    }

    public boolean cancelMeeting(Meeting meeting) {
        MeetingRoom room = meeting.getRoom();
        TimeInterval interval = meeting.getTimeInterval();

        if (room == null) {
            System.out.println("Meeting room is not assigned.");
            return false;
        }

        room.releaseRoom(interval);
        meeting.notifyAttendeesCancellation();
        return true;
    }

    public boolean modifyMeeting(Meeting meeting, TimeInterval newInterval, MeetingRoom newRoom) {
        for (User attendee : meeting.getAttendees()) {
            if (!attendee.getCalendar().isAvailable(newInterval)) {
                System.out.println("Attendee " + attendee.getName() + " is not available at the new time.");
                return false;
            }
        }

        if (newRoom != null && newRoom.isAvailable(newInterval) && newRoom.getCapacity() >= meeting.getAttendees().size()) {
            MeetingRoom oldRoom = meeting.getRoom();
            TimeInterval oldInterval = meeting.getTimeInterval();

            if (oldRoom != null) {
                oldRoom.releaseRoom(oldInterval);
            }
            newRoom.bookRoom(newInterval);

            meeting.setRoom(newRoom);
            meeting.setTimeInterval(newInterval);
            meeting.notifyAttendeesUpdate();
            return true;
        } else {
            System.out.println("No suitable room available for the new time.");
            return false;
        }
    }

    public boolean leaveMeeting(Meeting meeting, User user) {
        List<User> attendees = meeting.getAttendees();
        if (attendees.remove(user)) {
            user.getCalendar().removeMeeting(meeting);
            meeting.notifyAttendeesUpdate();
            return true;
        } else {
            System.out.println(user.getName() + " is not an attendee of this meeting.");
            return false;
        }
    }
}
