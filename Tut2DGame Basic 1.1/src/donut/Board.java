package donut;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Board extends JPanel {

	// the paint done inside this method
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		drawDount(g);
	}
	
	private void drawDount(Graphics g){
		// graphics2d: provide control over geometry, coordinate transformation, color, text layout
		Graphics2D g2d = (Graphics2D) g;
		
		// used to make the drawing smooth. 
		// renderinghints: used to allow us to use some attribute like (on/off) anti-aliasing in form (key,value)
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHints(rh);
		
		// get width/height of window. need to center Donut shape on window
		Dimension size = getSize();
		double w = size.getWidth();
		double h = size.getHeight();
		
		// here we create the ellipse (shape)
		Ellipse2D e = new Ellipse2D.Double(0,0,80,130);
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(Color.gray);
		
		// here the ellipse is rotated 72 times to create donut shape
		for (double deg = 0; deg < 360; deg +=5){
			
			//this can transform 2d object from 2d coordinate to 2d coordinate with keeps of straight and parallel
			AffineTransform at = AffineTransform.getTranslateInstance(w/2, h/2);
			
			//math.toradian: used to convert angle measured in Degree to angle measured in Radian
			at.rotate(Math.toRadians(deg));
			
			g2d.draw(at.createTransformedShape(e));
		}
	}
}
