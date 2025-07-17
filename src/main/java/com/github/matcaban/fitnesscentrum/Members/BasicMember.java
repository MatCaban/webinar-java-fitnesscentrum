package com.github.matcaban.fitnesscentrum.Members;

public class BasicMember extends Member{
    private final int MONTHLY_FEE = 25;
    private final int MAX_GUESTS = 1;

    public BasicMember(String name, int memberId) {
        super(name, memberId);
    }

    @Override
    public double calculateMonthlyFee() {
        return this.MONTHLY_FEE * super.calculateLoyaltyDiscount();
    }

    @Override
    public MembershipType getMembershipType() {
        return MembershipType.BASIC;
    }

    @Override
    public int getMaxGuestPasses() {
        return this.MAX_GUESTS;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
