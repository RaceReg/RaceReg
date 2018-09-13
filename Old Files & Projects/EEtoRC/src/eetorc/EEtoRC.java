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
public class EEtoRC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
        ArrayList<RunningEvent> events = new ArrayList<RunningEvent>();
        
        MainWindow window = new MainWindow(events);       
        
    }
    
}
