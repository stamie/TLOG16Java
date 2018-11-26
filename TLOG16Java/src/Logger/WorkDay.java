package Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.time.*;
import java.util.List;
import Logger.Task;
/**
 *
 * @author stampel
 * 
 *          tasks             :List<Task>
 *          requiredMinPerDay :(defulte 7,5 houers)long
 *          actualDay         :LocalDate
 *          sumPerDay         :long
 */
public class WorkDay {
    
           List <Task> tasks;
           long requiredMinPerDay;
           LocalDate actualDay;
           long sumPerDay; //calculations
           
           WorkDay( LocalDate actualDayI,
                    long requiredMinPerDayI
           ) {
               
               this.requiredMinPerDay = requiredMinPerDayI;
               this.actualDay = actualDayI;
           }
           
           WorkDay( long requiredMinPerDayI
           ) {
               
               this.requiredMinPerDay = requiredMinPerDayI;
               this.actualDay = LocalDate.now();
           }
           
           WorkDay( LocalDate actualDayI
           ) {
               this.requiredMinPerDay = 450;
               this.actualDay = actualDayI;
           
           }
           
           WorkDay() {
               this.requiredMinPerDay = 450;
               this.actualDay = LocalDate.now();
           
           }
 /*
  * getters for requiredMinPerDay, sumPerDay and actualDay 
  */
           
           
/*
 * getExtraMinPerDay():long method, which calculates the difference between requiredMinPerDay and sumPerDay
 * the isSeparatedTime(Task t):boolean method should be able to decide if the t Task has a common time interval with any existing Task's time interval in the tasks list
 * addTask(Task t):void add a task to the list of tasks, if length is multiple of the quarter hour and the task time intervals have no common parts, the else part will be implemented later
 * isWeekday():boolean decide if actual day is a weekday 
 */
           
           private void calculateSumPerDay() {
               
               this.sumPerDay = 0;
               for(Task task: this.tasks){
                   
                   Duration duration = Duration.between(task.getStartTime(), task.getEndTime());
               
                   this.sumPerDay += duration.toMinutes();
           
               }
           
           
           
           }
 
    
}
