package Princeton.AlgorithmsI.percolation;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {
    private double[] means;
    private int trials;
    
    public PercolationStats(int n, int trials){    // perform trials independent experiments on an n-by-n grid
        if (n<=0 || trials<=0)
            throw new java.lang.IllegalArgumentException();
        
        this.trials = trials;
        means = new double[trials];
        Percolation[] p = new Percolation[trials];
        
        for (int i=0;i<trials;i++){
            p[i] = new Percolation(n);
            while(!p[i].percolates()){
                int row = StdRandom.uniform(n)+1;
                int col = StdRandom.uniform(n)+1;
                p[i].open(row,col);
            }
            means[i] = (double)p[i].numberOfOpenSites()/n/n;
        }
    }
    
    public double mean(){                          // sample mean of percolation threshold
        return StdStats.mean(means);
    }
    
    public double stddev(){                        // sample standard deviation of percolation threshold
        return StdStats.stddev(means);
    }
    
    public double confidenceLo(){                  // low  endpoint of 95% confidence interval
        return mean()-1.96*stddev()/Math.sqrt(trials);
    }
    public double confidenceHi(){                  // high endpoint of 95% confidence interval
        return mean()+1.96*stddev()/Math.sqrt(trials);
    }

    public static void main(String[] args){        // test client (described below)
       int n = Integer.parseInt(args[0]);
       int T = Integer.parseInt(args[1]);
       PercolationStats stats = new PercolationStats(n,T);

       StdOut.println(stats.mean());
       StdOut.println(stats.stddev());
       StdOut.println(stats.confidenceLo());
       StdOut.println(stats.confidenceHi());
    }
}