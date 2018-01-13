package puzzle;

import edu.princeton.cs.algs4.MinPQ;
import java.util.Comparator;
import java.util.ArrayList;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
	private boolean solvable = false;
	private SearchNode finalNode; 
	
	private class SearchNode{
		private Board board;
		private int moves;
		private SearchNode preNode;
		
		public SearchNode(Board board, int moves, SearchNode node){
			this.board = board;
			this.moves = moves;
			this.preNode = node;
		}	
	}
	
    public Solver(Board initial){           // find a solution to the initial board (using the A* algorithm)
    	
    	if (initial == null)
    		throw new java.lang.IllegalArgumentException();
    	Comparator<SearchNode> comparator = new Comparator<SearchNode>(){
    		public int compare(SearchNode n1, SearchNode n2){
    			if (n1.board.manhattan()+n1.moves > n2.board.manhattan()+n2.moves)
    				return 1;
    			else if (n1.board.manhattan()+n1.moves < n2.board.manhattan()+n2.moves)
    				return -1;
    			return 0;
    		}
    	};
    	
    	MinPQ<SearchNode> minPQ = new MinPQ<SearchNode>(comparator);
    	minPQ.insert(new SearchNode(initial,0,null));
    	MinPQ<SearchNode> minPQ_twin = new MinPQ<SearchNode>(comparator);
    	minPQ_twin.insert(new SearchNode(initial.twin(),0,null));
    	boolean finish = false;
    	
    	do{
    		SearchNode node = minPQ.delMin();
			if (node.board.isGoal()){
				finish = true;
				solvable = true;
				finalNode = node;
				break;
			}
    		
			Iterable<Board> boards = node.board.neighbors();
			for (Board b: boards){
				if (node.preNode==null || !b.equals(node.preNode.board)){
					SearchNode next = new SearchNode(b,node.moves+1,node);
					minPQ.insert(next);
				}
			}
			
			SearchNode node_twin = minPQ_twin.delMin();
			if (node_twin.board.isGoal()){
				finish = true;
				solvable = false;
				break;
			}
			Iterable<Board> boards_twin = node_twin.board.neighbors(); 
			for (Board b: boards_twin){

				if (node_twin.preNode==null || !b.equals(node_twin.preNode.board)){
					SearchNode next = new SearchNode(b,node_twin.moves+1,node_twin);
					minPQ_twin.insert(next);
				}
			}	
    	}while(!finish);

    }
   
    
    public boolean isSolvable(){            // is the initial board solvable?
    	return solvable;
    }
    
    public int moves(){                     // min number of moves to solve initial board; -1 if unsolvable
    	if (!solvable)
    		return -1;
    	return finalNode.moves;
    }
    
    public Iterable<Board> solution(){      // sequence of boards in a shortest solution; null if unsolvable
    	if(!solvable)
    		return null;
    	
    	ArrayList<Board> step = new ArrayList<Board>();
    	step.add(finalNode.board);
    	SearchNode node = finalNode;
    	while(node.preNode!=null){
    		step.add(0,node.preNode.board);
    		node = node.preNode;
    	}
    	
    	return step;
    }
    
    public static void main(String[] args) {

        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);
        
        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}