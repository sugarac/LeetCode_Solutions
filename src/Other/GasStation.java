package Other;

public class GasStation {
    /**
     * Solution1: Greedy O(n); O(1)
     * Use a variable to record the starting gas station's index and another to record current rest gas
     * from starting gas station to current gas station.
     * If current rest gas is less than 0, which means it’s impossible to travel from start to current station,
     * so change start index to next and use a negative variable to record the total lacked gas of previous trips.
     * After traversing the array, compare the sum between previous lacked gas and current rest gas,
     * if it’s larger than 0, return start index, otherwise return -1.
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null) {
            return -2;
        }

        int start = 0;
        int preLack = 0;
        int curRest = 0;
        for (int i = 0; i < gas.length; i++) {
            curRest += gas[i] - cost[i];
            if (curRest < 0) {
                preLack += curRest;
                start = i + 1;
                curRest = 0;
            }
        }

        return preLack + curRest >= 0 ? start : -1;
    }
}
