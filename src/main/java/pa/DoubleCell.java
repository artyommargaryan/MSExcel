package pa;

import java.util.Objects;

public class DoubleCell extends Cell {
    double value;

    public DoubleCell() {
    }

    public DoubleCell(double value) {
        this.value = value;
    }

    public DoubleCell(double value, Color color) {
        this.value = value;
        setColor(color);
    }

    public void setValue(String value) {
        this.value = Double.parseDouble(value);
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String getStringValue() {
        return Double.toString(value);
    }

    @Override
    public void reset() {
        value = 0.0;
        super.reset();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof DoubleCell cell)) {
            return false;
        }

        return value == cell.value && super.equals(cell);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }
}
