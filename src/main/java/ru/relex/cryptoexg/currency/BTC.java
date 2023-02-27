package ru.relex.cryptoexg.currency;

public class BTC extends AbstractCurrency {
    public static final CurrencyName NAME = CurrencyName.BTC;
    public static final double MIN_UNIT = 1e-8;

    protected BTC(long amount) {
        super(amount);
    }

    protected BTC(double amount) {
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
}
