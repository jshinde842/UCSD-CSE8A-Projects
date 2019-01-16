class CSV {
  private final String header;
  private final String[] rows;

  /**
   * Constructs a CSV object with rows created by splitting the given string on
   * newlines, and a header from the first row.
   */
  public CSV (String table) {
    this.rows = table.trim().split("\n", -1);
    this.header = this.rows[0];
  }

  /**
   * @return the number of rows in the table
   */
  public int getNumRows()  {
    return this.rows.length;
  }

  /**
   * @return the number of columns in the table
   */
  public int getNumCols() {
    return this.header.split(",", -1).length;
  }

  /**
   * @return the array of rows in the table
   */
  public String[] getRows() {
    return this.rows;
  }

  /**
   * @param rowIndex the index of the row to look up
   * @param colIndex the index of the column to look up
   * @return the data at the given row and column index in the table, as a String
   */
  public String getData(int rowIndex, int colIndex) {
    String[] parts = this.rows[rowIndex].split(",", -1);
    return parts[colIndex];
  }

  /**
   * @param rowIndex the index of the row to look up
   * @return the data in the given row as a String
   */
  public String getRow(int rowIndex) {
    return this.rows[rowIndex];
  }

  /**
   * Assuming that values at column colIndex are formatted as integers, returns
   * the maximum value among the data at the given column index across all rows
   * in this CSV object.
   * 
   * @param colIndex the index of the column to consider
   * @return the maximum value
   */
  public int maxInt(int colIndex) {
    int max = Integer.MIN_VALUE;
    for(int i = 1; i < rows.length; i += 1) {
      String data = this.getData(i,colIndex);
      int val = Integer.parseInt(data);
      if(max < val) {
        max = val;
      }
    }
    return max;
  }

  /**
   * Assuming that values at column colIndex are formatted as integers, returns
   * the maximum value among the data at the given column index across all rows
   * in this CSV object.
   * 
   * @param colIndex the index of the column to consider
   * @return the maximum value
   */
  public int minInt(int colIndex) {
    int min = Integer.MAX_VALUE;
    for(int i = 1; i < this.rows.length; i += 1) {
      String data = this.getData(i,colIndex);
      int val = Integer.parseInt(data);
      if(min > val) {
        min = val;
      }
    }
    return min;
  }

  /**
   * Assuming that values at column colIndex are formatted as doubles, returns
   * the maximum value among the data at the given column index across all rows
   * in this CSV object.
   * 
   * @param colIndex the index of the column to consider
   * @return the maximum value
   */
  public double maxDouble(int colIndex) {
    double max = Double.MIN_VALUE;
    for(int i = 1; i < rows.length; i += 1) {
      String data = this.getData(i,colIndex);
      double val = Double.parseDouble(data);
      if(max < val) {
        max = val;
      }
    }
    return max;
  }

  /**
   * Assuming that values at column colIndex are formatted as doubles, returns
   * the minimum value among the data at the given column index across all rows
   * in this CSV object.
   * 
   * @param colIndex the index of the column to consider
   * @return the minimum value
   */
  public double minDouble(int colIndex) {
    double min = Double.MAX_VALUE;
    for(int i = 1; i < rows.length; i += 1) {
      String data = this.getData(i,colIndex);
      double val = Double.parseDouble(data);
      if(min > val) {
        min = val;
      }
    }
    return min;
  }

  /**
   * @return a String representation of this CSV data
   */
  public String toString() {
    String rowsRef = this.rows.toString();
    String r = rowsRef.substring(rowsRef.indexOf("@"));
    return "CSV[header=\"" + this.header + "\",rows=" + r + "]";
  }
}
