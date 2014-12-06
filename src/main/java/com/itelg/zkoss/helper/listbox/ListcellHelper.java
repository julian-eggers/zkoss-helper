package com.itelg.zkoss.helper.listbox;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.event.SelectEvent;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Textbox;

public class ListcellHelper
{
	public static Listcell buildEditableTextboxListcell(String currentValue, EventListener<InputEvent> onchangeListener)
	{
		Listcell listcell = new Listcell();
		Textbox textbox = new Textbox(currentValue);
		textbox.setInplace(true);
		textbox.setWidth("95%");
		textbox.addEventListener(Events.ON_CHANGE, onchangeListener);
		listcell.appendChild(textbox);

		return listcell;
	}

	public static Listcell buildDateListcell(Date date, String nullMessage)
	{
		return new Listcell(date != null ? new SimpleDateFormat("dd.MM.yyyy").format(date) : nullMessage);
	}

	public static Listcell buildDateListcell(Date date, String nullMessage, String dateFormat)
	{
		return new Listcell(date != null ? new SimpleDateFormat(dateFormat).format(date) : nullMessage);
	}

	public static Listcell buildDateTimeListcell(Date date, String nullMessage)
	{
		return new Listcell(date != null ? new SimpleDateFormat("dd.MM.yyyy HH:mm").format(date) : nullMessage);
	}

	public static Listcell buildDateTimeListcell(Date date)
	{
		return new Listcell(date != null ? new SimpleDateFormat("dd.MM.yyyy HH:mm").format(date) : "");
	}

	public static Listcell buildDateTimeListcell(Date date, String nullMessage, String dateFormat)
	{
		return new Listcell(date != null ? new SimpleDateFormat(dateFormat).format(date) : nullMessage);
	}

	public static <T> Listcell buildSelectboxListcell(List<T> items, EventListener<SelectEvent<Comboitem, T>> onselectListener, T selectedItem)
	{
		Listcell listcell = new Listcell();
		Combobox combobox = new Combobox();
		combobox.addEventListener(Events.ON_SELECT, onselectListener);
		combobox.setParent(listcell);

		for (T item : items)
		{
			Comboitem comboitem = new Comboitem(item.toString());
			comboitem.setValue(item);
			comboitem.setParent(combobox);

			if (item.equals(selectedItem))
			{
				combobox.setSelectedItem(comboitem);
			}
		}

		return listcell;
	}

	public static <T> Listcell buildSelectboxListcell(List<T> items, EventListener<SelectEvent<Comboitem, T>> onselectListener, T selectedItem, ComboitemRenderer<T> itemRenderer)
	{
		Listcell listcell = new Listcell();
		Combobox combobox = new Combobox();
		combobox.addEventListener(Events.ON_SELECT, onselectListener);
		combobox.setParent(listcell);

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

		return listcell;
	}

	public static Listcell buildBooleanChooseListcell(boolean currentValue, String trueMessage, String falseMessage, EventListener<Event> onclickListener)
	{
		Listcell listcell = new Listcell(currentValue ? trueMessage : falseMessage);
		listcell.addEventListener(Events.ON_CLICK, onclickListener);

		return listcell;
	}

	public static Listcell buildTextboxListcell(String text)
	{
		Listcell listcell = new Listcell();
		final Textbox textbox = new Textbox(text);
		textbox.setParent(listcell);
		textbox.setReadonly(true);
		textbox.setWidth("100%");

		return listcell;
	}
}