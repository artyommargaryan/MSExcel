package pa;

import java.util.Objects;

public class IntCell extends Cell {
    private int value;

    public IntCell() {
    }

    public IntCell(int value) {
        this.value = value;
    }

    public IntCell(int value, Color color) {
        this.value = value;
        setColor(color);
    }


    public void setValue(String value) {
        this.value = Integer.parseInt(value);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String getStringValue() {
        return Integer.toString(value);
    }

    @Override
    public void reset() {
        value = 0;
        super.reset();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof IntCell cell)) {
            return false;
        }

        return value == cell.value && super.equals(cell);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }
}
