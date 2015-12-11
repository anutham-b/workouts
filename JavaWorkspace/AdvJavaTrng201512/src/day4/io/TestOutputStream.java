package day4.io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestOutputStream {

  public static void main(String[] args) {
	String absolutePath = "file.txt";
	String buffFile = "buff_file.txt";
//	OutputStream outputStream = null;
//	try {
//	  outputStream = new FileOutputStream(absolutePath);
//
//	} catch (FileNotFoundException e) {
//	  // TODO Auto-generated catch block
//	  e.printStackTrace();
//	} finally {
//	  try {
//		outputStream.close();
//	  } catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	  }
//	}

	// New syntax for try-catch (Java7 onwards). try(withResource)catch{}.
	// No need to call resource.close() too
	try (OutputStream oos = new FileOutputStream(absolutePath)) {
	  oos.write('w');
	  oos.write('e');
	  oos.write('l');
	  oos.write('c');
	  oos.write('o');
	  oos.write('m');
	  oos.write('e');
	} catch (IOException e) {
	  e.printStackTrace();
	}
	
	// The buffered version
	try (BufferedOutputStream oos = new BufferedOutputStream(new FileOutputStream(buffFile))) {
	  oos.write('w');
	  oos.write('e');
	  oos.write('l');
	  oos.write('c');
	  oos.write('o');
	  oos.write('m');
	  oos.write('e');
	} catch (IOException e) {
	  e.printStackTrace();
	}
	
	

  }
}
