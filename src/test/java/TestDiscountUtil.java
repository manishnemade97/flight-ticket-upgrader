package test.java;

import org.junit.Assert;
import org.junit.Test;

import main.java.util.DiscountUtil;

public class TestDiscountUtil {

	private static final String NO_OFFER = "";
	private static final String OFFER_30 = "OFFER_30";
	private static final String OFFER_20 = "OFFER_20";
	private static final String OFFER_25 = "OFFER_25";

	@Test
	public void testFindDiscountOffer20() {
		Assert.assertEquals(OFFER_20, DiscountUtil.getDiscountCode("A"));
		Assert.assertEquals(OFFER_20, DiscountUtil.getDiscountCode("C"));
	}
	
	@Test
	public void testFindDiscountOffer25() {
		Assert.assertEquals(OFFER_25, DiscountUtil.getDiscountCode("O"));
		Assert.assertEquals(OFFER_25, DiscountUtil.getDiscountCode("L"));
		Assert.assertEquals(OFFER_25, DiscountUtil.getDiscountCode("R"));
	}
	
	@Test
	public void testFindDiscountOffer30() {
		Assert.assertEquals(OFFER_30, DiscountUtil.getDiscountCode("K"));
		Assert.assertEquals(OFFER_30, DiscountUtil.getDiscountCode("F"));
		Assert.assertEquals(OFFER_30, DiscountUtil.getDiscountCode("I"));
	}
	
	@Test
	public void testFindDiscountOfferNone() {
		Assert.assertEquals(NO_OFFER, DiscountUtil.getDiscountCode("T"));
		Assert.assertEquals(NO_OFFER, DiscountUtil.getDiscountCode("Z"));
	}
}
