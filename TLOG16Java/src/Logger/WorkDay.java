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
           long requiredMinPerDay = 450;
           LocalDate actualDay;
           long sumPerDay; //calculations
           
           WorkDay( List <Task> tasksI,
                    LocalDate actualDayI,
                    long requiredMinPerDayI// = null
           ) {
               
               this.tasks = tasksI;
               this.requiredMinPerDay = requiredMinPerDayI;
               this.actualDay = actualDayI;
               this.calculateSumPerDay();
           
           
           
           }
           WorkDay( List <Task> tasksI,
                    LocalDate actualDayI
           ) {
               
               this.tasks = tasksI;
               this.actualDay = actualDayI;
               this.calculateSumPerDay();
           
           
           
           }
           
           private void calculateSumPerDay() {
               
               this.sumPerDay = 0;
               for(Task task: this.tasks){
                   
                   Duration duration = Duration.between(task.getStartTime(), task.getEndTime());
               
                   this.sumPerDay += duration.toMinutes();
           
               }
           
           
           
           }
 
    
}
