package pa;

import java.util.Objects;

public abstract class Cell {

    private Color color = Color.WHITE;

    public enum Color {
        WHITE,
        GREEN,
        YELLOW,
        RED,
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract String getStringValue();
    public abstract void setValue(String value);

    public void reset() {
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

        return color == cell.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}
