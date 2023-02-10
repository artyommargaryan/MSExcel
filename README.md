# MSExcel
# Date Class
A simple implementation of a Date class in Java that contains a Day, Month, and Year component. The
class includes functionality to parse a String into a Date instance and to check if a given Day, Month, 
and Year are valid.

## Example Usage
To use the Date class, you can create an instance by passing in Day, Month, and Year objects:
```java
 Day day = new Day(25);
 Month month = Month.DECEMBER;
 Year year = new Year(2022);
 Date date = new Date(day, month, year);
```
You can also parse a String into a Date instance:
```java
String dateStr = "25 DECEMBER 2022";
Date date = Date.parseToDate(dateStr);
```
The Date class includes methods for accessing the Day, Month, and Year components of the date:
```java
Day day = date.getDay();
Month month = date.getMonth();
Year year = date.getYear();
```

## Implementation Details
The `Date` class consists of three components: ` Day`, `Month`, and `Year`. Each component is 
implemented as a separate class.

The `Day` class has an integer `day` and includes `toString()`, `equals()`, and `hashCode()` 
methods.

The `Month` enum contains the twelve months of the year and includes a `getValue()` method that 
returns the integer value of the month.

The `Year` class has an integer `year` and includes `toString()`, `equals()`, and `hashCode()` 
methods.

The `Date` class includes a `parseToDate()` method for parsing a `String` into a `Date` instance, 
and an `isValidDay()` method for checking if a given `Day`, `Month`, and `Year` are valid. The 
`isValidDay()` method uses the `isLeapYear()` method to determine if a given year is a leap 
year, which affects the number of days in the month of February.

The `Date` class includes `toString()`, `equals()`, and `hashCode()` methods for convenient 
output and comparison of `Date` instances.

# Cell Class

A simple Java class that represents a cell with a value and color.

## Properties

- `value` (`String`): The cell's value as a string.
- `color` (`Color`): The cell's color, one of the enumerated values in the `Color` inner class.

## Enumerated Type Color
An inner class of the `Cell` class, `Color` has four possible values:

- `WHITE`
- `GREEN`
- `YELLOW`
- `RED`

## Constructors

- `Cell()`: creates a new cell an empty `value` and `color` as `WHITE` .
- `Cell(value: String, color: Color)`: creates a new cell with the given `value` and `color`.

## Methods

- `setValue(String value)`: Set the cell's value as a string.
- `getValue()`: Return the cell's value as a string.
- `setColor(Color color)`: Set the cell's color to one of the values in the `Color` enumerated type.
- `getColor()`: Return the cell's color as a `Color` value. 
- `toInt()`: Convert the cell's value to an `int`. 
- `toDouble()`: Convert the cell's value to a `double`. 
- `toDate()`: Convert the cell's value to a `Date` object. 
- `reset()`: Reset the cell's value and color to the default values (empty string and `WHITE` color). 
- `equals(Object o)`: Check if two `Cell` objects are equal, based on their values and colors. 
- `hashCode()`: Return a hash code based on the `Cell` object's value and color.

## Example Usage
To use the Cell class, simply create an instance of the class and use the provided methods to access 
and modify its value and color. For example:

```java
Cell cell = new Cell();
cell.setValue("42");
cell.setColor(Color.GREEN);

System.out.println(cell.getValue()); // Outputs: 42
System.out.println(cell.getColor()); // Outputs: GREEN
```

# Spreadsheet Class

This is a Java class that implements a basic Spreadsheet with cells that can store values and colors.

## Class Structure

The class consists of the following attributes and methods:

- `cells`: a two-dimensional array of `Cell` objects.
- `rows`: an integer representing the number of rows in the Spreadsheet.
- `columns`: an integer representing the number of columns in the Spreadsheet.

## Constructor

The class has a constructor which takes two integer parameters `rows` and `columns` to initialize 
the size of the Spreadsheet. The constructor creates a new `Cell` object for each cell in the `cells` 
array. The `rows` and `columns` are set based on the parameters passed to the constructor.

## Validation Methods

The class has two validation methods `validateRow` and `validateColumn` which take a single 
integer parameter and check if it falls within the range of the number of rows and columns 
respectively. If the parameter is not valid, an `IllegalArgumentException` is thrown.

## Setter and Getter Methods

The class has methods to set and get the value and color of cells.

- `setCellAt`: a method that takes three parameters `r`, `c`, and either a `Cell` object or a 
`String` value. The method first calls the validation methods to check if the row and column
parameters are valid. The value and color of the cell at the specified location are then set based
on the parameters passed to this method.
- `getCellAt`: a method that takes two parameters `r` and `c` and returns the `Cell` object at 
the specified location. The method first calls the validation methods to check if the row and 
column parameters are valid.
- `getRow`: a method that returns the number of rows in the Spreadsheet.
- `getColumn`: a method that returns the number of columns in the Spreadsheet.

## Row and Column Management Methods

The class has methods to add and remove rows and columns to the Spreadsheet.

- `addRow`: a method that takes a single integer parameter `r` and adds a new row to the 
Spreadsheet after the specified row.
- `removeRow`: a method that takes a single integer parameter `r` and removes the specified row 
from the Spreadsheet.
- `addColumn`: a method that takes a single integer parameter `c` and adds a new column to the 
Spreadsheet after the specified column.
- `removeColumn`: a method that takes a single integer parameter `c` and removes the specified 
column from the Spreadsheet.

## Row and Column Swap Methods

The class has a methods to swap two rows or two columns in the Spreadsheet.

- `swapRows`: a method that takes two integer parameters `r1` and `r2` and swaps the two 
specified rows in the Spreadsheet.
- `swapColumns`: a method that takes two integer parameters `c1` and `c2` and swaps the two 
specified columns in the Spreadsheet.

## Example Usage

```java
Spreadsheet sheet = new Spreadsheet(10, 10);
sheet.setCellAt(0, 0, "Hello");
Cell cell = sheet.getCellAt(0, 0);
System.out.println(cell.getValue());// Outputs: Hello
```

This code creates a new Spreadsheet with 10 rows and 10 columns, sets the value of the cell at the 
first row and first column to "Hello", and retrieves the value of the cell to print it to the console.