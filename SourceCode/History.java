/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.util.ArrayList;
import javafx.geometry.Point2D;

/**
 *
 * @author Tom
 */
public interface History {
   public void addMove(ArrayList<Point2D> inputMove); 
    
   public ArrayList<ArrayList<Point2D>> getCurrentState();
    
   public int getTurnCount();
    
            
            
}

