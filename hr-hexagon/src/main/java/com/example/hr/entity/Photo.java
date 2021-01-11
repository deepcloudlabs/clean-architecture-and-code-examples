package com.example.hr.entity;

import java.util.Objects;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
// Value Object
public final class Photo {
	private final byte[] value;

	private Photo(byte[] value) {
		this.value = value;
	}

	public static Photo of(byte[] value) {
		Objects.requireNonNull(value);
		return new Photo(value);
	}

	public byte[] getValue() {
		return value;
	}

}
