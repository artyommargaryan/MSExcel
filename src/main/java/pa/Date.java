package pa;

import java.util.Objects;

public record Date(pa.Date.Day day, pa.Date.Month month, pa.Date.Year year) {
    public static class Day {
        int day;

        public Day(int day) {
            this.day = day;
        }

        @Override
        public String toString() {
            return Integer.toString(day);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (!(obj instanceof Day day)) {
                return false;
            }

            return this.day == day.day;
        }

        @Override
        public int hashCode() {
            return Objects.hash(day);
        }
    }

    public enum Month {
        JANUARY(1),
        FEBRUARY(2),
        MARCH(3),
        APRIL(4),
        MAY(5),
        JUNE(6),
        JULY(7),
        AUGUST(8),
        SEPTEMBER(9),
        OCTOBER(10),
        NOVEMBER(11),
        DECEMBER(12);

        private final int value;

        Month(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    public static class Year {

        private final int year;

        public Year(int year) {
            this.year = year;
        }

        @Override
        public String toString() {
            return Integer.toString(year);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (!(obj instanceof Year year)) {
                return false;
            }

            return this.year == year.year;
        }

        @Override
        public int hashCode() {
            return Objects.hash(year);
        }

    }

    public Date {
        if (!isValidDay(day, month, year)) {
            throw new IllegalArgumentException("Invalid day for given month and year");
        }
    }

    public static Date parseToDate(String value) {
        String[] parts = value.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid date format");
        }

        Day day = new Day(Integer.parseInt(parts[0]));
        String month1 = parts[1];
        Year year = new Year(Integer.parseInt(parts[2]));

        Month month = Month.JANUARY;
        for (Month mon : Month.values()) {
            if (Objects.equals(mon.toString(), month1)) {
                month = mon;
                break;
            }
        }

        if (!isValidDay(day, month, year)) {
            throw new IllegalArgumentException("Invalid day for given month and year");
        }

        return new Date(day, month, year);
    }

    private static boolean isValidDay(Day day, Month month, Year year) {
        int numDaysInMonth = switch (month) {
            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> 31;
            case APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30;
            case FEBRUARY -> (isLeapYear(year) ? 29 : 28);
        };
        return day.day >= 1 && day.day <= numDaysInMonth;
    }

    private static boolean isLeapYear(Year year) {
        if (year.year % 400 == 0) {
            return true;
        }
        if (year.year % 100 == 0) {
            return false;
        }
        return year.year % 4 == 0;
    }

    @Override
    public String toString() {
        return day.toString() + " " + month + " " + year.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Date date)) {
            return false;
        }

        return Objects.equals(year, date.year) && Objects.equals(month, date.month) && Objects.equals(day, date.day);
    }
}