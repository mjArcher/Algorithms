import java.util.ArrayList; //can change size dynamically, cannot work with primitive types (use wrappers instead??)
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class Point2D
{
  public final Comparator<Point2D> POLAR_ORDER = new PolarOrder();
  private final double x;
  private final double y;

  public Point2D(double x, double y)
  {
    this.x = x;
    this.y = y;
  }

  //counter clockwise turn: this is easy - computational geometry, is just the cross product
  public static int ccw(Point2D a, Point2D b, Point2D c)
  {
    double area2 = (b.x - a.x)*(c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    if (area2 < 0)
      return -1; // clockwise
    else if (area2 > 0)
      return 1; // counter-clockwise
    else 
      return 0; // collinear 
  }

  //need to find lowest Y

  private class PolarOrder implements Comparator<Point2D>
  {
    public int compare(Point2D q1, Point2D q2)
    {
      double dy1 = q1.y - y;
      double dy2 = q2.y - y;

      if (dy1 == 0 && dy2 == 0) {} //p, q1, q2 horozontal
      else if (dy1 >= 0 && dy2 < 0)// q1 above p; q2 below p
        return -1;
      else if (dy2 >= 0 && dy2 < 0)// q1 below p; q2 above p
        return -1;
      else  //both above or below p
        return -ccw(Point2D.this, q1, q2); // to access invoking point from within inner class
    }
  }

//graham scan implementation
//
//1. sort with lowest y coordinate, get p0
//2. sort by polar angle w.r.t p0
//3. p1 is definitely the next point on the hull (it is furthest to the right w.r.t p0)  
//4.  
//This has running time NlogN for sorting and linear for rest
//NlogN for sorting each point pushed and popped at most once

  public static void main(String[] args)
  {
    System.out.println("Test peek");
    //create symlinks to the locations of the stack and the stack iterator 
    // StackIterator<Point2D> hull = new StackIterator<Point2D>(); //we could use a stack or a stack iterator here
    Stack<Point2D> hull = new Stack<Point2D>();

    Arrays.sort(p, Point2D.Y_ORDER); //needs implementing - sort point with lowest y-coordinate
    Arrays.sort(p, p[0].BY_POLAR_ORDER); //needs implementing - sort by polar angle with respect to p[0]

    hull.push(p[0]); //these points are definitely on the hull
    hull.push(p[1]);

    for (int i = 2; i < N; i ++) {
      Point2D top = hull.pop();
      while (Point2D.ccw(hull.peek(), top, p[i]) <= 0) //need implementing (discard points that would create clockwise turn
        top = hull.pop();

      hull.push(top);
      hull.push(p[i]); //add p[i] to putative hull
    }
  }
}
    

