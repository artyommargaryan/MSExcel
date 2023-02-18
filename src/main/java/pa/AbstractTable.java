package pa;

public abstract class AbstractTable<T> {
    public int row;
    public int column;
    AbstractTable(int row, int column) {
        this.row = row;
        this.column = column;
    }
    public abstract void addRow();
    public abstract void addColum();
    public abstract void removeRow();
    public abstract void removeColumn();
    public abstract boolean validateRow();
    public abstract void setAt(int row, int column, T obj);
    public abstract int getRowsCount(int row);
    public abstract int getColumnsCount(int column);
    public abstract void swapRow(int row1, int row2);
    public abstract void swapColumn(int column1,int column2);
    protected void setRow(int row) {
        this.row = row;
    }
    protected void setColumn(int column) {
        this.column = column;
    }
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }

}
