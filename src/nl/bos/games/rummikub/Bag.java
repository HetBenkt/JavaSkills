package nl.bos.games.rummikub;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bosa on 11-7-2017.
 */
@Data
@AllArgsConstructor
public class Bag implements IBag {
    private int size;
    private static List<IStone> stones = new ArrayList();

    @Override
    public void addStones() {
        IStone.COLOR[] colors = IStone.COLOR.values();
        int index = 0;
        IStone.COLOR color = colors[index];

        for (int i=1; i <= size; i++){
            for (int number = 1; number <= IStone.MAX_NUMBER; number++) {
                IStone stone = new Stone(number, color);
                stones.add(stone);
            }
            index++;
            if(index < colors.length) {
                color = colors[index];
            }
            else {
                index = 0;
                color = colors[index];
            }
        }
    }

    @Override
    public List<IStone> getStones() {
        return stones;
    }
}
