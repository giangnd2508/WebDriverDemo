package utilities;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Random;
 
public class Generator {
 
	String[] words = { "man", "mountain", "state", "ocean", "country", 
			"building", "cat", "airline", "Act", "Agree", "Arrive",
			"Ask", "Bake", "Bring", "Build", "Buy" };
 
	public String title() {
		return randomString() + ", title";
	}
 
	public String body() {
		return randomString() + ", body";
	}
 
	private int createRandomNumber() {
		Random ran = new Random();
		int x = ran.nextInt(words.length);
		return x;
	}
 
	public int getTime() {
		return (int) ZonedDateTime.now().toInstant().toEpochMilli();
	}
 
	private String randomString() {
		String randomString = words[createRandomNumber()] + " " 
					+ words[createRandomNumber()] + " "
					+ words[createRandomNumber()] + " " 
					+ words[createRandomNumber()] + " "
					+ getTime();
		return randomString;
	}
	
	public String getTimeInFormat() {
		String timeStamp = new SimpleDateFormat("dd-MM-yyyy_HH.mm.ss").format(new Date());
		return timeStamp;
	}
}