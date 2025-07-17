package com.github.matcaban.fitnesscentrum.Members;

import java.util.Objects;

public abstract class Member {
    protected String name;
    protected int memberId;
    protected boolean isActive;
    protected int monthsActive;

    public Member(String name, int memberId, boolean isActive, int monthsActive) {
        this.name = name;
        this.memberId = memberId;
        this.isActive = isActive;
        this.monthsActive = monthsActive;
    }

    public int getMemberId(){
        return this.memberId;
    }

    public abstract double calculateMonthlyFee();

    public abstract MembershipType getMembershipType();

    public abstract int getMaxGuestPasses();

    public void suspendMembership(){
        this.isActive = false;
    }

    public void reactivateMembership(){
        this.isActive = true;
    }

    public double calculateLoyaltyDiscount() {
        if (this.monthsActive > 24) {
            return 0.85;
        } else if (this.monthsActive > 12) {
            return 0.9;
        } else {
            return 1;
        }
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(this.getMembershipType())
                .append(": ID: ")
                .append(this.memberId)
                .append(", Meno: ")
                .append(this.name)
                .append(", Typ: ")
                .append(this.getMembershipType().getDescription())
                .append(", Stav: ")
                .append(this.isActive ? "Aktivne" : "Neaktivne")
                .append(", Mesiacov aktivity: ")
                .append(this.monthsActive);
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return memberId == member.memberId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(memberId);
    }
}
