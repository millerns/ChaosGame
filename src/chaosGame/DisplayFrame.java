package chaosGame;

import javax.swing.*;

public class DisplayFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "Chaos Game";
	private static final int DEFAULT_TRIANGLE_SIZE = 500;
	private int windowWidth;
	private int windowHeight;
	//private static final int WINDOW_WIDTH = 850;
	//private static final int WINDOW_HEIGHT = 650;
	private PointDisplay pd;
	//JPanel graph = new JPanel(new BorderLayout());
	
	public DisplayFrame(){
		this(DEFAULT_TRIANGLE_SIZE);
	}
	
	public DisplayFrame(int triangleSize){
		this.setTitle(TITLE);
		this.windowWidth = (int)(triangleSize * 1.02);
		this.windowHeight = (int)(triangleSize * ChaosIterator.HEIGHTRATIO * 1.05);
		this.setSize(windowWidth, windowHeight);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.pd = new PointDisplay(triangleSize);
		this.add(pd);
	}
	
	
	public PointDisplay getPointDisplay(){
		return this.pd;
	}
	
}
