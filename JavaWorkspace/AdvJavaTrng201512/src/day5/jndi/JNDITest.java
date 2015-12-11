
package day5.jndi;

import java.rmi.RemoteException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class JNDITest {
  public JNDITest() {
  }

  public void doLookup() throws RemoteException {
	Properties properties = new Properties();
	properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
	properties.put(Context.PROVIDER_URL, "ldap://localhost:10389");

	try {
	  DirContext context = new InitialDirContext(properties);

	  Attributes attrs = context.getAttributes("employeeNumber=123,ou=vmware");
	  System.out.println(attrs);
	  System.out.println("Surname: " + attrs.get("sn").get());
	  System.out.println("Common name : " + attrs.get("cn").get());
	  System.out.println("telephone number : " + attrs.get("telephoneNumber").get());
	} catch (NamingException e) {
	  e.printStackTrace();
	}
  }

  public static void main(String[] args) throws RemoteException {
	JNDITest sample = new JNDITest();
	sample.doLookup();
  }
}
