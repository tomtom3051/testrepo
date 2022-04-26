/**
 * OvalDingus -- part of HA RandomArtist
 * example of a very simple Dingus
 * @author Tom Sijbers
 * @ID 1709208
 * @author IPEK DEGER
 * @id 1578006
 * @group 95
 * @date 08/10/2021
 */
import java.awt.Graphics;
class OvalDingus extends Dingus {
    protected int ovalWidth; // width of oval shape
    protected int ovalHeight; //height of oval shape
    protected boolean filled; //true: filled, false: outline
    public OvalDingus(int maxX, int maxY){
        super(maxX, maxY);
        ovalWidth = random.nextInt(maxX);
        ovalHeight = random.nextInt(maxY);
        filled = random.nextBoolean();
    }

    @Override
    void draw(Graphics g){
        g.setColor(color);
        if (filled){
            g.fillOval(x, y, ovalWidth, ovalHeight);
        }
        else{
            g.drawOval(x, y, ovalWidth, ovalHeight);
        }

    }
}
