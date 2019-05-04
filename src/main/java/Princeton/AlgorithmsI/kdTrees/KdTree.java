package Princeton.AlgorithmsI.kdTrees;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import java.util.TreeSet;
import edu.princeton.cs.algs4.StdOut;

public class KdTree {

	private Node root;
	private int size;
	private Point2D nearestPt;
	private double minDis;
	private TreeSet<Point2D> set;

	private class Node implements Comparable<Point2D>{
		public Point2D p;      // the point
		public RectHV rect;    // the axis-aligned rectangle corresponding to this node
		public Node lb;        // the left/bottom subtree
		public Node rt;        // the right/top subtree
		public boolean orient;
		
		public Node(Point2D p, boolean orient, RectHV rect){
			this.p = p;
			this.rect = rect;
			this.orient = orient;
		}
		
		public int compareTo(Point2D p){
			if (p.x()==this.p.x() && p.y()==this.p.y())
				return 0;
			if (orient==false){
				if (p.x()<=this.p.x())
					return -1;
				else
					return 1;
			}
			else{
				if (p.y()<=this.p.y())
					return -1;
				else
					return 1;
			}
		}

	}
	
	public KdTree(){                               // construct an empty set of points
		root = null;
		size = 0;
		set = new TreeSet<Point2D>();
	}
	
	public boolean isEmpty(){                      // is the set empty?
		return size==0;
	}
	
	public int size(){                         // number of points in the set
		return size;
	}
	
	public void insert(Point2D p){              // add the point to the set (if it is not already in the set)
		if (p==null)
			throw new java.lang.IllegalArgumentException();
		if (root==null){
			root = new Node(p,false,new RectHV(0.0,0.0,1.0,1.0));
			size++;
		}
		insert(root,p);
	}
		
	private void insert(Node n,Point2D p){
		int cmp = n.compareTo(p);
		if (cmp==0)
			return;
		else if (cmp<0){
			if (n.lb==null){
				if(n.orient==false)
					n.lb = new Node(p,!n.orient,new RectHV(n.rect.xmin(),n.rect.ymin(),n.p.x(),n.rect.ymax()));
				else
					n.lb = new Node(p,!n.orient,new RectHV(n.rect.xmin(),n.rect.ymin(),n.rect.xmax(),n.p.y()));
				size++;
			}
			else
				insert(n.lb,p);
		}
		else{
			if (n.rt==null){
				if(n.orient==false)
					n.rt = new Node(p,!n.orient,new RectHV(n.p.x(),n.rect.ymin(),n.rect.xmax(),n.rect.ymax()));
				else
					n.rt = new Node(p,!n.orient,new RectHV(n.rect.xmin(),n.p.y(),n.rect.xmax(),n.rect.ymax()));
				size++;
			}
			else
				insert(n.rt,p);
		}
	}
	
	public boolean contains(Point2D p){            // does the set contain point p?
		if (p==null)
			throw new java.lang.IllegalArgumentException();
		Node n = root;
		while (n!=null){
			int cmp = n.compareTo(p);
			if (cmp==0)
				return true;
			else if (cmp<0)
				n = n.lb;
			else 
				n = n.rt;
		}
		return false;
	}
	
	public void draw(){                         // draw all points to standard draw
		Node n = root;
		draw_point(n);
	}
	
	private void draw_point(Node n){
		n.p.draw();
		if (n.lb!=null)
			draw_point(n.lb);
		if (n.rt!=null)
			draw_point(n.rt);
	}
	
	public Iterable<Point2D> range(RectHV rect){             // all points that are inside the rectangle (or on the boundary)
		if (root==null)
			return set;
		if (rect==null)
			throw new java.lang.IllegalArgumentException();
		
		range_search(root,rect);
		return set;
	}
	
	private void range_search(Node n,RectHV range){
		if (range.contains(n.p))
			set.add(n.p);
		if (n.lb!=null && range.intersects(n.lb.rect))
			range_search(n.lb,range);
		if (n.rt!=null && range.intersects(n.rt.rect))
			range_search(n.rt,range);
	}
	
	public Point2D nearest(Point2D p){             // a nearest neighbor in the set to point p; null if the set is empty
		if (root==null)
			return null;
		if (p==null)
			throw new java.lang.IllegalArgumentException();
		minDis = Double.MAX_VALUE;
		find_nearest(root,p);
		return nearestPt;
	}
	
	private void find_nearest(Node n,Point2D p){
		if (n.p.distanceSquaredTo(p)<minDis){
			nearestPt = n.p;
			minDis = n.p.distanceSquaredTo(p);
		}
		
		if (n.lb!=null && n.rt!=null){
			double lb_dis = n.lb.rect.distanceSquaredTo(p);
			double rt_dis = n.rt.rect.distanceSquaredTo(p);
			if (lb_dis<minDis && lb_dis<=rt_dis){
				find_nearest(n.lb,p);
				if (rt_dis<minDis)
					find_nearest(n.rt,p);
			}
			else if (rt_dis<minDis && rt_dis<=lb_dis){
				find_nearest(n.rt,p);
				if (lb_dis<minDis)
					find_nearest(n.lb,p);
			}
		}
		else if (n.lb!=null && n.lb.rect.distanceSquaredTo(p)<minDis)
			find_nearest(n.lb,p);
		else if (n.rt!=null && n.rt.rect.distanceSquaredTo(p)<minDis)
			find_nearest(n.rt,p);
	}

	public static void main(String[] args){                  // unit testing of the methods (optional)
		
	}
}