package com.github.matcaban.fitnesscentrum.Members;

public enum MembershipType {
    BASIC("Zakladne clenstvo"),
    PREMIUM("Premiove clenstvo"),
    VIP("VIP clenstvo");

    private final String description;

    MembershipType(String description) {
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

}
