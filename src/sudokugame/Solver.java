/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokugame;

/**
 *
 * @author micha
 */
public class Solver extends Grid {
    int n = 9;
     public void solve() {
        if (!backtrackSolve()) {
            System.out.println("This sudoku can't be solved.");
        }
        else{
            System.out.println("Solved sudoku:");
        }
    }       
    
    public boolean isSuitableToPutXThere(int row_i2, int col_j2, int x) {

           // Is 'x' used in row.
           for (int i = 0; i < n; i++) {
               if (cell[row_i2][i].value == x) {
                   return false;
               }
           }

           // Is 'x' used in column.
           for (int j = 0; j < n; j++) {
               if (cell[j][col_j2].value == x) {
                   return false;
               }
           }

         // Is 'x' used in sudoku 3x3 box.
        int boxRow = row_i2 - row_i2 % 3;
        int boxColumn = col_j2 - col_j2 % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cell[boxRow + i][boxColumn + j].value == x) {
                    return false;
                }
            }
        }

           // Everything looks good.
           return true;
       }

    public boolean backtrackSolve() {
        int row_i2 = 0, col_j2 = 0;
        boolean isThereEmptyCell = false;
        for (int row_i = 0; row_i < 9 && !isThereEmptyCell; row_i++)
        {
            for (int col_j = 0; col_j < 9 && !isThereEmptyCell ; col_j++)
            {
                //reading array if we have empty spots
                if(cell[row_i][col_j].isEmpty() == true){
                    isThereEmptyCell = true;
                    row_i2 = row_i;
                    col_j2 = col_j;
                }
            }
        }
        // If all cells are not empty we finish
        if (!isThereEmptyCell) {
            return true;
        }

        for (int x = 1; x < 10; x++) {

            if (isSuitableToPutXThere(row_i2, col_j2, x)) { //Checking if we can insert X to this cell;
                cell[row_i2][col_j2].value = x;
                
                if (backtrackSolve()) {
                    return true;
                }

                cell[row_i2][col_j2].value = 0; // We've failed;
            }

        }

           return false; // Backtracking
       }
}
