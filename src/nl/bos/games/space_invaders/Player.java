/**
 * 
 */
package nl.bos.games.space_invaders;

import javax.swing.ImageIcon;
import static nl.bos.games.space_invaders.ICommons.*;
/**
 * @author x088498
 *
 */
public class Player extends Sprite {
	
	public Player(Board board) {
		System.out.println(this.getClass().getResource(PLAYER_IMAGE).getPath());
		ImageIcon ii = new ImageIcon(this.getClass().getResource(PLAYER_IMAGE));
		
		this.setImage(ii.getImage());
		this.setX(board.getWidth()/2);
		this.setY(board.getWidth() - APP_GROUND_HEIGHT);
	}
}
