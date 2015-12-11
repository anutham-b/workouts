package day4.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * Serialize a {@link Customer} object to a file.
 *
 */
public class ObjectSerialization {

  public static void main(String[] args) {
	try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tmp.obj"))) {
	  Customer customer = new Customer(1, "AAA", new Date());
	  oos.writeObject(customer);
	} catch (IOException e) {
	  e.printStackTrace();
	}

  }

}
