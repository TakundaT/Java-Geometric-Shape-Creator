import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.sound.sampled.Line;

public class A3Test {
    @Test
    public void testCircleInsideCircle() {
        Circle c1 = new Circle(new Point(1, 3), 4);
        Circle c2 = new Circle(new Point(0, 2), 2);
        assertTrue(c1.intersect(c2));
    }
    @Test 
    public void testCircleIntersectCircle(){
        Circle c1 = new Circle(new Point(1, 3), 3);
        Circle c2 = new Circle(new Point(2, 3), 3);
        assertTrue(c1.intersect(c2));
        
    } 

    @Test
    public void testCircleNotIntersectCircle(){
        Circle c1 = new Circle(new Point(1, 3), 3);
        Circle c2 = new Circle(new Point(-3, -1), 2);
        assertFalse(c1.intersect(c2));
    }
    @Test 
    public void testPointIntersectCircle(){
    Circle c1 = new Circle(new Point(3, 2), 3);
    Point p1 = new Point(3,1);
    assertTrue(c1.intersect(p1));
    }

    @Test 
    public void testPointTangentCircle(){
        Circle c1 = new Circle(new Point(3, 2), 3);
        Point p1 = new Point(0,2);
        assertFalse(c1.intersect(p1)); 
    }
    @Test 
    public void testPointNotIntersectCircle(){
        Circle c1 = new Circle(new Point(3, 2), 3);
        Point p1 = new Point(2,6);
        assertFalse(c1.intersect(p1));
    }

    @Test 
    public void testPointOnLineSeg(){
        LineSeg l1 = new LineSeg(new Point(2,2), new Point(5,3));
        Point p1 = new Point(5,3);
        assertTrue(l1.intersect(p1));
    }
    @Test 
    public void testPointNotOnLineSeg(){
        LineSeg l1 = new LineSeg(new Point(2,2), new Point(5,3));
        Point p1 = new Point(0,4);
        assertFalse(l1.intersect(p1));
    }
    @Test
    public void testLinesegIntersectLineSeg(){
        LineSeg l1 = new LineSeg(new Point(2,2), new Point(5,3));
        LineSeg l2 = new LineSeg(new Point(4,3), new Point(4,0));
        assertTrue(l1.intersect(l2));
    }
    @Test 
    public void testLinesegNotIntersectLineSeg(){
        LineSeg l1 = new LineSeg(new Point(2,2), new Point(5,3));
        LineSeg l2 = new LineSeg(new Point(0,3), new Point(4,0));
        assertFalse(l1.intersect(l2));
    }
    @Test 
    public void testLinesegIntersectCircle(){
        LineSeg l1 = new LineSeg(new Point(2,2), new Point(5,3));
        Circle c1 = new Circle(new Point(2, 3), 2);
        assertTrue(l1.intersect(c1));
    }
    @Test 
    public void testLinesegNotIntersectCircle(){
        LineSeg l1 = new LineSeg(new Point(-2,-2), new Point(5,-1));
        Circle c1 = new Circle(new Point(2, 3), 2);
        assertFalse(l1.intersect(c1));
    }
    @Test 
    public void testLinesegTangentCircle(){
        Circle c1 = new Circle(new Point(2, 3), 2);
        LineSeg l1 = new LineSeg(new Point(0,0), new Point(0,6));
        assertFalse(l1.intersect(c1));
    }
    @Test 
    public void testLineSegIntersectRectangle(){
        LineSeg l1 = new LineSeg(new Point(0,0), new Point(0,6));
        Rectangle r1 = new Rectangle(-2,4,4,1);
        assertTrue(l1.intersect(r1));
    }
    @Test 
    public void testLinesegNotIntersectRectangle(){
        LineSeg l1 = new LineSeg(new Point(-3,0), new Point(-3,6));
        Rectangle r1 = new Rectangle(-2,4,4,1);
        assertFalse(l1.intersect(r1));
    }
    @Test 
    public void testPointInsideRectangle(){
        Rectangle r1 = new Rectangle(-2,4,4,1);
        Point p1 = new Point(0,2);
        assertTrue(p1.intersect(r1));
    }
    @Test 
    public void testPointOutsideRectangle(){
        Rectangle r1 = new Rectangle(-2,4,4,1);
        Point p1 = new Point(0,5);
        assertFalse(p1.intersect(r1));   
    }
    @Test 
    public void testPointOnRectangleEdge(){
        Rectangle r1 = new Rectangle(-2,4,4,1);
        Point p1 = new Point(-2,2);
        assertFalse(p1.intersect(r1));   
    }
    @Test 
    public void LineSegOnRectangleEdge(){
        Rectangle r1 = new Rectangle(-2,4,4,1);
        LineSeg l1 = new LineSeg(new Point(-2,1), new Point(-2,5));
        assertFalse(r1.intersect(l1));   
    }
    @Test 
    public void testRectangleIntersectRectangle(){
        Rectangle r1 = new Rectangle(-2,4,4,1);
        Rectangle r2 = new Rectangle(-1,5,5,-1);
        assertTrue(r1.intersect(r2));
    }
    @Test 
    public void testRectangleTouchesRectangleEdge(){
        Rectangle r1 = new Rectangle(-2,4,4,1);
        Rectangle r2 = new Rectangle(-6,-2,4,1);
        assertFalse(r1.intersect(r2));
    }
    @Test 
    public void testRectangleNotIntersectRectangle(){
        Rectangle r1 = new Rectangle(-2,4,4,1);
        Rectangle r2 = new Rectangle(-6,-3,4,1);
        assertFalse(r1.intersect(r2));
    }
    @Test 
    public void testRectangleIntersectCircle(){
        Rectangle r1 = new Rectangle(-2,4,4,1);
        Circle c1 = new Circle(new Point(2, 1), 2);
        assertTrue(r1.intersect(c1));
    }
    @Test
    public void testRectangleIntersectCircleEdge(){
        Rectangle r1 = new Rectangle(4,6,3,1);
        Circle c1 = new Circle(new Point(2, 1), 2);
        assertFalse(r1.intersect(c1));
    }
    @Test 
    public void testRectangleNotIntersectCircle(){
        Rectangle r1 = new Rectangle(5,6,3,1);
        Circle c1 = new Circle(new Point(2, 1), 2);
        assertFalse(r1.intersect(c1));
    }
    @Test 
    public void testRectangleInsideRectangle(){
       Rectangle r1 = new Rectangle(3,6,3,0);
       Rectangle r2 = new Rectangle(4,5,2,1);
       assertTrue(r1.intersect(r2));
    }
    @Test 
    public void testPointIntersectPoint(){
        Point p1 = new Point (2,2);
        Point p2 = new Point (2,2);
        assertTrue(p1.intersect(p2));
    }
    @Test 
    public void PointInitializedTo0(){
        Point p1 = new Point ();
        Point p2 = new Point (0,0);
        assertTrue(p1.intersect(p2));
    }
    @Test 
    public void testReflexiveCircleRectangleIntersection(){
        Rectangle r1 = new Rectangle(3,6,3,0);
        Circle c1 = new Circle(new Point(2, 1), 2);
        assertEquals(r1.intersect(c1), c1.intersect(r1));
    }
    @Test 
    public void testReflexiveLineSegPointIntersection(){
        LineSeg l1 = new LineSeg(new Point(-2,-2), new Point(5,-1));
        Point p1 = new Point(2,2);
        assertEquals(p1.intersect(l1), l1.intersect(p1));       
    }
}

