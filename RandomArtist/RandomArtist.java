/** Main class for HA Random Artist
 * can be used unchanged in most cases
 * @author Tom Sijbers
 * @ID 1709208
 * @author IPEK DEGER
 * @id 1578006
 * @group 95
 * @date 08/10/2021
 */

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JButton;

public class RandomArtist {
    JFrame frame;
    Painting painting; // panel that provides the random painting
    JButton regenerateButton;
    JButton shotButton;

    RandomArtist() {
        // invokeLater: preferred way to create components
        SwingUtilities.invokeLater( new Runnable() {
            @Override
            public void run() {
                painting = new Painting();
                frame = new JFrame("Computer Assisted Random Artist");
                frame.add(painting, BorderLayout.CENTER);
                regenerateButton = new JButton("Regenerate");
                regenerateButton.addActionListener(painting); // painting provides reaction to buttonclick
                frame.add(regenerateButton, BorderLayout.SOUTH);
                shotButton = new JButton("Screenshot");
                shotButton.addActionListener(painting);
                frame.add(shotButton, BorderLayout.NORTH);
                frame.pack();
                painting.regenerate(); // can be done here since painting has a size!
                frame.setVisible(true);
            }
        } );
    }

    public static void main(String[] arg) {
        new RandomArtist();
    }
}
