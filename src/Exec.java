import java.awt.EventQueue;
import javax.swing.JFrame;

public class Exec extends JFrame {

    public Exec() {

        initUI();
    }
    
    private void initUI() {

        add(new Surface());

        setTitle("Graph");
        setSize(Surface.WIDTH, Surface.HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
            	Exec ex = new Exec();
                ex.setVisible(true);
            }
        });
    }
}