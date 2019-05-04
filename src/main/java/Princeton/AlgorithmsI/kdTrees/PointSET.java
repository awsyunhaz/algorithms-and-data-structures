package Princeton.AlgorithmsI.kdTrees;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import java.util.TreeSet;

public class PointSET {
	
	private TreeSet<Point2D> pointSet;
	
	public PointSET(){                               // construct an empty set of points
		pointSet = new TreeSet<Point2D>(); 
	}
	
	public boolean isEmpty(){                      // is the set empty?
		return pointSet.isEmpty();
	}
	
	public int size(){                         // number of points in the set
		return pointSet.size();
	}
	
	public void insert(Point2D p){              // add the point to the set (if it is not already in the set)
		if (p==null)
			throw new java.lang.IllegalArgumentException();
		pointSet.add(p);
	}
	
	public boolean contains(Point2D p){            // does the set contain point p?
		if (p==null)
			throw new java.lang.IllegalArgumentException();
		return pointSet.contains(p);
	}
	
	public void draw(){                         // draw all points to standard draw
		for (Point2D point: pointSet)
			point.draw();
	}
	
	public Iterable<Point2D> range(RectHV rect){             // all points that are inside the rectangle (or on the boundary)
		if (rect==null)
			throw new java.lang.IllegalArgumentException();
		
		TreeSet<Point2D> set = new TreeSet<Point2D>();
		for (Point2D point: pointSet){
			if (rect.contains(point))
				set.add(point);
		}
		
		return set;
	}
	
	public Point2D nearest(Point2D p){             // a nearest neighbor in the set to point p; null if the set is empty
		if (p==null)
			throw new java.lang.IllegalArgumentException();
		if (isEmpty())
			return null;
		
		double minDis = Double.MAX_VALUE;
		Point2D nearestPt = null;
		for (Point2D point: pointSet){
			if (point.distanceSquaredTo(p)<minDis){
				nearestPt = point;
				minDis = point.distanceSquaredTo(p);
			}
		}
		
		return nearestPt;
	}

	public static void main(String[] args){                  // unit testing of the methods (optional)
		
	}
}