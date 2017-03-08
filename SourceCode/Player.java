/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import javafx.geometry.Point2D;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public interface Player {
    ArrayList<Point2D> move(ArrayList<Object> input);
}
