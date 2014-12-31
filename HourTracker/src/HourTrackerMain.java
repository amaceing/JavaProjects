/**
 * Created by anthonymace on 12/31/14.
 */

import java.util.Scanner;
import java.io.*;

public class HourTrackerMain {

    public static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        int[] hoursMinutesWeekOne = getHoursFromWeek("one");
        int[] hoursMinutesWeekTwo = getHoursFromWeek("two");
        int addedHours = addHoursOrMinsFromTwoWeeks(hoursMinutesWeekOne, hoursMinutesWeekTwo, true);
        int addedMins = addHoursOrMinsFromTwoWeeks(hoursMinutesWeekOne, hoursMinutesWeekTwo, false);
        addedHours += convertMinsToHours(addedHours, addedMins);
        int convertedMins = leftOverMinutes(addedMins);
        if (convertedMins >= 10) {
            System.out.printf("Your hours and minutes for 2 weeks: %d:%d", addedHours, convertedMins);
        } else {
            System.out.printf("Your hours and minutes for 2 weeks: %d:0%d", addedHours, convertedMins);
        }


    }

    public static int[] getHoursFromWeek(String weekNumber) {
        int[] hoursMinutes = new int[2];
        System.out.printf("Enter your hours from week %s: ", weekNumber);
        int hours = console.nextInt();
        System.out.println();
        System.out.printf("Enter your minutes from week %s: ", weekNumber);
        int minutes = console.nextInt();
        System.out.println();
        hoursMinutes[0] = hours;
        hoursMinutes[1] = minutes;
        return hoursMinutes;
    }

    public static int addHoursOrMinsFromTwoWeeks(int[] weekOne, int[] weekTwo,boolean hours) {
        if (hours) {
            return weekOne[0] + weekTwo[0];
        } else {
            return weekOne[1] + weekTwo[1];
        }
    }

    public static int convertMinsToHours(int hours, int minutes) {
        if (minutes >= 60) {
            hours++;
        }
        return hours;
    }

    public static int leftOverMinutes(int mins) {
        int leftOver = 0;
        if (mins >= 60) {
            leftOver = mins - 60;
        }
        return leftOver;
    }


    /*public static double hoursToDecimals() {

    }*/

}
