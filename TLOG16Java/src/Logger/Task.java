package Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author stampel Task class: taskId :String startTime :LocalTime endTime
 * :LocalTime comment :String
 */
public class Task implements Util {

    private String taskId;
    private String comment;
    private String startTimeString;
    private String endTimeString;
    private int[] startTimeArray;
    private int[] endTimeArray;

    @SuppressWarnings("empty-statement")
    public Task(String taskIdI,
            String commentI,
            String startTimeI,
            String endTimeI) {

        this.taskId = taskIdI;
        this.startTimeString = startTimeI;
        this.endTimeString = endTimeI;
        this.comment = commentI;

        try {

            LocalTime l = LocalTime.parse(this.startTimeString);
            int hour = l.getHour();
            int minute = l.getMinute();

            this.startTimeArray = new int[2];
            this.startTimeArray[0] = hour;
            this.startTimeArray[1] = minute;

        } catch (DateTimeParseException ex) {

            System.out.println(ex.getErrorIndex() + ": " + ex.getParsedString());

        }

        try {

            LocalTime l = LocalTime.parse(this.endTimeString);
            int hour = l.getHour();
            int minute = l.getMinute();

            this.endTimeArray = new int[2];
            this.endTimeArray[0] = hour;
            this.endTimeArray[1] = minute;

        } catch (DateTimeParseException ex) {

            System.out.println(ex.getErrorIndex() + ": " + ex.getParsedString());

        }

    }

    public Task(String taskIdI,
            String commentI,
            int[] startTimeI,
            int[] endTimeI) {

        this.taskId = taskIdI;

        if (startTimeI.length != 2 && endTimeI.length != 2) {

            System.out.println("Input is wrong");
            return;

        }
        this.startTimeString = this.arrayTimeToString(startTimeI);
        this.endTimeString = this.arrayTimeToString(endTimeI);
        this.comment = commentI;

        try {

            LocalTime l = LocalTime.parse(this.startTimeString);
            int hour = l.getHour();
            int minute = l.getMinute();

            this.startTimeArray = new int[2];
            this.startTimeArray[0] = hour;
            this.startTimeArray[1] = minute;

        } catch (DateTimeParseException ex) {

            System.out.println(ex.getErrorIndex() + ": " + ex.getParsedString());

        }

        try {

            LocalTime l = LocalTime.parse(this.endTimeString);
            int hour = l.getHour();
            int minute = l.getMinute();

            this.endTimeArray = new int[2];
            this.endTimeArray[0] = hour;
            this.endTimeArray[1] = minute;

        } catch (DateTimeParseException ex) {

            System.out.println(ex.getErrorIndex() + ": " + ex.getParsedString());

        }

    }

    public Task(String taskIdI,
            String commentI,
            int[] startTimeI) {

        this.taskId = taskIdI;

        if (startTimeI.length != 2) {

            System.out.println("Input is wrong");
            return;

        }
        this.startTimeString = this.arrayTimeToString(startTimeI);
        this.comment = commentI;

        try {

            LocalTime l = LocalTime.parse(this.startTimeString);
            int hour = l.getHour();
            int minute = l.getMinute();

            this.startTimeArray = new int[2];
            this.startTimeArray[0] = hour;
            this.startTimeArray[1] = minute;

        } catch (DateTimeParseException ex) {

            System.out.println(ex.getErrorIndex() + ": " + ex.getParsedString());

        }

    }

    public Task(String taskIdI,
            int[] startTimeI,
            int[] endTimeI) {

        this.taskId = taskIdI;

        if (startTimeI.length != 2 && endTimeI.length != 2) {

            System.out.println("Input is wrong");
            return;

        }
        this.startTimeString = this.arrayTimeToString(startTimeI);
        this.endTimeString = this.arrayTimeToString(endTimeI);
        this.comment = this.startTimeString;

        try {

            LocalTime l = LocalTime.parse(this.startTimeString);
            int hour = l.getHour();
            int minute = l.getMinute();

            this.startTimeArray = new int[2];
            this.startTimeArray[0] = hour;
            this.startTimeArray[1] = minute;

        } catch (DateTimeParseException ex) {

            System.out.println(ex.getErrorIndex() + ": " + ex.getParsedString());

        }

        try {

            LocalTime l = LocalTime.parse(this.endTimeString);
            int hour = l.getHour();
            int minute = l.getMinute();

            this.endTimeArray = new int[2];
            this.endTimeArray[0] = hour;
            this.endTimeArray[1] = minute;

        } catch (DateTimeParseException ex) {

            System.out.println(ex.getErrorIndex() + ": " + ex.getParsedString());

        }

    }

    public Task(String taskIdI,
            int[] startTimeI) {

        this.taskId = taskIdI;

        if (startTimeI.length != 2) {

            System.out.println("Input is wrong");
            return;

        }

        this.startTimeString = this.arrayTimeToString(startTimeI);
        this.comment = this.startTimeString;

        try {

            LocalTime l = LocalTime.parse(this.startTimeString);
            int hour = l.getHour();
            int minute = l.getMinute();

            this.startTimeArray = new int[2];
            this.startTimeArray[0] = hour;
            this.startTimeArray[1] = minute;

        } catch (DateTimeParseException ex) {

            System.out.println(ex.getErrorIndex() + ": " + ex.getParsedString());

        }

    }

    public Task(String taskIdI,
            String startTimeI) {

        this.taskId = taskIdI;
        this.startTimeString = startTimeI;
        //  this.endTimeString = endTimeI;
        this.comment = startTimeI;

        try {

            LocalTime l = LocalTime.parse(this.startTimeString);
            int hour = l.getHour();
            int minute = l.getMinute();

            this.startTimeArray = new int[2];
            this.startTimeArray[0] = hour;
            this.startTimeArray[1] = minute;

        } catch (DateTimeParseException ex) {

            System.out.println(ex.getErrorIndex() + ": " + ex.getParsedString());

        }

    }

    public Task(String taskIdI,
            String UnknowData1,
            String UnknowData2) {

        try {
            LocalTime.parse(UnknowData1);
            try {
                LocalTime.parse(UnknowData2);
                this.TaskWithEndTimeStringNotComment(taskIdI, UnknowData1, UnknowData2);

            } catch (DateTimeParseException ex) {
                System.out.println(ex.getMessage() + " " + ex.getParsedString());

            }

        } catch (DateTimeParseException ex) {

            this.TaskNotEndTimeString(taskIdI, UnknowData1, UnknowData2);
        }

    }

    private String arrayTimeToString(int[] timeI) {

        String timeString;
        if (timeI[0] > 9) {
            timeString = timeI[0] + ":";
        } else {
            timeString = "0" + timeI[0] + ":";
        }

        if (timeI[1] > 9) {
            timeString += timeI[1];
        } else {
            timeString += "0" + timeI[1];
        }

        return timeString;
    }

    private void TaskNotEndTimeString(String taskIdI,
            String commentI,
            String startTimeI) {

        this.taskId = taskIdI;
        this.startTimeString = startTimeI;
        //this.endTimeString = endTimeI;
        this.comment = commentI;

        try {

            LocalTime l = LocalTime.parse(this.startTimeString);
            int hour = l.getHour();
            int minute = l.getMinute();

            this.startTimeArray = new int[2];
            this.startTimeArray[0] = hour;
            this.startTimeArray[1] = minute;

        } catch (DateTimeParseException ex) {

            System.out.println(ex.getErrorIndex() + ": " + ex.getParsedString() + " " + ex.getMessage());

        }

    }

    private void TaskWithEndTimeStringNotComment(String taskIdI,
            String startTimeI,
            String endTimeI) {

        this.taskId = taskIdI;
        this.startTimeString = startTimeI;
        this.endTimeString = endTimeI;
        this.comment = startTimeI;

        try {

            LocalTime l = LocalTime.parse(this.startTimeString);
            int hour = l.getHour();
            int minute = l.getMinute();

            this.startTimeArray = new int[2];
            this.startTimeArray[0] = hour;
            this.startTimeArray[1] = minute;

        } catch (DateTimeParseException ex) {

            System.out.println(ex.getErrorIndex() + ": " + ex.getParsedString());

        }

        try {

            LocalTime l = LocalTime.parse(this.endTimeString);
            int hour = l.getHour();
            int minute = l.getMinute();

            this.endTimeArray = new int[2];
            this.endTimeArray[0] = hour;
            this.endTimeArray[1] = minute;

        } catch (DateTimeParseException ex) {

            System.out.println(ex.getErrorIndex() + ": " + ex.getParsedString());

        }

    }

    public String getTaskId() {

        return this.taskId;

    }

    public LocalTime getStartTime() {

        return LocalTime.parse(this.startTimeString);

    }

    public LocalTime getEndTime() {
        try {
            return LocalTime.parse(this.endTimeString);
        } catch (NullPointerException ex) {
            return null;
        }

    }

    public String getStartTimeToString() {

        return this.startTimeString;

    }

    public String getEndTimeToString() {
        // try {
        System.out.println(this.endTimeString);
        return this.endTimeString;
        /* } catch (NullPointerException ex) {
            return null;
        }*/

    }

    public String getComment() {

        return this.comment;

    }

    /*
 * boolean isValidTaskId():
 *   boolean (Valid Ids: 4 digits or LT-{4 digits} for example: LT-4863)
     */
    public boolean isValidTaskId() {

        String regExp = "(L)(T)(-)\\d\\d\\d\\d";
        return this.taskId.matches(regExp);
    }

    public boolean isValidLTTaskId() {

        String regExp = "(L)(T)(-)\\d";
        return this.taskId.matches(regExp);
    }

    public boolean isValidRedmineTaskId() {

        String regExp = "\\d\\d\\d\\d";
        return this.taskId.matches(regExp);
    }

    /*
 * boolean isMultipleQuarterHour():
 *   boolean (check if the time interval's length is multiple of the quarter hour)
     */
    public boolean isMultipleQuarterHour() {

        if (this.startTimeArray == null || this.endTimeArray == null) {
            return true;
        }
        long minutes = Duration.between(LocalTime.parse(this.startTimeString), LocalTime.parse(this.endTimeString)).toMinutes();

        if (minutes % 15 == 0 && minutes > 15) {

            return true;

        }

        return false;

    }

    public void endTaskWithString(String endTimeStringI) {

        try {
            this.endTimeString = endTimeStringI;
            this.endTimeArray = new int[2];
            this.endTimeArray[0] = LocalTime.parse(this.endTimeString).getHour();
            this.endTimeArray[1] = LocalTime.parse(this.endTimeString).getMinute();

        } catch (DateTimeParseException ex) {
            System.out.println(ex.getErrorIndex() + ": " + ex.getParsedString());
        }

    }

    public void endTaskWithArray(int[] endTimeArrayI) {

        if (endTimeArrayI.length != 2) {
            System.out.println("Wrong Input!");
            return;
        }

        try {
            this.endTimeString = endTimeArrayI[0] + ":" + endTimeArrayI[1];
            LocalTime.parse(this.endTimeString);
            this.endTimeArray = new int[2];
            this.endTimeArray = endTimeArrayI;

        } catch (DateTimeParseException ex) {
            System.out.println(ex.getErrorIndex() + ": " + ex.getParsedString());
        }

    }

}
