package day4.casestudy.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IFlightSearchService extends Remote {

  public List<Flight> searchFlights(String source, String destination)  throws RemoteException ;

}
