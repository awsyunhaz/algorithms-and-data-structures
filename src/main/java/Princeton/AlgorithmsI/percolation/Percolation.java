package Princeton.AlgorithmsI.percolation;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF UF;
    private WeightedQuickUnionUF UFfull;
    private int n;
    private boolean[][] open;
    private int count;
    
    public Percolation(int n){                // create n-by-n grid, with all sites blocked
        if (n<=0) 
            throw new java.lang.IllegalArgumentException();
        else{
            this.n = n;
            UF = new WeightedQuickUnionUF(n*n+2);
            UFfull = new WeightedQuickUnionUF(n*n+1);
            count = 0;
            open = new boolean[n+1][n+1];
            for (int i=1;i<=n;i++){
            	UF.union(0, i);
            	UF.union(n*n+1-i, n*n+1);
            	UFfull.union(0, i);
            	for (int j=1;j<=n;j++)
            		open[i][j] = false;
            }
            	
        }
    }
   
    private void validate(int row, int col) {
        if (row<=0 || col<=0 || row>n || col>n){ 
            throw new java.lang.IllegalArgumentException();
        }
    }
    
    public void open(int row, int col){    // open site (row, col) if it is not open already
    	validate(row,col);
    	
        if (!open[row][col]){
            open[row][col] = true;
            count++;
            if (col-1>=1 && isOpen(row,col-1)){
                UF.union((row-1)*n+col,(row-1)*n+col-1);
                UFfull.union((row-1)*n+col,(row-1)*n+col-1);
            }
            if (col+1<=n && isOpen(row,col+1)){
                UF.union((row-1)*n+col,(row-1)*n+col+1);
                UFfull.union((row-1)*n+col,(row-1)*n+col+1);
            }
            if (row-1>=1 && isOpen(row-1,col)){
                UF.union((row-1)*n+col,(row-2)*n+col);
                UFfull.union((row-1)*n+col,(row-2)*n+col);
            }
            if (row+1<=n && isOpen(row+1,col)){
                UF.union((row-1)*n+col,row*n+col);
                UFfull.union((row-1)*n+col,row*n+col);
            }
        }
    }
    
    public boolean isOpen(int row, int col){  // is site (row, col) open?
        validate(row,col);
        return open[row][col];
    }
    
    public boolean isFull(int row, int col){  // is site (row, col) full?
    	validate(row,col);
        return isOpen(row,col) && UFfull.connected(0,(row-1)*n+col);
    }
    
    public int numberOfOpenSites(){       // number of open sites
        return count;
    }    
    
    public boolean percolates(){              // does the system percolate?
    	if (n==1)
    		return isOpen(1,1);
    	return UF.connected(0, n*n+1);
    }

    public static void main(String[] args){   // test client (optional)
    }
}