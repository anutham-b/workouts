package day4.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Deserialize the {@link Customer} object from a file and print the contents.
 */
public class ObjectDeserialization {
  public static void main(String[] args) {
	try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tmp.obj"))) {
	  Customer customer = (Customer) ois.readObject();
	  System.out.println(customer);
	} catch (IOException | ClassNotFoundException e) {
	  e.printStackTrace();
	}
  }
}
