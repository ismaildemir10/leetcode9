package leetcode;

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        return (int) (-1 + Math.sqrt(8 * n + 1)) / 2;
    }
}
