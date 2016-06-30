package com.itelg.zkoss.helper.listmodel;

import java.util.LinkedList;
import java.util.List;

import org.zkoss.zul.ListModel;

public class ListModelHelper
{
    @SuppressWarnings("unchecked")
    public static <T> List<T> getElementList(ListModel<?> listModel)
    {
        if (listModel == null)
        {
            throw new NullPointerException();
        }

        List<T> elements = new LinkedList<>();

        for (int i = 0; i < listModel.getSize(); i++)
        {
            elements.add((T) listModel.getElementAt(i));
        }

        return elements;
    }
}