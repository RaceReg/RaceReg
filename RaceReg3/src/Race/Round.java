/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Race;

import Racer.Racer;
import java.util.ArrayList;

/**
 * This is the Round class - it contains heats and runners. 
 * @author Jackson Porter
 * @verison 1.0.0
 */
public class Round {
    //Global Variables
    private ArrayList<Heat> heats;
    private int ID;
    private int numOfHeats;
    
    /**
     * This constructor creates a new Round.
     * @param i Round ID.
     */
    public Round(int i) 
    {
        heats = new ArrayList<Heat>();
        ID = i;        
    }
    
    
    /**
     * Adds a new heat to this round with a given ID.
     * @param heatnum Heat ID
     */
    public void addHeat(String heatnum)
    {
        Heat newHeat = new Heat(Integer.parseInt(heatnum));
        heats.add(newHeat);
        
        //System.out.println("Heat number: " + heats.get(0));
    }
    
    /**
     * Adds a Racer to a Heat in this round.
     * @param heatnum Desired Heat ID (given as a String)
     * @param r New Racer object to be added to the Heat. 
     */
    public void addRacerToHeat(String heatnum, Racer r)
    {
        //Find heat index and add racer.
        for(int i = 0; i < heats.size(); i++)
        {
            if(heats.get(i).getHeatNum() == Integer.parseInt(heatnum))
            {
                heats.get(i).addRacer(r);
            }
        }
        
        
    }
    
    /**
     * Returns a Heat object given a Heat ID.
     * @param id Heat ID that is desired to be returned.
     * @return Heat object
     */
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

    /**
     * Returns the most recently created Heat. 
     * @return Heat object
     */
    public Heat returnMostRecentHeat()
    {
        return heats.get(heats.size() - 1);
    }
    
    public int getRoundID()
    {
        return ID;
    }

    public int getNumberOfHeats() 
    {
       return heats.size();
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
