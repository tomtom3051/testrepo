/**
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * part Patch
 * @author Tom Sijbers
 * @id 1709208
 * @author IPEK DEGER
 * @id 1578006
 * @group 95
 * @date 14/10/21
 * assignment copyright Kees Huizing
 */
import java.awt.Graphics;
import java.awt.*;

public class Patch {
    private int blockSize = 10;
    private int x, y;
    private boolean isC;
    private double score;
    
    public Patch(int x, int y){
        this.x = x;
        this.y = y;
        
    }
    // returns true if and only if patch is cooperating
    boolean isCooperating() {
        if (isC){
            return true;
        }
        return false; // CHANGE THIS
    }
    
    // set strategy to C if isC is true and to D if false
    public void setCooperating(boolean isC) {
        this.isC = isC;
    }
    
    // change strategy from C to D and vice versa
    void toggleStrategy() {
        if (isC){
            isC = false;
        }
        else{
            isC = true;
        }
    }
    
    // return score of this patch in current round
    public double getScore() {

        return this.score; // CHANGE THIS
    }

    public void setScore(double score){
        this.score = score;
    }
    public void draw(Graphics g){
        //g.fillRect(x*blockSize, y*blockSize, blockSize, blockSize);
        //g.setColor(Color.BLACK);
        if (isC){
            g.setColor(Color.BLUE);
            g.fillRoundRect(x*blockSize, y*blockSize, blockSize, blockSize, 8, 8);
            //g.fillRect(x*blockSize, y*blockSize, blockSize, blockSize);
        }
        else{
            g.setColor(Color.RED);
            g.fillRoundRect(x*blockSize, y*blockSize, blockSize, blockSize, 8, 8);
            //g.fillRect(x*blockSize, y*blockSize, blockSize, blockSize);
        }
        g.setColor(Color.BLACK);
        g.drawRect(x*blockSize, y*blockSize, blockSize, blockSize);

    }
}
