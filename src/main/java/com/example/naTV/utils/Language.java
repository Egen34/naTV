package com.example.naTV.utils;


public enum Language {
    DEFAULT("RU_BUNDLE"),
    KG("KG_BUNDLE"),
    RU("RU_BUNDLE"),
    ENG("ENG_BUNDLE");



    private String baseName;
    Language(String baseName) {
        this.baseName = baseName;
    }


    public static Language getLanguage(int langId){
        switch (langId){
            case 1:return KG;
            case 2:return RU;
            case 3:return ENG;
            default:return DEFAULT;
        }
    }


    public String getBaseName() {
        return baseName;
    }

}
