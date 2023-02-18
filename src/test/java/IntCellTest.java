import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import pa.Cell;
import pa.IntCell;

public class IntCellTest {
    @Test
    public void intCellsSetValueThrowsNumberFormatExceptionIfArgumentIsNotParseToInt() {
        IntCell intCell = new IntCell();
        assertThrows(NumberFormatException.class, () -> intCell.setValue("aa"));
    }

    @Test
    public void intCellsGetStringValueForIntAndStringAreNotEqual() {
        IntCell intCell = new IntCell();
        intCell.setValue(Integer.toString(1));
        assertNotEquals(1, intCell.getStringValue());
    }

    @Test
    public void intCellsGetStringValueForStringAndStringAreEqual() {
        IntCell intCell = new IntCell();
        intCell.setValue(Integer.toString(1));
        assertEquals("1", intCell.getStringValue());
    }

    @Test
    public void intCellsGetValue() {
        IntCell intCell = new IntCell();
        intCell.setValue(1);
        assertEquals(1, intCell.getValue());
    }

    @Test
    public void intCellGetColor() {
        IntCell intCell = new IntCell();
        assertEquals(Cell.Color.WHITE, intCell.getColor());
        intCell.setColor(Cell.Color.GREEN);
        assertEquals(Cell.Color.GREEN, intCell.getColor());
        intCell.setColor(Cell.Color.YELLOW);
        assertEquals(Cell.Color.YELLOW, intCell.getColor());
        intCell.setColor(Cell.Color.RED);
        assertEquals(Cell.Color.RED, intCell.getColor());
    }

    @Test
    public void intCellReset() {
        IntCell intCell = new IntCell();
        intCell.setValue(1);
        intCell.setColor(Cell.Color.RED);
        intCell.reset();
        assertEquals("0", intCell.getStringValue());
        assertEquals(0, intCell.getValue());
        assertEquals(Cell.Color.WHITE, intCell.getColor());
    }

    @Test
    public void intCellEqualsTrue() {
        IntCell intCell1 = new IntCell();
        IntCell intCell2 = new IntCell();
        intCell1.setValue(1);
        intCell2.setValue(1);
        intCell1.setColor(Cell.Color.YELLOW);
        intCell2.setColor(Cell.Color.YELLOW);
        assertEquals(intCell1, intCell2);
    }

    @Test
    public void intCellEqualsFalseForIntValues() {
        IntCell intCell1 = new IntCell();
        IntCell intCell2 = new IntCell();
        intCell1.setValue(1);
        intCell2.setValue(2);
        intCell1.setColor(Cell.Color.YELLOW);
        intCell2.setColor(Cell.Color.YELLOW);
        assertNotEquals(intCell1, intCell2);
    }

    @Test
    public void intCellEqualsFalseForColor() {
        IntCell intCell1 = new IntCell();
        IntCell intCell2 = new IntCell();
        intCell1.setValue(1);
        intCell2.setValue(1);
        intCell1.setColor(Cell.Color.YELLOW);
        intCell2.setColor(Cell.Color.RED);
        assertNotEquals(intCell1, intCell2);
    }

    @Test
    public void intCellEqualsFalse() {
        IntCell intCell1 = new IntCell();
        IntCell intCell2 = new IntCell();
        intCell1.setValue(1);
        intCell2.setValue(2);
        intCell1.setColor(Cell.Color.YELLOW);
        intCell2.setColor(Cell.Color.RED);
        assertNotEquals(intCell1, intCell2);
    }

    @Test
    public void intCellHashcodesAreEqual() {
        IntCell intCell1 = new IntCell();
        IntCell intCell2 = new IntCell();
        intCell1.setValue(1);
        intCell2.setValue(1);
        intCell1.setColor(Cell.Color.YELLOW);
        intCell2.setColor(Cell.Color.YELLOW);
        assertEquals(intCell1.hashCode(), intCell2.hashCode());
    }

    @Test
    public void intCellHashcodesAreNoteEqualForDifferentIntValues() {
        IntCell intCell1 = new IntCell();
        IntCell intCell2 = new IntCell();
        intCell1.setValue(1);
        intCell2.setValue(2);
        intCell1.setColor(Cell.Color.YELLOW);
        intCell2.setColor(Cell.Color.YELLOW);
        assertNotEquals(intCell1.hashCode(), intCell2.hashCode());
    }

    @Test
    public void intCellHashcodesAreNoteEqualForDifferentForColor() {
        IntCell intCell1 = new IntCell();
        IntCell intCell2 = new IntCell();
        intCell1.setValue(1);
        intCell2.setValue(1);
        intCell1.setColor(Cell.Color.YELLOW);
        intCell2.setColor(Cell.Color.RED);
        assertNotEquals(intCell1.hashCode(), intCell2.hashCode());
    }

    @Test
    public void intCellHashcodesAreNoteEqualForDifferentIntValuesAndDifferentColors() {
        IntCell intCell1 = new IntCell();
        IntCell intCell2 = new IntCell();
        intCell1.setValue(1);
        intCell2.setValue(2);
        intCell1.setColor(Cell.Color.YELLOW);
        intCell2.setColor(Cell.Color.RED);
        assertNotEquals(intCell1.hashCode(), intCell2.hashCode());
    }
}
