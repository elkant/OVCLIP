/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ovc;

import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author MANUEL
 */
public class gen {
    
    
    //====================random id functions================================ 
    public String uniqueid() {

        Calendar cal = Calendar.getInstance();

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int date = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        int milsec = cal.get(Calendar.MILLISECOND);


        return year + "" + month + "" + date + hour + min + sec + milsec + generateRandomNumber(800, 9000);
    }

    public int generateRandomNumber(int start, int end) {
        Random random = new Random();
        long fraction = (long) ((end - start + 1) * random.nextDouble());
        return ((int) (fraction + start));
    }
//==========================================================================


    
}
