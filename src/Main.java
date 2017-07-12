
import javax.swing.JFrame;


public class Main {
    public static void main(String[] args) {
        DrawWithMouseClicks frame = new DrawWithMouseClicks();
        frame.initialize();
        frame.setSize(500, 500);
        frame.setLocation(100, 100);
        frame.setTitle("Draw Shapes with Buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
