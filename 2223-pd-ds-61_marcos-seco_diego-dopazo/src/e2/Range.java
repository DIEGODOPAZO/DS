package e2;

public class Range {
    float min;
    float max;

    Range(float min, float max) {
        this.min = min;
        this.max = max;
    }

    boolean contains(float value) {
        return value >= this.min && value <= this.max;
    }
}
