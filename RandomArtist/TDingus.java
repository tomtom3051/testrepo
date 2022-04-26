/**
 * TDingus -- part of HA RandomArtist
 * example of a very simple Dingus
 * @author Tom Sijbers
 * @ID 1709208
 * @author IPEK DEGER
 * @id 1578006
 * @group 95
 * @date 08/10/2021
 */
import java.awt.Graphics;
class TDingus extends Dingus {
    private int width; //width
    private int height; //height
    private boolean filled; //true: filled, false: outline
    public TDingus(int maxX, int maxY){
        super(maxX, maxY);
        width = random.nextInt(maxX);
        height = random.nextInt(maxY);
        filled = random.nextBoolean();
    }

    @Override
    void draw(Graphics g){
        g.setColor(color);
        //part 1 of shape
        if (filled){
            g.fillRect(x, y, width/2, height);
        }
        else{
            g.drawRect(x, y, width/2, height);
        }
        //part 2 of shape
        int xx = x - (width/4);
        g.setColor(color);
        if (filled){
            g.fillRect(xx, y, width, height/2);
        }
        else{
            g.drawRect(xx, y, width, height/2);
        }

   }
}