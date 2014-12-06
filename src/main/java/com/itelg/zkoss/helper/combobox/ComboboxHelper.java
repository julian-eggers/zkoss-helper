package com.itelg.zkoss.helper.combobox;

import java.util.List;

import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;

public class ComboboxHelper
{
	public static <T> void init(Combobox combobox, List<T> items, ComboitemRenderer<T> itemRenderer)
	{
		boolean firstSelected = false;

		for (T item : items)
		{
			Comboitem comboitem = new Comboitem();
			comboitem.setValue(item);
			comboitem.setParent(combobox);

			try
			{
				itemRenderer.render(comboitem, item, 0);

			} catch (Exception e) { }

			if (firstSelected == false)
			{
				combobox.setSelectedItem(comboitem);
				firstSelected = true;
			}
		}
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
}