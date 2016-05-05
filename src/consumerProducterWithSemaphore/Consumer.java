package consumerProducterWithSemaphore;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
	Semaphore semaphore;
	LinkedList<Integer> queue;
	
	public Consumer(Semaphore semaphore, LinkedList<Integer> queue){
		this.semaphore = semaphore;
		this.queue = queue;
	}
	
	@Override
	public void run() {
		Integer element;
		while(true){
			element = queue.poll();
			if(element != null){
				synchronized(this){//并不能保证被synchronized包裹的代码块整个执行完毕后才被调度，执行过程中也可能被调度
					semaphore.release();
					System.out.println("consumer: " + element.intValue());
				}
			}
		}
	}
}
