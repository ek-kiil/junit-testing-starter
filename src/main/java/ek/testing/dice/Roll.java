package ek.testing.dice;

public record Roll(int first, int second) {

    public int score() {
        if (first == second) {
            return (first + second) * 2;
        }
        return first + second;
    }
}
