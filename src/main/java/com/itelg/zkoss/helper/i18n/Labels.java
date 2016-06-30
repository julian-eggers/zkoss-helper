package com.itelg.zkoss.helper.i18n;

public class Labels
{
    public static String getLabel(String key)
    {
        return getLabel(key, "");
    }

    public static String getLabel(String key, String defaultValue)
    {
        return org.zkoss.util.resource.Labels.getLabel(key, defaultValue);
    }

    public static String getLabel(Enum<?> enumObject)
    {
        return getLabel(enumObject, "");
    }

    public static String getLabel(Enum<?> enumObject, String defaultValue)
    {
        if (enumObject != null)
        {
            String key = enumObject.getClass().getName() + "." + enumObject.name();
            return getLabel(key);
        }

        return defaultValue;
    }
}