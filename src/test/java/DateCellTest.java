import org.junit.jupiter.api.Test;

import pa.Cell;
import pa.DateCell;
import pa.Date;
import pa.Date.*;

import static org.junit.jupiter.api.Assertions.*;

public class DateCellTest {
    @Test
    public void dateCellsSetValueThrowsExceptionIfArgumentCanNotBeParsedToDate() {
        DateCell dateCell = new DateCell();
        assertThrows(Exception.class, () -> dateCell.setValue("1.02.2023"));
    }

    @Test
    public void dateCellsGetStringValueForIntAndStringAreNotEqual() {
        DateCell dateCell = new DateCell();
        Date date = new Date(new Day(2), Month.DECEMBER, new Year(2022));
        dateCell.setValue(date.toString());
        assertNotEquals(date, dateCell.getStringValue());
    }

    @Test
    public void dateCellsGetStringValueForStringAndStringAreEqual() {
        DateCell dateCell = new DateCell();
        Date date = new Date(new Day(2), Month.DECEMBER, new Year(2022));
        dateCell.setValue(date.toString());
        assertEquals(date.toString(), dateCell.getStringValue());
    }

    @Test
    public void dateCellsGetStringValueForNull() {
        DateCell dateCell = new DateCell();
        dateCell.setValue((Date) null);
        assertEquals("", dateCell.getStringValue());
    }

    @Test
    public void dateCellsGetValue() {
        DateCell dateCell = new DateCell();
        Date date = new Date(new Day(2), Month.DECEMBER, new Year(2022));
        dateCell.setValue(date);
        assertEquals(date, dateCell.getValue());
    }

    @Test
    public void dateCellGetColor() {
        DateCell dateCell = new DateCell();
        assertEquals(Cell.Color.WHITE, dateCell.getColor());
        dateCell.setColor(Cell.Color.GREEN);
        assertEquals(Cell.Color.GREEN, dateCell.getColor());
        dateCell.setColor(Cell.Color.YELLOW);
        assertEquals(Cell.Color.YELLOW, dateCell.getColor());
        dateCell.setColor(Cell.Color.RED);
        assertEquals(Cell.Color.RED, dateCell.getColor());
    }

    @Test
    public void dateCellReset() {
        DateCell dateCell = new DateCell();
        Date date = new Date(new Day(2), Month.DECEMBER, new Year(2022));
        dateCell.setValue(date);
        dateCell.setColor(Cell.Color.RED);
        dateCell.reset();
        assertEquals("", dateCell.getStringValue());
        assertNull(dateCell.getValue());
        assertEquals(Cell.Color.WHITE, dateCell.getColor());
    }

    @Test
    public void dateCellEqualsTrue() {
        DateCell dateCell1 = new DateCell();
        DateCell dateCell2 = new DateCell();
        Date date1 = new Date(new Day(2), Month.DECEMBER, new Year(2022));
        Date date2 = new Date(new Day(2), Month.DECEMBER, new Year(2022));
        dateCell1.setValue(date1);
        dateCell2.setValue(date2);
        dateCell1.setColor(Cell.Color.YELLOW);
        dateCell2.setColor(Cell.Color.YELLOW);
        assertEquals(dateCell1, dateCell2);
    }

    @Test
    public void dateCellEqualsFalseForDateValue() {
        DateCell dateCell1 = new DateCell();
        DateCell dateCell2 = new DateCell();
        Date date1 = new Date(new Day(2), Month.DECEMBER, new Year(2022));
        Date date2 = new Date(new Day(3), Month.DECEMBER, new Year(2022));
        dateCell1.setValue(date1);
        dateCell2.setValue(date2);
        dateCell1.setColor(Cell.Color.YELLOW);
        dateCell2.setColor(Cell.Color.YELLOW);
        assertNotEquals(dateCell1, dateCell2);
    }

    @Test
    public void dateCellEqualsFalseForColor() {
        DateCell dateCell1 = new DateCell();
        DateCell dateCell2 = new DateCell();
        Date date1 = new Date(new Day(2), Month.DECEMBER, new Year(2022));
        Date date2 = new Date(new Day(2), Month.DECEMBER, new Year(2022));
        dateCell1.setValue(date1);
        dateCell2.setValue(date2);
        dateCell1.setColor(Cell.Color.YELLOW);
        dateCell2.setColor(Cell.Color.RED);
        assertNotEquals(dateCell1, dateCell2);
    }

    @Test
    public void dateCellEqualsFalse() {
        DateCell dateCell1 = new DateCell();
        DateCell dateCell2 = new DateCell();
        Date date1 = new Date(new Day(2), Month.DECEMBER, new Year(2022));
        Date date2 = new Date(new Day(2), Month.MARCH, new Year(2022));
        dateCell1.setValue(date1);
        dateCell2.setValue(date2);
        dateCell1.setColor(Cell.Color.YELLOW);
        dateCell2.setColor(Cell.Color.RED);
        assertNotEquals(dateCell1, dateCell2);
    }

    @Test
    public void dateCellHashcodesAreEqual() {
        DateCell dateCell1 = new DateCell();
        DateCell dateCell2 = new DateCell();
        Date date1 = new Date(new Day(2), Month.DECEMBER, new Year(2022));
        Date date2 = new Date(new Day(2), Month.DECEMBER, new Year(2022));
        dateCell1.setValue(date1);
        dateCell2.setValue(date2);
        dateCell1.setColor(Cell.Color.YELLOW);
        dateCell2.setColor(Cell.Color.YELLOW);
        assertEquals(dateCell1.hashCode(), dateCell2.hashCode());
    }

    @Test
    public void dateCellHashcodesAreNoteEqualForDifferentDateValue() {
        DateCell dateCell1 = new DateCell();
        DateCell dateCell2 = new DateCell();
        Date date1 = new Date(new Day(2), Month.DECEMBER, new Year(2022));
        Date date2 = new Date(new Day(3), Month.DECEMBER, new Year(2022));
        dateCell1.setValue(date1);
        dateCell2.setValue(date2);
        dateCell1.setColor(Cell.Color.YELLOW);
        dateCell2.setColor(Cell.Color.YELLOW);
        assertNotEquals(dateCell1.hashCode(), dateCell2.hashCode());
    }

    @Test
    public void dateCellHashcodesAreNoteEqualForDifferentForColor() {
        DateCell dateCell1 = new DateCell();
        DateCell dateCell2 = new DateCell();
        Date date1 = new Date(new Day(2), Month.DECEMBER, new Year(2022));
        Date date2 = new Date(new Day(2), Month.DECEMBER, new Year(2022));
        dateCell1.setValue(date1);
        dateCell2.setValue(date2);
        dateCell1.setColor(Cell.Color.YELLOW);
        dateCell2.setColor(Cell.Color.RED);
        assertNotEquals(dateCell1.hashCode(), dateCell2.hashCode());
    }

    @Test
    public void dateCellHashcodesAreNoteEqualForDifferentDateValuesAndDifferentColors() {
        DateCell dateCell1 = new DateCell();
        DateCell dateCell2 = new DateCell();
        Date date1 = new Date(new Day(2), Month.DECEMBER, new Year(2022));
        Date date2 = new Date(new Day(2), Month.DECEMBER, new Year(2021));
        dateCell1.setValue(date1);
        dateCell2.setValue(date2);
        dateCell1.setColor(Cell.Color.YELLOW);
        dateCell2.setColor(Cell.Color.RED);
        assertNotEquals(dateCell1.hashCode(), dateCell2.hashCode());
    }
}
