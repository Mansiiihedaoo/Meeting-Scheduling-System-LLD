# Meeting-Scheduling-System-LLD
![Meet](https://github.com/user-attachments/assets/73877b1b-bc79-4742-8770-85e70c6cef35)

# MeetingScheduler

A Java-based meeting scheduler application that allows users to schedule, modify, and cancel meetings, as well as manage attendee availability and room bookings.

## Components

- **`Meeting Scheduler`**
- **`Attendee`**
- **`Meeting`**
- **`Room`**
- **`NotificationSystem`**

 
## Features

- Schedule meetings with attendees and rooms.
- Modify meeting times and rooms.
- Cancel meetings and free up room availability.
- Check attendee availability before scheduling.
- Notify attendees of meeting updates and cancellations.

## UML Design

The application is structured using the following UML objects and relationships:

### Classes and Relationships

- **`User`**: Represents a user with a unique ID, name, and personal `Calendar`.
- **`Calendar`**: Contains a list of `Meeting` objects. Has an association with the `User`.
- **`Meeting`**: Represents a meeting, including details like organizer, attendees, room, and time. Has an aggregation relationship with `User` and `MeetingRoom`.
- **`MeetingRoom`**: Manages room availability and bookings. Associated with multiple `Meeting` objects.
- **`TimeInterval`**: Represents the time span of a `Meeting`. Used by both `Meeting` and `MeetingRoom` to check for overlaps.
- **`Scheduler`**: The main class for scheduling, modifying, and canceling meetings. Mediates interactions between `Meeting`, `User`, and `MeetingRoom`.

### Design Patterns Used

- **Observer Pattern**: The `Meeting` class notifies `User` objects (attendees) of meeting updates or cancellations.
- **Strategy Pattern**: Potentially used to allow different scheduling strategies in the `Scheduler` class for room allocation and meeting time adjustments.
- **Singleton Pattern**: Could be applied to ensure only one instance of `Scheduler` manages the scheduling process (if scalability is considered).

## Project Structure

- `Calendar.java`: Manages user-specific meeting schedules and provides methods to add or remove meetings.
- `Meeting.java`: Encapsulates meeting details like organizer, attendees, room, and time interval, and provides notification mechanisms.
- `MeetingRoom.java`: Manages room bookings and availability using time intervals.
- `Scheduler.java`: Handles the core scheduling logic, including checking availability, booking rooms, and managing attendee lists.
- `TimeInterval.java`: Represents the start and end times of meetings and provides logic for checking overlapping intervals.
- `User.java`: Represents a user with personal meeting schedules, associated with the `Calendar`.
- 




