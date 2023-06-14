package com.ngomez.productpricefinder.infrastructure.configuration;

import java.util.Locale;

public class LocaleConfiguration {
    private LocaleConfiguration() {}

    public static Locale getDefaultLocale(){
        return Locale.US;
    }
}
