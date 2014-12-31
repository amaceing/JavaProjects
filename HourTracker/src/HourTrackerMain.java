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
        double decimalTime = hoursToDecimals(addedHours, convertedMins);
        System.out.printf("Your time in decimal format is %.2f", decimalTime);
        writeToFile();

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

    public static void printHoursAndMinutes(int hours, int mins) {
        if (mins >= 10) {
            System.out.printf("Your hours and minutes for 2 weeks: %d:%d", hours, mins);
        } else {
            System.out.printf("Your hours and minutes for 2 weeks: %d:0%d", hours, mins);
        }
    }


    public static double hoursToDecimals(int hours, int mins) {
        double convertedTime = hours;
        double minsDec = mins / 60.0;
        convertedTime += minsDec;
        return convertedTime;
    }

    public static void writeToFile() {
        File logHours = new File("logHours.txt");
        try {
            if(!logHours.exists()) {
                System.out.println("Had to create a new file!");
                logHours.createNewFile();
            }
            FileWriter fw = new FileWriter(logHours, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            bufferedWriter.write("hello");

        } catch (IOException exc) {
            System.out.println("Could not write to file");
        }

    }

}
