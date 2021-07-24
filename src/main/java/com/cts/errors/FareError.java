package com.cts.errors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
public class FareError {
	@Getter
	private String message;

}
