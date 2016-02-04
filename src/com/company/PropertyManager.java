package com.company;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Ira on 04.02.2016.
 */
public class PropertyManager {
    private ResourceBundle bundle;


    public PropertyManager(Locale locale, String bundleName) {

        bundle = ResourceBundle.getBundle(bundleName, locale);
    }

    public String getValue(String key) {
        return bundle.getString(key);

    }
}
