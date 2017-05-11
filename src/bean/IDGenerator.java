package bean;

import java.util.Random;
public class IDGenerator {

	public static String getID()
	{
		String id = "";
		String firstName = "Arpan";
		String secondName = "Majumder";
		char a = firstName.charAt(0);
		char b = secondName.charAt(0);
		//char c1 = c[0];
		id = a + "" + b;
		//id += "" + 
		return id;
	}
}
