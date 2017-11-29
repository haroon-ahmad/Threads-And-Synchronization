package producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerExampleWithWaitAndNotify {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      List<Integer> taskQueue = new ArrayList<Integer>();
	      int MAX_CAPACITY = 5;
	      
	      Producer prodObj = new Producer(taskQueue, MAX_CAPACITY);
	      Thread tProducer = new Thread(prodObj, "Producer");
	      
	      Consumer cosumerObj = new Consumer(taskQueue);
	      Thread tConsumer = new Thread(cosumerObj, "Consumer");
	      
	      tProducer.start();
	      tConsumer.start();

	}

}
