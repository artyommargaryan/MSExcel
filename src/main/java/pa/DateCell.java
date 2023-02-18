package pa;

import java.util.Objects;

public class DateCell extends Cell {
    private Date value;

    public DateCell() {
    }

    public DateCell(Date value) {
        this.value = value;
    }

    public DateCell(Date value, Color color) {
        this.value = value;
        setColor(color);
    }

    public void setValue(String value) {
        this.value = Date.parseToDate(value);
    }

    public void setValue(Date value) {
        this.value = value;
    }

    public Date getValue() {
        return value;
    }

    @Override
    public String getStringValue() {
        if(value == null){
            return "";
        }
        return value.toString();
    }

    @Override
    public void reset() {
        value = null;
        super.reset();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof DateCell cell)) {
            return false;
        }

        return Objects.equals(value, cell.value) && super.equals(cell);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }
}