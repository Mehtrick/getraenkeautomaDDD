package de.mehtrick.getraenkeautomaddd.domain.kasse;

public enum MuenzTyp {
    ZEHN_CENT(10),
    ZWANZIG_CENT(20),
    FUENFZIG_CENT(50),
    EIN_EURO(100),
    ZWEI_EURO(200);

    private final int wert;

    MuenzTyp(int wert) {
        this.wert = wert;
    }

    public int getWert() {
        return wert;
    }
}
