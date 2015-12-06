package com.itelg.zkoss.helper.listmodel;

import java.util.Arrays;
import java.util.List;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

public class ListModelHelperTest
{
	@Test(expected = NullPointerException.class)
	public void testGetElementListNull()
	{
		ListModelHelper.getElementList(null);
	}
	
	@Test
	public void testGetElementList()
	{
		ListModel<String> listModel = new ListModelList<>(Arrays.asList("string1", "string2"));
		List<String> elements = ListModelHelper.getElementList(listModel);
		Assertions.assertThat(elements).isNotNull().hasSize(2);
		Assertions.assertThat(elements.get(0)).isEqualTo("string1");
		Assertions.assertThat(elements.get(1)).isEqualTo("string2");
	}
}