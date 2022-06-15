package test.java;

import org.junit.Assert;
import org.junit.Test;

import main.java.util.StringUtil;

public class TestStringUtil {

	@Test
	public void testValidateEmail() {
		Assert.assertEquals(true, StringUtil.isValideEmail("abc.sds@gmail.com"));
		Assert.assertEquals(false, StringUtil.isValideEmail("abc.sds@gmail"));
		Assert.assertEquals(false, StringUtil.isValideEmail("abc.sds.com"));
	}
	
	@Test
	public void testValidatePhoneNumber() {
		Assert.assertEquals(true, StringUtil.isValideMobileNumber("1234567890"));
		Assert.assertEquals(false, StringUtil.isValideMobileNumber("123456789023"));
		Assert.assertEquals(false, StringUtil.isValideMobileNumber("1234B678s9"));
		Assert.assertEquals(false, StringUtil.isValideMobileNumber("1234678-9"));
		Assert.assertEquals(false, StringUtil.isValideMobileNumber("12346789"));
	}
	
	@Test
	public void testValidatePNR() {
		Assert.assertEquals(true, StringUtil.isValidePNR("123456"));
		Assert.assertEquals(true, StringUtil.isValidePNR("1D3s56"));
		Assert.assertEquals(false, StringUtil.isValidePNR("1D3s6"));
		Assert.assertEquals(false, StringUtil.isValidePNR("1D3s56ewq"));
		Assert.assertEquals(false, StringUtil.isValidePNR("1D3-56"));
	}
	
	@Test
	public void testValidateFareClass() {
		Assert.assertEquals(true, StringUtil.isValideFareClass("F"));
		Assert.assertEquals(false, StringUtil.isValideFareClass("a"));
		Assert.assertEquals(false, StringUtil.isValideFareClass("8"));
		Assert.assertEquals(false, StringUtil.isValideFareClass("*"));
	}
}
