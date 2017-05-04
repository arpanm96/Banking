package bean;


public class CheckFields {

	public boolean checkString(String s)
	{
		for(int i = 0;i < s.length();i++)
		{
			char c = s.charAt(i);
			if(!Character.isLetter(c) && c != ' ' )
				return false;
		}
		return true;
	}
	public boolean checkNumber(String s) {
	    try {
	        Long.parseLong(s);
	        return true;
	    } catch (NumberFormatException ex) {
	        return false;
	    }
	}
/*	public boolean check()
	{
		
		if(Integer.toString(PhoneNo).length() != 10 )
			return false;
		return true;

	}*/
	
	public boolean checkYOP(String y)
	{
		if(y == null)
		{
			y = "0";
			return false;
		}
			
		int a = Integer.parseInt(y);
		if(a > 2017 || a < 1960)
			return false;
		return true;
	}
	
	public boolean checkMarks(String y)
	{
		int a = Integer.valueOf(y);
		if(a > 500 || a < 0)
			return false;
		return true;
	}
	public boolean checkPercentage(String y)
	{
		float a = Float.valueOf(y);
		if(a > 100 || a < 0)
			return false;
		return true;
	}

}
