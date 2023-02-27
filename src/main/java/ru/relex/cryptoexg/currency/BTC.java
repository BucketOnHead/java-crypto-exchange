package ru.relex.cryptoexg.currency;

public class BTC extends AbstractCurrency<BTC> {
    public static final CurrencyName NAME = CurrencyName.BTC;
    public static final double MIN_UNIT = 1e-8;
    public static final double MAX_EXPONENT = 1 / MIN_UNIT;


    protected BTC(long amount) {
        super(amount);
    }

    public BTC(double amount) {
        super(amount);
    }

    public BTC(long mantis, int exponent) {
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
