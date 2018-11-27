package Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.time.*;
/**
 *
 * @author stampel
 * Task class:
 *      taskId    :String
 *      startTime :LocalTime
 *      endTime   :LocalTime
 *      comment   :String
 */
public class Task {
  private      String        taskId;
  private      LocalTime     startTime;
  private      LocalTime     endTime;
  private      String        comment;
  
  Task (String        taskIdI,
        String        commentI,
        LocalTime     startTimeI,
        LocalTime     endTimeI) {
      
    this.taskId = taskIdI;
    this.startTime = startTimeI;
    this.endTime = endTimeI;
    this.comment = commentI;
  
  }
  Task (String        taskIdI,
        LocalTime     startTimeI,
        LocalTime     endTimeI) {
      
    this.taskId = taskIdI;
    this.startTime = startTimeI;
    this.endTime = endTimeI;
    this.comment = startTimeI.getHour()+":"+startTime.getMinute();
  
  }
  
  public String getTaskId() {
    
    return this.taskId;

  }
  public LocalTime getStartTime() {
    
    return this.startTime;

  }
  public LocalTime getEndTime() {
    
    return this.endTime;

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
  
  
/*
 * boolean isMultipleQuarterHour():
 *   boolean (check if the time interval's length is multiple of the quarter hour)
 */
  
  public boolean isMultipleQuarterHour() {
      
      long minutes = Duration.between(this.startTime, this.endTime).toMinutes();
      
      if (minutes % 15 == 0 && minutes > 15) {
          
          return true;
          
      }
      
      return false;
  }
    
}