public class Time {
    // Private int instance variables
    private int hour;
    private int minute;
    private int second;

    // Construtor 1: zero-argument constructor that initializes all instance variables to zero
    public Time() {
        this(0, 0, 0);
    }

    // Constructor 2: takes three int-parameters as input and uses them to set the instance variables
    public Time(int hour, int minute, int second) {
        // Error message if invald input
        if (hour < 0 || hour >= 24 || minute < 0 || minute >= 60 || second < 0 || second >= 60) {
            System.out.println("Error: Invalid time input");
            System.exit(0);
        } else{
            this.hour = hour;
            this.minute = minute;
            this.second = second;   
        }
    }

    // Accessor method for hour
    public int getHour() {
        return this.hour;
    }

    // Accessor method for minute
    public int getMinute() {
        return this.minute;
    }

    // Accessor method for second
    public int getSecond() {
        return this.second;
    }

    // Mutator method for hour
    public void setHour(int hour) {
        // Error message if invald input
        if (hour < 0 || hour >= 24) {
            System.out.println("Error: Invalid hour input.");
            System.exit(0);
        } else {
            this.hour = hour;
        }
    }

    // Mutator method for minute
    public void setMinute(int minute) {
        // Error message if invald input
        if (minute < 0 || minute >= 60) {
            System.out.println("Error: Invalid minute input.");
            System.exit(0);
        } else {
            this.minute = minute;
        }
    }

    // Mutator method for second
    public void setSecond(int second) {
        // Error messge if invalid input
        if (second < 0 || second >= 60) {
            System.out.println("Error: Invalid second input.");
            System.exit(0);
        } else {
            this.second = second;
        }
    }

    // toUniversalString method with 24-hour format
    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
    }

    // toString method with 12-hour format
    public String toString() {
        int displayHour;
        String period;
        if (this.hour == 0) {
            displayHour = 12;  // 12 AM (midnight)
            period = "AM";
        } else if (this.hour == 12) {
            displayHour = 12;  // 12 PM (noon)
            period = "PM";
        } else if (this.hour > 12) {
            displayHour = hour - 12;  // Convert 24-hour PM to 12-hour format
            period = "PM";
        } else {
            displayHour = hour;  // AM times (1 - 11)
            period = "AM";
        }
        return String.format("%d:%02d:%02d %s", displayHour, this.minute, this.second, period);
    }

    // tick method to increment by one second
    public void tick() {
        if (this.second == 59) {
            setSecond(0);
            incrementMinute();
        } else {
            setSecond(this.second + 1);
        }
    }

    // incrementMinute method to increment by one minute
    public void incrementMinute() {
        if (this.minute == 59) {
            setMinute(0);
            incrementHour(); 
        } else {
            setMinute(this.minute + 1);
        }
    }

    // incrementHour method to increment by one hour
    public void incrementHour() {
        if (this.hour == 23) {
            setHour(0);
        } else {
            setHour(this.hour + 1);
        }
    }

    // isEqual method to check if two Time objects are equal
    public boolean isEqual(Time other) {
        if (this.hour != other.hour) {
            return false;
        } else if (this.minute != other.minute) {
            return false;
        } else if (this.second != other.second) {
            return false;
        } else {
            return true;
        }
    }
}
