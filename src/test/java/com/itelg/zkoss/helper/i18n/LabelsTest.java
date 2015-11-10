package com.itelg.zkoss.helper.i18n;

import org.junit.Assert;
import org.junit.Test;

public class LabelsTest
{
	@Test
	public void testGetEnumKey()
	{
		Assert.assertEquals("com.itelg.zkoss.helper.i18n.LabelsTest$TestEnu.TEST", Labels.getEnumKey(TestEnu.TEST));
		Assert.assertEquals("", Labels.getEnumKey(null));
	}

	private enum TestEnu
	{
		TEST;
	}
}