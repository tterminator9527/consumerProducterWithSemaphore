package consumerProducterWithSemaphore;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class ConsumerProducter {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(1, true);
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		Producter producter = new Producter(semaphore, queue);
		Consumer consumer = new Consumer(semaphore, queue);
		
		Thread producterThread = new Thread(producter);
		Thread consumerThread = new Thread(consumer);
		producterThread.start();
		consumerThread.start();
	}

}
