/**
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * part PlayingField
 * @author Tom Sijbers
 * @id 1709208
 * @author IPEK DEGER
 * @id 1578006
 * @group 95
 * @date 14/10/21
 * assignment copyright Kees Huizing
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;



class PlayingField extends JPanel implements ActionListener   /* possible implements ... */ {
    
    final private int gridSize = 50;
    private Patch[][] grid = new Patch[gridSize][gridSize];
    
    private double alpha = 1.0; // defection award factor

    private int frequency = 10;
    private double scoreCount;
    private boolean started;

    //change timer later
    private Timer timer = new Timer(1000, new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            timer.setDelay(1000/frequency);
            step();
            repaint();
        }
    });
    
    
    
    // random number genrator
    private static final long SEED = 37L; // seed for random number generator; any number goes
    public static final Random random = new Random( SEED );         
    
    //...
    public PlayingField(){
        for (int i= 0; i < gridSize; i++){
            for (int j = 0; j < gridSize; j++){
                Patch patch = new Patch(i, j);
                patch.setCooperating(random.nextBoolean());
                grid[i][j] = patch;
            }
        }
    }
    

    /**
     * calculate and execute one step in the simulation 
     */
    public void step(){
        for (int x = 0; x < gridSize; x++){
            for (int y = 0; y < gridSize; y++){
                scoreCount = 0.0;
                if (x == 0 && y == 0){
                    int[] neighboursXCoordinate = {49, 0, 1, 49, 1, 49, 0, 1};
                    int [] neighboursYCoordinate = {49, 49, 49, 0, 0, 1, 1, 1};
                    //scoreCount = 0.0;
                    if (grid[x][y].isCooperating()){
                        for(int i = 0; i < 8; i++){
                            if(grid[neighboursXCoordinate[i]][neighboursYCoordinate[i]].isCooperating()){
                                scoreCount++;
                            }
                        }
                        grid[x][y].setScore(scoreCount);
                    }
                    else{
                        for (int i = 0; i < 8; i++){
                            if(grid[neighboursXCoordinate[i]][neighboursYCoordinate[i]].isCooperating()){
                                scoreCount++;
                            }  
                        }
                        scoreCount = scoreCount * alpha;
                        grid[x][y].setScore(scoreCount);
                    }
                }
                //set in case x and y are both 49 because special rules apply
                else if (x == 49 && y == 49){
                    int[] neighboursXCoordinate = {48, 49, 0, 48, 0, 48, 49, 0};
                    int [] neighboursYCoordinate = {48, 48, 48, 49, 49, 0, 0, 0};
                    //scoreCount = 0.0;
                    if (grid[x][y].isCooperating()){
                        for(int i = 0; i < 8; i++){
                            if(grid[neighboursXCoordinate[i]][neighboursYCoordinate[i]].isCooperating()){
                                scoreCount++;
                            }
                        }
                        grid[x][y].setScore(scoreCount);
                    }
                    else{
                        for (int i = 0; i < 8; i++){
                            if(grid[neighboursXCoordinate[i]][neighboursYCoordinate[i]].isCooperating()){
                                scoreCount++;
                            }  
                        }
                        scoreCount = scoreCount * alpha;
                        grid[x][y].setScore(scoreCount);
                    }
                }
                //set in case x is 0 and y is 49 because special rules apply
                else if(x==49 && y == 0){
                    int[] neighboursXCoordinate = {48, 49, 0, 48, 0, 48, 49, 0};
                    int [] neighboursYCoordinate = {49, 49, 49, 0, 0, 1, 1, 1};
                    //scoreCount = 0.0;
                    if (grid[x][y].isCooperating()){
                        for(int i = 0; i < 8; i++){
                            if(grid[neighboursXCoordinate[i]][neighboursYCoordinate[i]].isCooperating()){
                                scoreCount++;
                            }
                        }
                        grid[x][y].setScore(scoreCount);
                    }
                    else{
                        for (int i = 0; i < 8; i++){
                            if(grid[neighboursXCoordinate[i]][neighboursYCoordinate[i]].isCooperating()){
                                scoreCount++;
                            }  
                        }
                        scoreCount = scoreCount * alpha;
                        grid[x][y].setScore(scoreCount);
                    }
                }
                //set in case x is 49 and y is 0 because special rules apply
                else if (x == 0 && y == 49){
                    int[] neighboursXCoordinate = {49, 0, 1, 49, 1, 49, 0, 1};
                    int [] neighboursYCoordinate = {48, 48, 48, 49, 49, 0, 0, 0};
                    //scoreCount = 0.0;
                    if (grid[x][y].isCooperating()){
                        for(int i = 0; i < 8; i++){
                            if(grid[neighboursXCoordinate[i]][neighboursYCoordinate[i]].isCooperating()){
                                scoreCount++;
                            }
                        }
                        grid[x][y].setScore(scoreCount);
                    }
                    else{
                        for (int i = 0; i < 8; i++){
                            if(grid[neighboursXCoordinate[i]][neighboursYCoordinate[i]].isCooperating()){
                                scoreCount++;
                            }  
                        }
                        scoreCount = scoreCount * alpha;
                        grid[x][y].setScore(scoreCount);
                    }
                }
                //for special case where x = 0
                else if (x==0){
                    int[] offsetX = {49, 0, 1, 49, 1, 49, 0, 1};
                    int [] offsetY = {-1, -1, -1, 0, 0, 1, 1, 1};
                    //scoreCount = 0.0;
                    if (grid[x][y].isCooperating()){
                        for(int i = 0; i < 8; i++){
                            if(grid[x + offsetX[i]][y + offsetY[i]].isCooperating()){
                                scoreCount++;
                            }
                        }
                        grid[x][y].setScore(scoreCount);
                    }
                    else{
                        for (int i = 0; i < 8; i++){
                            if(grid[x + offsetX[i]][y + offsetY[i]].isCooperating()){
                                scoreCount++;
                            }  
                        }
                        scoreCount = scoreCount * alpha;
                        grid[x][y].setScore(scoreCount);
                    }
        
                }
                //for special case where y = 0
                else if (y == 0){
                    int[] offsetX = {-1, 0, 1, -1, 1, -1, 0, -1};
                    int [] offsetY = {49, 49, 49, 0, 0, 1, 1, 1};
                    //scoreCount = 0.0;
                    if (grid[x][y].isCooperating()){
                        for(int i = 0; i < 8; i++){
                            if(grid[x + offsetX[i]][y + offsetY[i]].isCooperating()){
                                scoreCount++;
                            }
                        }
                        grid[x][y].setScore(scoreCount);
                    }
                    else{
                        for (int i = 0; i < 8; i++){
                            if(grid[x + offsetX[i]][y + offsetY[i]].isCooperating()){
                                scoreCount++;
                            }  
                        }
                        scoreCount = scoreCount * alpha;
                        grid[x][y].setScore(scoreCount);
                    }
                }
                //for special case where x = 49
                else if (x == 49){
                    int[] offsetX = {-1, 0, -49, -1, -49, -1, 0, -49};
                    int [] offsetY = {-1, -1, -1, 0, 0, 1, 1, 1};
                    //scoreCount = 0.0;
                    if (grid[x][y].isCooperating()){
                        for(int i = 0; i < 8; i++){
                            if(grid[x + offsetX[i]][y + offsetY[i]].isCooperating()){
                                scoreCount++;
                            }
                        }
                        grid[x][y].setScore(scoreCount);
                    }
                    else{
                        for (int i = 0; i < 8; i++){
                            if(grid[x + offsetX[i]][y + offsetY[i]].isCooperating()){
                                scoreCount++;
                            }  
                        }
                        scoreCount = scoreCount * alpha;
                        grid[x][y].setScore(scoreCount);
                    }
                }
                //for special case where y = 49
                else if (y == 49){
                    int[] offsetX = {-1, 0, 1, -1, 1, -1, 0, 1};
                    int [] offsetY = {-1, -1, -1, 0, 0, -49, -49, -49};
                    //scoreCount = 0.0;
                    if (grid[x][y].isCooperating()){
                        for(int i = 0; i < 8; i++){
                            if(grid[x + offsetX[i]][y + offsetY[i]].isCooperating()){
                                scoreCount++;
                            }
                        }
                        grid[x][y].setScore(scoreCount);
                    }
                    else{
                        for (int i = 0; i < 8; i++){
                            if(grid[x + offsetX[i]][y + offsetY[i]].isCooperating()){
                                scoreCount++;
                            }  
                        }
                        scoreCount = scoreCount * alpha;
                        grid[x][y].setScore(scoreCount);
                    }
                }
                //for normal cases where neither x or y are 0 or 49
                else{
                    int[] offsetX = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
                    int[] offsetY = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
                    //scoreCount = 0.0;
                    if (grid[x][y].isCooperating()){
                        for(int i = 0; i < 8; i++){
                            if(grid[x + offsetX[i]][y + offsetY[i]].isCooperating()){
                                scoreCount++;
                            }
                        }
                        grid[x][y].setScore(scoreCount);
                    }
                    else{
                        for (int i = 0; i < 8; i++){
                            if(grid[x + offsetX[i]][y + offsetY[i]].isCooperating()){
                                scoreCount++;
                            }  
                        }
                        scoreCount = scoreCount * alpha;
                        grid[x][y].setScore(scoreCount);
                    }
                }
            }
        }
        for (int x = 0; x < gridSize; x++){
            for (int y = 0; y < gridSize; y++){
                double currentHighestScore = grid[x][y].getScore();
                boolean highestScoreIsC = grid[x][y].isCooperating();
                if (x == 0 && y == 0){
                    int[] neighboursXCoordinate = {49, 0, 1, 49, 1, 49, 0, 1};
                    int [] neighboursYCoordinate = {49, 49, 49, 0, 0, 1, 1, 1};
                    for (int i = 0; i < 8; i++){
                        if (grid[neighboursXCoordinate[i]][neighboursYCoordinate[i]].getScore() > currentHighestScore){
                            currentHighestScore = grid[neighboursXCoordinate[i]][neighboursYCoordinate[i]].getScore();
                            highestScoreIsC = grid[neighboursXCoordinate[i]][neighboursYCoordinate[i]].isCooperating();
                        }
                    }
                    grid[x][y].setCooperating(highestScoreIsC);
                }
                else if (x == 49 && y == 49){
                    int[] neighboursXCoordinate = {48, 49, 0, 48, 0, 48, 49, 0};
                    int [] neighboursYCoordinate = {48, 48, 48, 49, 49, 0, 0, 0};
                    for (int i = 0; i < 8; i++){
                        if (grid[neighboursXCoordinate[i]][neighboursYCoordinate[i]].getScore() > currentHighestScore){
                            currentHighestScore = grid[neighboursXCoordinate[i]][neighboursYCoordinate[i]].getScore();
                            highestScoreIsC = grid[neighboursXCoordinate[i]][neighboursYCoordinate[i]].isCooperating();
                        }
                    }
                    grid[x][y].setCooperating(highestScoreIsC);
                }
                else if (x == 49 && y == 0){
                    int[] neighboursXCoordinate = {48, 49, 0, 48, 0, 48, 49, 0};
                    int [] neighboursYCoordinate = {49, 49, 49, 0, 0, 1, 1, 1};
                    for (int i = 0; i < 8; i++){
                        if (grid[neighboursXCoordinate[i]][neighboursYCoordinate[i]].getScore() > currentHighestScore){
                            currentHighestScore = grid[neighboursXCoordinate[i]][neighboursYCoordinate[i]].getScore();
                            highestScoreIsC = grid[neighboursXCoordinate[i]][neighboursYCoordinate[i]].isCooperating();
                        }
                    }
                    grid[x][y].setCooperating(highestScoreIsC);
                }
                else if (x == 0 && y == 49){
                    int[] neighboursXCoordinate = {49, 0, 1, 49, 1, 49, 0, 1};
                    int [] neighboursYCoordinate = {48, 48, 48, 49, 49, 0, 0, 0};
                    for (int i = 0; i < 8; i++){
                        if (grid[neighboursXCoordinate[i]][neighboursYCoordinate[i]].getScore() > currentHighestScore){
                            currentHighestScore = grid[neighboursXCoordinate[i]][neighboursYCoordinate[i]].getScore();
                            highestScoreIsC = grid[neighboursXCoordinate[i]][neighboursYCoordinate[i]].isCooperating();
                        }
                    }
                    grid[x][y].setCooperating(highestScoreIsC);
                }
                else if (x == 0){
                    int[] offsetX = {49, 0, 1, 49, 1, 49, 0, 1};
                    int [] offsetY = {-1, -1, -1, 0, 0, 1, 1, 1};
                    for (int i = 0; i < 8; i++){
                        if (grid[x + offsetX[i]][y + offsetY[i]].getScore() > currentHighestScore){
                            currentHighestScore = grid[x + offsetX[i]][y + offsetY[i]].getScore();
                            highestScoreIsC = grid[x + offsetX[i]][y + offsetY[i]].isCooperating();
                        }
                    }
                    grid[x][y].setCooperating(highestScoreIsC);
                }
                else if (x == 49){
                    int[] offsetX = {-1, 0, -49, -1, -49, -1, 0, -49};
                    int [] offsetY = {-1, -1, -1, 0, 0, 1, 1, 1};
                    for (int i = 0; i < 8; i++){
                        if (grid[x + offsetX[i]][y + offsetY[i]].getScore() > currentHighestScore){
                            currentHighestScore = grid[x + offsetX[i]][y + offsetY[i]].getScore();
                            highestScoreIsC = grid[x + offsetX[i]][y + offsetY[i]].isCooperating();
                        }
                    }
                    grid[x][y].setCooperating(highestScoreIsC);
                }
                else if (y == 0){
                    int[] offsetX = {-1, 0, 1, -1, 1, -1, 0, -1};
                    int [] offsetY = {49, 49, 49, 0, 0, 1, 1, 1};
                    for (int i = 0; i < 8; i++){
                        if (grid[x + offsetX[i]][y + offsetY[i]].getScore() > currentHighestScore){
                            currentHighestScore = grid[x + offsetX[i]][y + offsetY[i]].getScore();
                            highestScoreIsC = grid[x + offsetX[i]][y + offsetY[i]].isCooperating();
                        }
                    }
                    grid[x][y].setCooperating(highestScoreIsC);
                }
                else if (y == 49){
                    int[] offsetX = {-1, 0, 1, -1, 1, -1, 0, 1};
                    int [] offsetY = {-1, -1, -1, 0, 0, -49, -49, -49};
                    for (int i = 0; i < 8; i++){
                        if (grid[x + offsetX[i]][y + offsetY[i]].getScore() > currentHighestScore){
                            currentHighestScore = grid[x + offsetX[i]][y + offsetY[i]].getScore();
                            highestScoreIsC = grid[x + offsetX[i]][y + offsetY[i]].isCooperating();
                        }
                    }
                    grid[x][y].setCooperating(highestScoreIsC);
                }
                else{
                    int[] offsetX = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
                    int[] offsetY = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
                    for (int i = 0; i < 8; i++){
                        if (grid[x + offsetX[i]][y + offsetY[i]].getScore() > currentHighestScore){
                            currentHighestScore = grid[x + offsetX[i]][y + offsetY[i]].getScore();
                            highestScoreIsC = grid[x + offsetX[i]][y + offsetY[i]].isCooperating();
                        }
                    }
                    grid[x][y].setCooperating(highestScoreIsC);
                }
            }
        }
    }
    
    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }
    
    public double getAlpha() {
        return this.alpha;
    }

    public void setFrequency(int frequency){
        this.frequency = frequency;
    }

    public int getFrequency(){
        return this.frequency;
    }
    
    // return grid as 2D array of booleans
    // true for cooperators, false for defectors
    // precondition: grid is rectangular, has non-zero size and elements are non-null

    public boolean[][] getGrid() {
        boolean[][] resultGrid = new boolean[grid.length][grid[0].length];
        for (int x = 0; x < grid.length; x++ ) {
            for (int y = 0; y < grid[0].length; y++ ) {
                resultGrid[x][y] = grid[x][y].isCooperating();
            }
        }
        
        return resultGrid; 
    }
    
    // sets grid according to parameter inGrid
    // a patch should become cooperating if the corresponding
    // item in inGrid is true
    public void setGrid( boolean[][] inGrid) {
        // ...
    }

    public void paint(Graphics g){
        super.paint(g);
        for (int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid[0].length; c++){
                grid[r][c].draw(g);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Go".equals(e.getActionCommand())){
            timer.start();
            started = true;
        }
        else if ("Pause".equals(e.getActionCommand())){
            if (started){
                started = false;
                timer.stop();
            }
            else{
                started = true;
                timer.start();
            }
        }
        
        else if ("Reset".equals(e.getActionCommand())){
            started = false;
            timer.restart();

        }
        
    }   
}