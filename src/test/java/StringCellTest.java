import org.junit.jupiter.api.Test;
import pa.Cell;
import pa.StringCell;
import pa.Date;

import static org.junit.jupiter.api.Assertions.*;

public class StringCellTest {
    @Test
    public void stringCellsGetStringValueForInAndStringAreNotEqual() {
        StringCell stringCell = new StringCell();
        stringCell.setValue(Integer.toString(1));
        assertNotEquals(1, stringCell.getStringValue());
    }

    @Test
    public void stringCellsGetStringValueForStrinAndStringAreEqual() {
        StringCell stringCell = new StringCell();
        stringCell.setValue(Integer.toString(1));
        assertEquals("1", stringCell.getStringValue());
    }

    @Test
    public void stringCellsGetStringValueForDoubleAndStringNoteEqual() {
        StringCell stringCell = new StringCell();
        stringCell.setValue(Double.toString(1.0));
        assertNotEquals(1.0, stringCell.getStringValue());
    }

    @Test
    public void stringCellsGetStringValueForStringFromDoubleAndStringArqEqual() {
        StringCell stringCell = new StringCell();
        stringCell.setValue(Double.toString(1.0));
        assertEquals("1.0", stringCell.getStringValue());
    }

    @Test
    public void stringCellsGetStringValueForDateAndStringAreNotEqual() {
        StringCell stringCell = new StringCell();
        Date date = new Date(new Date.Day(5), Date.Month.JANUARY, new Date.Year(1200));
        stringCell.setValue(date.toString());
        assertNotEquals(date, stringCell.getStringValue());
    }

    @Test
    public void stringCellsGetStringValueForStringFromDateAndStringAreEqual() {
        StringCell stringCell = new StringCell();
        Date date = new Date(new Date.Day(5), Date.Month.JANUARY, new Date.Year(1200));
        stringCell.setValue(date.toString());
        assertEquals(date.toString(), stringCell.getStringValue());
    }
//
//    @Test
//    public void stringCellsToDouble() {
//        StringCell stringCell = new StringCell();
//        stringCell.setValue(Double.toString(1.0));
//        assertEquals(1.0, stringCell.toDouble());
//    }
//
//    @Test
//    public void stringCellsToDoubleThrowsExceptionIfIsNotDouble() {
//        StringCell stringCell = new StringCell();
//        stringCell.setValue("asd");
//        assertThrows(Exception.class, () -> stringCell.toDouble());
//    }
//
//    @Test
//    public void stringCellsToDate() {
//        StringCell stringCell = new StringCell();
//        Date date = new Date(new Date.Day(5), Date.Month.JANUARY, new Date.Year(2007));
//        stringCell.setValue(date.toString());
//        assertEquals(date, stringCell.toDate());
//    }
//
//    @Test
//    public void stringCellsToDateThrowsExceptionIfIsNotDate() {
//        StringCell stringCell = new StringCell();
//        stringCell.setValue("asd");
//        assertThrows(Exception.class, () -> stringCell.toDate());
//    }

    @Test
    public void stringCellGetColor() {
        StringCell stringCell = new StringCell();
        assertEquals(Cell.Color.WHITE, stringCell.getColor());
        stringCell.setColor(Cell.Color.GREEN);
        assertEquals(Cell.Color.GREEN, stringCell.getColor());
        stringCell.setColor(Cell.Color.YELLOW);
        assertEquals(Cell.Color.YELLOW, stringCell.getColor());
        stringCell.setColor(Cell.Color.RED);
        assertEquals(Cell.Color.RED, stringCell.getColor());
    }

    @Test
    public void stringCellReset() {
        StringCell stringCell = new StringCell();
        stringCell.setValue("aaa");
        stringCell.setColor(Cell.Color.RED);
        stringCell.reset();
        assertEquals("", stringCell.getStringValue());
        assertEquals(Cell.Color.WHITE, stringCell.getColor());
    }
    
    @Test
    public void stringCellEqualsTrue() {
        StringCell stringCell1 = new StringCell();
        StringCell stringCell2 = new StringCell();
        stringCell1.setValue("aaa");
        stringCell2.setValue("aaa");
        stringCell1.setColor(Cell.Color.YELLOW);
        stringCell2.setColor(Cell.Color.YELLOW);
        assertEquals(stringCell1, stringCell2);
    }

    @Test
    public void stringCellEqualsFalseForStringValue() {
        StringCell stringCell1 = new StringCell();
        StringCell stringCell2 = new StringCell();
        stringCell1.setValue("aaa");
        stringCell2.setValue("aba");
        stringCell1.setColor(Cell.Color.YELLOW);
        stringCell2.setColor(Cell.Color.YELLOW);
        assertNotEquals(stringCell1, stringCell2);
    }

    @Test
    public void stringCellEqualsFalseForColor() {
        StringCell stringCell1 = new StringCell();
        StringCell stringCell2 = new StringCell();
        stringCell1.setValue("aaa");
        stringCell2.setValue("aaa");
        stringCell1.setColor(Cell.Color.YELLOW);
        stringCell2.setColor(Cell.Color.RED);
        assertNotEquals(stringCell1, stringCell2);
    }

    @Test
    public void stringCellEqualsFalse() {
        StringCell stringCell1 = new StringCell();
        StringCell stringCell2 = new StringCell();
        stringCell1.setValue("aaa");
        stringCell2.setValue("ava");
        stringCell1.setColor(Cell.Color.YELLOW);
        stringCell2.setColor(Cell.Color.RED);
        assertNotEquals(stringCell1, stringCell2);
    }

    @Test
    public void stringCellHashcodesAreEqual() {
        StringCell stringCell1 = new StringCell();
        StringCell stringCell2 = new StringCell();
        stringCell1.setValue("aaa");
        stringCell2.setValue("aaa");
        stringCell1.setColor(Cell.Color.YELLOW);
        stringCell2.setColor(Cell.Color.YELLOW);
        assertEquals(stringCell1.hashCode(), stringCell2.hashCode());
    }

    @Test
    public void stringCellHashcodesAreNoteEqualForDifferentStringValue() {
        StringCell stringCell1 = new StringCell();
        StringCell stringCell2 = new StringCell();
        stringCell1.setValue("aaa");
        stringCell2.setValue("aba");
        stringCell1.setColor(Cell.Color.YELLOW);
        stringCell2.setColor(Cell.Color.YELLOW);
        assertNotEquals(stringCell1.hashCode(), stringCell2.hashCode());
    }

    @Test
    public void stringCellHashcodesAreNoteEqualForDifferentForColor() {
        StringCell stringCell1 = new StringCell();
        StringCell stringCell2 = new StringCell();
        stringCell1.setValue("aaa");
        stringCell2.setValue("aaa");
        stringCell1.setColor(Cell.Color.YELLOW);
        stringCell2.setColor(Cell.Color.RED);
        assertNotEquals(stringCell1.hashCode(), stringCell2.hashCode());
    }

    @Test
    public void stringCellHashcodesAreNoteEqualForDifferentStingValueAndDifferentColors() {
        StringCell stringCell1 = new StringCell();
        StringCell stringCell2 = new StringCell();
        stringCell1.setValue("aaa");
        stringCell2.setValue("ava");
        stringCell1.setColor(Cell.Color.YELLOW);
        stringCell2.setColor(Cell.Color.RED);
        assertNotEquals(stringCell1.hashCode(), stringCell2.hashCode());
    }
}