package utilities;

import java.time.ZonedDateTime;
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
 
	public int createRandomNumber() {
		Random ran = new Random();
		int x = ran.nextInt(words.length);
		return x;
	}
 
	public int getTime() {
		return (int) ZonedDateTime.now().toInstant().toEpochMilli();
	}
 
	public String randomString() {
		String randomString = words[createRandomNumber()] + " " 
					+ words[createRandomNumber()] + " "
					+ words[createRandomNumber()] + " " 
					+ words[createRandomNumber()] + " "
					+ getTime();
		return randomString;
	}
}