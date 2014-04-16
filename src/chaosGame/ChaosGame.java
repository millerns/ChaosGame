package chaosGame;

import java.awt.Point;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;

/**
 * The Chaos Game, for CSSE/MA 325
 * 3/24/14
 * @author Nick Miller
 *
 */
public class ChaosGame {
	
	private static final int POINTS_TO_GRAPH = 1000000;
	private static final int TRIANGLE_SIZE = 1080;
	
	public static void main(String[] args){
		ArrayList<Point> pointList = getIteratedPoints();
		//printPoints(pointList);
		DisplayFrame frame = new DisplayFrame(TRIANGLE_SIZE);
		frame.getPointDisplay().setPoints(pointList);
		frame.setVisible(true);
				
	}
	
	private static ArrayList<Point> getIteratedPoints(){
		ChaosIterator c = new ChaosIterator(TRIANGLE_SIZE);
		ArrayList<Point> pointList = new ArrayList<Point>();
		
		pointList.add(new Point((int)c.getCurrentPoint().x, (int)c.getCurrentPoint().y));
		
		for (int x=0; x<POINTS_TO_GRAPH-1; x++){
			Double p = c.getNextPoint();
			pointList.add(new Point((int)p.x, (int)p.y));
		}
		
		return pointList;
	}
	
	@SuppressWarnings("unused")
	private static void printPoints(ArrayList<Point> list){
		for (Point p: list){
			System.out.println(p.toString());
		}
	}
	
	
}
