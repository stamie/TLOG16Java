package Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.time.*;
import java.time.format.DateTimeParseException;

/**
 *
 * @author stampel Task class: taskId :String startTime :LocalTime endTime
 * :LocalTime comment :String
 */
public class Task implements Util{

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
    
    
    public Task(String taskIdI,
            String commentI,
            int[] startTimeI,
            int[] endTimeI) {

        this.taskId = taskIdI;
        
        if (startTimeI.length != 2 && endTimeI.length != 2) {
        
                System.out.println("Input is wrong");
                return;
        
        }
        this.startTimeString = startTimeI[0] + ":" + startTimeI[1];
        this.endTimeString = endTimeI[0] + ":" + endTimeI[1];
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
            int[] startTimeI,
            int[] endTimeI) {

        this.taskId = taskIdI;
        
        if (startTimeI.length != 2 && endTimeI.length != 2) {
        
                System.out.println("Input is wrong");
                return;
        
        }
        this.startTimeString = startTimeI[0] + ":" + startTimeI[1];
        this.endTimeString = endTimeI[0] + ":" + endTimeI[1];
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

    public String getTaskId() {

        return this.taskId;

    }

    public LocalTime getStartTime() {

        return LocalTime.parse(this.startTimeString);

    }

    public LocalTime getEndTime() {

        return LocalTime.parse(this.endTimeString);

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

        long minutes = Duration.between(LocalTime.parse(this.startTimeString), LocalTime.parse(this.endTimeString)).toMinutes();

        if (minutes % 15 == 0 && minutes > 15) {

            return true;

        }

        return false;
    }

}
