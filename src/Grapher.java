import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.geom.Ellipse2D;
import java.util.*;

class Surface extends JPanel {
	
	public static final int HEIGHT = 1000;
	public static final int WIDTH = 1920;
	public static final int X_MIN = 0;
	public static final long X_MAX = 10000;
	public static final int Y_MIN = -50;
	public static final long Y_MAX = 10000;
	public static final double XRATIO = (double) WIDTH/(X_MAX - X_MIN);
	public static final double YRATIO = (double) HEIGHT/(Y_MAX - Y_MIN);
	public static final int RADIUS = 1;
	public static final int BASE = 10;
	
	//Create sequence by rotating binary digits of it's number by the number
	//Now in the OEIS https://oeis.org/A336953
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        
        for(int x = X_MIN; x < X_MAX; x++) {
        	int y = function(x);
        	int yCord = HEIGHT - (int) Math.round((y -Y_MIN) * YRATIO);
        	int xCord = (int) Math.round((x - X_MIN)* XRATIO);
        	Ellipse2D theCircle = new Ellipse2D.Double(xCord - RADIUS, yCord - RADIUS, 2 * RADIUS, 2 * RADIUS);
        	g2d.setPaint(Color.BLACK);
        	g2d.fill(theCircle);
        }
    }
    
    public static int function(int n) {
    	String baseString = Integer.toString(n, BASE);
    	String[] based = baseString.split("");
    	int rotate = based.length - (n % based.length);
    	String rotatedString = "";
    	for (int i = based.length - rotate; i < based.length; i++) {
    		rotatedString += based[i];
    	}
    	for (int i = 0; i < based.length - rotate; i++) {
    		rotatedString += based[i];
    	}
//    	System.out.println(rotatedString);
    	return Integer.parseInt(rotatedString, BASE);
    }

    @Override
    public void paintComponent(Graphics g) {

        
        doDrawing(g);
    }
}

