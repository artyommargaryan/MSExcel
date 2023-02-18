import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import pa.Cell;
import pa.DoubleCell;

public class DoubleCellTest {
    @Test
    public void doubleCellsSetValueThrowsNumberFormatExceptionIfArgumentIsNotParseToDouble() {
        DoubleCell doubleCell = new DoubleCell();
        assertThrows(NumberFormatException.class, () -> doubleCell.setValue("aa"));
    }

    @Test
    public void doubleCellsGetStringValueForDoubleAndStringAreNotEqual() {
        DoubleCell doubleCell = new DoubleCell();
        doubleCell.setValue(Double.toString(1.0));
        assertNotEquals(1.0, doubleCell.getStringValue());
    }

    @Test
    public void doubleCellsGetStringValueForStringAndStringAreEqual() {
        DoubleCell doubleCell = new DoubleCell();
        doubleCell.setValue(Double.toString(1.0));
        assertEquals("1.0", doubleCell.getStringValue());
    }

    @Test
    public void doubleCellsGetValue() {
        DoubleCell doubleCell = new DoubleCell();
        doubleCell.setValue(1.0);
        assertEquals(1.0, doubleCell.getValue());
    }

    @Test
    public void doubleCellGetColor() {
        DoubleCell doubleCell = new DoubleCell();
        assertEquals(Cell.Color.WHITE, doubleCell.getColor());
        doubleCell.setColor(Cell.Color.GREEN);
        assertEquals(Cell.Color.GREEN, doubleCell.getColor());
        doubleCell.setColor(Cell.Color.YELLOW);
        assertEquals(Cell.Color.YELLOW, doubleCell.getColor());
        doubleCell.setColor(Cell.Color.RED);
        assertEquals(Cell.Color.RED, doubleCell.getColor());
    }

    @Test
    public void doubleCellReset() {
        DoubleCell doubleCell = new DoubleCell();
        doubleCell.setValue(1.0);
        doubleCell.setColor(Cell.Color.RED);
        doubleCell.reset();
        assertEquals("0.0", doubleCell.getStringValue());
        assertEquals(0.0, doubleCell.getValue());
        assertEquals(Cell.Color.WHITE, doubleCell.getColor());
    }

    @Test
    public void doubleCellEqualsTrue() {
        DoubleCell doubleCell1 = new DoubleCell();
        DoubleCell doubleCell2 = new DoubleCell();
        doubleCell1.setValue(1.0);
        doubleCell2.setValue(1.0);
        doubleCell1.setColor(Cell.Color.YELLOW);
        doubleCell2.setColor(Cell.Color.YELLOW);
        assertEquals(doubleCell1, doubleCell2);
    }

    @Test
    public void doubleCellEqualsFalseForDoubleValues() {
        DoubleCell doubleCell1 = new DoubleCell();
        DoubleCell doubleCell2 = new DoubleCell();
        doubleCell1.setValue(1.0);
        doubleCell2.setValue(2.0);
        doubleCell1.setColor(Cell.Color.YELLOW);
        doubleCell2.setColor(Cell.Color.YELLOW);
        assertNotEquals(doubleCell1, doubleCell2);
    }

    @Test
    public void doubleCellEqualsFalseForColor() {
        DoubleCell doubleCell1 = new DoubleCell();
        DoubleCell doubleCell2 = new DoubleCell();
        doubleCell1.setValue(1.0);
        doubleCell2.setValue(1.0);
        doubleCell1.setColor(Cell.Color.YELLOW);
        doubleCell2.setColor(Cell.Color.RED);
        assertNotEquals(doubleCell1, doubleCell2);
    }

    @Test
    public void doubleCellEqualsFalse() {
        DoubleCell doubleCell1 = new DoubleCell();
        DoubleCell doubleCell2 = new DoubleCell();
        doubleCell1.setValue(1.0);
        doubleCell2.setValue(2.0);
        doubleCell1.setColor(Cell.Color.YELLOW);
        doubleCell2.setColor(Cell.Color.RED);
        assertNotEquals(doubleCell1, doubleCell2);
    }

    @Test
    public void doubleCellHashcodesAreEqual() {
        DoubleCell doubleCell1 = new DoubleCell();
        DoubleCell doubleCell2 = new DoubleCell();
        doubleCell1.setValue(1.0);
        doubleCell2.setValue(1.0);
        doubleCell1.setColor(Cell.Color.YELLOW);
        doubleCell2.setColor(Cell.Color.YELLOW);
        assertEquals(doubleCell1.hashCode(), doubleCell2.hashCode());
    }

    @Test
    public void doubleCellHashcodesAreNoteEqualForDifferentDoubleValues() {
        DoubleCell doubleCell1 = new DoubleCell();
        DoubleCell doubleCell2 = new DoubleCell();
        doubleCell1.setValue(1.0);
        doubleCell2.setValue(2.0);
        doubleCell1.setColor(Cell.Color.YELLOW);
        doubleCell2.setColor(Cell.Color.YELLOW);
        assertNotEquals(doubleCell1.hashCode(), doubleCell2.hashCode());
    }

    @Test
    public void doubleCellHashcodesAreNoteEqualForDifferentForColor() {
        DoubleCell doubleCell1 = new DoubleCell();
        DoubleCell doubleCell2 = new DoubleCell();
        doubleCell1.setValue(1.0);
        doubleCell2.setValue(1.0);
        doubleCell1.setColor(Cell.Color.YELLOW);
        doubleCell2.setColor(Cell.Color.RED);
        assertNotEquals(doubleCell1.hashCode(), doubleCell2.hashCode());
    }

    @Test
    public void doubleCellHashcodesAreNoteEqualForDifferentDoubleValuesAndDifferentColors() {
        DoubleCell doubleCell1 = new DoubleCell();
        DoubleCell doubleCell2 = new DoubleCell();
        doubleCell1.setValue(1.0);
        doubleCell2.setValue(2.0);
        doubleCell1.setColor(Cell.Color.YELLOW);
        doubleCell2.setColor(Cell.Color.RED);
        assertNotEquals(doubleCell1.hashCode(), doubleCell2.hashCode());
    }
}
