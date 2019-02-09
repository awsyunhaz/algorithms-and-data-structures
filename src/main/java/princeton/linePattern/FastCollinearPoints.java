package linePattern;

import java.util.Arrays;
import java.util.ArrayList;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;

public class FastCollinearPoints {
	private Point[] points;
	
	public FastCollinearPoints(Point[] points){     // finds all line segments containing 4 or more points
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
	  
	public LineSegment[] segments(){        // the line segments
		int count = 0;
		int n = points.length;
		ArrayList<LineSegment> temp = new ArrayList<LineSegment>();
		
		for (int i=0; i<n; i++){
			Point origin = points[i];
			Point[] pts = points.clone();
			Arrays.sort(pts,origin.slopeOrder());
			
			int head=1,tail=1;
			while (tail<n){
				while(tail+1<n && origin.slopeTo(pts[head])==origin.slopeTo(pts[tail+1]))
					tail++;
				if (tail-head>=2){
					Point[] p = new Point[tail-head+2];
					p[0] = origin;
					for (int j=1; j<tail-head+2; j++)
						p[j] = pts[head+j-1];
					if (origin==minPoint(p)){
						temp.add(new LineSegment(minPoint(p),maxPoint(p)));
						count++;
					}
				}
				head = tail+1;
				tail = head;
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
	    FastCollinearPoints collinear = new FastCollinearPoints(points);
	    for (LineSegment segment : collinear.segments()) {
	        StdOut.println(segment);
	        segment.draw();
	    }
	    StdDraw.show();
	}
}