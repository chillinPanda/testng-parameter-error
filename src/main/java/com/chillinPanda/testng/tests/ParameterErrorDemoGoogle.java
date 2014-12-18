package com.chillinPanda.testng.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterErrorDemoGoogle {

	@Parameters(value = "url")
	@Test(description = "demo to show wrong parameter")
	public void test(String url) {
		Assert.assertEquals(url, "www.google.com", "check if we got the right parameter from ");
	}
}
