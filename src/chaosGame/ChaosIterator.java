package chaosGame;
import java.awt.geom.Point2D.Double;
import java.util.Random;

public class ChaosIterator {

	private static final int DEFAULT_SIZE = 500;
	private int triangleSize;
	
	// Equal to sqrt(3)/2, the ratio of the side of the triangle to the height
	public static final double HEIGHTRATIO = 0.866;

	private Double leftVertex;
	private Double rightVertex;
	private Double topVertex;

	private static final Random randomGen = new Random();
	private Double currentPoint;

	public ChaosIterator() {
		this(getPointInsideTriangle(DEFAULT_SIZE));
	}

	public ChaosIterator(int triangleSize){
		this(getPointInsideTriangle(DEFAULT_SIZE), triangleSize);
	}
	
	public ChaosIterator(Double initialPoint) {
		this(initialPoint, DEFAULT_SIZE);
	}
	
	public ChaosIterator(Double initialPoint, int triangleSize){
		this.currentPoint = initialPoint;
		this.triangleSize = triangleSize;
		this.leftVertex = new Double(0, 0);
		this.rightVertex = new Double(this.triangleSize, 0);
		this.topVertex = new Double(this.triangleSize / 2.0,
				(HEIGHTRATIO * this.triangleSize));
	}

	private void iterate() {
		int direction = randomGen.nextInt(3);
		//System.out.println(direction);
		switch (direction) {
		case 0:
			moveTowardPoint(this.leftVertex);
			break;
		case 1:
			moveTowardPoint(this.rightVertex);
			break;
		case 2:
			moveTowardPoint(this.topVertex);
			break;
		}
	}

	private void moveTowardPoint(Double p){
		/*
		int oldX = this.currentPoint.x;
		int oldY = this.currentPoint.y;
		int newX = p.x;
		int newY = p.y;
		int avgX = (newX+oldX)/2;
		int avgY = (newY+oldY)/2;
		this.currentPoint = new Point(avgX, avgY);
		*/
		this.currentPoint = new Double((this.currentPoint.x + p.x) / 2.0, (this.currentPoint.y + p.y)/2.0);
	}
	
	public Double getCurrentPoint() {
		return this.currentPoint;
	}
	
	public Double getNextPoint() {
		this.iterate();
		return this.currentPoint;
	}

	public static Boolean isInsideTriangle(Double p, int triangleSize){
		if (p.x < 0)
			return false;
		if (p.x > triangleSize)
			return false;
		if (p.y < 0)
			return false;
		if (p.y > triangleSize * HEIGHTRATIO)
			return false;
		if (p.x <= (triangleSize / 2)){
			if (p.y > (p.x * 2 * HEIGHTRATIO))
				return false;
		}
		else if (p.y > ((triangleSize - p.x) * 2 *HEIGHTRATIO))
			return false;
		return true;			
	}
	
	public static Double getPointInsideTriangle(int triangleSize){
		Double p = new Double(randomGen.nextInt(), randomGen.nextInt());
		while (!isInsideTriangle(p, triangleSize)){
			p = new Double(randomGen.nextInt(triangleSize), randomGen.nextInt(triangleSize));
		}
		return p;
	}
}
