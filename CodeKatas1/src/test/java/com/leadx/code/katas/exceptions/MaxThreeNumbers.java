package com.leadx.code.katas.exceptions;

import java.util.List;

public class MaxThreeNumbers extends RuntimeException {

	/** */
	private static final long serialVersionUID = 3877809371414088731L;

	public MaxThreeNumbers(final List<Integer> numbers) {
		super(String.format("Max three numbers to add: %s", numbers));
	}

}
