package day3.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Info {
	private double value1,value2;
	private ReadWriteLock lock;
	
	public Info() {
		value1 = 0.0;
		value2 = 0.0;
		lock = new ReentrantReadWriteLock();
	}
	
	public double getValue1(){
		lock.readLock().lock();
		double value = value1;
		lock.readLock().unlock();
		return value;
	}
	
	public double getValue2(){
		lock.readLock().lock();
		double value = value2;
		lock.readLock().unlock();
		return value;
	}
	
	public void writeValues(double value1,double value2){
		lock.writeLock().lock();
		this.value1 = value1;
		this.value2 = value2;
		lock.writeLock().unlock();
	}
	
}
