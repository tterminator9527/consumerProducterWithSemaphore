package consumerProducterWithSemaphore;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Producter implements Runnable {
	Semaphore semaphore;
	LinkedList<Integer> queue;
	
	public Producter(Semaphore semaphore, LinkedList<Integer> queue){
		this.semaphore = semaphore;
		this.queue = queue;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(this){//并不能保证被synchronized包裹的代码块整个执行完毕后才被调度，执行过程中也可能被调度
				queue.add(i);
				System.out.println("product: " + i);
			}
		}
	}

}
