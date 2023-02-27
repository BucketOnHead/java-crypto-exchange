package ru.relex.cryptoexg.currency;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractCurrency {
    private long mantis;
    private int exponent;

    protected AbstractCurrency(long amount) {
        this.mantis = amount;
    }

    protected AbstractCurrency(double amount) {
        this.mantis = extractMantis(amount);
        this.exponent = extractExponent(amount);
    }

    protected AbstractCurrency(long mantis, int exponent) {
        if (exponent >= 1 / getMinUnit()) {
            throw new IllegalArgumentException("exponent >= maxExponent");
        }

        this.mantis = mantis;
        this.exponent = exponent;
    }

    @Override
    public String toString() {
        return String.format("%f %s",
                (mantis + exponent * getMinUnit()),
                getName());
    }

    public abstract CurrencyName getName();
    public abstract double getMinUnit();

    public String toStringValue() {
        return String.valueOf(mantis + exponent * getMinUnit());
    }

    private long extractMantis(double amount) {
        return (long) amount;
    }

    private int extractExponent(double amount) {
        double floatExponent = amount - (long) amount;
        return (int) (floatExponent / getMinUnit());
    }
}
