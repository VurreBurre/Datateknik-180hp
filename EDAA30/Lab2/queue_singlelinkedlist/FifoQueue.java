package queue_singlelinkedlist;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}
	



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof FifoQueue))
			return false;
		FifoQueue other = (FifoQueue) obj;
		if (last == null) {
			if (other.last != null)
				return false;
		} else if (!last.equals(other.last))
			return false;
		return true;
	}


	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	e the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E e) {
		QueueNode<E> temp = new QueueNode<E>(e);
		if(size ==0) last =null;
		if (last == null) {
			last = temp;
			last.next = last;
		}
		else {
		temp.next = last.next;
		last.next = temp;
		last = temp;
		}
		System.out.println(last.element);
		
		size++;
		return true;
	}
	
	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {	
		return size;
	}
	
	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		if (size == 0) {
			return null;
		}
		else {
			QueueNode<E> temp;
			temp = last.next;
			
			
			
			return temp.element;
			
		}
		
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
		if (last == null) {
			return null;
		}
		
		else {
			size--;
			QueueNode<E> temp;
			temp = last.next;
			last.next = temp.next;
			
			
			
			return temp.element;
			
		}
	}
	
	public void append(FifoQueue<E> q) {
		if (q.equals(this)) throw new IllegalArgumentException();
		
		this.addAll(q);
		/*for (int i = 0; i < q.size; i++) {
			this.add(q.element());
			q.remove();
		}
		*/
		
	}
	
	
	
	
	
	private class QueueIterator implements Iterator<E>{
		private QueueNode<E> pos;
		private int k;
		
		
		private QueueIterator(){
			if(size == 0) {
				pos = null;
			}else {
				pos = last.next;
				
			}
			
		}
		@Override
		public boolean hasNext() {
			
			//System.out.println(pos.element);
			if (pos == null) {
				return false;
			}
			return true;
		}

		@Override
		public E next() {
			if (!(hasNext())) throw new NoSuchElementException();
				
			E temp = pos.element;
			if (pos == last) {
				pos = null;
			}else {
			pos = pos.next;
			}
			return temp;
		}
		
		
	}
	
	
	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return  new QueueIterator(); //new QueueIterator
	}

}
