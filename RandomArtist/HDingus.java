/**
 * HDingus -- part of HA RandomArtist
 * example of a very simple Dingus
 * @author Tom Sijbers
 * @ID 1709208
 * @author IPEK DEGER
 * @id 1578006
 * @group 95
 * @date 08/10/2021
 */
import java.awt.Graphics;
class HDingus extends Dingus {
    int radius;
    int width;
    int height;
    private boolean filled; //true: filled, false: outline
    public HDingus(int maxX, int maxY){
        super(maxX, maxY);
        
        width = random.nextInt(maxX/10);
        height = width*2;
        radius = width/2; // radius and height are defined in terms of width so that the proportions remain consistant
        filled = random.nextBoolean();
    }

    @Override
    void draw(Graphics g){
        g.setColor(color);
        //draw first square
        if (filled){
            g.fillRect(x, y, width, height);
        }
        else{
            g.drawRect(x, y, width, height);
        }
        //draw second square
        int xx = x + width + radius;
        if (filled){
            g.fillRect(xx, y, width, height);
        }
        else{
            g.drawRect(xx, y, width, height);
        }
        int xxx = x + width;
        int yy = y + height/4;
        if (filled){
            g.fillArc(xxx, yy, radius, radius,0, 360);
        }
        else{
            g.drawArc(xxx, yy, radius, radius,0, 360);
        }  
   }
}