/**
 * Implementation of the Change Return Program
 */
package nl.bos.numbers.impl;

import static nl.bos.common.IContants.ERROR_NOT_VALID;
import static nl.bos.common.IContants.INPUT_COSTS;
import static nl.bos.common.IContants.INPUT_MONEY_AMOUNT;
import static nl.bos.common.IContants.MONEY_VALUES;
import static nl.bos.common.IContants.OUTPUT_TOTAL_CHANGE;
import static nl.bos.common.IContants.STR_THE_STUFF;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import nl.bos.numbers.IChangeReturnProgram;

/**
 * @author bosa
 *
 */
public class ChangeReturnProgram implements IChangeReturnProgram {

	private static double costs, moneyAmount;
	private static double totalChange;

	public static void setCosts(double costs) {
		ChangeReturnProgram.costs = costs;
	}

	public static void setMoneyAmount(double moneyAmount) {
		ChangeReturnProgram.moneyAmount = moneyAmount;
	}

	@Override
	public void getUserInput(Scanner reader) {
		try {
			System.out.print(String.format(INPUT_COSTS, STR_THE_STUFF));
			costs = Double.parseDouble(reader.next());

			System.out.print(INPUT_MONEY_AMOUNT);
			moneyAmount = Double.parseDouble(reader.next());
		} catch (NumberFormatException nfe) {
			System.out.println(ERROR_NOT_VALID);
			getUserInput(reader);
		}
	}

	@Override
	public void displayOutput(String changeMoney) {
		System.out.println(String.format(OUTPUT_TOTAL_CHANGE, totalChange, changeMoney));
	}

	private String arrayListToString(ArrayList<Float> changeMoney) {
		String result = "";
		
		for (Iterator<Float> iterator = changeMoney.iterator(); iterator.hasNext();) {
			Float value = (Float) iterator.next();
			result += value.floatValue() + ", ";
		}
		
		return result.substring(0, result.length()-2);
	}

	@Override
	public String getChangeMoney() {
		double change = Math.round((moneyAmount - costs)*100)/100.0d;
		totalChange = change; 
		
		ArrayList<Float> changeMoney = new ArrayList<Float>();
		
		for (int i = 0; i < MONEY_VALUES.length; i++) {
			double valueCheck = Math.round((change - MONEY_VALUES[i])*100)/100.0d;
			if(valueCheck >= 0) {
				changeMoney.add(MONEY_VALUES[i]);
				change = Math.round((change - MONEY_VALUES[i])*100)/100.0d;
				i--;
			}
		}
		
		return arrayListToString(changeMoney);
	}

}
