
/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Prg03 - Player class
 * Name(s):
 */

public class Player implements Comparable<Player> {

    private String name;
    private int    score;
    private static final int MIN_SCORE = 0;

    public Player(final String name, int score) {
        this.name = name;
        if (score < MIN_SCORE)
            this.score = 0;
        else
            this.score = score;
    }

    public Player(final String name) {
        this(name, MIN_SCORE);
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + ": " + score;
    }

    // TODO: compare player objects based on their scores
    @Override
    public int compareTo(Player other) {
        return this.score-other.score;
    }
}