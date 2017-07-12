package nl.bos.games.rummikub;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;

/**
 * Created by bosa on 11-7-2017.
 */
@Data
public class Stone implements IStone {
    private final int value;
    private final COLOR color;
}
