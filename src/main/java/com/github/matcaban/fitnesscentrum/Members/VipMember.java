package com.github.matcaban.fitnesscentrum.Members;

public class VipMember extends Member{
    private final int MONTHLY_FEE = 75;
    private final int SPA_FEE = 25;
    private final int PERSONAL_SESSION_FEE = 15;
    private final int MAX_GUESTS = 10;
    private boolean hasSpaAccess;
    private int personalSessionsIncluded;

    public VipMember(String name, int memberId) {
        super(name, memberId);
    }

    @Override
    public double calculateMonthlyFee() {
        int personalSessionsFee = PERSONAL_SESSION_FEE * this.personalSessionsIncluded;
        if (hasSpaAccess) {
            return MONTHLY_FEE + SPA_FEE + super.calculateLoyaltyDiscount() + personalSessionsFee;
        } else {
            return MONTHLY_FEE + super.calculateLoyaltyDiscount() + personalSessionsFee;
        }
    }

    @Override
    public MembershipType getMembershipType() {
        return MembershipType.VIP;
    }

    @Override
    public int getMaxGuestPasses() {
        return MAX_GUESTS;
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
