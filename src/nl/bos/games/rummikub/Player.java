package nl.bos.games.rummikub;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by bosa on 11-7-2017.
 */
@Data
@AllArgsConstructor
public class Player implements IPlayer {
    private String name;
    private int age;
    private String gender;
}
