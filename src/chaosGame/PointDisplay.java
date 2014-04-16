package chaosGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PointDisplay extends JPanel{
	
	private static final int DEFAULT_WIDTH = 100;
	private static final int DEFAULT_HEIGHT = 100;
	private static final int POINT_WIDTH = 2;
	private static final int POINT_HEIGHT = 2;
	//private static final int WIDTH_BUFFER = 25;
	//private static final int HEIGHT_BUFFER = 25;
	
	private static final Color BACKGROUND_COLOR = Color.WHITE;
	private static final Color POINT_COLOR = Color.BLACK;
	
	//set to false to display each of the thre largest triangles as a different color
	private static final Boolean BW = true;
	
	private int currentColor = 0;
	
	private int height;
	private int width;
	
	private ArrayList<Point> pointList = new ArrayList<Point>();
	
	public PointDisplay(){
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	public PointDisplay(int size){
		this(size, size);
	}
	
	public PointDisplay(int width, int height){
		this.width = width;
		this.height = height;
		this.setSize((int)(this.width * 1.1), (int)(this.height*1.5));
		this.setBackground(BACKGROUND_COLOR);
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(POINT_COLOR);
		for (Point p: this.pointList){
			if (!BW)
				this.triangleColor(p.x, p.y, g2d);
			this.plotPoint(p.x, p.y, g2d);
			//this.rotateColor(g2d);
		}
	}
	
	
	private void plotPoint(int x, int y, Graphics2D g2d){
		g2d.fillOval(x, (int)((y*-1) + (this.height * ChaosIterator.HEIGHTRATIO)), POINT_WIDTH, POINT_HEIGHT);
	}
	
	public void addPoint(Point p){
		this.pointList.add(p);
	}
	
	public void clearPoints(){
		this.pointList = new ArrayList<Point>();
	}
	
	public void setPoints(ArrayList<Point> l){
		this.pointList = l;
	}
	
	@SuppressWarnings("unused")
	private void rotateColor(Graphics2D g2d){
		switch (currentColor) {
			case 0:
				g2d.setColor(Color.BLUE);
				this.currentColor = 1;
				break;
			case 1:
				g2d.setColor(Color.CYAN);
				this.currentColor = 2;
				break;
			case 2:
				g2d.setColor(Color.WHITE);
				this.currentColor = 0;
				break;
		}
	}
	
	private void triangleColor(int x, int y, Graphics2D g2d){
		if (y >= (this.height * ChaosIterator.HEIGHTRATIO * .5) -1)
			g2d.setColor(Color.BLUE);
		else
			if (x <= (this.width/2))
					g2d.setColor(Color.RED);
			else
				g2d.setColor(Color.GREEN);
	}
}
