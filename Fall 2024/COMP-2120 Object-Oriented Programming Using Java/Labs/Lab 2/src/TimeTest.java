public class TimeTest {
    public static void main(String[] args) {
        // Test inputs
        int test_hour = 23;
        int test_minute = 59;
        int test_second = 59;
        
        // Objects of Time class
        Time time1 = new Time(); // zero-argument constructor
        Time time2 = new Time(test_hour, test_minute, test_second); // three parameter constructor

        // Test toString method
        System.out.println("Time 1 (Standard Time): " + time1.toString());
        System.out.println("Time 2 (Standard Time): " + time2.toString());

        // Test toUniversalString method
        System.out.println("\nTime 1 (Universal Time): " + time1.toUniversalString());
        System.out.println("Time 2 (Universal Time): " + time2.toUniversalString());

        // Test tick method
        Time time1_new = new Time(); // Resetting to 00:00:00
        Time time2_new = new Time(test_hour, test_minute, test_second); // Resetting to 23:59:59
        time1_new.tick();
        time2_new.tick();
        System.out.println("\n====================TICK========================================");
        System.out.println("Time 1 (Standard Time): " + time1.toString());
        System.out.println("Time 1 after incrementing 1 second (Standard Time): " + time1_new.toString());
        System.out.println("Time 1 (Universal Time): " + time1.toUniversalString());
        System.out.println("Time 1 after incrementing 1 second (Universal Time): " + time1_new.toUniversalString());
        System.out.println("\nTime 2 (Standard Time): " + time2.toString());
        System.out.println("Time 2 after incrementing 1 second (Standard Time): " + time2_new.toString());
        System.out.println("Time 2 (Universal Time): " + time2.toUniversalString());
        System.out.println("Time 2 after incrementing 1 second (Universal Time): " + time2_new.toUniversalString());

        // Test incrementMinute method
        time1_new = new Time(); // Resetting to 00:00:00
        time2_new = new Time(test_hour, test_minute, test_second); // Resetting to 23:59:59
        time1_new.incrementMinute();
        time2_new.incrementMinute();
        System.out.println("\n====================MINUTE======================================");
        System.out.println("Time 1 (Standard Time): " + time1.toString());
        System.out.println("Time 1 after incrementing 1 minute (Standard Time): " + time1_new.toString());
        System.out.println("Time 1 (Universal Time): " + time1.toUniversalString());
        System.out.println("Time 1 after incrementing 1 minute (Universal Time): " + time1_new.toUniversalString());
        System.out.println("\nTime 2 (Standard Time): " + time2.toString());
        System.out.println("Time 2 after incrementing 1 minute (Standard Time): " + time2_new.toString());
        System.out.println("Time 2 (Universal Time): " + time2.toUniversalString());
        System.out.println("Time 2 after incrementing 1 minute (Universal Time): " + time2_new.toUniversalString());

        // Test incrementHour method
        time1_new = new Time(); // Resetting to 00:00:00
        time2_new = new Time(test_hour, test_minute, test_second); // Resetting to 23:59:59
        time1_new.incrementHour();
        time2_new.incrementHour();
        System.out.println("\n====================HOUR========================================");
        System.out.println("Time 1 (Standard Time): " + time1.toString());
        System.out.println("Time 1 after incrementing 1 hour (Standard Time): " + time1_new.toString());
        System.out.println("Time 1 (Universal Time): " + time1.toUniversalString());
        System.out.println("Time 1 after incrementing 1 hour (Universal Time): " + time1_new.toUniversalString());
        System.out.println("\nTime 2 (Standard Time): " + time2.toString());
        System.out.println("Time 2 after incrementing 1 hour (Standard Time): " + time2_new.toString());
        System.out.println("Time 2 (Universal Time): " + time2.toUniversalString());
        System.out.println("Time 2 after incrementing 1 hour (Universal Time): " + time2_new.toUniversalString());

        // Test isEqual method
        Time time3 = new Time(23, 59, 59);
        Time time4 = new Time(11,59, 59);
        System.out.println("\n====================EQUAL=======================================");
        System.out.println("Time 2 (Standard Time): " + time2.toString());
        System.out.println("Time 3 (Standard Time): " + time3.toString());
        System.out.println("Time 2 is equal to Time 3: " + time2.isEqual(time3));
        System.out.println("\nTime 2 (Standard Time): " + time2.toString());
        System.out.println("Time 4 (Standard Time): " + time4.toString());
        System.out.println("Time 2 is equal to Time 4: " + time2.isEqual(time4));
        System.out.println("\nTime 1 (Standard Time): " + time1.toString());       
        System.out.println("Time 3 (Standard Time): " + time3.toString());
        System.out.println("Time 1 is equal to Time 3: " + time1.isEqual(time3));
        System.out.println("\nTime 1 (Standard Time): " + time1.toString()); 
        System.out.println("Time 1 (Standard Time): " + time1.toString()); 
        System.out.println("Time 1 is equal to Time 1: " + time1.isEqual(time1));
        System.out.println("\nTime 3 (Standard Time): " + time3.toString());
        System.out.println("Time 4 (Standard Time): " + time4.toString());
        System.out.println("Time 3 is equal to Time 4: " + time3.isEqual(time4));
    }
}
