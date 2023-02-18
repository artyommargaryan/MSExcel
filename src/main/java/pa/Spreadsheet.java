package pa;

import java.util.HashMap;


public class Spreadsheet {
    private final HashMap<Integer, HashMap<Integer, Cell>> cells = new HashMap<>();
    private int rows;
    private int columns;

    public Spreadsheet(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        for (int i = 0; i < rows; i++) {
            cells.put(i, new HashMap<>());
        }
    }

    private void validateRow(int r) {
        if (isValidRow(r)) {
            throw new IllegalArgumentException("r: " + r);
        }
    }

    private boolean isValidRow(int r) {
        return r >= rows || r < 0;
    }

    private void validateColumn(int c) {
        if (isValidColumn(c)) {
            throw new IllegalArgumentException("c: " + c);
        }
    }

    private boolean isValidColumn(int c) {
        return c >= columns || c < 0;
    }

    public void setCellAt(int r, int c, Cell cl) {
        validateRow(r);
        validateColumn(c);
        cells.get(r).put(c, cl);
    }

    public void setCellAt(int r, int c, String cl) {
        validateRow(r);
        validateColumn(c);
        cells.get(r).put(c, new StringCell(cl));
    }

    public void setCellAt(int r, int c, int cl) {
        validateRow(r);
        validateColumn(c);
        cells.get(r).put(c, new IntCell(cl));
    }

    public void setCellAt(int r, int c, double cl) {
        validateRow(r);
        validateColumn(c);
        cells.get(r).put(c, new DoubleCell(cl));
    }

    public void setCellAt(int r, int c, Date cl) {
        validateRow(r);
        validateColumn(c);
        cells.get(r).put(c, new DateCell(cl));
    }

    public Cell getCellAt(int r, int c) {
        validateRow(r);
        validateColumn(c);
        return cells.get(r).get(c);
    }

    public int getRow() {
        return rows;
    }

    public int getColumn() {
        return columns;
    }

    public void addRow(int r) {
        validateRow(r);

        for (int i = rows - 1; i >= r + 1; --i) {
            cells.put(i + 1, cells.get(i));

        }
        cells.put(r + 1, new HashMap<>());
        ++rows;
    }

    public void removeRow(int r) {
        validateRow(r);
        for (int i = r; i < rows - 1; ++i) {
            cells.put(i, cells.get(i + 1));
        }
        --rows;
    }

    public void addColumn(int c) {
        validateColumn(c);
        HashMap<Integer, Cell> tmp;
        for (int i = 0; i < rows; ++i) {
            tmp = cells.get(i);
            for (int j = columns - 1; j >= c + 1; --j) {
                tmp.put(j + 1, tmp.get(j));
            }
        }
        ++columns;
    }


    public void removeColumn(int c) {
        validateColumn(c);

        HashMap<Integer, Cell> tmp;
        for (int i = 0; i < rows; ++i) {
            tmp = cells.get(i);
            for (int j = c; j < c - 1; ++j) {
                tmp.put(j, tmp.get(j + 1));
            }
        }
        --columns;
    }

    public void swapRows(int r1, int r2) {
        validateRow(r1);
        validateRow(r2);

        HashMap<Integer, Cell> tmp;
        tmp = cells.get(r1);
        cells.put(r1, cells.get(r2));
        cells.put(r2, tmp);
    }

    public void swapColumns(int c1, int c2) {
        validateColumn(c1);
        validateColumn(c2);

        HashMap<Integer, Cell> tmp;
        Cell tmpCell;
        for (int i = 0; i < rows; ++i) {
            tmp = cells.get(i);
            tmpCell = tmp.get(c1);
            tmp.put(c1, tmp.get(c2));
            tmp.put(c2, tmpCell);
        }
    }

    public Cell[] getRowAt(int i) {
        Cell[] row = new Cell[columns];
        HashMap<Integer, Cell> tmp = cells.get(i);
        for (int j = 0; j < columns; ++j) {
            row[j] = tmp.get(j);
        }
        return row;
    }

    public Cell[] getColumnsAt(int i) {
        Cell[] col = new Cell[rows];
        for (int j = 0; j < rows; ++j) {
            col[j] = cells.get(j).get(i);
        }

        return col;
    }
}