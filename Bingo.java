package solutions;

import java.util.Random;

class Bingo {

    static boolean showExpectedResult = false;
    static boolean showHints = false;

    // Create a BingoCard object
    static BingoCard getBingoCard() {
        int[] B = generateColumn(1, 15, 5);
        int[] I = generateColumn(16, 30, 5);
        int[] N = generateColumn(31, 45, 5); // center is free
        int[] G = generateColumn(46, 60, 5);
        int[] O = generateColumn(61, 75, 5);

        return new BingoCard(B, I, N, G, O);
    }

    // Generate a column of unique numbers within a range
    private static int[] generateColumn(int min, int max, int entries) {
        Random random = new Random();
        int[] column = new int[entries];
        int count = 0;

        while (count < entries) {
            int number = random.nextInt(min,max+1);
            if (!elementExists(column, number)) {
                column[count] = number;
                count++;
            }
        }
        return column;
    }

    // Check if an element exists in an array
    private static boolean elementExists(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return true;
            }
        }
        return false;
    }

    // Main method to test BingoCard generation
    public static void main(String[] args) {
        BingoCard card = getBingoCard();
        card.printCard();
    }
}

// BingoCard class
class BingoCard {
    private int[] b, i, n, g, o;

    public BingoCard(int[] b, int[] i, int[] n, int[] g, int[] o) {
        setB(b);
        setI(i);
        setN(n);
        setG(g);
        setO(o);
    }

    public void setB(int[] numbers) { b = numbers; }
    public void setI(int[] numbers) { i = numbers; }
    public void setN(int[] numbers) { n = numbers; }
    public void setG(int[] numbers) { g = numbers; }
    public void setO(int[] numbers) { o = numbers; }

    public int[] getB() { return b; }
    public int[] getI() { return i; }
    public int[] getN() { return n; }
    public int[] getG() { return g; }
    public int[] getO() { return o; }

    // Print the Bingo card
    public void printCard() {
        System.out.println(" B  I  N  G  O");
        for (int row = 0; row < 5; row++) {
            System.out.printf("%2d %2d %2d %2d %2d%n",
                    b[row], i[row], n[row], g[row], o[row]);
        }
    }
}

