package com.github.matcaban.fitnesscentrum.Members;

public class PremiumMember extends Member{
    private final boolean hasPersonalTrainer;

    public PremiumMember(String name, int memberId, boolean isActive, int monthsActive, boolean hasPersonalTrainer) {
        super(name, memberId, isActive, monthsActive);
        this.hasPersonalTrainer = hasPersonalTrainer;
    }

    @Override
    public double calculateMonthlyFee() {
        if (this.hasPersonalTrainer){
            return 45 + 30 + super.calculateLoyaltyDiscount();
        } else {
            return 45 + super.calculateLoyaltyDiscount();
        }
    }

    @Override
    public MembershipType getMembershipType() {
        return MembershipType.PREMIUM;
    }

    @Override
    public int getMaxGuestPasses() {
        return 3;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());
        result.append(", Osobny trener: ")
                .append(hasPersonalTrainer ? "Ano" : "Nie");
        return result.toString();
    }


}
