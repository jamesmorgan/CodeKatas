package com.leadx.code.katas.exceptions;

import java.util.List;

public class NegativesNotAllowedException extends RuntimeException {

	/** */
	private static final long serialVersionUID = 1350687840782475779L;

	public NegativesNotAllowedException(final List<Integer> negativeNumbers) {
		super(String.format("negatives not allowed: %s", negativeNumbers));
	}
}
