package day4.casestudy.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class FlightSearchServiceImpl extends UnicastRemoteObject implements IFlightSearchService {

  private FlightRepository flightRepository;

  protected FlightSearchServiceImpl() throws RemoteException {
	super();
	flightRepository = new FlightRepository();
  }

  @Override
  public List<Flight> searchFlights(String source, String destination) throws RemoteException {
	return flightRepository.fetchFlights(source, destination);
  }

}
