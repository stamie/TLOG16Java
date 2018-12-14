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
        if (!timeLogger.listMonths())
            System.out.println("No items");
        System.out.println();
        return;

    }

    public void listDays(TimeLogger timeLogger) {

    }

    public void listTasks(TimeLogger timeLogger) {

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

    public void addDay(TimeLogger timeLogger) {

    }

    public void startTask(TimeLogger timeLogger) {

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
