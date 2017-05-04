package bean;

import java.util.Random;
public class IDGenerator {

	public static long getID()
	{
		long id = 1;
		Random r = new Random(System.currentTimeMillis());
		id = r.nextLong();
		return id;
	}
}
