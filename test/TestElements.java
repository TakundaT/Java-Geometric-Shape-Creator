public class TestElements {
    public static void main(String[] args) {
        testStaticElements();
        testCollisions();
    }

    static void testStaticElements(){
        
        // Uncomment the following code when you want to test your classes
         Point p1 = new Point(1,1);
		 Point p2 = new Point(4,3);
         Point p3 = new Point(18,6);
		 LineSeg l1 = new LineSeg(new Point(2,2), new Point(5,3));
		 LineSeg l2 = new LineSeg(p1, p2);
         LineSeg l3 = new LineSeg(new Point(6,12), new Point(13,2));
		 Circle c1 = new Circle(p1, 3);
		 Circle c2 = new Circle(p2, 5);
		 Rectangle r1 = new Rectangle(3,5,3,0);
		 Rectangle r2 = new Rectangle(1,7,6,3);

		
		 if(Point.getNumOfInstances()!=7){
		 	System.out.println("Point.NumberOfInsances error");

		 }
		 if(LineSeg.getNumOfInstances()!= 2){
		 	System.out.println("LineSeg.NumberOfInsances error");
		 }
		 if(Circle.getNumOfInstances()!= 2){
		 	System.out.println("Circle.NumberOfInsances error");
		 }
		 if(Rectangle.getNumOfInstances()!= 2){
		 	System.out.println("Rectangle.NumberOfInsances error");
		 }
		 if(AbstractElement.getNumOfInstances()!=10){
		 	System.out.println("AbstractElement.NumberOfInsances error");
		 }
    }

    
    static void testCollisions(){
        Point p1 = new Point(6, 2); //red point
        Point p2 = new Point(0, 8); //blue point
		Point p3 = new Point(-2,-3); //green point 
        LineSeg l1 = new LineSeg(new Point(-2, -3), new Point(10, -3)); // red lineseg
		LineSeg l2 = new LineSeg(new Point(-2, -2), new Point(-4, 4)); //black lineseg
		LineSeg l3 = new LineSeg(new Point(-5, -4), new Point(4, -2)); //purple lineseg
        Circle c1 = new Circle(new Point(2, 1), 3);  //small red circle
		Circle c2 = new Circle(new Point(4, 2), 5); //big blue circle
        Rectangle r1 = new Rectangle(-5, 0, 2, 0); //green rect
		Rectangle r2 = new Rectangle(-3, 10, 3, 1);   //orange rect

        //p3 is on l1
        if (!l1.intersect(p3)) {
            System.out.println("Error:  p3-l1");
        }

        
        //the two lines intersect
        if (!l1.intersect(l3)) {
            System.out.println("Error:  l1-l3");
        }

        //should not intersect
        if (c1.intersect(p1)) {
            System.out.println("Error:  c1-p1");
        }
		//should intersect
		if (!r2.intersect(p1)) {
            System.out.println("Error:  r2-p1");
        }

        
        //should intersect
        if (!c1.intersect(c2)) {
            System.out.println("Error:  c1-c2");
        }

        //should not intersect-tangent
        if (l1.intersect(c2)) {
            System.out.println("Error: l1-c2");
        }
		//should intersect
        if (!r1.intersect(c1)) {
            System.out.println("Error:  r1-c1");
        }

       
        //r1 should intersect r2
        if (!r1.intersect(r2)) {
            System.out.println("Error: r1-r2");
        }
		//l2 should intersect r2
        if (!l2.intersect(r2)) {
            System.out.println("Error: l2-r2");
        }
		//l2 should intersect r1
		if (!l2.intersect(r1)){
			System.out.print("Error: l2-r1");
		}
        System.out.println("Intersection tests have passed");
    }
}
