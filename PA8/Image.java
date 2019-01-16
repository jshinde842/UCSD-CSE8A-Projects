import java.awt.Color;

class Image {

  private final int width;
  private final int height;
  private final Color[] pixels;

  /**
   * Constructor that creates an image with width-many pixels across,
   * height-many pixels down, and where the colors of the pixels are specified
   * by successive elements of the given array of Colors, starting at the
   * top-left corner and moving across (left to right) and then down.
   */
  Image(int width, int height, Color[] pixels) {
    this.width = width;
    this.height = height;
    this.pixels = pixels;
  }

  /**
   * @return a String representation of this Image.
   */
  public String toString() {
    int w = this.width;
    int h = this.height;
    String pixelRef = this.pixels.toString();
    String p = pixelRef.substring(pixelRef.indexOf("@"));
    return "Image[width=" + w + ",height=" + h + ",pixels=" + p + "]";
  }

  /**
   * @param col the column of the pixel to look up
   * @param row the row of the pixel to look up
   * @return the Color at the given location in the image
   */
  Color getColorAtPos(int col, int row) {
    return this.pixels[this.width*row + col];
  }

  /**
   * @return the width in pixels of this Image object
   */
  int getWidth() {
    return this.width;
  }

  /**
   * @return the height in pixels of this Image object
   */
  int getHeight() {
    return this.height;
  }

  /**
   * @return the array of Colors representing pixels in this Image object
   */
  Color[] getPixels() {
    return this.pixels;
  }

  /**
   * @return the number of pixels in this Image object
   */
  int size() {
    return pixels.length;
  }

}
