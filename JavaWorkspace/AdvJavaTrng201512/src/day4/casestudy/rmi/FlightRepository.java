package day4.casestudy.rmi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Loads the flights' info from the csv files
 */
public class FlightRepository {

  List<Flight> flightList = new ArrayList<Flight>();
  List<File> files = new ArrayList<File>();

  public List<File> fetchFiles(String name, List<File> files) {
	File dir = new File(name);
	File flist[] = dir.listFiles();
	for (File file : flist) {
	  if (file.isDirectory()) {
		fetchFiles(file.getAbsolutePath(), files);
	  } else {
		files.add(file);
	  }
	}
	return files;
  }

  public List<Flight> fetchFlights(String source, String destination) {
	String line;
	BufferedReader br = null;
	flightList.clear();
	List<File> list = fetchFiles("Flights", files);
	try {
	  for (File file : list) {
		br = new BufferedReader(new FileReader(file));
		while ((line = br.readLine()) != null) {
		  String[] flight = line.split(",");
		  Flight f = new Flight();
		  f.setFlightNumber(flight[0]);
		  f.setSource(flight[1]);
		  f.setDestination(flight[2]);
		  f.setFare(Double.parseDouble(flight[3]));
		  f.setDuration(Double.parseDouble(flight[4]));
		  if (f.getSource().equalsIgnoreCase(source) && f.getDestination().equalsIgnoreCase(destination)) {
			flightList.add(f);
		  }
		}
	  }
	  br.close();
	} catch (IOException e) {
	  e.printStackTrace();
	}
	return flightList;
  }
}