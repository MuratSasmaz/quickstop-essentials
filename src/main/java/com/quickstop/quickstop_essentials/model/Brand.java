package com.quickstop.quickstop_essentials.model;

public enum Brand {
    CASTROL("Castrol"),
    MOBIL_1("Mobil 1"),
    RAIN_X("Rain-X"),
    ANKER("Anker"),
    BELKIN("Belkin"),
    SAMSUNG("Samsung"),
    DOVE("Dove"),
    COLGATE("Colgate"),
    NIKE("Nike"),
    ADIDAS("Adidas");

    private final String displayName;

    Brand(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}