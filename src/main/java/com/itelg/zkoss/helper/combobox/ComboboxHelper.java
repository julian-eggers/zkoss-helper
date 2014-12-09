package com.itelg.zkoss.helper.combobox;

import java.util.Arrays;
import java.util.List;

import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;

public class ComboboxHelper
{
	public static <T> void init(Combobox combobox, List<T> items, ComboitemRenderer<T> itemRenderer)
	{
		for (T item : items)
		{
			Comboitem comboitem = new Comboitem();
			comboitem.setValue(item);
			comboitem.setParent(combobox);

			try
			{
				itemRenderer.render(comboitem, item, 0);

			} catch (Exception e) { }
		}
	}
	
	public static <T> void init(Combobox combobox, T[] items, ComboitemRenderer<T> itemRenderer)
	{
		init(combobox, Arrays.asList(items), itemRenderer);
	}

	public static <T> void init(Combobox combobox, List<T> items, T selectedItem, ComboitemRenderer<T> itemRenderer)
	{
		for (T item : items)
		{
			Comboitem comboitem = new Comboitem();
			comboitem.setValue(item);
			comboitem.setParent(combobox);

			try
			{
				itemRenderer.render(comboitem, item, 0);

			} catch (Exception e) { }

			if (item.equals(selectedItem))
			{
				combobox.setSelectedItem(comboitem);
			}
		}
	}
	
	public static <T> void init(Combobox combobox, T[] items, T selectedItem, ComboitemRenderer<T> itemRenderer)
	{
		init(combobox, Arrays.asList(items), selectedItem, itemRenderer);
	}
	
	public static void setDefaultItem(Combobox combobox, String label)
	{
		setDefaultItem(combobox, label, null);
	}
	
	public static void setDefaultItem(Combobox combobox, String label, Object value)
	{
		Comboitem defaultItem = new Comboitem();
		defaultItem.setLabel(label);
		defaultItem.setValue(value);
		combobox.appendChild(defaultItem);
		combobox.setSelectedItem(defaultItem);
	}
}