package Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.*;
import java.util.List;
import Logger.WorkDay;

/**
 *
 * @author stampel
 * 
 *  days:List<WorkDay>
 *  date
 *  sumPerMonth
 *  requiredMinPerMonth 
 */
public class WorkMonth {
    
    private List<WorkDay> days;
    private LocalDate date;
    private long sumPerMonth;
    private long requiredMinPerMonth;
    
    /*
    WorkMonth class's methods: 
constructor which has a year, and a month paramater, but in the constructor from this informations you should create the date field
getters for all the fields 
getExtraMinPerMonth():long method should calculate, how many extra minutes did the employee work in the actual month
isNewDate(WorkDay):boolean method decides if this day is already existing or not
isSameMonth(WorkDay): boolean method decides, if this day should be in this month or it fits into an other month by date
addWorkDay(WorkDay wd, boolean isWeekendEnabled):void add a day to the list of days, if isWeekendEnabled=true. Do not add the day to the list of days, if actualDay is on the weekend and isWeekendEnabled=false. The isWeekendEnabled boolean parameter has default value=false (it means there will be an overloaded method). You should also check if the WorkDay is in this month, and if it is existing already or not .
*/
    
    
}
