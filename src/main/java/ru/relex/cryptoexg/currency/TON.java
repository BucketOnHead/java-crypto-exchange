package ru.relex.cryptoexg.currency;

public class TON extends AbstractCurrency<TON> {
    public static final CurrencyName NAME = CurrencyName.TON;
    public static final double MIN_UNIT = 1e-2;
    public static final double MAX_EXPONENT = 1 / MIN_UNIT;

    protected TON(long amount) {
        super(amount);
    }

    public TON(double amount) {
        super(amount);
    }

    public TON(long mantis, int exponent) {
        super(mantis, exponent);
    }

    @Override
    public CurrencyName getName() {
        return NAME;
    }

    @Override
    public double getMinUnit() {
        return MIN_UNIT;
    }

    @Override
    public int getMaxExponent() {
        return (int) MAX_EXPONENT;
    }
}
