/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokugame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 * @author micha
 */
public class Grid { 
    public static Cell[][] cell = new Cell[9][9];
    public static void readGrid(String nazwa) throws FileNotFoundException
    {
        File file = new File (nazwa);
        int number;
        Scanner sc = new Scanner(file);
        while (sc.hasNext())
        {
            //read sudoku from text file into 9x9 array
            for (int i = 0; i < 9; i ++)
            {
                for (int j = 0; j < 9; j++)
                {
                    cell[i][j] = new Cell();
                    cell[i][j].value = sc.nextInt();

                }
            }
        }
    }
    
    public static void printGrid()
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                //output the array
                System.out.print(cell[i][j].value);
            }
            //add new line at the end of each row
            System.out.println();
        }
    }
         
}
