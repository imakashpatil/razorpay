package dev.akashpatil.razorpay.shared.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
@Embeddable
public class Money {
    private BigInteger amountUnits = BigInteger.ZERO;
    private String currency = "INR";

    public static Money of(BigInteger amount, String currency) {
        return new Money(amount, currency);
    }

    public Money add(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Cannot add money with different currencies");
        }
        return new Money(this.amountUnits.add(other.amountUnits), this.currency);
    }

    public Money indianRupees(BigInteger amountUnits) {
        return new Money(amountUnits, "INR");
    }

    public static Money of(int amountUnits, String currency) {
        return new Money( BigInteger.valueOf(amountUnits), currency);
    }

    public Money indianRupees(int amountUnits) {
        return new Money( BigInteger.valueOf(amountUnits), "INR");
    }

    public Money subtract(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Cannot subtract money with different currencies");
        }
        return new Money(this.amountUnits.subtract(other.amountUnits), this.currency);
    }
}
