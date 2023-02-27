package ru.relex.cryptoexg.currency;

public class RUB extends AbstractCurrency<RUB> {
    public static final CurrencyName NAME = CurrencyName.RUB;
    public static final double MIN_UNIT = 1e-2;
    public static final double MAX_EXPONENT = 1 / MIN_UNIT;

    protected RUB(long amount) {
        super(amount);
    }

    public RUB(double amount) {
        super(amount);
    }

    public RUB(long mantis, int exponent) {
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
