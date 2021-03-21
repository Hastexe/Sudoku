/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokugame;

import java.io.IOException;

/**
 *
 * @author micha
 */
public class SudokuGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Grid grid = new Grid();
        grid.readGrid("G:/plik.txt");
        grid.printGrid();
        System.out.println();
        Solver game_solve = new Solver();
        game_solve.solve();
        grid.printGrid();
    }
    
}
