/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logger;

import java.util.List;
import Logger.WorkMonth;

/**
 *
 * @author stampel
 */
public class TimeLogger {
    
    private List<WorkMonth> months;
    
    TimeLogger(List<WorkMonth> monthsI) {
        
        this.months = monthsI;
        
    }
    
    
/*
 * getter for months
 */
    public List<WorkMonth> getMonths() {
        
        return this.months;
        
    }
/*
 * boolean isNewMonth(WorkMonth):
 * boolean decides, if this month already exists or not
 */
    
    public boolean isNewMonth(WorkMonth wm) {
        
        for (WorkMonth wm2: this.months) {
            if (wm2.getDate() == wm.getDate()) {
                return false;
            }
        }
        return true;
    
    
    
    }
/*
 * void addMonth(WorkMonth):
 * void  adds a new month to the months list if it is new
 */
    public void addMonth(WorkMonth wm) {
        
        if (this.isNewMonth(wm)) {
            
            this.months.add(wm);
        
        }
        
    }

    
    
}
