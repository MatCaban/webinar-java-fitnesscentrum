package com.github.matcaban.fitnesscentrum.Members;

public class PremiumMember extends Member{
    private static final int MONTHLY_FEE = 45;
    private static final int MAX_GUESTS = 3;
    private static final int PERSONAL_TRAINER_FEE = 30;
    private boolean hasPersonalTrainer;

    public PremiumMember(String name, int memberId) {
        super(name, memberId);
    }

    @Override
    public double calculateMonthlyFee() {
        if (this.hasPersonalTrainer){
            return MONTHLY_FEE + PERSONAL_TRAINER_FEE + super.calculateLoyaltyDiscount();
        } else {
            return MONTHLY_FEE + super.calculateLoyaltyDiscount();
        }
    }

    @Override
    public MembershipType getMembershipType() {
        return MembershipType.PREMIUM;
    }

    @Override
    public int getMaxGuestPasses() {
        return MAX_GUESTS;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());
        result.append(", Osobny trener: ")
                .append(hasPersonalTrainer ? "Ano" : "Nie");
        return result.toString();
    }


}
