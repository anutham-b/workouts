package day4.io.nio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {
  public static void main(String[] args) {
	try {
	  ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
	  serverSocketChannel.configureBlocking(true);
	  serverSocketChannel.bind(new InetSocketAddress("10.113.227.153", 1234));
	  System.out.println("Server is listening at port 1234");
	  SocketChannel socketChannel = serverSocketChannel.accept();
	  Socket socket = socketChannel.socket();
	  try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
		System.out.println(ois.readObject());
	  } catch (IOException | ClassNotFoundException e) {
		e.printStackTrace();
	  }
	} catch (IOException e) {
	  e.printStackTrace();
	}
  }
}
