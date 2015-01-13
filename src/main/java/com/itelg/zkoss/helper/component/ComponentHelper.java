package com.itelg.zkoss.helper.component;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;

public class ComponentHelper
{
	public static void removeAllChildren(Component component)
	{
		List<Component> removableComponents = new ArrayList<Component>();
		
		for (Component children : component.getChildren())
		{
			removableComponents.add(children);
		}
		
		for (Component removableComponent : removableComponents)
		{
			component.removeChild(removableComponent);
		}
	}
}