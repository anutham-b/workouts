package day4.casestudy.rmi;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class FlightDetailsTask implements Runnable {

  BlockingQueue<List<Flight>> flightQueue;

  public FlightDetailsTask() {

  }

  public FlightDetailsTask(BlockingQueue<List<Flight>> flightQueue) {
	this.flightQueue = flightQueue;
  }

  @Override
  public void run() {
	try {
	  while (!Thread.interrupted()) {
		List<Flight> flights = flightQueue.take();
		System.out.println("FLIGHTS AVAILABLE: ");
		System.out.println("Flight_Number" + "\t" + "Source_City" + "\t" + "Destination City" + "\t" + "Fare" + "\t" + "Duration");
		System.out.println("--------------------------------------------------------------------------");
		for (Flight flight : flights) {
		  System.out.println(flight.getFlightNumber() + "\t\t" + flight.getSource() + "\t\t" + flight.getDestination() + "\t\t" + flight.getFare()
			  + "\t\t" + flight.getDuration());
		}
	  }
	} catch (InterruptedException e) {
	  e.printStackTrace();
	}
  }

}
