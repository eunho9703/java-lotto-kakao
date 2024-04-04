package model.random;

public enum NumberRange {
    START(1),
    END(45),
    ;

    NumberRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private final int value;
}
