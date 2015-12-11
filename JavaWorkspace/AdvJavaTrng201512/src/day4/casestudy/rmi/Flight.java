package day4.casestudy.rmi;

import java.io.Serializable;

/**
 * The POJO class for the flight information
 */
public class Flight implements Comparable<Flight>, Serializable {

  private static final long serialVersionUID = -1004403326876603780L;
  
  private String flightNumber;
  private String sourceCity;
  private String destinationCity;
  private Double Fare;
  private Double Duration;

  public String getFlightNumber() {
	return flightNumber;
  }

  public void setFlightNumber(String flightNumber) {
	this.flightNumber = flightNumber;
  }

  public String getSource() {
	return sourceCity;
  }

  public void setSource(String sourceCity) {
	this.sourceCity = sourceCity;
  }

  public String getDestination() {
	return destinationCity;
  }

  public void setDestination(String destinationCity) {
	this.destinationCity = destinationCity;
  }

  public Double getFare() {
	return Fare;
  }

  public void setFare(Double fare) {
	Fare = fare;
  }

  public Double getDuration() {
	return Duration;
  }

  public void setDuration(Double duration) {
	Duration = duration;
  }

  @Override
  public String toString() {
	return flightNumber + " , " + sourceCity + " , " + destinationCity + " , " + Fare + " , " + Duration;
  }

  public Flight(String flightNumber, String sourceCity, String destinationCity, Double fare, Double duration) {
	super();
	this.flightNumber = flightNumber;
	this.sourceCity = sourceCity;
	this.destinationCity = destinationCity;
	Fare = fare;
	Duration = duration;
  }

  public Flight() {

  }

  @Override
  public int compareTo(Flight o) {

	return this.Fare.compareTo(o.Fare);
  }

}
