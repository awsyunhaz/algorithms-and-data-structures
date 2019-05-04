package Princeton.AlgorithmsI.linePattern;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;

public class BruteCollinearPoints {
	
	private Point[] points;
	
	public BruteCollinearPoints(Point[] points){    // finds all line segments containing 4 points
		if (points==null)
			throw new java.lang.IllegalArgumentException();
		for (int i=0;i<points.length;i++){
			if (points[i]==null)
				throw new java.lang.IllegalArgumentException();
		}
		for (int i=0;i<points.length;i++){
			for (int j=i+1;j<points.length;j++){
				if (points[i].slopeTo(points[j])==Double.NEGATIVE_INFINITY)
					throw new java.lang.IllegalArgumentException();
			}		
		}
		this.points = points.clone();
	}
	
	public int numberOfSegments(){        // the number of line segments
		return segments().length;
	}
	
	public LineSegment[] segments(){                // the line segments
		int count = 0;
		int n = points.length;
		ArrayList<LineSegment> temp = new ArrayList<LineSegment>();
		
		
		for (int i1=0; i1<n; i1++){
			for (int i2=i1+1; i2<n; i2++){
				for (int i3=i2+1; i3<n; i3++){
					for (int i4=i3+1; i4<n; i4++){
						if (points[i1].slopeTo(points[i2])==points[i1].slopeTo(points[i3]) &&
								points[i1].slopeTo(points[i2])==points[i1].slopeTo(points[i4])){
							Point[] pts = {points[i1],points[i2],points[i3],points[i4]};
							temp.add(new LineSegment(minPoint(pts),maxPoint(pts)));
							count++;
						}
					}
				}
			}
		}
		LineSegment[] s = new LineSegment[count];
		for (int i=0; i<count; i++)
			s[i] = temp.get(i);
		return s;
	}
	
	private Point minPoint(Point[] points){
		Point min = points[0];
		for (int i=1;i<points.length;i++){
			if (points[i].compareTo(min)<0)
				min = points[i];
		}
		return min;
	}
	
	private Point maxPoint(Point[] points){
		Point max = points[0];
		for (int i=1;i<points.length;i++){
			if (points[i].compareTo(max)>0)
				max = points[i];
		}
		return max;
	}
	
	public static void main(String[] args) {

	    // read the n points from a file
	    In in = new In(args[0]);
	    int n = in.readInt();
	    Point[] points = new Point[n];
	    for (int i = 0; i < n; i++) {
	        int x = in.readInt();
	        int y = in.readInt();
	        points[i] = new Point(x, y);
	    }

	    // draw the points
	    StdDraw.enableDoubleBuffering();
	    StdDraw.setXscale(0, 32768);
	    StdDraw.setYscale(0, 32768);
	    for (Point p : points) {
	        p.draw();
	    }
	    StdDraw.show();

	    // print and draw the line segments
	    BruteCollinearPoints collinear = new BruteCollinearPoints(points);
	    for (LineSegment segment : collinear.segments()) {
	        StdOut.println(segment);
	        segment.draw();
	    }
	    StdDraw.show();
	}
}