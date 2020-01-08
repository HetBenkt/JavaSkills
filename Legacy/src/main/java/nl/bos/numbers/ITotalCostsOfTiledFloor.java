/**
 * Interface for the Total number of tiled floor case
 */
package nl.bos.numbers;

import java.util.Scanner;

/**
 * 
 * @author bosa
 */
public interface ITotalCostsOfTiledFloor {
	public void getUserInput(Scanner reader);
	public double getTotalSurface(double width, double lenght);
	public long getTotalTilesForSurface(double surfaceFloor, double surfaceTile);
	public double getTotalCosts(long totalTiles, double costsOneTile);
	public double getWidthFloor();
	public double getLenghtFloor();
	public double getWidthTile();
	public double getLenghtTile();
	public double getCostsOneTile();
}
