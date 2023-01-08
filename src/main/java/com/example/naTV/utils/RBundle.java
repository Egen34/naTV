package com.example.naTV.utils;


import java.util.ResourceBundle;

public class RBundle {
    public final static RBundle SINGILTON = new RBundle();
    private static Language language = null;
    private static int languageId = 0;

    private RBundle() {
    }

    public String periodMessage(String key) {
        if (language == null)
            language = Language
                    .getLanguage(languageId);

        return ResourceBundle
                .getBundle(language.getBaseName()).getString(key);
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

}
