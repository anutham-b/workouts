package day4.casestudy;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FlightSearchTest {

  public static void main(String[] args) {
	BlockingQueue<List<Flight>> blockingQueue = new ArrayBlockingQueue<>(10);
	FlightSearchTask searchTask = new FlightSearchTask(blockingQueue);
	FlightDetailsTask detailsTask = new FlightDetailsTask(blockingQueue);
	
	ExecutorService executorService  = Executors.newCachedThreadPool();
	executorService.submit(searchTask);
	executorService.submit(detailsTask);
	
  }

}
