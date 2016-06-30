package com.itelg.zkoss.helper.component;

import org.junit.Assert;
import org.junit.Test;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

public class ComponentHelperTest
{
    @Test
    public void testRemoveAllChildren()
    {
        Listbox listbox = new Listbox();
        Assert.assertEquals(0, listbox.getChildren().size());

        Listitem listitem = new Listitem();
        listbox.appendChild(listitem);
        Assert.assertEquals(1, listbox.getChildren().size());

        ComponentHelper.removeAllChildren(listbox);
        Assert.assertEquals(0, listbox.getChildren().size());
    }
}