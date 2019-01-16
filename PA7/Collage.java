import java.awt.Color;
import java.util.Arrays;

class Collage {
  public static void main(String[] args) {
    Image canvas1 = ImageLibRef.canvasProvided(400, 400, new Color(0, 255, 0));
    System.out.println("canvas1: " + canvas1.toString());
    Image checker200 = CSE8ALib.readImage("image-files/checker200.bmp");
    Image canvasTopLeft = ImageLibRef.overlayProvided(checker200, canvas1, 0, 0);
    Image checker200Red = ImageLibRef.chromascale(checker200, new Color(255, 0, 0));
    Image canvasTopRight = ImageLibRef.overlayProvided(checker200Red, canvasTopLeft, 200, 0);
    Image checker200Green = ImageLibRef.chromascale(checker200, new Color(0, 255, 0));
    Image canvasBottomLeft = ImageLibRef.overlayProvided(checker200Green, canvasTopRight, 0, 200);
    Image checker200Blue = ImageLibRef.chromascale(checker200, new Color(0, 0, 255));
    Image canvasBottomRight = ImageLibRef.overlayProvided(checker200Blue, canvasBottomLeft, 200, 200);
    CSE8ALib.explore(canvasBottomRight);
  }
}
