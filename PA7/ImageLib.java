import java.awt.Color;
import java.util.Arrays;

class ImageLib {
  public static Color scaleColor(Image original, int col, int row, double widthFactor, double heightFactor){
    int originalCol = CSE8ALib.doubleToInt(col / widthFactor);
    int originalRow = CSE8ALib.doubleToInt(row / heightFactor);
    return original.getColorAtPos(originalCol, originalRow);
  }
  public static Color[] scalePixels(Image original, int width, int height, double widthFactor, double heightFactor){
    int size = width*height;
    Color[] newArray = new Color[size];
    for(int col = 0; col < width; col += 1){
      for(int row = 0; row < height; row += 1){
        newArray[width*row +col] = ImageLib.scaleColor(original, col, row, widthFactor, heightFactor);
      }
    }
    return newArray;
  }
  public static Image scale(Image original, double widthFactor, double heightFactor){
    int width = CSE8ALib.doubleToInt(original.getWidth()*widthFactor);
    int height = CSE8ALib.doubleToInt(original.getHeight()*heightFactor);
    Color[] pixels = ImageLib.scalePixels(original, width, height, widthFactor, heightFactor);
    return new Image(width, height, pixels);
  }
  public static Image scaleTo(Image original, int targetWidth, int targetHeight){
    int height = original.getHeight();
    double heightFactor = CSE8ALib.intToDouble(targetHeight) / height;
    int width = original.getWidth();
    double widthFactor = CSE8ALib.intToDouble(targetWidth) / width;
    return ImageLib.scale(original, widthFactor, heightFactor);
  }
  public static Image canvas(int width, int height, Color color ){
    int size = width * height;
    Color[] canvasArray = new Color[size];
    for(int i = 0; i < size; i += 1){
      canvasArray[i] = color;
    }
    return new Image(width, height, canvasArray);
  }
  public static Image frame(Image original, int thickness, Color color){
    int height = original.getHeight();
    int width = original.getWidth();
    Image canvas = ImageLib.canvas(width+(2*thickness), height+(2*thickness), color);
    System.out.println(canvas);
    System.out.println(original);
    int heightC = canvas.getHeight();
    int widthC = canvas.getWidth();
    int originalTopLeftX = (widthC/2) - (width/2);
    int originalTopLeftY = (heightC/2) - (height/2);
    System.out.println("topleftx " + originalTopLeftX);
    System.out.println("toplefty " + originalTopLeftY);
    Image framedImage = ImageLib.overlay(original, canvas, originalTopLeftX, originalTopLeftY);
    return framedImage;
  }
  public static Image crop(Image original, int topLeftCol, int topLeftRow, int bottomRightCol, int bottomRightRow){
    int height = original.getHeight();
    int width = original.getWidth();
    int croppedHeight = bottomRightRow - topLeftRow;
    int croppedWidth = bottomRightCol -  topLeftCol;
    Image canvasCrop = canvas(croppedWidth, croppedHeight, new Color(0, 0, 0));
    Color[] canvasArray = canvasCrop.getPixels();
    Color[] pixelsOriginal = original.getPixels();
    for(int row = topLeftRow; row < bottomRightRow ; row += 1){
      for(int col = topLeftCol; col < bottomRightCol; col += 1){
        int canvasPosRow = row - topLeftRow;
        int canvasPosCol = col - topLeftCol;
        canvasArray[(croppedWidth*canvasPosRow) + canvasPosCol] = original.getColorAtPos(col, row);
      }
    }
    return new Image(croppedWidth, croppedHeight, canvasArray);
  }
  public static Color overlayColor(Color[] fg, Color bg, int col, int row, int topLeftCol, int topLeftRow, int bottomRightCol, int bottomRightRow, int fgWidth) {
    if(col >= topLeftCol && col < bottomRightCol && row >= topLeftRow && row < bottomRightRow) {
      return fg[(row-topLeftRow)*fgWidth + (col-topLeftCol)];
    }
    else {
      return bg;
    }
  }
  public static Color[] overlayPixels(Color[] fg, Color[] bg, int width,int fgWidth, int height, int topLeftCol, int topLeftRow, int bottomRightCol, int bottomRightRow) {
     Color[] newPixels = new Color[bg.length];
     for(int col = 0; col < width; col += 1) {
       for(int row = 0; row < height; row += 1) {
         newPixels[row * width + col] = ImageLib.overlayColor(fg, bg[row * width + col], col, row, topLeftCol, topLeftRow, bottomRightCol, bottomRightRow, fgWidth);
       }
     }
     return newPixels;
  }
  public static Image overlay(Image fg, Image bg, int topLeftCol, int topLeftRow) {
    int bottomRightCol = fg.getWidth() + topLeftCol;
    int bottomRightRow = fg.getHeight() + topLeftRow;
    int width = bg.getWidth();
    int height = bg.getHeight();
    int fgWidth = fg.getWidth();
    Color[] newPixels = ImageLib.overlayPixels(fg.getPixels(), bg.getPixels(), width, fgWidth, height, topLeftCol, topLeftRow, bottomRightCol, bottomRightRow);
  return new Image(width, height, newPixels);
  }
}
