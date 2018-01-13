package queues;
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	
	private class Node{
		Item item;
		Node prev;
		Node next;
	}
	
	public Deque(){                           // construct an empty deque
		first = null;
		last = null;
	}
	
	public boolean isEmpty(){                 // is the deque empty?
		return (first==null && last==null);
	}
	
	public int size(){                        // return the number of items on the deque
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
	
	public void addFirst(Item item){          // add the item to the front
		if (item==null)
			throw new java.lang.IllegalArgumentException();
		
		Node node = new Node();
		node.item = item;
		if (isEmpty())
			first = last = node;
		else{
			Node oldFirst = first;
			first = node;
			node.next = oldFirst;
			oldFirst.prev = node;
		}
	}
	
	public void addLast(Item item){           // add the item to the end
		if (item==null)
			throw new java.lang.IllegalArgumentException();
		
		Node node = new Node();
		node.item = item;
		if (isEmpty())
			first = last = node;
		else{
			Node oldLast = last;
			last = node;
			node.prev = oldLast;
			oldLast.next = node;
		}
	}
	
	public Item removeFirst(){                // remove and return the item from the front
		if (isEmpty())
			throw new java.util.NoSuchElementException();
		
		Item item = first.item;
		first = first.next;
		if (first==null){
			last = null;
			return item;
		}
		first.prev = null;
		return item;
	}
	
	public Item removeLast(){                 // remove and return the item from the end
		if (isEmpty())
			throw new java.util.NoSuchElementException();
		
		Item item = last.item;
		last = last.prev;
		if (last==null){
			first = null;
			return item;
		}
		last.next = null;
		return item;
	}
	
	public Iterator<Item> iterator(){         // return an iterator over items in order from front to end
		return new DequeIterator();
	}
	
	
	private class DequeIterator implements Iterator<Item>{
		private Node current = first;
			
		public boolean hasNext(){
			return current!=null;
		}
		public Item next(){
			if (!hasNext())
				throw new java.util.NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
		public void remove(){
			throw new java.lang.UnsupportedOperationException();
		}
	}
	   
	//public static void main(String[] args)   // unit testing (optional)
}
