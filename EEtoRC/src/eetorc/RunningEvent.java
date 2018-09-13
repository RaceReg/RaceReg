/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eetorc;

import java.util.ArrayList;

/**
 *
 * @author jackson
 */
class RunningEvent {
    ArrayList<Heat> heats;
    int numOfHeats;
    int runners;
    int eventID;
    int roundID;
    String name;
    String eventType;
    
    public RunningEvent(int id, String n)
    {
        eventID = id;
        name = n;
    }
    
    public RunningEvent(String id, String roundnum, String heatnum, String n, String et)
    {
        //Inialtize variables
        heats = new ArrayList<Heat>();
        eventID = Integer.parseInt(id);
        roundID = Integer.parseInt(roundnum);
        
        addHeat(heatnum);
        
        name = n;
        eventType = et;
    }
    
    //Add a heat to this event
    public void addHeat(String heatnum)
    {
        Heat newHeat = new Heat(Integer.parseInt(heatnum));
        heats.add(newHeat);
        
        //System.out.println("Heat number: " + heats.get(0));
    }
    
    public void addRunnerToHeat(String heatnum, Runner r)
    {
        //Find heat index and add racer.
        for(int i = 0; i < heats.size(); i++)
        {
            if(heats.get(i).getHeatNum() == Integer.parseInt(heatnum))
            {
                heats.get(i).addRunner(r);
            }
        }
        
        
    }
    
    public Heat returnHeatByID(int id)
    {
        for(int i = 0; i < heats.size(); i++)
        {           
            if(heats.get(i).getHeatNum() == id)
            {
                return heats.get(i);
            }
        }
        
        return null;
    }
    
    public Heat returnMostRecentHeat()
    {
        return heats.get(heats.size() - 1);
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
    public int getRoundID()
    {
        return roundID;
    }
    
    
    public int getNumberOfHeats()
    {
        return numOfHeats;
    }
    
    public int getRunners()
    {
        return runners;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getID()
    {
        return eventID;
    }
    
    public String getInfo()
    {
        String toReturn = "";
        
        for(int i = 0; i < heats.size(); i++)
        {
            //Display heat info
            toReturn += "\tHeat #: " + heats.get(i).getHeatNum() + "\n";
            toReturn += heats.get(i).getInfo();
        }
        
        return toReturn;
    }
}
