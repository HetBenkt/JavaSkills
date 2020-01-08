/**
 * Implementation class for interface IBinaryDecimalConverter
 */
package nl.bos.numbers.impl;

import nl.bos.numbers.IBinaryDecimalConverter;

import java.util.Scanner;

import static nl.bos.common.IContants.*;

/**
 * @author bosa
 *
 */
public class BinaryDecimalConverter implements IBinaryDecimalConverter {
	private int decimal;
	private String binary;

	@Override
	public String getBinary() {
		return binary;
	}

	@Override
	public void setBinary(String binary) {
		this.binary = binary;
	}

	@Override
	public void setDecimal(int decimal) {
		this.decimal = decimal;
	}

	@Override
	public int getDecimal() {
		return decimal;
	}

	@Override
	public void getUserInput(Scanner reader) {
		System.out.print(String.format(INPUT_CONVERTER, STR_DECIMAL));
		decimal = Integer.parseInt(reader.next());

		System.out.print(String.format(INPUT_CONVERTER, STR_BINARY));
		binary = reader.next();
	}

	@Override
	public void displayOutput(int decimal, String binary) {
		System.out.println(STR_BINARY + "=" + binary);
		System.out.println(STR_DECIMAL + "=" + decimal);
	}
}
