/**
 * Class that solves the Asterisk Sudoku. Prints the number of solutions of a
 * Sudoku if there are multiple. If there is only a single solution, prints this
 * solution instead.
 * 
 * @name Tom Sijbers
 * @id 1709208
 * @name IPEK DEGER
 * @id 1578006
 * @group 95
 */

class SudokuSolver {

    int sudokuSize = 9; // Size of the grid.
    int sudokuMinNumber = 1; // Minimum digit to be filled in.
    int sudokuMaxNumber = 9; // Maximum digit to be filled in.
    int sudokuBoxDimension = 3; // Dimension of the boxes (sub-grids that should contain all digits).

    int[][] grid = new int[][] { 
        { 0, 0, 0, , 3, 0, 4, 0, 0 }, 
        { 0, 0, 0, 0, 0, 0, 5, 0, 0 },
        { 3, 0, 0, 0, 0, 6, 0, 0, 0 }, 
        { 0, 0, 0, 0, 0, 2, 6, 4, 0 }, 
        { 0, 0, 0, 6, 5, 1, 0, 0, 0 },
        { 0, 0, 6, 9, 0, 7, 0, 0, 0 }, 
        { 5, 8, 0, 0, 0, 0, 0, 0, 0 }, 
        { 9, 0, 0, 0, 0, 3, 0, 2, 5 },
        { 6, 0, 3, 0, 0, 0, 8, 0, 0 }, 
    };
    int[][] astrisksPoints = new int[][] { 
        { 1, 4 }, 
        { 2, 2 }, 
        { 2, 6 }, 
        { 4, 1 }, 
        { 4, 4 }, 
        { 4, 7 }, 
        { 6, 2 },
        { 6, 6 }, 
        { 7, 4 }, 
    };

    int solutionCounter = 0; // solution counter

    // Is there conflict when we fill in d at position (r, c)
    //Checker calls upon all other conflict booleans and if one is true it returns to the main code that there is an error
    //if everything is false it returns false signaling d can be placed at position (r,c) without a conflict
    boolean givesConflict(int r, int c, int d) {
        if (rowConflict(r, d) || columnConflict(c, d) || boxConflict(r, c, d) || asteriskConflict(r, c, d)) {
            return true;
        }
        return false;
    }
    //astrisk conflict checks if there is conflic between the astriks points
    boolean asteriskConflict(int r, int c, int d) {
        //boolean is set to false since most points are not asterisk and can therefore ignore this conflict checker
        boolean pointIsAsterisk = false;
        for (int x = 0; x < 9; x++) {
            int[] pointRCAstriskChecker = astrisksPoints[x];
            if (r == pointRCAstriskChecker[0] && c == pointRCAstriskChecker[1]) {
                // if point (r,c) is in the arraylist of all asterisk points boolean turns true
                //this ensures that the asterisk conflict checker executes
                pointIsAsterisk = true;
            }

        }
        if (pointIsAsterisk) {
            for (int i = 0; i < 9; i++) {
                int[] pointToCheck = astrisksPoints[i];
                if (grid[pointToCheck[0]][pointToCheck[1]] == d) {
                    // if any point in the asterisk points array equals d the code returns true signaling there is a conflict
                    //this means d cannot be placed here
                    return true;
                }
            }
        }
        return false;
    }

    // Is there conflict when we fill in d in row r?
    boolean rowConflict(int r, int d) {
        //checks every box in row r to see if d already occur
        for (int i = 0; i < 9; i++) {
            if (grid[r][i] == d) {
                //if d returns there is a conflict and therefore the code returns true signalling that d cannot be placed at point (r,c)
                return true;
            }
        }
        return false;
    }

    // Is there a conflict in column c when we fill in d?
    boolean columnConflict(int c, int d) {
        //checks every box in column c to see if d already occur
        for (int i = 0; i < 9; i++) {
            if (grid[i][c] == d) {
                //if d returns there is a conflict and therefore the code returns true signalling that d cannot be placed at point (r,c)
                return true;
            }
        }
        return false;
    }

    // Is there a conflict in the box at (r, c) when we fill in d?
    boolean boxConflict(int r, int c, int d) {
        // checks every point in a box for value d
        int boxR = r - r % 3;
        int boxC = c - c % 3;
        for (int i = boxR; i < boxR + 3; i++) {
            for (int j = boxC; j < boxC + 3; j++) {
                if (grid[i][j] == d) {
                    //if value d is already found the code returns true signalling that the point d cannot be placed at point (r,c)
                    return true;
                }
            }
        }
        return false;
    }

    // find all solutions to the grid and stores the final solution
    // print the sudoku grid
    void print() {
        //prints +-----------------+ on first line
        System.out.println("+-----------------+");
        for (int row = 0; row < validGridd.length; row++) {
            System.out.print("|");
            for (int col = 0; col < validGridd[row].length; col++) {
                // if statement in case element is in the last column of a row
                // this if statement ensures no space is placed after the element in this case
                if (col == 8) {
                    if (validGridd[row][col] == 0) {
                        System.out.print(" ");
                    } else {
                        System.out.print(validGridd[row][col]);
                    }
                }
                // if statement in case the element is at the end of a 3 by 3 grid
                // if statement ensures a | is placed instead of a space
                else if (col == 2 || col == 5) {
                    if (validGridd[row][col] == 0) {
                        System.out.print(" ");
                        System.out.print("|");
                    } else {
                        System.out.print(validGridd[row][col]);
                        System.out.print("|");
                    }
                }
                // if statements in scenarios where a > should follow the element rather than a
                // space
                else if ((row == 1 && col == 3) ^ (row == 2 && col == 1)
                        ^ (row == 4 && (col == 0 ^ col == 3 ^ col == 6)) ^ (row == 6 && col == 1)
                        ^ (row == 7 && col == 3)) {
                    if (validGridd[row][col] == 0) {
                        System.out.print(" ");
                        System.out.print(">");
                    } else {
                        System.out.print(validGridd[row][col]);
                        System.out.print(">");
                    }
                }
                // if statements in scenarios where a < should follow the element rather than a
                // space
                else if ((row == 1 && col == 4) ^ (row == 2 && col == 6)
                        ^ (row == 4 && (col == 1 ^ col == 4 ^ col == 7)) ^ (row == 6 && col == 6)
                        ^ (row == 7 && col == 4)) {
                    if (validGridd[row][col] == 0) {
                        System.out.print(" ");
                        System.out.print("<");
                    } else {
                        System.out.print(validGridd[row][col]);
                        System.out.print("<");
                    }
                }
                // if statement in case of 0, ensures an empty space is printed instead of 0
                else if (validGridd[row][col] == 0) {
                    System.out.print(" ");
                    System.out.print(" ");
                }
                // else the number itself is output with a space behinf it
                else {
                    System.out.print(validGridd[row][col]);
                    System.out.print(" ");
                }
            }
            //prints | at the end of a row
            System.out.print("|");
            //if statement makes sure that row 2 and 5 are followed by +-----------------+
            if (row == 2 || row == 5) {
                System.out.println();
                System.out.println("+-----------------+");
            } else {
                System.out.println();
            }
        }
        // ends code with +-----------------+
        System.out.println("+-----------------+");
    }

    int[] findEmptySquare() {
        //for loops loop throughout the entire grid looking for a square 0
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (grid[r][c] == 0) {
                    //if a square with value zero is found the r and c value of this point is returned so it can be used later
                    return new int[] { r, c };
                }
            }
        }
        //if no zero is found -1 -1 is returned signalling that the grid is filled up
        return new int[] { -1, -1 };
    }

    //sets up a new 9 by 9 grid into which the last found solution will later be coppied
    int[][] validGridd = new int[9][9];

    void solve() {
        int[] emptySquare = findEmptySquare();
        //if emptySquare = -1 -1 then the grid is filled and a solution has been found
        if ((emptySquare[0] == -1) && (emptySquare[1] == -1)) {
            //for loops copy the solution from grid into validgridd ensuring it can be printed later
            for (int x = 0; x < 9; x++) {
                for (int y = 0; y < 9; y++) {
                    validGridd[x][y] = grid[x][y];
                }
            }
            //solutionCounter increases by 1
            solutionCounter++;
        // if emptySquare != -1 -1 then the grid has not been filled meaning there is more empty spaces     
        } else {
            // fills the empty space with a value between 1 and 9
            for (int number2Check = 1; number2Check < 10; number2Check++) {
                //checks if value gives conflict when filled into point (r,c)
                if (!givesConflict(emptySquare[0], emptySquare[1], number2Check)) {
                    grid[emptySquare[0]][emptySquare[1]] = number2Check;
                    //code uses recursion here so it can backtrack if a later zero cannot be filled
                    solve();
                }
            }
            grid[emptySquare[0]][emptySquare[1]] = 0;
        }
    }

    // run the actual solver
    void solveIt() {
        solve();
        //if statement to ensure the correct output is produced
        if (solutionCounter == 1) {
            print();
        } else {
            System.out.println(solutionCounter);
        }
    }

    public static void main(String[] args) {
        (new SudokuSolver()).solveIt();
    }
}
