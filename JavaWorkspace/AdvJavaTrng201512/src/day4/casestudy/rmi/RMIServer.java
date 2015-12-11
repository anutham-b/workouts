package day4.casestudy.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {

  public static void main(String[] args) {
	try {
	  Registry registry = LocateRegistry.createRegistry(4321);
	  registry.rebind("flightSearch",new FlightSearchServiceImpl());
	  System.out.println("RMI server started");
	} catch (RemoteException e) {
	  e.printStackTrace();
	}
  }
}
