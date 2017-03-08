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
public interface UserInterface {
//Add update void(Board) -This should displaye board

    public ArrayList<Point2D>  requestMove(ArrayList<Object> player, FooHistory GameState); // Takes in object (will check what kind of player)
        
    
}
