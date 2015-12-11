package day4.casestudy;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class FlightSearchTask implements Runnable {

  List<Flight> flightList;
  BlockingQueue<List<Flight>> flightQueue;

  public FlightSearchTask() {

  }

  public FlightSearchTask(BlockingQueue<List<Flight>> flightQueue) {
	this.flightQueue = flightQueue;
  }

  public List<Flight> searchFlight() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the source and destination cities");
	String source = sc.next();
	String destination = sc.next();
	flightList = new FlightRepository().fetchFlights(source, destination);
	Collections.sort(flightList);
	sc.close();
	return flightList;

  }

  public List<Flight> searchFlight(String source, String destination) {

	flightList = new FlightRepository().fetchFlights(source, destination);
	Collections.sort(flightList);

	return flightList;

  }

  @Override
  public void run() {
	try {
	  while (!Thread.interrupted()) {
		List<Flight> flights = searchFlight();
		flightQueue.put(flights);
	  }
	} catch (InterruptedException e) {
	  e.printStackTrace();
	}
  }
}