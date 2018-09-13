/*
 * This file contains the driver program for the main RaceReg program. 
 */
package racereg3;

/**
 * This is the driver program the launches the appropriate program upon program start as directed by the user.
 * @author Jackson Porter
 * @version 1.0.0
 */
public class RaceReg3 {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create local variables
        MainProgram program;
        
        boolean runCommandLine = false;
        boolean runTimerOnly = false;
        boolean runRegistrationOnly = false;
        boolean runBibEntryOnly = false;
                
        //Print welcome message to the command line. 
        System.out.println("Loading RaceReg 3.0 ...\n");
        
        //Read command line arguments to see if command line verison should be ran. 
        
        //See if command line arguments exist and take not of which options have been selected.
        //Terminate the program if syntax or other error is found.
        try{
            //Check to see if syntax is correct. 
            if(args[0].charAt(0) != '-' || args[0].length() <= 1 || args.length > 1)
            {
                System.out.println("Invalid syntax on command line argument. Example: \"java -jar RaceReg3.jar -ct\"\nProgram Terminated!");
                System.exit(1);
            }
            //Check arguments and mark which were selected.
            else
            {
                for(int i = 1; i < args[0].length(); i++)
                {
                    switch (args[0].charAt(i)) 
                    {
                        case 'c':
                            runCommandLine = true;
                            break;
                        case 't':
                            runTimerOnly = true;
                            break;
                        case 'r':
                            runRegistrationOnly = true;
                            break;
                        case 'b':
                            runBibEntryOnly = true;
                            break;
                        default:
                            System.out.println("This option (" + args[0].charAt(i) + ") is not a valid option.\nProgram terminated.");
                            System.exit(1);
                            break;
                    }
                }
            }
        }catch(java.lang.ArrayIndexOutOfBoundsException e)
        {
            System.out.println("No command line options selected.");
        }
        
        //Check to see if invalid options were choosen together
        
        if((runTimerOnly && runRegistrationOnly && runBibEntryOnly) || (runTimerOnly && runRegistrationOnly) || (runRegistrationOnly && runBibEntryOnly) || (runTimerOnly && runBibEntryOnly))
        {
            System.out.println("You cannot run multiple programs at once. If you want to run the general program, do not select any of these options.");          
        }
        else if(runTimerOnly)
        {
            program = new MainProgram(2, runCommandLine);
        }
        else if(runRegistrationOnly)
        {
            program = new MainProgram(1, runCommandLine);
        }
        else if(runBibEntryOnly)
        {
            program = new MainProgram(3, runCommandLine);
        }
        else
        {
            System.out.println("Starting Combined Program.");
            program = new MainProgram(0, runCommandLine);
        }
    }
    
}
