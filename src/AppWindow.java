import java . awt . * ;
import java.awt . event . * ;
import java . applet .*;
import java.util.Random;

public class AppWindow extends Frame {
    public AppWindow() {
        addWindowListener(new MyWindowAdapter());
    }
    public static void main(String args[]) {
        AppWindow appwin = new AppWindow();
        appwin.setSize(new Dimension(300, 200));
        appwin.setTitle("An AWT-Based Application ");
        appwin.setVisible(true);

        Button button = new Button();
        button.setBounds(50, 50, 100, 50);
        button.setLabel("adasd");
        button.setVisible(true);
        button.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                int x = getRandomNumberInRange(0, 1920 - 100);
                int y = getRandomNumberInRange(0, 1080 - 50);
                button.setBounds(x, y, 100, 50);
            }
        });

        appwin.add(button);
        appwin.setLayout(null);
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}

class MyWindowAdapter extends WindowAdapter {
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}