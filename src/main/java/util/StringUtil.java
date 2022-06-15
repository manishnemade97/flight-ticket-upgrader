package main.java.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	private StringUtil() {}
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static final Pattern VALID_MOBILE_NUMBER_REGEX = Pattern.compile("^\\d{10}$");
	
	public static final Pattern VALID_PNR_REGEX = Pattern.compile("^[a-zA-Z0-9]{6}$");
	
	public static final Pattern VALID_FARE_CLASS_REGEX = Pattern.compile("^[A-Z]{1}$");
	
	public static boolean isValideEmail(String email) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
	}
	
	public static boolean isValideMobileNumber(String number) {
	    Matcher matcher = VALID_MOBILE_NUMBER_REGEX.matcher(number);
	    return matcher.find();
	}
	
	public static boolean isValidePNR(String pnr) {
	    Matcher matcher = VALID_PNR_REGEX.matcher(pnr);
	    return matcher.find();
	}
	
	public static boolean isValideFareClass(String fareClass) {
	    Matcher matcher = VALID_FARE_CLASS_REGEX.matcher(fareClass);
	    return matcher.find();
	}
}
