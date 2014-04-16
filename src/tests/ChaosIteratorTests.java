package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import chaosGame.ChaosIterator;

import java.awt.geom.Point2D.Double;

;

public class ChaosIteratorTests {

	private final int TRIANGLESIDE = 100;
	private Double centerPoint = new Double(TRIANGLESIDE / 2, (TRIANGLESIDE
			* ChaosIterator.HEIGHTRATIO * .5));
	private final Double LEFTVERTEX = new Double(0, 0);
	private final Double RIGHTVERTEX = new Double(TRIANGLESIDE, 0);
	private final Double TOPVERTEX = new Double(TRIANGLESIDE / 2,
			(int) (ChaosIterator.HEIGHTRATIO * TRIANGLESIDE));

	private final Double towardsLeft = new Double(TRIANGLESIDE / 4,
			(TRIANGLESIDE * ChaosIterator.HEIGHTRATIO * .25));
	private final Double towardsRight = new Double(3 * TRIANGLESIDE / 4,
			(TRIANGLESIDE * ChaosIterator.HEIGHTRATIO * .25));
	private final Double towardsTop = new Double(TRIANGLESIDE / 2,
			(TRIANGLESIDE * ChaosIterator.HEIGHTRATIO * .75));

	@Test
	public void testThatIteratorConstructsWithGivenPoint() {
		assertEquals(LEFTVERTEX,
				new ChaosIterator(LEFTVERTEX).getCurrentPoint());
		assertEquals(RIGHTVERTEX,
				new ChaosIterator(RIGHTVERTEX).getCurrentPoint());
		assertEquals(TOPVERTEX, new ChaosIterator(TOPVERTEX).getCurrentPoint());
	}

	@Test
	public void testThatIteratorConstructsWithRandomPoint() {
		assertNotNull(new ChaosIterator());
		assertNotNull(new ChaosIterator().getCurrentPoint());
		assertNotNull(new ChaosIterator());
		assertNotNull(new ChaosIterator().getCurrentPoint());
		assertNotNull(new ChaosIterator());
		assertNotNull(new ChaosIterator().getCurrentPoint());
	}

	@Test
	public void testThatIteratorConstructsWithValidRandomPoint() {
		assertTrue(ChaosIterator.isInsideTriangle(new ChaosIterator()
				.getCurrentPoint(), TRIANGLESIDE));
		assertTrue(ChaosIterator.isInsideTriangle(new ChaosIterator()
				.getCurrentPoint(), TRIANGLESIDE));
		assertTrue(ChaosIterator.isInsideTriangle(new ChaosIterator()
				.getCurrentPoint(), TRIANGLESIDE));
	}

	@Test
	public void testThatIteratorMovesTowardPoint() {
		// ChaosIterator c1 = new ChaosIterator(centerPoint);
		// assertEquals(expected, actual);
		//fail("Not yet implemented");
		
	}

	@Test
	public void testThatIteratorIteratesProperly() {
		ChaosIterator c1 = new ChaosIterator(centerPoint);
		Double p1 = c1.getNextPoint();
		System.out.println(p1.toString());
		System.out.printf(
				"Point: %f, %f%nLeft: %f, %f%nRight: %f, %f%nTop: %f, %f%n",
				p1.x, p1.y, towardsLeft.x, towardsLeft.y, towardsRight.x,
				towardsRight.y, towardsTop.x, towardsTop.y);
		assertTrue((p1.equals(towardsLeft)) || (p1.equals(towardsRight))
				|| (p1.equals(towardsTop)));
		ChaosIterator c2 = new ChaosIterator(centerPoint);
		Double p2 = c2.getNextPoint();
		assertTrue((p2.equals(towardsLeft)) || (p2.equals(towardsRight))
				|| (p2.equals(towardsTop)));
		ChaosIterator c3 = new ChaosIterator(centerPoint);
		Double p3 = c3.getNextPoint();
		assertTrue((p3.equals(towardsLeft)) || (p3.equals(towardsRight))
				|| (p3.equals(towardsTop)));
	}

	@Test
	public void testIsInsideTriangle() {
		assertTrue(ChaosIterator.isInsideTriangle(centerPoint, TRIANGLESIDE));
		assertTrue(ChaosIterator.isInsideTriangle(towardsLeft, TRIANGLESIDE));
		assertTrue(ChaosIterator.isInsideTriangle(towardsRight, TRIANGLESIDE));
		assertTrue(ChaosIterator.isInsideTriangle(towardsTop, TRIANGLESIDE));

		assertFalse(ChaosIterator.isInsideTriangle(new Double(-1,
				TRIANGLESIDE / 2), TRIANGLESIDE));
		assertFalse(ChaosIterator.isInsideTriangle(new Double(TRIANGLESIDE / 2,
				-1), TRIANGLESIDE));
		assertFalse(ChaosIterator.isInsideTriangle(new Double(TRIANGLESIDE + 1,
				TRIANGLESIDE / 2), TRIANGLESIDE));
		assertFalse(ChaosIterator.isInsideTriangle(new Double(TRIANGLESIDE / 2,
				TRIANGLESIDE + 1), TRIANGLESIDE));
		assertFalse(ChaosIterator.isInsideTriangle(new Double(TRIANGLESIDE / 4,
				(int) (TRIANGLESIDE * ChaosIterator.HEIGHTRATIO)), TRIANGLESIDE));
	}

	@Test
	public void testGetPointInsideTriangle() {
		assertTrue(ChaosIterator.isInsideTriangle(ChaosIterator
				.getPointInsideTriangle(TRIANGLESIDE), TRIANGLESIDE));
		assertTrue(ChaosIterator.isInsideTriangle(ChaosIterator
				.getPointInsideTriangle(TRIANGLESIDE), TRIANGLESIDE));
		assertTrue(ChaosIterator.isInsideTriangle(ChaosIterator
				.getPointInsideTriangle(TRIANGLESIDE), TRIANGLESIDE));
	}
}
