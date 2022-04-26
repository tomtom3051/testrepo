/**
 * SquareDingus -- part of HA RandomArtist
 * example of a very simple Dingus
 * @author Tom Sijbers
 * @ID 1709208
 * @author IPEK DEGER
 * @id 1578006
 * @group 95
 * @date 08/10/2021
 */
import java.awt.Graphics;
class SquareDingus extends Dingus {
    protected int widthSquare; //width of square
    protected int heightSquare; // height of square
    protected boolean filled; //true: filled, false: outline
    public SquareDingus(int maxX, int maxY){
        super(maxX, maxY);
        widthSquare = random.nextInt(maxX);
        heightSquare = random.nextInt(maxY);
        filled = random.nextBoolean();
    }

   @Override
    void draw(Graphics g){
        g.setColor(color);
        if (filled) {
            g.fillRect(x, y, widthSquare, heightSquare);
        }
        else{
            g.drawRect(x, y, widthSquare, heightSquare);
        }

    }
}
