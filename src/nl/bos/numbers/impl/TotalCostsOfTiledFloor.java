/**
 * Calculate the total cost of tile it would take to cover a floor plan of width and height, using a cost entered by the user.
 */
package nl.bos.numbers.impl;

import static nl.bos.common.IContants.ERROR_NOT_VALID;
import static nl.bos.common.IContants.INPUT_COSTS;
import static nl.bos.common.IContants.INPUT_DIMENTIONS;
import static nl.bos.common.IContants.REGEX_DIMENTIONS;
import static nl.bos.common.IContants.REGEX_TWO_DIGIT_DOUBLE;
import static nl.bos.common.IContants.STR_FLOOR;
import static nl.bos.common.IContants.STR_ONE_TILE;
import static nl.bos.common.IContants.STR_TILE;

import java.util.Scanner;

import nl.bos.common.NumberMethods;
import nl.bos.numbers.ITotalCostsOfTiledFloor;

/**
 * 
 * @author bosa
 *
 */
public class TotalCostsOfTiledFloor implements ITotalCostsOfTiledFloor {
	private double widthFloor, lenghtFloor, widthTile, lenghtTile,
			costsOneTile;

	public double getWidthFloor() {
		return widthFloor;
	}

	public double getLenghtFloor() {
		return lenghtFloor;
	}

	public double getWidthTile() {
		return widthTile;
	}

	public double getLenghtTile() {
		return lenghtTile;
	}

	public double getCostsOneTile() {
		return costsOneTile;
	}

	/**
	 * Getting the floor and tile info from user input
	 * 
	 * @param reader
	 *            Console input reader
	 */
	@Override
	public void getUserInput(Scanner reader) {
		double[] info = handleInfo(reader, STR_FLOOR);
		widthFloor = info[0];
		lenghtFloor = info[1];

		info = handleInfo(reader, STR_TILE);
		widthTile = info[0];
		lenghtTile = info[1];

		System.out.print(String.format(INPUT_COSTS, STR_ONE_TILE));
		String oneTile = reader.next();
		if (NumberMethods.isCorrectFormat(REGEX_TWO_DIGIT_DOUBLE, oneTile))
			costsOneTile = Double.parseDouble(oneTile);
		else {
			System.out.println(ERROR_NOT_VALID);
			getUserInput(reader);
		}
	}

	/**
	 * Getting the floor or tile info from user input
	 * 
	 * @param reader
	 *            Console input reader
	 * @param type
	 *            Floor | Tile
	 * @return double array for width and height of the type
	 */
	private double[] handleInfo(Scanner reader, String type) {
		double[] result = { 0, 0 };

		System.out.print(String.format(INPUT_DIMENTIONS, type));
		String dimentions = reader.next();
		if (NumberMethods.isCorrectFormat(REGEX_DIMENTIONS, dimentions)) {
			result[0] = Double.parseDouble(dimentions.substring(0,
					dimentions.indexOf("*")));
			result[1] = Double.parseDouble(dimentions.substring(
					dimentions.indexOf("*") + 1, dimentions.length()));
		} else {
			System.out.println(ERROR_NOT_VALID);
			result = handleInfo(reader, type);
		}

		return result;
	}

	/**
	 * Getting the total size of the surface
	 * 
	 * @param width
	 *            Width of the surface
	 * @param lenght
	 *            Length of the surface
	 * @return Width multiplied with length
	 */
	@Override
	public double getTotalSurface(double width, double lenght) {
		return width * lenght;
	}

	/**
	 * Getting the total number of tiles for the surface
	 * 
	 * @param surfaceFloor
	 *            m2 for the floor
	 * @param surfaceTile
	 *            m2 for the tile
	 * @return Rounded devide from the surface floor en suface tile
	 */
	@Override
	public long getTotalTilesForSurface(double surfaceFloor, double surfaceTile) {
		double devide = surfaceFloor / surfaceTile;
		return Math.round(devide);
	}

	/**
	 * Getting the total costs for all tiles
	 * 
	 * @param totalTiles
	 *            Input for the number of tiles
	 * @param costsOneTile
	 *            Input of the costs for 1 tile
	 * @return Calculation of the input with 2 digits
	 */
	@Override
	public double getTotalCosts(long totalTiles, double costsOneTile) {
		return Math.round((totalTiles * costsOneTile) * 100.0) / 100.0;

	}

}
