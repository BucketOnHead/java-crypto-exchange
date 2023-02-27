package ru.relex.cryptoexg.currency;

public class RUB extends AbstractCurrency {
    public static final CurrencyName NAME = CurrencyName.RUB;
    public static final double MIN_UNIT = 1e-2;

    protected RUB(long amount) {
        super(amount);
    }

    protected RUB(double amount) {
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
}
