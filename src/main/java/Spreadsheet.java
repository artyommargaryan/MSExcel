public class Spreadsheet {
    private Cell[][] cells;
    private int rows;
    private int columns;

    public Spreadsheet(int rows, int columns) {
        cells = new Cell[rows][columns];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                cells[i][j] = new Cell();
            }
        }
        this.rows = rows;
        this.columns = columns;
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
        cells[r][c].setValue(cl.getValue());
        cells[r][c].setColor(cl.getColor());
    }

    public void setCellAt(int r, int c, String cl) {
        validateRow(r);
        validateColumn(c);
        cells[r][c].setValue(cl);
    }

    public Cell getCellAt(int r, int c) {
        validateRow(r);
        validateColumn(c);
        return cells[r][c];
    }

    public int getRow() {
        return rows;
    }

    public int getColumn() {
        return columns;
    }

    public void addRow(int r) {
        validateRow(r);

        Cell[][] tmp = new Cell[rows + 1][columns];
        int counter = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                tmp[i][j] = new Cell();
                if (i != (r + 1)) {
                    tmp[counter][j].setValue(cells[i][j].getValue());
                    tmp[counter][j].setColor(cells[i][j].getColor());
                }
            }
            counter++;
        }

        cells = tmp;
        rows += 1;
    }

    public void removeRow(int r) {
        validateRow(r);

        Cell[][] tmp = new Cell[rows - 1][columns];
        int counter = 0;
        for (int i = 0; i < rows; ++i) {
            if (i != r) {
                for (int j = 0; j < columns; ++j) {
                    tmp[counter][j] = new Cell();
                    tmp[counter][j].setValue(cells[i][j].getValue());
                    tmp[counter][j].setColor(cells[i][j].getColor());
                }
                counter++;
            }
        }

        cells = tmp;
        rows -= 1;
    }

    public void addColumn(int c) {
        validateColumn(c);

        Cell[][] tmp = new Cell[rows][columns + 1];
        int counter;
        for (int i = 0; i < rows; ++i) {
            counter = 0;
            for (int j = 0; j < columns; ++j) {
                tmp[i][j] = new Cell();
                if (j != c + 1) {
                    tmp[i][counter].setValue(cells[i][j].getValue());
                    tmp[i][counter].setColor(cells[i][j].getColor());
                }
                counter++;
            }
        }

        cells = tmp;
        columns += 1;
    }


    public void removeColumn(int c) {
        validateColumn(c);

        Cell[][] tmp = new Cell[rows][columns - 1];
        int counter;
        for (int i = 0; i < rows; ++i) {
            counter = 0;
            for (int j = 0; j < columns; ++j) {
                if (j != c) {
                    tmp[i][counter] = new Cell();
                    tmp[i][counter].setValue(cells[i][j].getValue());
                    tmp[i][counter].setColor(cells[i][j].getColor());
                    counter++;
                }
            }
        }

        cells = tmp;
        columns -= 1;
    }

    public void swapRows(int r1, int r2) {
        validateRow(r1);
        validateRow(r2);

        Cell tmp = new Cell();
        for (int i = 0; i < columns; ++i) {
            tmp.setValue(cells[r1][i].getValue());
            tmp.setColor(cells[r1][i].getColor());
            cells[r1][i].setValue(cells[r2][i].getValue());
            cells[r1][i].setColor(cells[r2][i].getColor());
            cells[r2][i].setValue(tmp.getValue());
            cells[r2][i].setColor(tmp.getColor());
        }
    }

    public void swapColumns(int c1, int c2) {
        validateColumn(c1);
        validateColumn(c2);

        Cell tmp = new Cell();
        for (int i = 0; i < rows; ++i) {
            tmp.setValue(cells[i][c1].getValue());
            tmp.setColor(cells[i][c1].getColor());
            cells[i][c1].setValue(cells[i][c2].getValue());
            cells[i][c1].setColor(cells[i][c2].getColor());
            cells[i][c2].setValue(tmp.getValue());
            cells[i][c2].setColor(tmp.getColor());
        }

    }

    public Cell[] getRowAt(int i) {
        Cell[] row = new Cell[columns];
        for (int j = 0; j < columns; ++j) {
            row[j] = new Cell();
            row[j].setValue(cells[i][j].getValue());
            row[j].setColor(cells[i][j].getColor());

        }
        return row;
    }

    public Cell[] getColumnsAt(int i) {
        Cell[] col = new Cell[rows];
        for (int j = 0; j < rows; ++j) {
            col[j] = new Cell();
            col[j].setValue(cells[j][i].getValue());
            col[j].setColor(cells[j][i].getColor());
        }

        return col;
    }
}