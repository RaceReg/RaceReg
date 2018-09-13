/*
 * This file contains the RegistrationProgram class. 
 */
package Registration;

import Race.RaceEditForm;
import Race.RunningEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * This is the RegistrationProgram class - it contains the tools for RaceReg registration.
 * @author Jackson Porter
 * @version 1.0.0
 */
public class RegistrationProgram {
    //Global Variables
    private ArrayList<RunningEvent> events;
    NewRacerForm racerWin;
    RegistrationWindow regWindow;
    NewRaceForm raceForm;
    RaceEditForm raceEditForm;
    Scanner input;
    
    public RegistrationProgram(boolean commandLine)
    {
        events = new ArrayList<RunningEvent>();
        
        //This section of code will only be ran in the Graphical Program.
        if(!commandLine)
        {
            racerWin = new NewRacerForm(this);
            regWindow = new RegistrationWindow(this);
            raceForm = new NewRaceForm(this);
            raceEditForm = new RaceEditForm();
            
        }
        else
        {
            input = new Scanner(System.in);
            startCommandLineMenu();
        }
        
        
    }

    void getNewRacer() 
    {
        racerWin.setVisible(true);
        racerWin.clearFields();
    }

    /**
     * The following code will append to the log file for this program. 
     * It will write the log to the same directory the .jar is executed.
     * @param s 
     */
    public void appendToLog(String s)
    {
        try
        {
            File saveFile = new File("RegistrationProgramLog.txt");
        
            //Assigns the file to write to as well as well as tell to open at the end of the file.
            FileWriter fileout = new FileWriter(saveFile, true);
            BufferedWriter writer = new BufferedWriter(fileout);


            //Date information obtained from: http://beginnersbook.com/2013/05/current-date-time-in-java/
            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            Date date = new Date();

            //Writes given message with format Date Time: Message at the end of the file.
            writer.write(df.format(date) + ": " + s + "\n");

            //Closes log file
            writer.close();
        }catch(java.io.IOException e)
        {
            System.out.println("PROGRAM ERROR - WE COULDN'T LOG TO THE LOG FILE!");
            System.exit(1);
        }       
    }
    
    /**
     * Creates new Running Event given a name, distance and number of rounds.
     * @param n Name of Running Event
     * @param d Distance of running event in meters.
     * @param r Number of Rounds to be created.
     */
    public void newRunningEvent(String n, Double d, int r) 
    {
        //For now, the ID of the event will corresponding to its position in the array.
        RunningEvent temp = new RunningEvent(events.size(), n, d, r);
    }
    
    /**
     * Opens RaceWindow to create a Race and clears its text fields.
     */
    public void openRaceWindow()
    {
        raceForm.clearWindow();
        raceForm.setVisible(true);
    }
    
    /**
     * Opens RaceEditWindow to view/edit a Race.
     */
    public void openRaceEditWindow()
    {
        raceForm.clearWindow();
        raceForm.setVisible(true);
    }
    
    void addRacer(String lName, String fName, String bibnum, String gender, String age, String race) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void deleteRacer(String editLocation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void scanForErrors() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //The following Code is only ran is the command line option is choosen.
    
    
    /**
     * Starts the command line menu for the RegistrationProgram.
     */
    private void startCommandLineMenu() 
    {        
        int userInput = -1;
        
        //Create menu and welcome message.
        System.out.println("Welcome to the Registration Program!");
        
        //Menu
        while(userInput != 0)
        {
            System.out.println("Registration Menu");
            System.out.println("\t(1) Add a Race");
            //More options can be added.
            System.out.println("\t(0) Quit");
            
            
            //Print input prompt
            System.out.print("Please select an option: ");
            
            //Get user input
            userInput = input.nextInt();
            
            switch(userInput)
            {
                case 0:
                    System.out.println("Program Terminated.");
                    System.exit(0);
                    break;
                case 1:
                    openRaceMenu();
                    break;
                default:
                    System.out.println("Invalid option.\n");
            }
        }
    }
    
    /**
     * Opens the new Race Menu on the command line.
     */
    private void openRaceMenu() 
    {
        //Variables
        String raceName = null;
        Double raceDistance;
        Integer roundNumber;
        
        //Get the name of the Race.
        System.out.print("\nPlease type the name of the Race: ");
        raceName = input.nextLine();
        
        //Validate input.
        while(raceName.equals(""))
        {
            System.out.print("\nNO NAME ENTERED! Please type the name of the Race: ");
            raceName = input.nextLine();
        }
        
        
        //Race Distance
        do
        {
            try
            {
                //Get the race distance
                System.out.print("\nPlease type the disance of the race in meters: ");
                raceDistance = input.nextDouble();

                //Validate input
                while(raceDistance < 1)
                {
                    System.out.print("\nMUST BE AT LEAST 1 METER!");
                }
            }catch(java.util.InputMismatchException e)
            {
                System.out.print("\nYOU MUST ENTER AN DECIMAL NUMBER!");
                raceDistance = -1.0;
            }
        }
        while(raceDistance < 1);
        
        
        
        
        
        //Round Number
        do
        {
            try
            {
                //Get the number of rounds
                System.out.print("\nPlease type the number of rounds that this event will have: ");
                roundNumber = input.nextInt();

                //Validate input
                while(roundNumber < 1)
                {
                    System.out.print("\nMUST BE AT LEAST 1 ROUND!");
                }
            }catch(java.util.InputMismatchException e)
            {
                System.out.print("\nYOU MUST ENTER AN INTEGER!");
                roundNumber = -1;
            }
        }
        while(raceDistance < 1);
        
        
        
        //Print completion message.
        System.out.println("Race Created.\n");
    }
}
