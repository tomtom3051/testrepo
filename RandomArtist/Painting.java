/*
 * part of HA Random artist
 * TO BE COMPLETED
 * @author Tom Sijbers
 * @ID 1709208
 * @author IPEK DEGER
 * @id 1578006
 * @group 95
 * @date 08/10/2021
 */

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.io.*;


public class Painting extends JPanel implements ActionListener {

   /*---- Randomness ----*/
    /** you can change the variable SEED if you like
     *  the same program with the same SEED will generate exactly the same sequence of pictures
     */
    final static long SEED = 55; // seed for the random number generator; any number works

    /** do not change the following two lines **/
    final static Random random = new Random( SEED ); // random generator to be used by all classes
    int numberOfRegenerates = 0;
    
   /*---- Screenshots ----
    * do not change
    */
    char current = '0';
    String filename = "randomshot_"; // prefix
   /*---- Dinguses ----*/
    ArrayList<Dingus> shapes = new ArrayList<>();
        //...

    public Painting() {
        setPreferredSize(new Dimension(800, 450)); // make panel 800 by 450 pixels.
        
    }

    @Override
    protected void paintComponent(Graphics g) { // draw all your shapes
        super.paintComponent(g);     // clears the panel
        for (int x = 0; x < shapes.size(); x++){
            //if error it's here
            shapes.get(x).draw(g);
        }
    }

    /**
     * reaction to button press
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if ( "Regenerate".equals(e.getActionCommand()) ) {
            regenerate();
            repaint();
        } else { // screenshot
            saveScreenshot( this, filename+current++ ); // ++ to show of compact code :-)
        }
    }

    void regenerate() {
        numberOfRegenerates++; // do not change
        //if there is something in the list the if statment ensures it is deleted
        if (shapes != null){
            shapes.removeAll(shapes);
        }
        //generate number of shapes
        int numberOfShapes = random.nextInt(30-10+1)+10;
        //maxX and maxY provide the largest possible coordinates
        int maxX = 800;
        int maxY = 450; 
        //loop from 0 until number of shapes
        for (int i = 0; i <= numberOfShapes; i++){
            //shapedecision places the object in a specific object dingus based on the random number assigned
            int shapeDecision = random.nextInt(6);
            if (shapeDecision == 0){
                Dingus circle = new CircleDingus(maxX, maxY);
                shapes.add(circle);
            }
            else if (shapeDecision == 1){
                Dingus tree = new TreeDingus(maxX, maxY);
                shapes.add(tree);
            }
            else if (shapeDecision == 2){
                Dingus square = new SquareDingus(maxX, maxY);
                shapes.add(square);
            }
            else if (shapeDecision == 3){
                Dingus oval = new OvalDingus(maxX, maxY);
                shapes.add(oval);
            }
            else if (shapeDecision == 4){
                Dingus t = new TDingus(maxX, maxY);
                shapes.add(t);
            }
            else if (shapeDecision == 5){
                Dingus h = new HDingus(maxX, maxY);
                shapes.add(h);
            }
        }
    }

    /** 
     * saves a screenshot of a Component on disk
     *  overides existing files
     *
     * @param component - Component to be saved
     * @param name - filename of the screenshot, followed by a sequence number
     * 
     * do not change
     */
    void saveScreenshot(Component component, String name) {
        String randomInfo = ""+SEED+"+"+ (numberOfRegenerates-1); //minus 1 because the initial picture should not count
        System.out.println( SwingUtilities.isEventDispatchThread() );
        BufferedImage image =
            new BufferedImage(
                              component.getWidth(),
                              component.getHeight(),
                              BufferedImage.TYPE_INT_RGB
                             );
        // call the Component's paint method, using
        // the Graphics object of the image.
        Graphics graphics = image.getGraphics();
        component.paint( graphics ); // alternately use .printAll(..)
        graphics.drawString(randomInfo, 0, component.getHeight());
        
        try {
            ImageIO.write(image, "PNG", new File(name+".png"));
            System.out.println( "Saved screenshot as "+ name );
        } catch( IOException e ) {
            System.out.println( "Saving screenshot failed: "+e );
        }
    }
    
}