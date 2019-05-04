package Princeton.AlgorithmsI.queues;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public RandomizedQueue(){                           // construct an empty deque
		first = null;
		last = null;
	}
	
	public boolean isEmpty(){                 // is the deque empty?
		return (first==null && last==null);
	}
	
	public int size(){                        // return the number of items on the queue
		if (isEmpty())
			return 0;
		
		int count=1;
		Node node = first;
		while(node!=last){
			count++;
			node = node.next;
		}
		return count;
	}
	
	public void enqueue(Item item){           // add the item
		if (item==null)
			throw new java.lang.IllegalArgumentException();
		
		Node node = new Node();
		node.item = item;
		if (isEmpty())
			first = last = node;
		else{
			Node oldLast = last;
			last = node;
			oldLast.next = node;
		}
	}
	
	public Item dequeue(){                // // remove and return a random item
		if (isEmpty())
			throw new java.util.NoSuchElementException();
		
		int x = StdRandom.uniform(size());
		
		if (x==0){
			Item item = first.item;
			first = first.next;
			if (first==null)
				last = null;
			return item;
		}
		else{
			Node current = first;
			for (int i=0; i<x-1; i++){
				current = current.next;
			}
			Item item = current.next.item;
			current.next = current.next.next;
			if (current.next==null)
				last = current;
			return item;
		}
	}
	
	public Item sample(){                 // return (but do not remove) a random item
		if (isEmpty())
			throw new java.util.NoSuchElementException();
		
		int x = StdRandom.uniform(size());
		Node current = first;
		for (int i=0; i<x; i++){
			current = current.next;
		}
		
		return current.item;
	}
	
	public Iterator<Item> iterator(){         // return an iterator over items in order from front to end
		return new RandomIterator();
	}
	
	
	private class RandomIterator implements Iterator<Item>{
		private RandomizedQueue<Item> items;
		Node current = first;
		
		public RandomIterator(){
			items = new RandomizedQueue<Item>();
			for (int i=0; i<size(); i++){
				items.enqueue(current.item);
				current = current.next;
			}
		}
		
		public boolean hasNext(){
			return !items.isEmpty();
		}
		public Item next(){
			if (!hasNext())
				throw new java.util.NoSuchElementException();
			Item item = items.dequeue();
			return item;
		}
		public void remove(){
			throw new java.lang.UnsupportedOperationException();
		}
	}
	   
	//public static void main(String[] args)   // unit testing (optional)
}
