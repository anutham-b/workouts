package day1;

public class AMarkerImpl implements AIMarker {
	/**
	 * Simple check
	 */
	public void checkInterface() {
		if (this instanceof AIMarker) {
			System.out.println("This class implements AIMarker");
		} else {
			System.out.println("This class DOES NOT implements AIMarker");
		}
	}

	/**
	 * Reflection
	 */
	public void checkInterfaceWithMetadata() {
		Class clazz = this.getClass();
		Class[] interfaces = clazz.getInterfaces();
		for (Class intf : interfaces) {
			if (intf.getSimpleName().equals("AIMarker")) {
				System.out.println("This class implements AIMarker");
				break;
			}
		}
	}

	/**
	 * Uses Class.forName(); when the class may/not be present
	 */
	public void checkWithClassForName() {
		Class clazz = null;
		try {
			clazz = Class.forName("day1.AMarkerImpl");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Class[] interfaces = clazz.getInterfaces();
		for (Class intf : interfaces) {
			if (intf.getSimpleName().equals("AIMarker")) {
				System.out.println("This class implements AIMarker");
				break;
			}
		}

	}

	public static void main(String args[]) {
		AMarkerImpl impl = new AMarkerImpl();
		impl.checkInterface();
		impl.checkInterfaceWithMetadata();
		impl.checkWithClassForName();
	}
}
