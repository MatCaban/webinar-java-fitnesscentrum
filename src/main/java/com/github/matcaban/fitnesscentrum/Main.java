package com.github.matcaban.fitnesscentrum;

import com.github.matcaban.fitnesscentrum.Members.*;

import java.util.*;

public class Main {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final Member basicMember1 = new BasicMember("Peter Novak", 1);
        basicMember1.setMonthsActive(2);
        final Member premiumMember1 = new PremiumMember("Anna Svoboda", 2);
        premiumMember1.setMonthsActive(6);
        final Member vipMember1 = new VipMember("Milan Kovac", 3);
        vipMember1.setMonthsActive(3);


        System.out.println("=== TO STRING() ===");
        System.out.println(basicMember1);
        System.out.println(premiumMember1);
        System.out.println(vipMember1);

        final Member basicMember2 = new BasicMember("Janko Hrasko", 1);
        final Member basicMember3 = new BasicMember("Annamaria Sladkovicova", 1);

        final List<Member> allMembers = List.of(basicMember2, basicMember3);

        System.out.println("\n=== HASHSET UKAZKA ===");
        Set<Member> testSet = new HashSet<>(allMembers);

        System.out.println("Velkost listu so vsetkymi membermi: " + allMembers.size());
        System.out.println("HashSet velkost: " + testSet.size());
        System.out.println("Obsahuje HashSet basic1?: " + testSet.contains(basicMember2));
        System.out.println("Obsahuje HashSet basic2?: " + testSet.contains(basicMember3));



        System.out.println("\n=== HASHMAP UKAZKA ===");
        Map<MembershipType, ArrayList<Member>> mapTest = new HashMap<>();
        ArrayList<Member> basicMemberList = new ArrayList<>();
        ArrayList<Member> premiumMemberList = new ArrayList<>();
        ArrayList<Member> vipMemberList = new ArrayList<>();

        basicMemberList.add(basicMember1);
        basicMemberList.add(basicMember2);
        basicMemberList.add(basicMember3);

        premiumMemberList.add(premiumMember1);

        vipMemberList.add(vipMember1);

        mapTest.put(MembershipType.BASIC, basicMemberList);
        mapTest.put(MembershipType.PREMIUM, premiumMemberList);
        mapTest.put(MembershipType.VIP, vipMemberList);

        for (Map.Entry<MembershipType, ArrayList<Member>> entry : mapTest.entrySet()) {
            System.out.println(entry.getKey().getDescription() + "(" + entry.getValue().size() + " clenov):");
            if (!entry.getValue().isEmpty()) {
                for (Member member : entry.getValue()) {
                    System.out.println(member);
                }
            }
        }

        System.out.println("\n=== HASHMAP HLADANIE PODLA ID ===");
        Map<Integer, Member> memberIdMap = new HashMap<>();
        for (Member member : allMembers) {
            memberIdMap.put(member.getMemberId(), member);
        }
        System.out.println("Hladanie ID 3 v ArrayListe");
        long start = System.nanoTime();
        for (Member member : allMembers) {
            if (member.getMemberId() == 3) {
                System.out.println("Nasiel som: ");
                System.out.println(member);
            } else {
                System.out.println("Nenasiel som.");
            }
        }
        long stop = System.nanoTime();
        long elapsedTimeList = stop - start;
        System.out.println("Cas vykonania v nanosekundach: " + elapsedTimeList);

        System.out.println("\nHladanie ID 3 v Mape");
        start = System.nanoTime();
        if (memberIdMap.containsKey(3)) {
            System.out.println("Nasiel som: ");
            System.out.println(memberIdMap.get(3));
        } else {
            System.out.println("Nenasiel som.");
        }

        stop = System.nanoTime();
        long elapsedTimeMap = stop - start;
        System.out.println("Cas vykonania v nanosekundach: " + elapsedTimeMap);

        System.out.println("Rozdiel v rychlosti hladania aj pri velmi malych kolekciach je viditelny");
        System.out.println("Rozdiel v nanosekundach cini: " + (elapsedTimeList - elapsedTimeMap) + " nanosekund.");

        System.out.println("\n=== TESTOVANIE EQUALS() VS '==' ===");
        System.out.println("basic1 equals basic2 -> " + basicMember2.equals(basicMember3));
        System.out.println("basic1 == basic2 -> " + (basicMember2 == basicMember3));
        System.out.println("basic1 hash -> " + basicMember2.hashCode());
        System.out.println("basic2 hash -> " + basicMember3.hashCode());

        /*
         * vsetky vytvorene triedy dedia z triedy Object, ktora ma definovane
         * equals() a hashCode(). V triede Object je equals() definovany ako najprisnejsi mozny
         * ekvivalencny vztah, cize objekty su equals len ak odkazuju na rovnaky objekt.
         * Kazdy objekt si moze metodu equals() prepisat podla seba. Teraz sme metodu prepisali tak
         * aby sa objekty rovnali v pripade ze maju ronake ID, na ostatncyh vlastnostiach objektu nezalezi.
         * Prave kvoli prepisaniu metody equals nam basic1 equals basi2 dava vysledok true, lebo oba maju ID 1,
         * ale kedze neodkazuju na rovnaky objekt, oba su samostatne objekty s vyhradenym miestom v heape,
         * preto basi1 == basic2 vracia false.
         * hashCode() je v Object triede tiez definovay najprisnjsim moznym ekvivalencnym vztahom, cize
         * rovnako ako equals, objekty maju rovnaky hash len ak odkazuju na rovnaky objekt (o1 == o2).
         * V triede Member sme prepisali hash tak aby mal hodnotu rovnu ID, vsetky podtriedy triedy Member
         * teda budu mat hashCode rovny ID objektu.
         * */

        System.out.println("\n=== POLYMORFIZMUS A TOSTRING() ===");
        final Member[] membersArray = new Member[]{basicMember1, basicMember2, basicMember3, premiumMember1, vipMember1};
        for (Member member : membersArray) {
            System.out.println("Trieda: " + member.getClass().getSimpleName() + ",\ntoString(): " + member.toString());
        }

        System.out.println("\n=== SIMULACIA NOVEHO CLENA ===");
        Set<Member> memberSet = new HashSet<>();
        Map<Integer, Member> memberDatabase = new HashMap<>();
        boolean endProgram = false;
        while (!endProgram) {
            System.out.println("\nMenu:");
            System.out.println("1 - pre zadanie noveho clena");
            System.out.println("2 - pre vyhladanie clena podla id");
            System.out.println("3 - pre ukoncenie programu");
            int userInput = getCorrectInt(scanner, "Zadaj volbu: ");

            switch (userInput) {
                case 1:
                    Member member = createNewMember();
                    if (memberSet.contains(member)) {
                        System.out.println("Clen s tymto ID uz existuje");
                        System.out.println("Zadanie zopakuj\n");
                    } else {
                        memberSet.add(member);
                        memberDatabase.put(member.getMemberId(), member);
                        System.out.println("Uzivatel uspesne registrovany");
                    }
                    break;
                case 2:
                    if (memberSet.isEmpty()) {
                        System.out.println("Nieje registrovany ziadny uzivatel");
                        break;
                    }
                    int id = getCorrectInt(scanner, "Zadaj hladane id: ");
                    if (memberDatabase.containsKey(id)) {
                        System.out.println(memberDatabase.get(id));
                    } else {
                        System.out.println("Clen so zadanym ID: " + id + " nieje v nasej databaze\n");
                    }
                    break;
                case 3:
                    endProgram = true;
                    break;
                default:
                    System.out.println("Nespravne zadanie");
            }
        }


    }

    public static Member createNewMember() {
            int newMemberId = getCorrectInt(scanner, "Zadaj id: ");
            String name = getCorrectString(scanner, "Zadaj meno: ");
            MembershipType membership = getCorrectMembership(scanner, "Zadaj druh clenstva (BASIC, PREMIUM, VIP): ");
            return memberFactory(name, newMemberId, membership);
    }

    public static Member memberFactory(String name, int id, MembershipType membershipType) {
        switch (membershipType) {
            case BASIC:
                return new BasicMember(name, id);
            case PREMIUM:
                return new PremiumMember(name, id);
            case VIP:
                return new VipMember(name, id);
            default:
                throw new IllegalArgumentException("Nezname clenstvo");
        }
    }

    public static int getCorrectInt(Scanner scanner, String prompt) {
        int id = 0;
        while (true) {
            System.out.print(prompt);
            try {
                id = scanner.nextInt();
                if (id < 1) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println("Musis zadat len cislo vacsie ako 0");
                scanner.nextLine(); //vycisti buffer
            }
        }
        scanner.nextLine();
        return id;
    }

    public static MembershipType getCorrectMembership(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String membership = scanner.nextLine().toLowerCase();
            if (membership.equals("basic") || membership.equals("premium") || membership.equals("vip")) {
                return MembershipType.getMembership(membership);
            } else {
                System.out.println("Nespravny input");
                continue;
            }
        }
    }

    public static String getCorrectString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String name = scanner.nextLine();
            if (!name.isBlank()) {
                return name;
            }
        }
    }
}
