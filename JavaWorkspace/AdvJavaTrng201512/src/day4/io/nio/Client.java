package day4.io.nio;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

import day4.serialization.Customer;

public class Client {
  public static void main(String[] args) {
	try {
	  SocketChannel socketChannel = SocketChannel.open();
	  socketChannel.configureBlocking(true);
	  boolean flag = socketChannel.connect(new InetSocketAddress("10.120.229.34", 1234));
	  if(flag){
		try (ObjectOutputStream oos = new ObjectOutputStream(socketChannel.socket().getOutputStream())){
		  oos.writeObject(new Customer(1,"AAA",new java.util.Date()));
		  System.out.println("Written into socket. Check the Server application");
		} catch (IOException e) {
		  // TODO: handle exception
		}
	  }
	  
	} catch (IOException e) {
	  e.printStackTrace();
	}
  }
}
