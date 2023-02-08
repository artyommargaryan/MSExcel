import java.util.Objects;

public class Cell {
    private String value;
    private Color color = Color.WHITE;

    public enum Color {
        WHITE,
        GREEN,
        YELLOW,
        RED,
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int toInt() {
        return Integer.parseInt(value);
    }

    public double toDouble() {
        return Double.parseDouble(value);
    }

    public Date toDate() {
        return Date.parseToDate(value);
    }

    public void reset() {
        value = "";
        color = Color.WHITE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Cell cell)) {
            return false;
        }

        return Objects.equals(value, cell.value) && color == cell.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, color);
    }
}
