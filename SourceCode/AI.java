/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;
import java.util.ArrayList;
import java.util.Random;
import javafx.geometry.Point2D;

public class AI implements Player{
    public ArrayList<Point2D> move(ArrayList<Object> input)
    { 
        //takes in gamestate
        FooHistory Gamestate = (FooHistory) input.get(0);
        //random move for AI magic
        Random rand = new Random();
        int n = rand.nextInt(2);
        //find all possible moves
        ArrayList<Point2D> possibleMoves = new ArrayList();
        ArrayList<Point2D> tempPossibleMoves = new ArrayList();
        int i;
        int j;
        //fill new arraylist with all possible moves
        for(i=0;i<5;i++)
        {
           for(j=0;j<5;j++)
           {
               possibleMoves.add(new Point2D(i,j));
           }
        }
        //get moves on current board 
        ArrayList<Point2D> p1 = new ArrayList<>();
        p1.addAll(Gamestate.getCurrentState().get(0)); 
        ArrayList<Point2D> p2 = new ArrayList<>();
        p2.addAll(Gamestate.getCurrentState().get(1));
        tempPossibleMoves.addAll(possibleMoves);
       
        for(Point2D point: p1)
            for(Point2D pPoint: tempPossibleMoves)
        {
            if(point.getX() == pPoint.getX() && point.getY() == pPoint.getY())
            {
                possibleMoves.remove(pPoint);
            }
        }
        for(Point2D point: p2)
            for(Point2D pPoint: tempPossibleMoves)
        {
            if(point.getX() == pPoint.getX() && point.getY() == pPoint.getY())
            {
                possibleMoves.remove(pPoint);
            }
        }
        //get ready to return the AI move
        ArrayList<Point2D> aiMove = new ArrayList();
        //add random move from what's left of the list of possible moves
        aiMove.add(possibleMoves.get(n));
        return aiMove;
    }    
}