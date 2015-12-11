package day4.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Read the file created by {@link TestOutputStream} using {@link Reader}.
 */
public class TestReaderWriter {

  public static void main(String[] args) {
	String rw_buffFile = "buff_file.txt";
	try (Reader reader = new BufferedReader(new FileReader(rw_buffFile))) {
	  int data = 0;
	  while ((data = reader.read()) != -1) {
		System.out.print((char) data);
	  }
	} catch (IOException e) {
	  e.printStackTrace();
	}
  }
}
