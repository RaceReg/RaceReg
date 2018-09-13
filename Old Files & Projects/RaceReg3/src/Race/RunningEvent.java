/*
 * This file contains the RunningEvent class.
 */
package Race;

import java.util.ArrayList;

/**
 * This is the RunningEvent class - which contains heats and runners. 
 * @author Jackson Porter
 */
public class RunningEvent {
    ArrayList<Round> rounds;
    int eventID;
    String name;
    String eventType;
    double eventDistance;
    
    /**
     * Creates a new Running Event with NO rounds and NO heats.
     * @param id Event ID
     * @param n Event Name
     * @param ed Event Distance (in meters) as a Double.
     */
    public RunningEvent(int id, String n, double ed, int r)
    {
        eventID = id;
        name = n;
        eventDistance = ed;
        
        //Set number of rounds and heats. 
        //Number of heats will only we set for the first round.        
        
        for(int i = 0; i < r; i++)
        {
            rounds.add(new Round(rounds.size()));
        }
        
    }
    
//    public RunningEvent(String id, String roundnum, String heatnum, String n, String et)
//    {
//        //Inialtize variables
//        rounds = new ArrayList<Round>();
//        eventID = Integer.parseInt(id);
//        roundID = Integer.parseInt(roundnum);
//        
//        addHeat(heatnum);
//        
//        name = n;
//        eventType = et;
//    }
    
    /**
     * Adds a new round to this event. 
     * @param roundNum Round ID/Number 
     */
    public void addRound(String roundNum)
    {
        Round newRound = new Round(Integer.parseInt(roundNum));
        rounds.add(newRound);
    }
    

    public Heat returnMostRecentHeat()
    {
        return rounds.get(rounds.size() - 1).returnMostRecentHeat();
    }

    //Return values to a caller
    public int getEventID()
    {
        return eventID;
    }
    public String getEventType()
    {
        return eventType;
    }
    
    /**
     * Returns the number of heats from a given Round ID.
     * @param i Round ID to return number of heats. 
     * @return Number of heats in the desired Round.
     */
    public int getNumberOfHeats(int i)
    {
        return rounds.get(i).getNumberOfHeats();
    }
    
    /**
     * Returns the name of the RunningEvent.
     * @return String containing the name of the Event.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Retuns the ID of the event.
     * @return int containing the event ID.
     */
    public int getID()
    {
        return eventID;
    }
    
    /**
     * Returns the information about this object (similar to toString) with its desendents as well
     * @return String containg the information about this RunningEvent.
     */
    public String getInfo()
    {
        String toReturn = "";
        
        for(int i = 0; i < rounds.size(); i++)
        {
            //Display heat info
            toReturn += "\tRound #: " + rounds.get(i).getRoundID() + "\n";
            toReturn += rounds.get(i).getInfo();
        }
        
        return toReturn;
    }
}
