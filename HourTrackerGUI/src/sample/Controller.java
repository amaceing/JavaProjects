package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class Controller {

    public TextField week1Hours;
    public TextField week2Hours;

    public void calcHours(ActionEvent actionEvent) {
        String week1 = week1Hours.getText();
        String week2 = week2Hours.getText();
        int[] hoursMinutesWeek1 = parseHoursAndMinutesString(week1);
        int[] hoursMinutesWeek2 = parseHoursAndMinutesString(week2);
        int addedHours = addHoursOrMinsFromTwoWeeks(hoursMinutesWeek1, hoursMinutesWeek2, true);
        int addedMins = addHoursOrMinsFromTwoWeeks(hoursMinutesWeek1, hoursMinutesWeek2, false);
        addedHours = convertMinsToHours(addedHours, addedMins);
        int convertedMins = leftOverMinutes(addedMins);
        double decimalTime = hoursToDecimals(addedHours, convertedMins);
    }

    public int[] parseHoursAndMinutesString(String hoursAndMinutes) {
        int[] hoursMinutes = new int[2];
        String[] hoursAndMinutesSplit = hoursAndMinutes.split(":");
        int hours = Integer.parseInt(hoursAndMinutesSplit[0]);
        int minutes = Integer.parseInt(hoursAndMinutesSplit[1]);
        hoursMinutes[0] = hours;
        hoursMinutes[1] = minutes;
        return hoursMinutes;
    }

    public int addHoursOrMinsFromTwoWeeks(int[] weekOne, int[] weekTwo,boolean hours) {
        if (hours) {
            return weekOne[0] + weekTwo[0];
        } else {
            return weekOne[1] + weekTwo[1];
        }
    }

    public int convertMinsToHours(int hours, int minutes) {
        if (minutes >= 60) {
            hours++;
        }
        return hours;
    }

    public int leftOverMinutes(int mins) {
        if (mins >= 60) {
            mins -= 60;
        }
        return mins;
    }

    public double hoursToDecimals(int hours, int mins) {
        double convertedTime = hours;
        double minsDec = mins / 60.0;
        convertedTime += minsDec;
        return convertedTime;
    }
}
