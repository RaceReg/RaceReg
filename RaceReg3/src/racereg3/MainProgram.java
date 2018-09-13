/*
 * This file contians the MainProgram class - the controller for the whole program.
 */
package racereg3;

import Registration.RegistrationProgram;

/**
 * This is the MainProgram class - all objects and program orginate and are controlled from here.
 * @author Jackson Porter
 * @version 1.0.0
 */
public class MainProgram {
    //Global Variables
    
    public MainProgram(Integer option, boolean cl)
    {
        //Instantiation of Global Variables
        
        
        //Only uncomment this next two line if you need to override the chosen options.
        option = 1;
        //cl = true;
        
        
        if(null != option)
        {
            switch (option) 
            {
                case 0:
                    setUpTimer();
                    setUpRegistration(cl);
                    setUpBibEntry();
                    break;
                case 1:
                    setUpRegistration(cl);
                    break;
                case 2:
                    setUpTimer();
                    break;
                case 3:
                    setUpBibEntry();
                    break;
                default:
                    System.out.print("A severe error occured.\nProgram Terminated.");
                    System.exit(1);
                    break;
            }
        }
        else
        {
            System.out.print("A severe error occured.\nProgram Terminated.");
            System.exit(1);
        }

    }
    
    
    public void setUpTimer()
    {
        
    }
    
    public void setUpRegistration(boolean cl)
    {
        RegistrationProgram registration = new RegistrationProgram(cl);
    }
    
    public void setUpBibEntry()
    {
        
    }
}
