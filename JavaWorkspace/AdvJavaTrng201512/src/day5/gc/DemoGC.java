package day5.gc;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * Execution:
 * 
 * classes-folder> java day5.gc.DemoGC > output.csv
 * Output: GC action is not seen.
 * 
 * classes-folder> java -Xms6m -Xmx10m day5.gc.DemoGC > output1.csv 
 * Output: GC action can be seen.
 * 
 * Plot line chart for the output.csv and output1.csv present in the project root
 * 
 * TRY: use the infinite while loop in main() and watch the GC using jconsole
 */
public class DemoGC {
  private static Unsafe unsafe;

  static {
	try {
	  Field field = Unsafe.class.getDeclaredField("theUnsafe");
	  field.setAccessible(true);
	  unsafe = (Unsafe) field.get(null);
	} catch (Exception e) {
	  e.printStackTrace();
	}
  }

  public static long addressOf(Object o) throws Exception {
	Object[] array = new Object[] { o };

	long baseOffset = unsafe.arrayBaseOffset(Object[].class);
	int addressSize = unsafe.addressSize();
	long objectAddress;
	switch (addressSize) {
	case 4:
	  objectAddress = unsafe.getInt(array, baseOffset);
	  break;
	case 8:
	  objectAddress = unsafe.getLong(array, baseOffset);
	  break;
	default:
	  throw new Error("unsupported address size: " + addressSize);
	}

	return (objectAddress);
  }

  public static void main(String... args) throws Exception {
	for (int i = 0; i < 32000; i++) {
	  Object mine = new GCMe();
	  long address = addressOf(mine);
	  System.out.println(address);
	}

	while(true){
	  
	}
	
	// Verify address works - should see the characters in the array in the output
	// printBytes(address, 31);

  }

  public static void printBytes(long objectAddress, int num) {
	for (long i = 0; i < num; i++) {
	  int cur = unsafe.getByte(objectAddress + i);
	  System.out.print((char) cur);
	}
	System.out.println();
  }
}

class GCMe {
  long data;
  long _;
  long __;
  long ___;
  long ____;
  long _____;
  long ______;
  long _______;
  long ________;
  long _________;
  long __________;
  long ___________;
  long ____________;
  long _____________;
  long ______________;
  long _______________;
  long _________________;
  long __________________;
}
