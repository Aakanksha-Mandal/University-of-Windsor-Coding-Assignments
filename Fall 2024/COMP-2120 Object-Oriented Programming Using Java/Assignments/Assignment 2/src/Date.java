// Name: Aakanksha Mandal
// Student Number: 110189000

public class Date {
    // Private fields
    private int day;
    private int month;
    private int year;
    private boolean validDate;

    // Constructor that takes day, month, and year with input validation
    public Date(int day, int month, int year) {
        setDate(day, month, year);
    }

    // Copy constructor
    public Date(Date date) {
        setDate(date.day, date.month, date.year);
    }

    // Constructor that takes a string input
    public Date(String dateStr) {
        // Attempt to parse the date from the given string
        String[] parts;
        if (dateStr.contains("/")) {
            parts = dateStr.split("/");
            if (parts.length == 3) {
                int d = parseInteger(parts[0]);
                int m = parseInteger(parts[1]);
                int y = parseInteger(parts[2]);
                setDate(d, m, y);
            } else {
                setValidDate(false);
            }
        } else if (dateStr.contains(",")) {
            parts = dateStr.split(" ");
            if (parts.length == 3) {
                String monthStr = parts[0];
                int d = parseInteger(parts[1].replace(",", ""));
                int y = parseInteger(parts[2]);
                int m = convertMonth(monthStr);
                if (m > 0) { // Only set if month is valid
                    setDate(d, m, y);
                } else {
                    setValidDate(false);
                }
            } else {
                setValidDate(false);
            }
        }
    }

    // Setters with validation
    public void setDate(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    public void setValidDate(boolean validDate) {
        this.validDate = validDate;
    }

    // Getters
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public boolean getValidDate() {
        return validDate;
    }

    // Method to check if the date is valid
    private boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12 || day < 1 || year < 0 || year > 2024) {
            setValidDate(false);
            return false;
        }
        if (day > getDaysInMonth(month, year)) {
            setValidDate(false);
            return false;
        }
        setValidDate(true);
        return true;
    }

    // Method to get the number of days in a month
    private int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return (isLeapYear(year)) ? 29 : 28;
            default:
                return 0; // Invalid month
        }
    }

    // Method to check leap year
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Convert month string to number
    private int convertMonth(String monthStr) {
        monthStr = monthStr.toLowerCase();
        switch (monthStr) {
            case "jan": return 1;
            case "feb": return 2;
            case "mar": return 3;
            case "apr": return 4;
            case "may": return 5;
            case "jun": return 6;
            case "jul": return 7;
            case "aug": return 8;
            case "sep": return 9;
            case "oct": return 10;
            case "nov": return 11;
            case "dec": return 12;
            default: return 0; // Invalid month string
        }
    }

    // Helper method to parse an integer safely
    private int parseInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return -1; // Return an invalid value if parsing fails
        }
    }

    // Equals method to compare two Date objects
    public boolean equals(Date other) {
        return this.day == other.day && this.month == other.month && this.year == other.year;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }
}