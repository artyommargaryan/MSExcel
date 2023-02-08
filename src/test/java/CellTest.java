import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CellTest {
    @Test
    public void cellsGetValuesTestForIntAndString() {
        Cell cell = new Cell();
        cell.setValue(Integer.toString(1));
        assertNotEquals(1, cell.getValue());
    }

    @Test
    public void cellsGetValuesTestForStringAndString() {
        Cell cell = new Cell();
        cell.setValue(Integer.toString(1));
        assertEquals("1", cell.getValue());
    }

    @Test
    public void cellsGetValuesTestForDoubleAndString() {
        Cell cell = new Cell();
        cell.setValue(Double.toString(1.0));
        assertNotEquals(1.0, cell.getValue());
    }

    @Test
    public void cellsGetValuesTestForStringFromFromDoubleAndString() {
        Cell cell = new Cell();
        cell.setValue(Double.toString(1.0));
        assertEquals("1.0", cell.getValue());
    }

    @Test
    public void cellsGetValuesTestForDateAndString() {
        Cell cell = new Cell();
        Date date = new Date(new Date.Day(5), Date.Month.JANUARY, new Date.Year(1200));
        cell.setValue(date.toString());
        assertNotEquals(date, cell.getValue());
    }

    @Test
    public void cellsGetValuesTestForStringFromDateAndString() {
        Cell cell = new Cell();
        Date date = new Date(new Date.Day(5), Date.Month.JANUARY, new Date.Year(1200));
        cell.setValue(date.toString());
        assertEquals(date.toString(), cell.getValue());
    }

    @Test
    public void cellsToIntTest() {
        Cell cell = new Cell();
        cell.setValue(Integer.toString(1));
        assertEquals(1, cell.toInt());
    }

    @Test
    public void cellsToIntThrowsExceptionIfIsNotInt() {
        Cell cell = new Cell();
        cell.setValue("asd");
        assertThrows(Exception.class, () -> cell.toInt());
    }

    @Test
    public void cellsToDoubleTest() {
        Cell cell = new Cell();
        cell.setValue(Double.toString(1.0));
        assertEquals(1.0, cell.toDouble());
    }

    @Test
    public void cellsToDoubleThrowsExceptionIfIsNotDouble() {
        Cell cell = new Cell();
        cell.setValue("asd");
        assertThrows(Exception.class, () -> cell.toDouble());
    }

    @Test
    public void cellsToDateTest() {
        Cell cell = new Cell();
        Date date = new Date(new Date.Day(5), Date.Month.JANUARY, new Date.Year(2007));
        cell.setValue(date.toString());
        assertEquals(date, cell.toDate());
    }

    @Test
    public void cellsToDateThrowsExceptionIfIsNotDate() {
        Cell cell = new Cell();
        cell.setValue("asd");
        assertThrows(Exception.class, () -> cell.toDate());
    }

    @Test
    public void cellGetColorTest() {
        Cell cell = new Cell();
        assertEquals(Cell.Color.WHITE, cell.getColor());
        cell.setColor(Cell.Color.GREEN);
        assertEquals(Cell.Color.GREEN, cell.getColor());
        cell.setColor(Cell.Color.YELLOW);
        assertEquals(Cell.Color.YELLOW, cell.getColor());
        cell.setColor(Cell.Color.RED);
        assertEquals(Cell.Color.RED, cell.getColor());
    }

    @Test
    public void cellResetTest() {
        Cell cell = new Cell();
        cell.setValue("aaa");
        cell.setColor(Cell.Color.RED);
        cell.reset();
        assertEquals("", cell.getValue());
        assertEquals(Cell.Color.WHITE, cell.getColor());
    }
}
