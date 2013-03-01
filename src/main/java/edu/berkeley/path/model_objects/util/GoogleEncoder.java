/**
 * Copyright (c) 2012, Regents of the University of California
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 *   Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 *   Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 **/
package edu.berkeley.path.model_objects.util;

import java.math.BigDecimal;
import java.util.Vector;

import edu.berkeley.path.model_objects.jaxb.Point;

/** Converts a path into a string */

public class GoogleEncoder extends EncoderBase implements EncoderIF {
	StringBuilder sb;
	Point prev = null;

	public GoogleEncoder() {
		sb = new StringBuilder();
	}

	public void add(Point point) {
		encode(new BigDecimal(point.getLat()), null == prev ? null : 
		  new BigDecimal(prev.getLat()));
		encode(new BigDecimal(point.getLng()), null == prev ? null : 
		  new BigDecimal(prev.getLng()));
		prev = point;
	}

	public String getResult() {
		return sb.toString();
	}

	private void encode(BigDecimal curr, BigDecimal prev) {
		curr = round(curr);
		if (null != prev) curr = curr.subtract(round(prev));
		encode(curr);
	}

	private BigDecimal round(BigDecimal value) {
		return value.setScale(5, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * See https://developers.google.com/maps/documentation/utilities/polylinealgorithm
	 * @param coord the value to encode
	 */
	private void encode(BigDecimal coord) {
		// 1. Take the initial signed value
		// 2. Take the decimal value and multiply it by 1e5, rounding the result
		// 3. Convert the decimal value to binary.
		//    Note that a negative value must be calculated using its two's complement
		//    by inverting the binary value and adding one to the result
		int value = coord.multiply(BigDecimal.valueOf((long) 1E5)).intValueExact();
		boolean is_negative = value < 0;
		// 4. Left-shift the binary value one bit
		value <<= 1;
		// 5. If the original decimal value is negative, invert this encoding
		if (is_negative) value = ~value;
		// 6. Break the binary value out into 5-bit chunks (starting from the right hand side)
		// 7. Place the 5-bit chunks into reverse order
		Vector<Integer> chunks = new Vector<Integer>();
		do {
			chunks.add(value & 0x1F);
			value >>>= 5;
		} while (0 != value);
		// 8. OR each value with 0x20 if another bit chunk follows
		for (int i = 0; i < chunks.size() - 1; ++i)
			chunks.set(i, chunks.get(i) | 0x20);
		// 9. Convert each value to decimal
		// 10. Add 63 to each value
		// 11. Convert each value to its ASCII equivalent
		for (Integer chunk : chunks)
			sb.append((char) (chunk.intValue() + 63));
	}

	public void reset() {
		sb.setLength(0);
		prev = null;
	}

}
