package Princeton.AlgorithmsI.puzzle;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Board {
    private int n;
    private int[][] blocks, twin_block;
    private int manhattan_dis = 0;
    
	public Board(int[][] blocks){           // construct a board from an n-by-n array of blocks
                                           // (where blocks[i][j] = block in row i, column j)
    	
		n = blocks[0].length;
        this.blocks = new int[n][n];
        for (int i=0; i<n; i++){
        	for (int j=0; j<n; j++){
        		this.blocks[i][j] = blocks[i][j];
        	}
        }
        
		//manhattan distance
    	for (int i=0; i<n; i++){
    		for (int j=0; j<n; j++){
    			if (blocks[i][j]!=0){
    				int dx = Math.abs((blocks[i][j]-1)/n-i);
    				int dy = Math.abs((blocks[i][j]-1)%n-j);
    				manhattan_dis += dx+dy;
    			}
    		}
    	}
        
        //twin
        int p1,p2;
        do{
        	p1 = StdRandom.uniform(n*n);
        	p2 = StdRandom.uniform(n*n);
        }
        while (p1==p2 || blocks[p1/n][p1%n]==0 || blocks[p2/n][p2%n]==0);
        
        twin_block = new int[n][n];
        for (int i=0; i<n; i++){
        	for (int j=0; j<n; j++){
        		twin_block[i][j] = blocks[i][j];
        	}
        }
        
        int temp = twin_block[p1/n][p1%n];     
        twin_block[p1/n][p1%n] = twin_block[p2/n][p2%n];
        twin_block[p2/n][p2%n] = temp;
	}	
	
    public int dimension(){                 // board dimension n
    	return n;
    }
    
    public int hamming(){                   // number of blocks out of place
    	int distance = 0;
    	for (int i=0; i<n; i++){
    		for (int j=0; j<n; j++){
    			if (blocks[i][j]!=0 && blocks[i][j]!=i*n+j+1)
    				distance++;
    		}
    	}
    	return distance;
    }
    
    public int manhattan(){                 // sum of Manhattan distances between blocks and goal
    	return manhattan_dis;
    }
    
    public boolean isGoal(){                // is this board the goal board?
    	for (int i=0; i<n; i++){
    		for (int j=0; j<n; j++){
    			if (blocks[i][j]!=0 && blocks[i][j]!=i*n+j+1)
    				return false;
    		}
    	}
    	return true;
    }
    
    public Board twin(){                    // a board that is obtained by exchanging any pair of blocks
        return new Board(twin_block); 
    }
    
    private int[][] getBlocks(){
    	return blocks;
    }
    
    public boolean equals(Object y){        // does this board equal y?
    	if (y==null)
    		return false;
    	
    	int[][] b;
		b = ((Board) y).getBlocks();
    	if (n!=b[0].length)
    		return false;
    	
    	for (int i=0; i<n; i++){
    		for (int j=0; j<n; j++){
    			if (blocks[i][j]!=b[i][j])
    				return false;
    		}
    	}
    	return true;
    }
      
    public Iterable<Board> neighbors(){     // all neighboring boards
    	
    	int blank_row=0, blank_col=0;
    	for (int row=0; row<n; row++){
    		for (int col=0; col<n; col++){
    			if (blocks[row][col]==0){
    				blank_row = row;
    				blank_col = col;
    			}
    		}
    	}
    	
    	Queue<Board> queue = new Queue<Board>();
    	if (blank_row>0){
            int[][] b = new int[n][n];
            for (int i=0; i<n; i++){
            	for (int j=0; j<n; j++){
            		b[i][j] = blocks[i][j];
            	}
            }
			b[blank_row][blank_col] = b[blank_row-1][blank_col];
			b[blank_row-1][blank_col] = 0;
			queue.enqueue(new Board(b));
		}
    		
		if (blank_col>0){
	        int[][] b = new int[n][n];
	        for (int i=0; i<n; i++){
	        	for (int j=0; j<n; j++){
	        		b[i][j] = blocks[i][j];
	        	}
	        }
			b[blank_row][blank_col] = b[blank_row][blank_col-1];
			b[blank_row][blank_col-1] = 0;
			queue.enqueue(new Board(b));
		}
		
		if (blank_row<n-1){
	        int[][] b = new int[n][n];
	        for (int i=0; i<n; i++){
	        	for (int j=0; j<n; j++){
	        		b[i][j] = blocks[i][j];
	        	}
	        }
			b[blank_row][blank_col] = b[blank_row+1][blank_col];
			b[blank_row+1][blank_col] = 0;
			queue.enqueue(new Board(b));
		}
		
		if (blank_col<n-1){
	        int[][] b = new int[n][n];
	        for (int i=0; i<n; i++){
	        	for (int j=0; j<n; j++){
	        		b[i][j] = blocks[i][j];
	        	}
	        }
			b[blank_row][blank_col] = b[blank_row][blank_col+1];
			b[blank_row][blank_col+1] = 0;
			queue.enqueue(new Board(b));
		}
		
    	return queue;
		
    }
    
    public String toString(){               // string representation of this board (in the output format specified below)
    	String s = new String();
    	s = s.concat(Integer.toString(n)+'\n');
    	for (int i=0; i<n; i++){
    		for (int j=0; j<n; j++){
    			s = s.concat(Integer.toString(blocks[i][j])+' ');
    		}
    		s = s+'\n';
    	}
    	return s;
    }

    public static void main(String[] args){} // unit tests (not graded)
}
