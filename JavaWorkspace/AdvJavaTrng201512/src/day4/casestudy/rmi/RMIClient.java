package day4.casestudy.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {

  public static void main(String[] args) {
	try {
	  IFlightSearchService remoteObject = (IFlightSearchService) Naming.lookup("rmi://localhost:4321/flightSearch");
	  System.out.println(remoteObject.searchFlights("Delhi", "Bangalore"));
	} catch (MalformedURLException | RemoteException | NotBoundException e) {
	  e.printStackTrace();
	}
  }
}
