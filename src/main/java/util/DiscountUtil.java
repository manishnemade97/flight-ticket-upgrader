package main.java.util;

import main.java.enums.DiscountCode;

public class DiscountUtil {

	private DiscountUtil() {}
	
	public static String getDiscountCode(String fareClass) {
		char fareClassChar = fareClass.charAt(0);
		if (fareClassChar>='A' && fareClassChar<='E') {
			
			return DiscountCode.OFFER_20.name();
		} else if (fareClassChar>='F' && fareClassChar<='K') {
			
			return DiscountCode.OFFER_30.name();
		} else if (fareClassChar>='L' && fareClassChar<='R') {
			
			return DiscountCode.OFFER_25.name();
		}
		return "";
	}
}
