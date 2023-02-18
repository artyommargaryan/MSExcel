import org.junit.jupiter.api.Test;
import pa.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SpreadsheetTest {
    @Test
    public void spreadsheetGetCellAtWithCell() {
        Spreadsheet spreadsheet = new Spreadsheet(4, 5);
        Cell cell = new IntCell();
        spreadsheet.setCellAt(0, 0, cell);
        assertEquals(cell.getStringValue(), spreadsheet.getCellAt(0, 0).getStringValue());
        assertEquals(cell.getColor(), spreadsheet.getCellAt(0, 0).getColor());
    }

    @Test
    public void spreadsheetGetCellAtWithCellShouldThrowExceptionIfRIsBiggerOrEqualThanRow() {
        Spreadsheet spreadsheet = new Spreadsheet(4, 5);
        Cell cell = new StringCell();
        assertThrows(IllegalArgumentException.class, () -> spreadsheet.setCellAt(5, 0, cell));
    }

    @Test
    public void spreadsheetGetCellAtWithCellShouldThrowExceptionIfRIsNegative() {
        Spreadsheet spreadsheet = new Spreadsheet(4, 5);
        Cell cell = new DoubleCell();
        assertThrows(IllegalArgumentException.class, () -> spreadsheet.setCellAt(-1, 3, cell));
    }


    @Test
    public void spreadsheetGetCellAtWithCellShouldThrowExceptionIfCIsBiggerOrEqualThanColumn() {
        Spreadsheet spreadsheet = new Spreadsheet(4, 5);
        Cell cell = new DateCell();
        assertThrows(IllegalArgumentException.class, () -> spreadsheet.setCellAt(5, 0, cell));
    }

    @Test
    public void spreadsheetGetCellAtWithCellShouldThrowExceptionIfCIsNegative() {
        Spreadsheet spreadsheet = new Spreadsheet(4, 5);
        Cell cell = new IntCell();
        assertThrows(IllegalArgumentException.class, () -> spreadsheet.setCellAt(3, -1, cell));
    }

    @Test
    public void spreadsheetGetCellAtWithString() {
        Spreadsheet spreadsheet = new Spreadsheet(4, 5);
        spreadsheet.setCellAt(0, 0, "aaa");
        assertEquals("aaa", spreadsheet.getCellAt(0, 0).getStringValue());
        assertEquals(Cell.Color.WHITE, spreadsheet.getCellAt(0, 0).getColor());
    }

    @Test
    public void spreadsheetGetCellAtWithStringShouldThrowExceptionIfRIsBiggerOrEqualThanRow() {
        Spreadsheet spreadsheet = new Spreadsheet(4, 5);
        assertThrows(IllegalArgumentException.class, () -> spreadsheet.setCellAt(5, 0, "aaa"));
    }

    @Test
    public void spreadsheetGetCellAtWithStringShouldThrowExceptionIfRIsNegative() {
        Spreadsheet spreadsheet = new Spreadsheet(4, 5);
        assertThrows(IllegalArgumentException.class, () -> spreadsheet.setCellAt(-1, 2, "aaa"));
    }

    @Test
    public void spreadsheetGetCellAtWithStringShouldThrowExceptionIfCIsBiggerOrEqualThanColumn() {
        Spreadsheet spreadsheet = new Spreadsheet(4, 5);
        assertThrows(IllegalArgumentException.class, () -> spreadsheet.setCellAt(2, 7, "aaa"));
    }

    @Test
    public void spreadsheetGetCellAtWithStringShouldThrowExceptionIfCIsNegative() {
        Spreadsheet spreadsheet = new Spreadsheet(4, 5);
        assertThrows(IllegalArgumentException.class, () -> spreadsheet.setCellAt(3, -1, "aaa"));
    }

    @Test
    public void spreadsheetAddRow() {
        Spreadsheet spreadsheet = new Spreadsheet(4, 5);
        spreadsheet.addRow(1);
        assertEquals(5, spreadsheet.getRow());
    }

    @Test
    public void spreadsheetRemoveRow() {
        Spreadsheet spreadsheet = new Spreadsheet(4, 5);
        spreadsheet.removeRow(1);
        assertEquals(3, spreadsheet.getRow());
    }

    @Test
    public void spreadsheetAddColumn() {
        Spreadsheet spreadsheet = new Spreadsheet(4, 5);
        spreadsheet.addColumn(1);
        assertEquals(6, spreadsheet.getColumn());
    }

    @Test
    public void spreadsheetRemoveColumn() {
        Spreadsheet spreadsheet = new Spreadsheet(4, 5);
        spreadsheet.removeColumn(1);
        assertEquals(4, spreadsheet.getColumn());
    }

    @Test
    public void spreadsheetSwapRows() {
        Spreadsheet spreadsheet = new Spreadsheet(2, 3);
        initializeSpreadsheet(spreadsheet);
        Cell[] cells1 = spreadsheet.getRowAt(0);
        Cell[] cells2 = spreadsheet.getRowAt(1);
        spreadsheet.swapRows(0, 1);
        Cell[] cells3 = spreadsheet.getRowAt(0);
        Cell[] cells4 = spreadsheet.getRowAt(1);
        assertArrayEquals(cells1, cells4);
        assertArrayEquals(cells2, cells3);
    }

    private void initializeSpreadsheet(Spreadsheet spreadsheet) {
        for (int i = 0; i < spreadsheet.getRow(); ++i) {
            for (int j = 0; j < spreadsheet.getColumn(); ++j) {
                spreadsheet.setCellAt(i, j, "" + i + j);
            }
        }
    }

    @Test
    public void spreadsheetSwapColumns() {
        Spreadsheet spreadsheet = new Spreadsheet(4, 5);
        initializeSpreadsheet(spreadsheet);
        Cell[] cells1 = spreadsheet.getColumnsAt(0);
        Cell[] cells2 = spreadsheet.getColumnsAt(1);
        spreadsheet.swapColumns(0, 1);
        Cell[] cells3 = spreadsheet.getColumnsAt(0);
        Cell[] cells4 = spreadsheet.getColumnsAt(1);
        assertArrayEquals(cells1, cells4);
        assertArrayEquals(cells2, cells3);
    }
}
