package com.itelg.zkoss.helper.listbox;

import java.util.Comparator;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.ext.Sortable;

public class ListboxSortingHelper
{
    @SuppressWarnings("unchecked")
    private static Comparator<Object> getComparator(Listbox listbox, int column, boolean ascending)
    {
        List<Component> components = listbox.getListhead().getChildren();
        int i = 0;
        for (Component component : components)
        {
            if (Listheader.class.isAssignableFrom(component.getClass()))
            {
                if (i == column)
                {
                    Listheader listheader = (Listheader) component;
                    return ascending ? listheader.getSortAscending() : listheader.getSortDescending();
                }
                i++;
            }
        }
        return null;
    }
	
    public static void sortListbox(Listbox listbox, int column, boolean ascending)
    {
        ListModel<Object> model = listbox.getModel();
        if (Sortable.class.isAssignableFrom(model.getClass()))
        {
            @SuppressWarnings("unchecked") Sortable<Object> sortable = (Sortable<Object>) model;
            Comparator<Object> cmpr = getComparator(listbox, column, ascending);
            sortable.sort(cmpr, ascending);
        }
    }
	
	public static void resortListbox(Listbox listbox)
	{
		ListModel<Object> model = listbox.getModel();

		if (Sortable.class.isAssignableFrom(model.getClass()))
		{
			Sorting sorting = getSorting(listbox);

			if (sorting != null)
			{
				@SuppressWarnings("unchecked")
				Sortable<Object> sortable = (Sortable<Object>) model;
				sortable.sort(sorting.getComparator(), sorting.isAscending());
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static Sorting getSorting(Listbox listbox)
	{
		List<Component> components = listbox.getListhead().getChildren();

		for (Component component : components)
		{
			if (Listheader.class.isAssignableFrom(component.getClass()))
			{
				Listheader listheader = (Listheader) component;
				String sortDirection = listheader.getSortDirection();

				if ("ascending".equals(sortDirection))
				{
					return new Sorting(listheader.getSortAscending(), true);
				}
				else if ("descending".equals(sortDirection))
				{
					return new Sorting(listheader.getSortDescending(), false);
				}
			}
		}

		return null;
	}

	private static class Sorting
	{
		private Comparator<Object> comparator;
		private boolean ascending;

		public Sorting(Comparator<Object> comparator, boolean ascending)
		{
			this.comparator = comparator;
			this.ascending = ascending;
		}

		public Comparator<Object> getComparator()
		{
			return comparator;
		}

		public boolean isAscending()
		{
			return ascending;
		}
	}
}