package testqueue;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.Queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import queue_singlelinkedlist.FifoQueue;
import org.junit.jupiter.api.Test;

class TestAppendFifoQueue extends FifoQueue{
	
	private FifoQueue<Integer> myIntQueue1;
	private FifoQueue<Integer> myIntQueue2;
	

	@BeforeEach
	void setUp() {
		myIntQueue1 = new FifoQueue<Integer>();
		myIntQueue2 = new FifoQueue<Integer>();
		
	}

	@AfterEach
	void tearDown(){
		myIntQueue1 = null;
		myIntQueue2 = null;
	}

	@Test
	void testAppendEmpty() {
		assertThrows(IllegalArgumentException.class, () -> myIntQueue1.append(myIntQueue2));
		
	}
	
	
	@Test
	void testAppendEmptyVSNonEmpty() { 
		for (int i = 1; i <4 ; i++) {
			myIntQueue2.offer(i);
		}
		myIntQueue1.append(myIntQueue2);
		int k = 0;
		for (int j = 1; j < 4; j++) {
			k = myIntQueue2.poll();
			assertEquals(j, k, "poll returns incorrect element");
		}
		assertTrue(myIntQueue2.isEmpty(), "Queue not empty after poll");
		
	}
	
	@Test
	void testAppendNonEmptyVSEmpty() { 
		for (int i = 0; i < 3; i++) {
			myIntQueue1.offer(i);
		}
		myIntQueue1.append(myIntQueue2);
		int k = 0;
		for (int j = 0; j < 3; j++) {
			k = myIntQueue1.poll();
			assertEquals(j, k, "poll returns incorrect element");
		}
		assertTrue(myIntQueue1.isEmpty(), "Queue not empty after poll");
	}
	
	@Test
	void testAppendTwoQueues() { 
		for (int i =1; i <= 3; i++) {
			myIntQueue2.offer(i);
			myIntQueue1.offer(i);
		}
		myIntQueue1.append(myIntQueue2);
		
		for (int i = 1; i <= myIntQueue1.size(); i++) {
			
			assertEquals(i, myIntQueue1.poll(), "poll returns incorrect element");
			
		}
		for (int i = 1; i <= myIntQueue2.size(); i++) {
			assertEquals(i, myIntQueue1.poll(), "poll returns incorrect element");
		}	
		assertTrue(myIntQueue1.isEmpty(), "Queue not empty after poll");
	}
	
	
	@Test
	void testAppendQueueWithItself() { 
		for (int i =1; i <= 3; i++) {
			myIntQueue1.offer(i);
		}
		assertThrows(IllegalArgumentException.class, () -> myIntQueue1.append(myIntQueue1));
		
	}
}
	
	



