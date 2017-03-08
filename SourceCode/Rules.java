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
public interface Rules {
    public boolean checkWin(ArrayList<Object> Gamestate);
    public boolean legalMove(ArrayList<Point2D> inputMove,ArrayList<Object> Gamestate);
    
    
}
