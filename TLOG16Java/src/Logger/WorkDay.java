package Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.time.*;
import java.util.List;
import Logger.Task;
import java.time.format.DateTimeFormatter;

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
           public long getRequiredMinPerDay() {
               
               return this.requiredMinPerDay;
           
           }
           
           public long getSumPerDay() {
                
               return this.sumPerDay;
           
           }
           
           public LocalDate getActualDay() {
               
               return this.actualDay;
               
           }
            
          
           
/*
 * long getExtraMinPerDay():
 *        long method, which calculates the difference between requiredMinPerDay and sumPerDay
 */
           public long getExtraMinPerDay() {
               
               return this.sumPerDay-this.requiredMinPerDay;
               
           }
/*
 * boolean isSeparatedTime(Task t):
 *         boolean method should be able to decide if the t Task has a common time interval with any 
 *         existing Task's time interval in the tasks list
 */
           
           public boolean isSeparatedTime(Task t) {
               
               for (Task t1: this.tasks) {
                   if (t1.getStartTime() == t.getStartTime() || t.getEndTime() == t1.getEndTime() ){
                       return true;
                   }
                   
                   if (Duration.between(t1.getStartTime(), t.getStartTime()).toMinutes() > 0 && Duration.between(t.getStartTime(), t1.getEndTime()).toMinutes() > 0 ){
                       return true;
                   }
                   
                   if (Duration.between(t.getEndTime(), t1.getEndTime()).toMinutes() > 0 && Duration.between(t1.getStartTime(), t.getEndTime()).toMinutes() > 0 ){
                       return true;
                   }
               
               }
               
               
               
               return false;
           }
           
/*
 * void addTask(Task t):
 *         void add a task to the list of tasks, if length is multiple of the quarter hour and the task
 *         time intervals have no common parts, the else part will be implemented later
 */
           
           public void addTask(Task t) {
               
               if (t.isMultipleQuarterHour() && !this.isSeparatedTime(t)) {
                   
                   this.insertTask(t);
               
               }
               
               
               
           }
           
           private void insertTask(Task t) {
               
               boolean first = true;
               for (Task t1: this.tasks) {
                  
                   if (first && Duration.between(t.getEndTime(), t1.getStartTime()).toMinutes() >= 0) {
                       
                       this.tasks.add(0, t);
                       return;
                   
                   
                   }
                   
                   first = false;
                   
                   
                   if (Duration.between(t1.getEndTime(), t.getStartTime()).toMinutes() >= 0) {
                       
                       this.tasks.add(t);
                       return;
                       
                   }
               
               }
               return;
           
           }
/*
 * isWeekday():boolean decide if actual day is a weekday 
 */
           public boolean isWeekday() {
               
               DateTimeFormatter format = DateTimeFormatter.ofPattern("a");
               
               String str = this.actualDay.format(format);
               
               if (str == "Sun" || str == "Sat") {
                   
                   return false;
                   
               }
               
               return true;
           
           }
           
}
