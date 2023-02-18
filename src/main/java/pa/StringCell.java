package pa;

import java.util.Objects;

public class StringCell extends Cell {
    private String value;

    public StringCell() {
        value = "";
    }

    public StringCell(String value) {
        this.value = value;
    }

    public StringCell(String value, Color color) {
        this.value = value;
        setColor(color);
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getStringValue() {
        return value;
    }

    @Override
    public void reset() {
        value = "";
        super.reset();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof StringCell cell)) {
            return false;
        }

        return Objects.equals(value, cell.value) && super.equals(cell);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }
}
