package com.itelg.zkoss.helper.i18n;

import java.util.Arrays;
import java.util.Locale;

public class Labels
{
	public static String getLabel(Object object)
	{
		if (object.getClass().isEnum())
		{
			return getLabel((Enum<?>) object);
		}
		else
		{
			return getLabel(object.getClass().getName());
		}
	}

	public static String getLabel(Enum<?> object)
	{
		return getLabel(getEnumKey(object));
	}

	public static String getLabel(Enum<?> object, String postFix)
	{
		return getLabel(getEnumKey(object, postFix));
	}

	public static String getLabel(String key)
	{
		return org.zkoss.util.resource.Labels.getLabel(key, key);
	}

	public static String getLabel(String key, Object... args)
	{
		return org.zkoss.util.resource.Labels.getLabel(key, key, args);
	}

	public static String getLabel(Class<?> key, Object... args)
	{
		return getLabel(key.getName(), args);
	}

	public static String getEnumKey(Enum<?> object)
	{
		if (object != null)
		{
			return object.getClass().getName() + "." + object.name();
		}

		return "";
	}

	public static String getEnumKey(Enum<?> object, String postFix)
	{
		return getEnumKey(object) + "." + postFix;
	}

	public static boolean localeIsAvailable(String language)
	{
		if (language == null)
		{
			return false;
		}

		return Arrays.asList(Locale.getAvailableLocales()).contains(new Locale(language));
	}

	public String getLabel(Locale locale, Object object)
	{
		if (object.getClass().isEnum())
		{
			return getLabel(locale, (Enum<?>) object);
		}
		else
		{
			return getLabel(locale, object.getClass().getName());
		}
	}

	public String getLabel(Locale locale, Enum<?> object)
	{
		return getLabel(locale, getEnumKey(object));
	}

	public String getLabel(Locale locale, Enum<?> object, String postFix)
	{
		return getLabel(locale, getEnumKey(object, postFix));
	}
}