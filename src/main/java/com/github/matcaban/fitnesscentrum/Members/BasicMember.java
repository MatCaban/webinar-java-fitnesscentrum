package com.github.matcaban.fitnesscentrum.Members;

public class BasicMember extends Member{

    public BasicMember(String name, int memberId, boolean isActive, int monthsActive) {
        super(name, memberId, isActive, monthsActive);
    }

    @Override
    public double calculateMonthlyFee() {
        return 25 * super.calculateLoyaltyDiscount();
    }

    @Override
    public MembershipType getMembershipType() {
        return MembershipType.BASIC;
    }

    @Override
    public int getMaxGuestPasses() {
        return 1;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
