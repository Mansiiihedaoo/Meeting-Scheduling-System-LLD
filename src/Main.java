import models.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create Users
        User alice = new User("1", "Alice");
        User bob = new User("2", "Bob");
        User charlie = new User("3", "Charlie");

        // Create Meeting Rooms
        MeetingRoom room101 = new MeetingRoom("101", 10);
        MeetingRoom room102 = new MeetingRoom("102", 5);

        // Create TimeIntervals
        TimeInterval interval1 = new TimeInterval(
                LocalDateTime.of(2024, 8, 16, 9, 0),
                LocalDateTime.of(2024, 8, 16, 10, 0)
        );
        TimeInterval interval2 = new TimeInterval(
                LocalDateTime.of(2024, 8, 16, 11, 0),
                LocalDateTime.of(2024, 8, 16, 12, 0)
        );

        // Create Scheduler
        Scheduler scheduler = new Scheduler(Arrays.asList(room101, room102));

        // Schedule a meeting
        List<User> attendees = Arrays.asList(alice, bob);
        Meeting meeting = scheduler.scheduleMeeting("1", alice, attendees, interval1);

        if (meeting != null) {
            System.out.println("Meeting scheduled successfully!");
        }

        // Modify the meeting
        TimeInterval newInterval = new TimeInterval(
                LocalDateTime.of(2024, 8, 16, 10, 0),
                LocalDateTime.of(2024, 8, 16, 11, 0)
        );
        MeetingRoom newRoom = room102;
        boolean modified = scheduler.modifyMeeting(meeting, newInterval, newRoom);

        if (modified) {
            System.out.println("Meeting modified successfully!");
        }

        // Leave the meeting
        boolean left = scheduler.leaveMeeting(meeting, bob);

        if (left) {
            System.out.println("User Bob left the meeting successfully!");
        }

        // Cancel the meeting
        boolean canceled = scheduler.cancelMeeting(meeting);

        if (canceled) {
            System.out.println("Meeting canceled successfully!");
        }
    }
}
