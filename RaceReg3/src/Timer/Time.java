/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Timer;

import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 *
 * @author Jackson Porter
 * @verison 1.0.0
 */
public class Time {
    //Global Variables
    private int hours;
    private int minutes;
    private double seconds;
    
    
    //Constructor
    public Time(String s)
    {
        String [] qualities = s.split(":");
        for(int i = 0; i < qualities.length; i++)
        {
            //System.out.println(i + ": " + qualities[i]);
        }
        
        if(qualities.length == 3)
        {
             hours = Integer.parseInt(qualities[0]);
             minutes = Integer.parseInt(qualities[1]);
             seconds = Double.parseDouble(qualities[2]);
        }
        else if(qualities.length == 2)
        {
            hours = 0;
            minutes = Integer.parseInt(qualities[0]);
            seconds = Double.parseDouble(qualities[1]);
        }
        else if(qualities.length == 1)
        {
            if(qualities[0].equals("TBA") || qualities[0].equals("DNS") || qualities[0].equals(""))
            {
                hours = 0;
                minutes = -1;
                seconds = 0.00;
            }
            else
            {
                hours = 0;
                minutes = 0;
                seconds = Double.parseDouble(qualities[0]);                
            }
           
            
        }
        else
        {
            hours = 0;
            minutes = 0;
            seconds = 0;
        }

    }
    
    public int getHours()
    {
        return hours;
    }
    
    public int getMinutes()
    {
        return minutes;
    }
    
    public double getSeconds()
    {
        return seconds;
    }
    
    public boolean isEmpty()
    {
        return minutes == - 1;
    }
    
    public double returnTotalTimeHours()
    {
        //MUST CONVERT ALL TIMES TO DOUBLES TO HAVE CORRECT CONVERSION
        double tempHours = hours;
        double tempMinutes = minutes;
        
        
        
        double temp = 0;
        if(minutes == -1)
        {
            temp = -1.00;
        }
        else
        {
            temp += tempHours;
            temp += (tempMinutes / 60);
            temp += (seconds / 60 / 60);
        }
        
        //System.out.println("THIS IS THE TIME's HOURS DOUBLE FORMAT: " + temp);
        
        return temp;
    }
    
    public Time subtractATime(Time t)
    {
        double hoursTotal = this.returnTotalTimeHours() - t.returnTotalTimeHours();
        
        
        int tempHours = (int) (1 % hoursTotal);
        hoursTotal -= tempHours;
                
        hoursTotal *= 60;
        int tempMinutes = (int) (1 % hoursTotal);
        hoursTotal -= tempMinutes;
        
        hoursTotal *= 60;
        double tempSeconds = round(hoursTotal, 2);
        
        String tempString = "";
        
        if(tempHours != 0)
        {
            tempString += tempHours + ":" + tempMinutes + ":" + tempSeconds;
        }
        else
        {
            tempString += tempMinutes + ":" + tempSeconds;
        }
        
        return new Time(tempString);
    }
    
    
    @Override
    public String toString()
    {
        String toReturn = "";
        
        if(minutes == -1.00)
        {
            toReturn = "DNS";
        }
        else
        {
            if(hours != 0)
            {
                toReturn += hours + ":" + minutes + ":" + seconds;
            }
            else
            {
                toReturn += minutes + ":" + seconds;
            }
        }
        
        
        return toReturn;
    }
    
    public double returnTotalTimeSeconds()
    {
        //MUST CONVERT ALL TIMES TO DOUBLES TO HAVE CORRECT CONVERSION.
        //Conversion to seconds also done here.
        double tempHours = hours * 60 * 60;
        double tempMinutes = minutes * 60;
        
        
        
        double temp = seconds;
        if(minutes == -1)
        {
            temp = -1.00;
        }
        else
        {
            temp += tempHours;
            temp += tempMinutes;
        }
        
        //System.out.println("THIS IS THE TIME's SECOND DOUBLE FORMAT: " + temp);
        
        return temp;
    }
    
}
