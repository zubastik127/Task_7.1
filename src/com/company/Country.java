package com.company;

public enum Country {

    RUSSIA("RUSSIA", "Россия", true),
    ARMENIA("ARMENIA", "Армения", true),
    GERMANY("GERMANY", "Германия", false),
    JAPAN("JAPAN", "Япония", false),
    USA("USA", "США", false);

    private final String euName;
    private final String ruName;
    private final boolean isOpen;

    Country(final String euName, final String ruName, final boolean isOpen) {
        this.euName = euName;
        this.ruName = ruName;
        this.isOpen = isOpen;
    }

    public String getIsOpen() {
        String open;
        if (isOpen) {
            open = " открыта для посещения.";
        } else {
            open = " закрыта для посещения.";
        }
        return open;
    }

    @Override
    public String toString() {
        return euName + " (" + ruName + ")";
    }

    public static Country getByRuName(final String ruName) throws NoSuchCountryException {
        for (Country b : Country.values()) {
            if (b.ruName.equalsIgnoreCase(ruName)) {
                return b;
            }
        }
        throw new NoSuchCountryException("Страны '" + ruName + "' не существует.");
    }
}
