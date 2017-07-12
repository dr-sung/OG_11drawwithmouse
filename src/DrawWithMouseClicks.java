
import java.awt.Container;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DrawWithMouseClicks extends JFrame {
    
    private DrawPanel panel;
    private JTextField widthField;
    private JTextField heightField;
    private JButton rectButton;
    private JButton ellipseButton;
    private JButton clearButton;
    private ArrayList<Shape> shapes;
    private static final int RECT_SHAPE = 0;
    private static final int CIRCLE_SHAPE = 1;
    private int shapeType = RECT_SHAPE;

    public void initialize() {
        
        shapes = new ArrayList<>();

        panel = new DrawPanel(shapes); // Use JPanel for drawing canvas
        panel.addMouseListener(new MouseObserver());
        Container contentPane = getContentPane();
        contentPane.add(panel, "Center");

        widthField = new JTextField("10", 5);
        heightField = new JTextField("10", 5);
        JPanel fieldPanel = new JPanel();
        fieldPanel.add(new JLabel("width:"));
        fieldPanel.add(widthField);
        fieldPanel.add(new JLabel("height:"));
        fieldPanel.add(heightField);
        contentPane.add(fieldPanel, "South");

        rectButton = new JButton("Rectangle");
        ellipseButton = new JButton("Ellipse");
        clearButton = new JButton("clear");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(rectButton);
        buttonPanel.add(ellipseButton);
        buttonPanel.add(clearButton);
        contentPane.add(buttonPanel, "North");

        ActionListener buttonObserver = new ButtonObserver();
        rectButton.addActionListener(buttonObserver);
        ellipseButton.addActionListener(buttonObserver);
        clearButton.addActionListener(buttonObserver);

    }

    private class ButtonObserver implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == rectButton) {
                shapeType = RECT_SHAPE;
            } else if (source == ellipseButton) {
                shapeType = CIRCLE_SHAPE;
            } else {
                shapes.clear();
                panel.repaint();
            }
        }
    }

    private class MouseObserver implements MouseListener {

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            float w = Float.parseFloat(widthField.getText());
            float h = Float.parseFloat(heightField.getText());

            if (shapeType == RECT_SHAPE) {
                shapes.add(new Rectangle2D.Float(x, y, w, h));
            } else {
                shapes.add(new Ellipse2D.Float(x-w/2, y-h/2, w, h));
            }

            panel.repaint();
        }
    }

    
    
}
