package com.github.matcaban.fitnesscentrum.Members;

public class VipMember extends Member{
    private boolean hasSpaAccess;
    private int personalSessionsIncluded;

    public VipMember(String name, int memberId, boolean isActive, int monthsActive, boolean hasSpaAccess, int personalSessionsIncluded) {
        super(name, memberId, isActive, monthsActive);
        this.hasSpaAccess = hasSpaAccess;
        this.personalSessionsIncluded = personalSessionsIncluded;
    }

    @Override
    public double calculateMonthlyFee() {
        int personalSessionsFee = 15 * this.personalSessionsIncluded;
        if (hasSpaAccess) {
            return 75 + 25 + super.calculateLoyaltyDiscount() + personalSessionsFee;
        } else {
            return 75 + super.calculateLoyaltyDiscount() + personalSessionsFee;
        }
    }

    @Override
    public MembershipType getMembershipType() {
        return MembershipType.VIP;
    }

    @Override
    public int getMaxGuestPasses() {
        return 10;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());
        result.append(", Spa: ")
                .append(this.hasSpaAccess ? "Ano" : "Nie")
                .append(", Treningy/mesiac: ")
                .append(this.personalSessionsIncluded);
        return result.toString();
    }
}
