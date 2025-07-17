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

    public static MembershipType getMembership(String membership) {
        membership = membership.toLowerCase();
        switch (membership) {
            case "basic":
                return BASIC;
            case "premium":
                return PREMIUM;
            default:
                return VIP;
        }
    }

}
