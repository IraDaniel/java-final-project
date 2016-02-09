package com.company.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Ira on 09.02.2016.
 */
public class AdminProperty {
    private ResourceBundle bundle;


    public AdminProperty(String bundleName) {

        bundle = ResourceBundle.getBundle(bundleName);
    }

    public String getValue(String key) {
        return bundle.getString(key);

    }
}
