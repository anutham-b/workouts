package day3.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestLocks {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		Info info = new Info();
		
		WriteUsingLocks writeUsingLocks = new WriteUsingLocks(info);
		ReadUsingLocks readUsingLocks = new ReadUsingLocks(info);
		executor.execute(readUsingLocks);
		executor.execute(writeUsingLocks);
		executor.shutdown();
	}
}
