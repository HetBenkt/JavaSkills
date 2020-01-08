/**
 * Builder pattern builds a complex object using simple objects and using a step by step approach.
 * A Builder class builds the final object step by step
 * CREATIONAL
 * http://www.tutorialspoint.com/design_pattern/
 */
package nl.bos.design_patterns.impl.demo.creational;

import nl.bos.design_patterns.impl.Meal;
import nl.bos.design_patterns.impl.MealBuilder;

import static nl.bos.design_patterns.IConstants.*;

/**
 * @author bosa
 *
 */
public class _BuilderPatternDemo {
	public static void main(String[] args) {
		MealBuilder mealBuilder = new MealBuilder();

		Meal vegMeal = mealBuilder.prepareVegMeal();
		System.out.println(STR_OUTPUT_VEG_MEAL + "\n" + STR_SEPERATOR);
		vegMeal.showItems();
		System.out.println(String.format(STR_OUTPUT_TOTAL_COSTS,
				vegMeal.getCosts()));

		System.out.println(STR_EMPTY);

		Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
		System.out.println(STR_OUTPUT_NON_VEG_MEAL + "\n" + STR_SEPERATOR);
		nonVegMeal.showItems();
		System.out.println(String.format(STR_OUTPUT_TOTAL_COSTS,
				nonVegMeal.getCosts()));
	}
}
