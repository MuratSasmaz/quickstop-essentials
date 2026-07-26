package com.quickstop.quickstop_essentials.model;

public enum Category {
    AUTO_ESSENTIALS("Auto Essentials"),
    PERSONAL_CARE("Personal Care"),
    TECH_ESSENTIALS("Tech Essentials"),
    BASIC_CLOTHING("Basic Clothing");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}