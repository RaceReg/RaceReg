/*
 * This file contains the Racer class.
 */
package Racer;

import Timer.Time;

/**
 * This is the Racer class - it contains the information needed for a Racer.
 * @author Jackson Porter
 * @version 1.0.0
 */
public class Racer {
    //Global Variables
    private int ID;
    private int age;
    private int lane;
    private String lastName;
    private String firstName;
    private String affiliation;
    private Time time;
    private String place;
    
    
    public Racer(int i, int ag, int ln, String l, String f, String a, String t)
    {
        ID = i;
        age = ag;
        lane = ln;
        
        lastName = l;
                
        //Last name ending and before quotes check
        try
        {
            if(lastName.charAt(0) == '\"')
            {
                lastName = lastName.substring(1);
            }
            if(lastName.charAt(lastName.length() - 1) == '\"')
            {
                lastName = lastName.substring(0, lastName.length() - 1);
            } 
        }catch(java.lang.StringIndexOutOfBoundsException e)
        {
            System.out.println("Ignoring - blank string");
        }
        
        
        firstName = f;
        
        
        try
        {
            //First name ending and before quotes check
            if(firstName.charAt(0) == '\"')
            {
                firstName = firstName.substring(1);
            }
            if(firstName.charAt(firstName.length() - 1) == '\"')
            {
                firstName = firstName.substring(0, firstName.length() - 1);
            } 
        }catch(java.lang.StringIndexOutOfBoundsException e)
        {
            System.out.println("Ignoring - blank string");
        }
        
        
        
        affiliation = a;
        
        try
        {
            //affiliation name ending and before quotes check
            {
                affiliation = affiliation.substring(1);
            }
            if(affiliation.charAt(affiliation.length() - 1) == '\"')
            {
                affiliation = affiliation.substring(0, affiliation.length() - 1);
            }
        }catch(java.lang.StringIndexOutOfBoundsException e)
        {
            System.out.println("Ignoring - blank string");
        }
        
        
        
        
        time = new Time(t);
    }
    
    
//    public Racer(int p, int i, int ln, String l, String f, String a, String t)
//    {
//        place = p + "";
//        ID = i;
//        lane = ln;
//        
//        lastName = l;
//                
//        //Last name ending and before quotes check
//        if(lastName.charAt(0) == '\"')
//        {
//            lastName = lastName.substring(1);
//        }
//        if(lastName.charAt(lastName.length() - 1) == '\"')
//        {
//            lastName = lastName.substring(0, lastName.length() - 1);
//        }
//        
//        firstName = f;
//        
//        //First name ending and before quotes check
//        if(firstName.charAt(0) == '\"')
//        {
//            firstName = firstName.substring(1);
//        }
//        if(firstName.charAt(firstName.length() - 1) == '\"')
//        {
//            firstName = firstName.substring(0, firstName.length() - 1);
//        }
//        
//        affiliation = a;
//        
//        //affiliation name ending and before quotes check
//        if(affiliation.charAt(0) == '\"')
//        {
//            affiliation = affiliation.substring(1);
//        }
//        if(affiliation.charAt(affiliation.length() - 1) == '\"')
//        {
//            affiliation = affiliation.substring(0, affiliation.length() - 1);
//        }
//        time = new Time(t);
//    }
//    
//    public Racer(int i, int ln, String l, String f, String a)
//    {
//        ID = i;
//        lane = ln;     
//        
//        lastName = l;
//
//        try
//        {
//            //Last name ending and before quotes check
//            if(lastName.charAt(0) == '\"')
//            {
//                lastName = lastName.substring(1);
//            }
//            if(lastName.charAt(lastName.length() - 1) == '\"')
//            {
//                lastName = lastName.substring(0, lastName.length() - 1);
//            }
//        }catch(java.lang.StringIndexOutOfBoundsException e)
//        {
//            lastName = "";
//        }
//        
//        try
//        {
//            firstName = f;
//        
//            //First name ending and before quotes check
//            if(firstName.charAt(0) == '\"')
//            {
//                firstName = firstName.substring(1);
//            }
//            if(firstName.charAt(firstName.length() - 1) == '\"')
//            {
//                firstName = firstName.substring(0, firstName.length() - 1);
//            }
//        }catch(java.lang.StringIndexOutOfBoundsException e)
//        {
//            firstName = "";
//        }
//        
//        
//        
//        
//        affiliation = a;
//        
//        //affiliation name ending and before quotes check
//        if(affiliation.charAt(0) == '\"')
//        {
//            affiliation = affiliation.substring(1);
//        }
//        if(affiliation.charAt(affiliation.length() - 1) == '\"')
//        {
//            affiliation = affiliation.substring(0, affiliation.length() - 1);
//        }
//        
//        time = new Time("");
//    }
//    
//    public Racer(String l)
//    {
//        ID = 0;
//        lane = Integer.parseInt(l);
//        lastName = "";
//        firstName = "";
//        affiliation = "";
//        time = new Time("");
//    }

    public String getInfo() 
    {
        return "ID: " + ID + ", Lane: " + lane + ", Name: " + firstName + " " + lastName + ", School: " + affiliation + ", Time: " + time;
    }
    
    public String getPlace()
    {
        return place;
    }
    
    public Time getTime()
    {
        return time;
    }
    
    public Integer getLane()
    {
        return lane;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLifInfo(Racer previous)
    {
        Time deltaTime = previous.getTime().subtractATime(time);
        
        return place + "," + ID + "," + lane + "," + lastName + "," + firstName + "," + affiliation + "," + time + "," + "," + deltaTime + "," + "," + "," + "," + "," + "," + ",";
    }

    public String getLifInfoFirstPlace() {
        return place + "," + ID + "," + lane + "," + lastName + "," + firstName + "," + affiliation + "," + time + "," + "," + time + "," + "," + "," + "," + "," + "," + ",";
    }
    
    public void setTime(Time t)
    {
        time = t;
    }

    void setPlace(int p) 
    {
        if(p == -1)
        {
            place = "DNS";
        }
        else           
        {
            place = p + "";
        }
    }

    public Integer getID()
    {
        return ID;
    }
    
    public String getAge() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getRaceType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getGender() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
