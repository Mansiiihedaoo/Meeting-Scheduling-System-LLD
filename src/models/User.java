package models;

public class User {
    private String userId;
    private String name;
    private Calendar calendar;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.calendar = new Calendar();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Calendar getCalendar() {
        return calendar;
    }
}
