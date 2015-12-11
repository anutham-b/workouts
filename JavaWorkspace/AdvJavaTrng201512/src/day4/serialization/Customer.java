package day4.serialization;

import java.io.InvalidClassException;
import java.io.Serializable;
import java.util.Date;

/**
 * A business object which implements comparable. TRY: Set serialVersionUID a value during serialization and change to a
 * different value before deserializing. </br>
 * Expect a {@link InvalidClassException}
 *
 */
public class Customer implements Comparable<Customer>, Cloneable, Serializable {

  private static final long serialVersionUID = 2L;

  private int id;
  private String name;
  private Date dob;

  public Customer() {
  }

  public Customer(int id, String name, Date dob) {
	super();
	this.id = id;
	this.name = name;
	this.dob = dob;
  }

  public int getId() {
	return id;
  }

  public void setId(int id) {
	this.id = id;
  }

  public String getName() {
	return name;
  }

  public void setName(String name) {
	this.name = name;
  }

  public Date getDob() {
	return dob;
  }

  public void setDob(Date dob) {
	this.dob = dob;
  }

  @Override
  public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	return result;
  }

  @Override
  public boolean equals(Object obj) {
	if (this == obj)
	  return true;
	if (obj == null)
	  return false;
	if (getClass() != obj.getClass())
	  return false;
	Customer other = (Customer) obj;
	if (id != other.id)
	  return false;
	return true;
  }

  @Override
  public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Customer [id=");
	builder.append(id);
	builder.append(", name=");
	builder.append(name);
	builder.append(", dob=");
	builder.append(dob);
	builder.append("]");
	return builder.toString();
  }

  @Override
  protected Customer clone() throws CloneNotSupportedException {
	// Shallow copy:
	// return new Customer(id,name,dob);
	// Deep copy:
	Customer cloned = (Customer) super.clone();
	cloned.setDob((Date) this.dob.clone());
	return cloned;
  }

  @Override
  public int compareTo(Customer o) {
	return ((Integer) this.id).compareTo(o.getId());
  }

}
