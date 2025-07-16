package com.github.matcaban.fitnesscentrum;

import com.github.matcaban.fitnesscentrum.Members.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Member basic = new BasicMember("Peter Novak", 1, true, 13);
        Member premium = new PremiumMember("Anna Svoboda", 2, true, 14, true);
        Member vip = new VipMember("Milan Kovac", 3, true, 5, true,4);


        System.out.println("=== TO STRING() ===");
        System.out.println(basic);
        System.out.println(premium);
        System.out.println(vip);

        Member basic1 = new BasicMember("Peter", 1, false, 10);
        Member basic2 = new BasicMember("Annamaria", 1, false, 10);

        System.out.println("=== HASHSET UKAZKA ===");
        Set<Member> testSet = new HashSet<>();
        testSet.add(basic1);
        testSet.add(basic2);
        System.out.println("HashSet velkost: " + testSet.size());
        System.out.println("Obsahuje HashSet basic1?: " + testSet.contains(basic1));
        System.out.println("Obsahuje HashSet basic2?: " + testSet.contains(basic2));

        System.out.println("=== HASHMAP UKAZKA ===");
        Map<MembershipType, ArrayList<Member>> mapTest = new HashMap<>();
        ArrayList<Member> basicMemberList = new ArrayList<>();
        ArrayList<Member> premiumMemberList = new ArrayList<>();
        ArrayList<Member> vipMemberList = new ArrayList<>();

        basicMemberList.add(basic);
        basicMemberList.add(basic1);
        basicMemberList.add(basic2);

        premiumMemberList.add(premium);

        vipMemberList.add(vip);

        mapTest.put(MembershipType.BASIC, basicMemberList);
        mapTest.put(MembershipType.PREMIUM, premiumMemberList);
        mapTest.put(MembershipType.VIP, vipMemberList);

        for (Map.Entry<MembershipType, ArrayList<Member>> entry: mapTest.entrySet()) {
            System.out.println(entry.getKey().getDescription() + "(" + entry.getValue().size() + " clenov):");
            if (!entry.getValue().isEmpty()) {
                for (Member member: entry.getValue()){
                    System.out.println(member);
                }
            }
        }


    }
}
