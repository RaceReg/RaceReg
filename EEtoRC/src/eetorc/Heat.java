/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eetorc;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jackson
 */
public class Heat {
    private ArrayList<Runner> runners;
    private int heatNum;
    
    public Heat(int n)
    {
        runners = new ArrayList<Runner>();
        heatNum = n;
    }
    
    public void addRunner(Runner r)
    {
        runners.add(r);
    }
    
    public String getLifInfo()
    {
        //Sorts runners by place the lane for no time. If place numbers are not on the runners, they will be added. 
        addPlaceNumber();
        
        String lifInfo = "";      
        
        for(int i = 0; i < runners.size(); i++)
        {
            if(i == 0)
            {
                lifInfo += runners.get(i).getLifInfoFirstPlace() + "\n";
            }
            else
            {
                lifInfo += runners.get(i).getLifInfo(runners.get(i-1)) + "\n";
            }
            
        }
        
        return lifInfo;
    }
    
    public int getHeatNum()
    {
        return heatNum;
    }
    
    public String getInfo()
    {
        String toReturn = "";
        
        for(int i = 0; i < runners.size(); i++)
        {
            toReturn += "\t\t" + runners.get(i).getInfo() + "\n";
        }
        
        return toReturn;
    }

    public void addTimeToRunner(String lane, String t)
    {
        for(int i = 0; i < runners.size(); i++)
        {
            if(runners.get(i).getLane() == Integer.parseInt(lane))
            {
                runners.get(i).setTime(new Time(t));
                //runners.get(i).populateSpeed(
                
                break;
            }
        }
    }

    public void addPlaceNumber()
    {
        //This method can only be called once each racer has a time. 
        ArrayList<Runner> temp = new ArrayList<Runner>();
        ArrayList<Runner> temp2 = new ArrayList<Runner>();
        ArrayList<Runner> noTimesTemp = new ArrayList<Runner>();
        
        
        while(runners.size() != 0)
        {           
            int index = 0;
            Runner top = null;
            boolean noTime = false;
            
            for(int i = 0; i < runners.size(); i++)
            {
                //Check to see if we are the first item
                if(top == null)
                {
                    if(runners.get(i).getTime().returnTotalTimeSeconds() == -1.00)
                    {
                        noTime = true;
                        index = i;
                        break;
                    }
                    else
                    {
                        top = runners.get(i);
                        index = 0;  
                    }                                     
                }
                //Check to see if no time is listed
                else if(runners.get(i).getTime().returnTotalTimeSeconds() == -1.00)
                {               
                    noTime = true;
                    index = i;
                    break;
                }
                //Compare time with current highest
                else if(runners.get(i).getTime().returnTotalTimeSeconds() < top.getTime().returnTotalTimeSeconds())
                {                
                    top = runners.get(i);
                    index = i;
                }
            }
            
            if(noTime)
            {
                noTimesTemp.add(runners.get(index));
            }
            else
            {
                temp.add(runners.get(index));
            }            
            runners.remove(index);                        
        }
        
        //Assign place values to those who had times. 
        for(int k = 0; k < temp.size(); k++)
        {
            temp.get(k).setPlace(k + 1);
        }
        
        //Assign "DNS" to runners without a time.     
        for(int l = 0; l < noTimesTemp.size(); l++)
        {
            noTimesTemp.get(l).setPlace(-1);
        }
        
        //Sort by lane those without a time.         
        while(noTimesTemp.size() != 0)
        {           
            int index = -1;
            for(int i = 0; i < noTimesTemp.size(); i++)
            {
                if(noTimesTemp.get(i).getLane() > -1)
                {                   
                    index = i;
                }
            }
            
            temp2.add(noTimesTemp.get(index));
            noTimesTemp.remove(index);            
        }
        
        //Reverse the order
        while(temp2.size() != 0)
        {
            temp.add(temp2.get(temp2.size() - 1));
            temp2.remove(temp2.size() -1);
        }
       
        
        //Set the list of runners to our sorted list. 
        runners = temp;
                
    }
    
    public ArrayList<Runner> getRunnersByLane()
    {
        addPlaceNumber();
        
        ArrayList<Runner> temp = new ArrayList<Runner>();
        ArrayList<Runner> temp2 = new ArrayList<Runner>();
        
        boolean firstTime = true;
        int index = -1;
        
        while(runners.size() != 0)
        {           
            for(int i = 0; i < runners.size(); i++)
            {
                if(firstTime)
                {
                    index = i;
                    break;
                }
                else
                {
                    if(runners.get(i).getLane() < runners.get(index).getLane())
                    {
                        index = i;
                    }
                }
            }
            
            if(firstTime)
            {
                firstTime = false;
            }
            else if(index != -1)
            {
                temp2.add(runners.get(index));
                runners.remove(index);
                firstTime = true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error! Empty Runner List! Terminating.", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }

        }  
        runners = temp2;        
        return runners;
    }
    
    int getNumRunners() {
        return runners.size();
    }
    
}
