/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 26.3.2023 г.
 * Time: 7:39
 */
package P16_04Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Lake implements Iterable<Integer>{
    private List<Integer> lakeArr;

    public Lake(int[] arr) {
        this.lakeArr = new ArrayList<>();
        for (int i : arr) {
            this.lakeArr.add(i);
        }
    }

    public List<Integer> getLakeArr() {
        return lakeArr;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Froggy();
    }

    public class Froggy implements Iterator<Integer> {
        int counter = 0;
        boolean firstRound = false;

        @Override
        public boolean hasNext() {
            return this.counter < lakeArr.size();
        }

        @Override
        public Integer next() {
            int result = lakeArr.get(counter);
            this.counter += 2;
            if (this.counter >= lakeArr.size() && !firstRound) {
                firstRound = true;
                this.counter = 1;
            }
            return result;
        }
    }
}
