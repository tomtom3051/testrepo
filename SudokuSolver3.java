/**
 * Class that solves the Asterisk Sudoku.
 * Prints the number of solutions of a Sudoku if there are multiple. If there is only a single solution, prints this solution instead.
 * 
 * @name Tom Sijbers
 * @id 1709208
 * @name IPEK DEGER
 * @id 1578006
 * @group 95
 */

 class SudokuSolver3 {

    int sudokuSize = 9; // Size of the grid.
    int sudokuMinNumber = 1; // Minimum digit to be filled in.
    int sudokuMaxNumber = 9; // Maximum digit to be filled in.
    int sudokuBoxDimension = 3; // Dimension of the boxes (sub-grids that should contain all digits).
    //the variables below contain the row and collumn of the last empty row found, they have to be initialized outside a method so they don't reset to 0
    //int lastEmptyRow = 0;
    //int LastEmptyCollumn = 0;

    int[][] grid = new int [] []{ //The puzzle grid; 0 represents empty.  One solution
        {0, 9, 0, 7, 3, 0, 4, 0, 0},
        {0, 0, 0, 0, 0, 0, 5, 0, 0},
        {3, 0, 0, 0, 0, 6, 0, 0, 0},

        {0, 0, 0, 0, 0, 2, 6, 4, 0},
        {0, 0, 0, 6, 5, 1, 0, 0, 0},
        {0, 0, 6, 9, 0, 7, 0, 0, 0},

        {5, 8, 0, 0, 0, 0, 0, 0, 0},
        {9, 0, 0, 0, 0, 3, 0, 2, 5},
        {6, 0, 3, 0, 0, 0, 8, 0, 0},
    };
    int [][] astrisksPoints = new int[][]{
        {1, 4},
        {2, 2},
        {2, 6},
        {4, 1},
        {4, 4},
        {4, 7},
        {6, 2},
        {6, 6},
        {7, 4},
    };

    int solutionCounter = 0; // solution counter

    //Is there conflict when we fill in d at position (r, c)
    boolean givesConflict(int r, int c, int d) {
        //if (rowConflict(r, d) || columnConflict(c, d) || boxConflict(r, c, d) || asteriskConflict2(r, c, d)){
        if (rowConflict(r, d) || columnConflict(c, d) || boxConflict(r, c, d)){    
            //grid[r][c] = 0;
            //System.out.println("1");
            return true;
        }
        //grid[r][c] = d;
        //System.out.println("2");
        return false;
    }

    //Is there conflict when we fill in d in row r?
    boolean rowConflict(int r, int d){
        for (int i = 0; i < 9; i++){
            if (grid[r][i] == d){
                return true;
            }
        }
        return false;
    }

    //Is there a conflict in column c when we fill in d?
    boolean columnConflict(int c, int d){
        for (int i = 0; i < 9; i++){
            if (grid[i][c] == d){
                return true;
            }
        }
        return false; 
    }

    // Is there a conflict in the box at (r, c) when we fill in d?    
    boolean boxConflict(int r, int c, int d) {        
        int boxR = r - r % 3;
        int boxC = c - c % 3;
        for (int i = boxR; i < boxR + 3; i++){
            for (int j = boxC; j < boxC + 3; j++){
                if (grid[i][j] == d){
                    return true;
                }

            }
        }
        return false;
    }
    // Is there a conflict in the asterisk when we fill in d?
    // Delete this comment and add your asteriskConflict method in its place.
    boolean asteriskConflict2(int r, int c, int d){
        for (int i = 0; i<9; i++){
            int [] pointToCheck = astrisksPoints[i];
            if (grid[pointToCheck[0]][pointToCheck[1]]==d){
                return true;
            }
        }
        return false;
    }
    
    boolean asteriskConflict(int r, int c, int d){
        if (r == 1 && c == 4){
            if (grid[r][c] == d && grid[2][2] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[2][6] == d){
                return true;
            } 
            else if (grid[r][c] == d && grid[4][1] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[4][4] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[4][7] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[6][2] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[6][6] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[7][4] == d){
                return true;
            }
        }
        else if (r == 2 && c == 2){
            if (grid[r][c] == d && grid[1][4] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[2][6] == d){
                return true;
            } 
            else if (grid[r][c] == d && grid[4][1] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[4][4] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[4][7] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[6][2] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[6][6] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[7][4] == d){
                return true;
            }
        }
        else if (r == 2 && c == 6){
            if (grid[r][c] == d && grid[1][4] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[2][2] == d){
                return true;
            } 
            else if (grid[r][c] == d && grid[4][1] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[4][4] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[4][7] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[6][2] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[6][6] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[7][4] == d){
                return true;
            }
        }
        else if (r == 4 && c == 1){
            if (grid[r][c] == d && grid[1][4] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[2][2] == d){
                return true;
            } 
            else if (grid[r][c] == d && grid[2][6] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[4][4] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[4][7] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[6][2] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[6][6] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[7][4] == d){
                return true;
            }
        }
        else if (r == 4 && c == 4){
            if (grid[r][c] == d && grid[1][4] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[2][2] == d){
                return true;
            } 
            else if (grid[r][c] == d && grid[2][6] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[4][1] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[4][7] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[6][2] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[6][6] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[7][4] == d){
                return true;
            }
        }
        else if (r == 4 && c == 7){
            if (grid[r][c] == d && grid[1][4] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[2][2] == d){
                return true;
            } 
            else if (grid[r][c] == d && grid[2][6] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[4][1] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[4][4] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[6][2] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[6][6] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[7][4] == d){
                return true;
            }
        }
        else if (r == 6 && c == 2){
            if (grid[r][c] == d && grid[1][4] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[2][2] == d){
                return true;
            } 
            else if (grid[r][c] == d && grid[2][6] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[4][1] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[4][4] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[4][7] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[6][6] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[7][4] == d){
                return true;
            }
        }
        else if (r == 6 && c == 6){
            if (grid[r][c] == d && grid[1][4] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[2][2] == d){
                return true;
            } 
            else if (grid[r][c] == d && grid[2][6] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[4][1] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[4][4] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[4][7] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[6][2] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[7][4] == d){
                return true;
            }
        }
        else if (r == 7 && c == 4){
            if (grid[r][c] == d && grid[1][4] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[2][2] == d){
                return true;
            } 
            else if (grid[r][c] == d && grid[2][6] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[4][1] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[4][4] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[4][7] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[6][2] == d){
                return true;
            }
            else if (grid[r][c] == d && grid[7][4] == d){
                return true;
            }
        }
        return false;
    }

    //find the next empty square (in "reading order")
    //int[] findEmptySquare(){
        //for (int r = 0; r < 9; r++){
            //for (int c = 0; c < 9; c++){
                //if (grid[r][c] == 0){
                    //lastEmptyRow = r;
                    //LastEmptyCollumn = c;
                    //return new int[] {r, c};
                //}
            //} 
        //}
        //return new int[] {-1, -1};
    //}

    //find all solutions to the grid and stores the final solution
    //print the sudoku grid
    void print(){
        System.out.println("+-----------------+");
        for (int row = 0; row < grid.length; row++){
            System.out.print("|");
            for(int col = 0; col < grid[row].length; col++){
                //if statement in case element is in the last column of a row
                //this if statement ensures no space is placed after the element in this case
                if (col == 8){
                    if (grid[row][col] == 0){
                        System.out.print(" ");
                    }
                    else{
                        System.out.print(grid[row][col]);
                    }
                }
                //if statement in case the element is at the end of a 3 by 3 grid
                //if statement ensures a | is placed instead of a space
                else if (col == 2 || col == 5){
                    if (grid[row][col] == 0){
                        System.out.print(" ");
                        System.out.print("|");
                    }
                    else{
                        System.out.print(grid[row][col]);
                        System.out.print("|");
                    }
                }
                //if statements in scenarios where a > should follow the element rather than a space
                else if((row==1&&col==3)^(row==2&&col==1)^(row==4&&(col==0^col==3^col==6))^(row==6&&col==1)^(row==7&&col==3) ){
                    if (grid[row][col] == 0){
                        System.out.print(" ");
                        System.out.print(">");
                    }
                    else{
                        System.out.print(grid[row][col]);
                        System.out.print(">");
                    }
                }
                //if statements in scenarios where a < should follow the element rather than a space
                else if((row==1&&col==4)^(row==2&&col==6)^(row==4&&(col==1^col==4^col==7))^(row==6&&col==6)^(row==7&&col==4)){
                    if (grid[row][col] == 0){
                        System.out.print(" ");
                        System.out.print("<");
                    }
                    else{
                        System.out.print(grid[row][col]);
                        System.out.print("<");
                    }
                }
                // if statement in case of 0, ensures an empty space is printed instead of 0
                else if (grid[row][col] == 0){
                    System.out.print(" ");
                    System.out.print(" ");
                }
                //else the number itself is output with a space behinf it
                else{
                    System.out.print(grid[row][col]);
                    System.out.print(" ");
                }
            }
            System.out.print("|");
            if (row == 2 || row == 5){
                System.out.println();
                System.out.println("+-----------------+");
            }
            else{
                System.out.println();
            }
            
        }
        System.out.println("+-----------------+");
    }
    boolean solveGridd(){
        for (int r = 0; r < 9; r++){
            for (int c = 0; c < 9; c++){
                if (grid[r][c] == 0){
                    for (int d = 1; d < 10; d++){
                        if (!givesConflict(r, c, d)){
                            grid[r][c] = d;
                            if (solveGridd()){
                                return true;
                            }
                            else{
                                grid[r][c] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
        
    
    boolean checkAsteriks(){
        boolean inValid = false;
        for(int numberToCheck = 1; numberToCheck <= 9;numberToCheck++){
            boolean found = false;
            for (int j = 0; j<9; j++){
                int [] pointToCheck = astrisksPoints[j];
                if (grid[pointToCheck[0]][pointToCheck[1]]==numberToCheck){
                    found = true;
                }
            }
            if (!found){
                inValid = true;
            }
        }
        return inValid;
    }
    
    //run the actual solver
    void solveIt(){
        solveGridd(); 
        print(); 
        if (checkAsteriks()){
            System.out.println("A check failed");
        }    
    }
    
    public static void main (String[] args){
        (new SudokuSolver3()).solveIt();
    }
 }