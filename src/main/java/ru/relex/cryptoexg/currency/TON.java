package ru.relex.cryptoexg.currency;

public class TON extends AbstractCurrency {
    public static final CurrencyName NAME = CurrencyName.TON;
    public static final double MIN_UNIT = 1e-2;

    protected TON(long amount) {
        super(amount);
    }

    protected TON(double amount) {
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
}
