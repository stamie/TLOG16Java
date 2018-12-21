/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextBasedUI;

import Logger.Task;
import Logger.WorkDay;
import Logger.WorkMonth;
import Logger.TimeLogger;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author stampel
 */
/*
0. Exit
1. List months: shows a counter, the year & the month line by line (example: 1. 2016-09, 2. 2016-10, ...)
2. List days:
lists the months, select one by ask for row number
list all workdays of this month
3. List tasks for a specific day (ask for month & day)
4. Add new month: specify year & month with integers
5. Add day to a specific month:
list the workmonths (2. menu item)
ask the index of workmonth
ask the day
ask the required working hours, default value=7.5
6. Start a task for a day
ask for month, day, task id, what you do (comment)
ask for start time in format 10:30 
if there is a task in the day, get the end time of the last task and show it in braces! If the user enters an empty value, save that time in the task!
don't ask for the end time!
7. Finish a specific task: 
ask for month & day, 
display only unfinished tasks
ask for end time (format: 12:45, with validation)
8. Delete a task: ask for month, day, select task - ask for confirmation!
9. Modify task: ask for month, day, task, let change every fields (shows previous value in braces, if the input is empty, don't change the value!)
10. Statistics: ask for month, then print the statistics of the month, and the statistics of the days of this month
 */
public class TimeLoggerUI {

    public boolean TimeLoggerUICreat(int input, TimeLogger timeLogger) {

        switch (input) {

            case 0: // Exit
                return false;
            case 1: // List months: shows a counter, the year & the month line by line (example: 1. 2016-09, 2. 2016-10, ...)
                listMonths(timeLogger);
                break;
            case 2:
                /* List days:
lists the months, select one by ask for row number
list all workdays of this month */
                listDays(timeLogger);
                break;

            case 3: // List tasks for a specific day (ask for month & day)
                listTasks(timeLogger);
                break;
            case 4: // Add new month: specify year & month with integers
                addNewMonth(timeLogger);
                break;
            case 5:
                /* Add day to a specific month:
list the workmonths (2. menu item)
ask the index of workmonth
ask the day
ask the required working hours, default value=7.5 */
                addDay(timeLogger);
                break;
            case 6:
                /* Start a task for a day
ask for month, day, task id, what you do (comment)
ask for start time in format 10:30 
if there is a task in the day, get the end time of the last task and show it in braces! If the user enters an empty value, save that time in the task!
don't ask for the end time! */
                startTask(timeLogger);
                break;
            case 7:
                /* Finish a specific task: 
ask for month & day, 
display only unfinished tasks
ask for end time (format: 12:45, with validation)*/
                finishASpecificTask(timeLogger);
                break;
            case 8: // Delete a task: ask for month, day, select task - ask for confirmation!
                deleteTask(timeLogger);
                break;
            case 9: // Modify task: ask for month, day, task, let change every fields (shows previous value in braces, if the input is empty, don't change the value!)
                modifyTask(timeLogger);
                break;
            case 10: // Statistics: ask for month, then print the statistics of the month, and the statistics of the days of this month    
                statistics(timeLogger);
                break;
            default:
                System.out.println("Wrong function key!");
                break;
        }

        return true;
    }

    public void listMonths(TimeLogger timeLogger) {

        System.out.println("List of month:");
        if (!timeLogger.listMonths()) {
            System.out.println("No items");
        }
        System.out.println();
        return;

    }

    public WorkMonth listDays(TimeLogger timeLogger) {
        this.listMonths(timeLogger);

        if (timeLogger.getMonths().isEmpty()) {
            return null;
        }

        Scanner in = new Scanner(System.in);
        int monthNum;
        while (1 == 1) {
            System.out.print("Months number is: ");
            monthNum = in.nextInt();

            if (monthNum > timeLogger.getMonths().size() || monthNum < 1) {
                System.out.println("Wrong number");
            } else {
                break;
            }
        }

        monthNum--;

        WorkMonth month = timeLogger.getMonths().get(monthNum);

        if (!month.listDays()) {
            System.out.println("It haven't work days.");
            return null;

        }
        System.out.println();
        return month;
    }

    // List tasks for a specific day (ask for month & day)
    public WorkDay listTasks(TimeLogger timeLogger) {

        WorkMonth wm = this.listDays(timeLogger);
        if (wm != null) {
            int dayNum = 0;

            while ((dayNum > wm.getDays().size() || dayNum == 0) && wm.getDays().size() > 0) {
                Scanner in = new Scanner(System.in);
                dayNum = in.nextInt();
            }

            //TODO: testing the tasks list printer
            if (dayNum > 0) {
                WorkDay wd = wm.getDays().get(--dayNum);

                wd.listTask();
                return wd;

            }

        }
        return null;
    }

    public void addNewMonth(TimeLogger timeLogger) {

        Scanner in = new Scanner(System.in);
        System.out.print("Year: ");
        int year = in.nextInt();
        System.out.print("Month: ");
        int month = in.nextInt();
        WorkMonth wm = new WorkMonth(year, month);
        timeLogger.addMonth(wm);

    }

    /*
    Add day to a specific month:
        -list the workmonths (2. menu item)
        -ask the index of workmonth
        -ask the day
        -ask the required working hours, default value=7.5
     */
    public void addDay(TimeLogger timeLogger) {

        this.listMonths(timeLogger); //list the workmonths (2. menu item)

        if (timeLogger.getMonths().isEmpty()) {
            return;
        }
        //ask the index of workmonth:
        Scanner in = new Scanner(System.in);
        int month;
        while (1 == 1) {
            System.out.print("Months number is: ");
            month = in.nextInt();

            if (month > timeLogger.getMonths().size() || month < 1) {
                System.out.println("Wrong number!");
            } else {
                break;
            }
        }

        month--;

        //ask the day
        int day;
        while (1 == 1) {
            System.out.print("Add day: ");

            day = in.nextInt();
            if (day > 0 && day < 32) {
                break;
            }
            System.out.println("Wrong day numbers!");
        }

        int[] actualDay = new int[3];
        actualDay[0] = timeLogger.getMonths().get(month).getDate().getYear();
        actualDay[1] = timeLogger.getMonths().get(month).getDate().getMonthValue();
        actualDay[2] = day;

        //ask the required working hours, default value=7.5
        System.out.print("Required working hours: ");

        float hours;
        try {
            Scanner in2 = new Scanner(System.in);
            String hoursString;
            hoursString = "";

            hoursString += in2.nextLine();
            System.out.println("hoursString: " + hoursString);
            hours = Float.parseFloat(hoursString);

            hours = Float.parseFloat(hoursString);
        } catch (NoSuchElementException ex) {
            hours = (float) 7.5;
            System.out.println("It hasen't input! Then hours = 7.5! " + ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("Is wrong input! Then hours = 7.5!");
            hours = (float) 7.5;
        } catch (NumberFormatException ex) {
            System.out.println("Is wrong input! Then hours = 7.5! " + ex.getMessage());
            hours = (float) 7.5;
        } catch (IllegalStateException ex) {
            System.out.println("Is wrong input! Then hours = 7.5! " + ex.getMessage());
            hours = (float) 7.5;
        }

        float minuteFloat = hours * 60;

        int minute = (int) minuteFloat;

        WorkDay wd = new WorkDay(actualDay, minute);
        WorkMonth wm = timeLogger.getMonths().get(month);
        wm.addWorkDay(wd);
        if (timeLogger.isNewMonth(wm)) {
            timeLogger.addMonth(wm);
        } else {
            timeLogger.updateMonth(wm);
        }

    }

    /* Start a task for a day:
    -ask for month, day, task id, what you do (comment)
    -ask for start time in format 10:30 
        -if there is a task in the day, get the end time of the last task and show it in braces! If the user enters an empty value, save that time in the task!
    -don't ask for the end time! */
    public void startTask(TimeLogger timeLogger) {

        try {
            WorkMonth workMonth = this.listDays(timeLogger);

            if (workMonth == null || workMonth.getDays().isEmpty()) {
                return;
            }

            int dayNumber;

            while (1 == 1) {
                Scanner in = new Scanner(System.in);
                System.out.print("Select day: ");

                dayNumber = in.nextInt();
                if (dayNumber > 0 && dayNumber <= workMonth.getDays().size()) {
                    break;
                }
                System.out.println("Wrong day numbers!");
            }

            dayNumber--;

            WorkDay day = workMonth.getDays().get(dayNumber);

            Scanner in = new Scanner(System.in);

            System.out.print("TaskId: ");
            String taskId = in.nextLine();
            System.out.print("Comment: ");
            String comment = in.nextLine();
            System.out.print("StartTime: ");
            String startTime = in.nextLine();
            if (!startTime.isEmpty()) {
                LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm"));
            } else {
                startTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
            }

            Task taskI;
            if (comment.isEmpty()) {
                taskI = new Task(taskId, startTime);
            } else {
                taskI = new Task(taskId, comment, startTime);
            }

            if (day.getTasks().isEmpty()) {
                List<Task> tasks = new ArrayList();
                tasks.add(taskI);
                day.setTasks(tasks);

            } else {

                day.getTasks().add(day.getTasks().size(), taskI);
            }

            workMonth.getDays().set(dayNumber, day);
            timeLogger.updateMonth(workMonth);

        } catch (DateTimeParseException ex) {
            System.out.println(ex.getErrorIndex() + ": " + ex.getParsedString() + " " + ex.getMessage());
            return;
        }
    }

    public void finishASpecificTask(TimeLogger timeLogger) {

    }

    public void deleteTask(TimeLogger timeLogger) {

    }

    public void modifyTask(TimeLogger timeLogger) {

    }

    public void statistics(TimeLogger timeLogger) {

    }

}
