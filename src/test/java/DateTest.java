import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateTest {
    @Test
    public void dateGetDayTest() {
        Date date1 = new Date(new Date.Day(6), Date.Month.APRIL, new Date.Year(2020));
        assertEquals(new Date.Day(6), date1.getDay());
    }

    @Test
    public void dateGetMonthTest() {
        Date date1 = new Date(new Date.Day(6), Date.Month.APRIL, new Date.Year(2020));
        assertEquals(Date.Month.APRIL, date1.getMonth());
    }

    @Test
    public void dateGetYearTest() {
        Date date1 = new Date(new Date.Day(6), Date.Month.APRIL, new Date.Year(2020));
        assertEquals(new Date.Year(2020), date1.getYear());
    }

    @Test
    public void dateParseToDateTest() {
        Date date1 = new Date(new Date.Day(6), Date.Month.APRIL, new Date.Year(2020));
        assertEquals(date1, Date.parseToDate(date1.toString()));
    }

    @Test
    public void dateParseToDateThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Date.parseToDate("32 JANUARY 2022"));
    }

    @Test
    public void dateEqualsTest() {
        Date date1 = new Date(new Date.Day(6), Date.Month.APRIL, new Date.Year(2020));
        Date date2 = new Date(new Date.Day(6), Date.Month.APRIL, new Date.Year(2020));

        assertEquals(date1, date2);
    }

    @Test
    public void dateHashCodeTest() {
        Date date1 = new Date(new Date.Day(6), Date.Month.APRIL, new Date.Year(2020));
        Date date2 = new Date(new Date.Day(6), Date.Month.APRIL, new Date.Year(2020));

        assertEquals(date1.hashCode(), date2.hashCode());
    }
}