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
        LocalTime     startTimeI,
        LocalTime     endTimeI,
        String        commentI) {
      
    this.taskId = taskIdI;
    this.startTime = startTimeI;
    this.endTime = endTimeI;
    this.comment = commentI;
  
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
  
    
    
}
