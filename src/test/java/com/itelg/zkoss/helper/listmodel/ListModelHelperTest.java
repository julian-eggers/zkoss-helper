package com.itelg.zkoss.helper.listmodel;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
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
        Assert.assertNotNull(elements);
        Assert.assertEquals(2, elements.size());
        Assert.assertEquals("string1", elements.get(0));
        Assert.assertEquals("string2", elements.get(1));
    }
}