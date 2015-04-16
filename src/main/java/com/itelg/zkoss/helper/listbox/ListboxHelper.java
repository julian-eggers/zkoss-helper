package com.itelg.zkoss.helper.listbox;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;

public class ListboxHelper
{
	public static void hideIfEmpty(Listbox listbox)
	{
		if (isNotEmpty(listbox))
		{
			listbox.setVisible(true);
		}
		else
		{
			listbox.setVisible(false);
		}
	}

	public static void hideIfEmpty(Listbox listbox, String emptyMessage)
	{
		Component emptyLabelComponent = null;

		for (Component component : listbox.getParent().getChildren())
		{
			if (component.getId().equals(listbox.getId() + "_emptyLabel"))
			{
				emptyLabelComponent = component;
			}
		}

		if (isNotEmpty(listbox))
		{
			listbox.setVisible(true);

			if (emptyLabelComponent != null)
			{
				emptyLabelComponent.detach();
			}
		}
		else
		{
			listbox.setVisible(false);

			if (emptyLabelComponent == null)
			{
				Label emptyLabel = new Label(emptyMessage);
				emptyLabel.setId(listbox.getId() + "_emptyLabel");
				listbox.getParent().appendChild(emptyLabel);
			}
		}
	}
	
	public static boolean isEmpty(Listbox listbox)
	{
		return listbox.getModel() != null && listbox.getModel().getSize() == 0;
	}
	
	public static boolean isNotEmpty(Listbox listbox)
	{
		return listbox.getModel() != null && listbox.getModel().getSize() > 0;
	}
}