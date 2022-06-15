package test.java;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

import main.java.util.DateUtil;

public class TestDateUtil {

	@Test
	public void testCompareDate() throws ParseException {
		Assert.assertEquals(0, DateUtil.compareDates("2022-01-23", "2022-01-23"));
		Assert.assertTrue(0 > DateUtil.compareDates("2022-01-20", "2022-01-24"));
		Assert.assertTrue(0 < DateUtil.compareDates("2022-01-28", "2022-01-20"));
		Assert.assertTrue(0 < DateUtil.compareDates("2019-08-23", "2019-07-25"));
	}
}
