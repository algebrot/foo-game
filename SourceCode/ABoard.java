/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.util.ArrayList;
import javafx.geometry.Point2D;
import java.util.ArrayList;

/**
 *
 * @author coracoleman
 */
public class ABoard 
{
    //player move arraylists
    
    //what is initially put in the row arrays 
    String grid = " .";
    //counter
    int i;
    //counter2
    int j;
    //row arrays
    ArrayList<String> row0 = new ArrayList(5);
    ArrayList<String> row1 = new ArrayList(5);
    ArrayList<String> row2 = new ArrayList(5);
    ArrayList<String> row3 = new ArrayList(5);
    ArrayList<String> row4 = new ArrayList(5);
    //holds all of the rows
    ArrayList<ArrayList<String>> rows = new ArrayList();
    //column number array
    ArrayList<String> cols = new ArrayList(5);
    
    public ABoard()
    {
        //add header values to column array
        cols.add("  0");
        cols.add(" 1");
        cols.add(" 2");
        cols.add(" 3");
        cols.add(" 4");
        //populate the row arrays with .s
        
        
        for(int q=0; q<5;q++){
        row0.add(grid);
        row1.add(grid);
        row2.add(grid);
        row3.add(grid);
        row4.add(grid);
       
        }
       
        
        //add the respective header in the 0th index

        //combine all to rows array
        rows.add(row0);
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
         
        //get rid of the array parts
    }
    public void drawBoard()
    {
        String colsout = cols.toString()
               .replace(",", "")
               .replace("[", "")
               .replace("]", "");
        String row4out = row4.toString()
               .replace(",", "")
               .replace("[", "")
               .replace("]", "");
        //System.out.println(row0out);
        String row3out = row3.toString()
               .replace(",", "")
               .replace("[", "")
               .replace("]", "");
        //System.out.println(row1out);
        String row2out = row2.toString()
               .replace(",", "")
               .replace("[", "")
               .replace("]", "");
        //System.out.println(row2out);
        String row1out = row1.toString()
               .replace(",", "")
               .replace("[", "")
               .replace("]", "");
        //System.out.println(row3out);
        String row0out = row0.toString()
               .replace(",", "")
               .replace("[", "")
               .replace("]", "");
        //System.out.println(row4out);
        
        //print out the board in its entirety
        System.out.println("4"+row4out);
             System.out.println("3"+row3out);
              System.out.println("2"+row2out);
               System.out.println("1"+row1out);
                System.out.println("0"+ row0out);
                 System.out.println(colsout);
    }
    //get point method reutrns an arraylist where index0=x and index1=y (a point)
    public void updateBoard(ArrayList<ArrayList<Point2D>> gameState)
    {
        //Clears the previous content from the board. And rebuilds the pieces
  



        //populate player arrays 
        
        ArrayList<Point2D> player1;
        ArrayList<Point2D> player2;
        player1 = gameState.get(0);
        player2 =gameState.get(1);
        ArrayList<Point2D> allPoints = new ArrayList<>();
        allPoints.addAll(player1);
        allPoints.addAll(player2);
        ArrayList<Point2D> emptyPoints = new ArrayList<>();
        
    
        

            for(i=0;i<5;i++)
            {
               for(j=0;j<5;j++)
               {
                  
                        
   
                for (Point2D point1: player2){
                    if(point1.getY()==i && point1.getX()==j) //For player 2
                        {

                            rows.get(i).remove(j);
                            rows.get(i).add(j," O");
                        }
                     
                    }
                for (Point2D point1: player1){
                    if(point1.getY()==i && point1.getX()==j) //For player 1
                        {

                            rows.get(i).remove(j);
                            rows.get(i).add(j," X");
                        }
                     
                    }
                
               }
            }  
    }
    public void deleteFromBoard(Point2D input){
         for(i=0;i<5;i++)
            {
               for(j=0;j<5;j++)
               {
                   if(input.getY()==i && input.getX()==j) //For player 1
                        {

                            rows.get(i).remove(j);
                            rows.get(i).add(j," .");
                        }
               }
    }
    }
}
