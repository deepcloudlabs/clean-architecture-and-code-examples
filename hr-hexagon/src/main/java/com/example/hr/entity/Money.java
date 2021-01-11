package com.example.hr.entity;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
// Value Object, Immutable
public class Money {
	private final double value;
	private final MoneyCurrency currency;

	private Money(double value, MoneyCurrency currency) {
		this.value = value;
		this.currency = currency;
	}

	public static Money of(double value, MoneyCurrency currency) {
		if (value <= 0.)
			throw new IllegalArgumentException("Value must be positive!");
		return new Money(value, currency);
	}

	public double getValue() {
		return value;
	}

	public MoneyCurrency getCurrency() {
		return currency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		if (currency != other.currency)
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Money [value=" + value + ", currency=" + currency + "]";
	}

	public Money multiply(double percentage) {
		return Money.of(this.value * (1. + percentage / 100.), currency);
	}

	public boolean lessThan(Money minSalary) {
		return true;
	}

}
