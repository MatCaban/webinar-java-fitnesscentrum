## ÚLOHA 3: Fitness centrum (Pokročilá)

**Cieľ:** Vytvorte komplexný systém na správu členov fitness centra, ktorý demonštruje pokročilé OOP koncepty vrátane `toString()`, `equals()`, `hashCode()` a prácu s kolekciami.

### **Časť A: Základná štruktúra**

**1. Vytvorte enum `MembershipType`:**
```java
// Enum s hodnotami: BASIC, PREMIUM, VIP
// Každá hodnota má description (napr. "Základné členstvo")
// Implementujte konštruktor a getter pre description
```

**2. Vytvorte abstraktnú triedu `Member`:**
```java
// Vlastnosti:
// - protected String name, int memberId, boolean isActive, int monthsActive

// Abstraktne metódy:
// - calculateMonthlyFee() -> double
// - getMembershipType() -> MembershipType  
// - getMaxGuestPasses() -> int

// Konkrétne metódy:
// - suspendMembership() - nastaví isActive na false
// - reactivateMembership() - nastaví isActive na true
// - calculateLoyaltyDiscount() -> double (10% po 12 mes., 15% po 24 mes.)

// DÔLEŽITÉ: Implementujte equals(), hashCode() a toString()
// - equals() a hashCode() založené na memberId (dva členovia sú rovnakí ak majú rovnaké ID)
// - toString() vráti všetky informácie v jednom riadku (použite StringBuilder)
```

### **Časť B: Konkrétne triedy členov**

**3. Implementujte `BasicMember`:**
- Základný mesačný poplatok: 25€
- Maximálny počet hostí: 1 mesačne
- `toString()` môže volať `super.toString()`

**4. Implementujte `PremiumMember`:**
- Základný poplatok: 45€
- Dodatočná vlastnosť: `boolean hasPersonalTrainer`
- Ak má osobného trénera: +30€ k poplatku
- Maximálny počet hostí: 3 mesačne
- `toString()` pridá informáciu o osobnom trénerovi

**5. Implementujte `VipMember`:**
- Základný poplatok: 75€
- Dodatočné vlastnosti: `boolean hasSpaAccess`, `int personalSessionsIncluded`
- Spa prístup: +25€, každý osobný tréning: +15€
- Maximálny počet hostí: 10 mesačne
- `toString()` pridá informácie o spa a tréningoch

### **Časť C: Main trieda - demonštrácia konceptov**

**6. V `main()` metóde implementujte nasledujúce sekcie:**

**a) Základná ukážka toString():**
```java
// Vytvorte po jednom členovi každého typu
// Vypíšte ich pomocou System.out.println(member) - automaticky sa zavolá toString()
```

**b) Demonštrácia equals() a hashCode() s HashSet:**
```java
// Vytvorte BasicMember s ID=1
// Vytvorte ďalší BasicMember s iným menom ale rovnakým ID=1
// Pridajte oba do HashSet<Member>
// Ukážte, že HashSet obsahuje len jedného člena (kvôli equals/hashCode)
// Otestujte contains() metódu
```

**c) HashMap pre kategorizáciu členov podľa typu:**
```java
// Vytvorte HashMap<MembershipType, ArrayList<Member>>
// Inicializujte prázdne ArrayListy pre každý typ členstva
// Pridajte všetkých členov do príslušných zoznamov
// Vypíšte štatistiku: koľko členov je v každej kategórii
```

**d) HashMap pre rýchle vyhľadávanie podľa ID:**
```java
// Vytvorte HashMap<Integer, Member> ako "databázu" členov
// Pridajte všetkých členov s ich ID ako kľúčom
// Implementujte vyhľadávanie člena podľa ID
// Ukážte rozdiel v rýchlosti oproti lineárnemu vyhľadávaniu v ArrayList
```

**e) Testovanie equals() vs. == :**
```java
// Porovnajte dva objekty s rovnakým ID pomocou equals() a ==
// Vypíšte ich hashCode values
// Vysvetlite výsledky v komentároch
```

**f) Polymorfizmus s toString():**
```java
// Vytvorte pole Member[] s rôznymi typmi členov
// Pre každého člena vypíšte: typ triedy + výsledok toString()
// Ukážte, že sa volajú rôzne implementácie toString()
```

**g) Praktická simulácia:**
```java
// Simulujte registráciu nového člena, ktorý už existuje (rovnaké ID)
// Ukážte, ako HashSet zabráni duplicitám
// Simulujte vyhľadávanie člena v "databáze" HashMap
```

### **Očakávaný výstup:**
```
=== TOSTRING() UKÁŽKA ===
Basic: ID: 1, Meno: Peter Novák, Typ: Základné členstvo, Stav: Aktívne, ...
Premium: ID: 2, Meno: Anna Svoboda, Typ: Prémiové členstvo, ..., Osobný tréner: Áno
VIP: ID: 3, Meno: Milan Kovač, Typ: VIP členstvo, ..., Spa: Áno, Tréningy/mesiac: 4

=== HASHSET UKÁŽKA (duplicitné ID) ===
Počet členov v HashSet: 3
HashSet obsahuje duplicateBasic? true

=== HASHMAP UKÁŽKA - členovia podľa typu ===
Základné členstvo (1 členov):
  ID: 1, Meno: Peter Novák, ...
Prémiové členstvo (1 členov):
  ID: 2, Meno: Anna Svoboda, ...
...
```


### **Bonus úlohy:**
1. Pridajte metódu `generateMembershipCard()` ktorá vráti String s ID a QR kódom
2. Implementujte `Comparable<Member>` pre zoradenie podľa mena
3. Vytvorte `MembershipManager` triedu na správu všetkých členov

