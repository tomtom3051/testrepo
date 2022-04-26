// TO BE COMPLETED 
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Dingus --  part of HA Random Artist
 * abstract class representing an arbitrary shape
 * @author Tom Sijbers
 * @ID 1709208
 * @author IPEK DEGER
 * @id 1578006
 * @group 95
 * @date 08/10/2021
 */
abstract class Dingus {
    /** random generator to be used by all subclasses of Dingus 
     *  do not change
     */
    Random random = Painting.random;

    /** postion of the shape (upper left corner) **/
    protected int x, y;

    /** color used for drawing this shape **/
    protected Color color;
    protected int r, g, b;

    /** maximal coordinates; drawing area is (0,0)- (maxX,maxY) **/
    int maxX, maxY;

    /**
     * initializes color and position to random values
     *
     * @param maxX, maxY - give maximum values for the position
     */    
     public Dingus(int maxX, int maxY) {
        this.maxX = maxX; this.maxY = maxY;
        // initialize to a random position
        x = random.nextInt(maxX);
        y = random.nextInt(maxY);
        // initialize to a random color
        //creates r, g and b values between 0 and 255 allowing the programm to generate lots of different colors
        r = random.nextInt(256);
        g = random.nextInt(256);
        b = random.nextInt(256);
        color = new Color(r,g,b);
        
    }

    abstract void draw(Graphics g);
}
