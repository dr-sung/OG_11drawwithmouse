
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.ArrayList;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
    
    private final ArrayList<Shape> shapes;
    
    public DrawPanel(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Shape s : shapes) {
            g2.draw(s);
        }
    }
}
