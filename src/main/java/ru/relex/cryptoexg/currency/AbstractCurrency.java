package ru.relex.cryptoexg.currency;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractCurrency<T extends AbstractCurrency> {
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

    public abstract int getMaxExponent();

    public void plus(T currency) {
        this.mantis += currency.getMantis();
        this.exponent += currency.getExponent();

        if (this.exponent >= getMaxExponent()) {
            int mantisInExponent = exponent / getMaxExponent();

            this.mantis += mantisInExponent;
            this.exponent += currency.getExponent() - getMaxExponent() * mantisInExponent;
        }
    }

    public void minus(T currency) {
        if (this.mantis >= currency.getMantis() && this.exponent >= currency.getExponent()) {
            this.mantis -= currency.getMantis();
            this.exponent -= currency.getExponent();
        } else if (this.exponent < currency.getMantis()
                && (this.mantis - currency.getMantis() - 1) > currency.getMantis()) {
            this.mantis -= (currency.getMantis() + 1);
            this.exponent += getMaxExponent() - currency.getExponent();
        } else {
            throw new IllegalArgumentException("Insufficient funds to perform the operation");
        }
    }

    public String toStringValue() {
        if (exponent == 0) {
            return String.valueOf(mantis);
        } else {
            return String.valueOf(mantis + exponent * getMinUnit());
        }
    }

    private long extractMantis(double amount) {
        return (long) amount;
    }

    private int extractExponent(double amount) {
        double floatExponent = amount - (long) amount;
        return (int) (floatExponent / getMinUnit());
    }
}
