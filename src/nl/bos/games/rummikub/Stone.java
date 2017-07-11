package nl.bos.games.rummikub;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;

/**
 * Created by bosa on 11-7-2017.
 */
@Data
@AllArgsConstructor
public class Stone implements IStone {

    int value;
    COLOR color;

}
