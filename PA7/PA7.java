import java.awt.Color;
import java.util.Arrays;


class PA7 {
  public static void main(String[] args){
    Image checker200 = CSE8ALib.readImage("image-files/checker200.bmp");
    Image canvas2 = ImageLib.canvas(3,3, new Color(255,255,255));
    Image canvas1 = ImageLib.canvas(1000,1000, new Color(0,0,0));
    // scaleTo Example 1
    Image crane = CSE8ALib.readImage("image-files/crane.jpg");
    Image scaleToExample1 = ImageLib.scaleTo(crane, 1000, 1000);
    System.out.println(scaleToExample1);
    CSE8ALib.explore(scaleToExample1);
    // canvas Example 1
    Image canvasExample1 = ImageLib.canvas(1000, 1000, new Color(255, 0, 255));
    System.out.println(canvasExample1);
    CSE8ALib.explore(canvasExample1);
    // frame Example 1
    Image frameExample1 = ImageLib.frame(canvas1, 20, new Color(0,255,0));
    System.out.println(frameExample1);
    CSE8ALib.explore(frameExample1);
    // crop Example 1
    Image cropExample1 = ImageLib.crop(crane, 100, 400, 600, 600);
    System.out.println(cropExample1);
    CSE8ALib.explore(cropExample1);
    // overlay Example 1
    Image overlayExample1 = ImageLib.overlay(crane, canvas1, 30, 30);
    System.out.println(overlayExample1);
    CSE8ALib.explore(overlayExample1);
    // Task 3: Creating a Collage
    Image catDog = CSE8ALib.readImage("image-files/Cute_cat_and_dog_3.jpg");
    Image croppedCatDog = ImageLib.crop(catDog, 0, 0, 1770, 1600);
    Image scaledChecker200 = ImageLib.scaleTo(checker200, 500, 500);
    Image canvas3 = ImageLib.canvas(1910, 1070, new Color(255, 255, 255));
    Image framedCanvas3 = ImageLib.frame(canvas3, 10, new Color(0, 0, 0));
    Image graceHopper = CSE8ALib.readImage("image-files/grace-hopper.png");
    Image one = ImageLib.overlay(croppedCatDog, framedCanvas3, 0, 10);
    Image two = ImageLib.overlay(graceHopper, one, 700, 700);
    Image three = ImageLib.overlay(scaledChecker200, two, 1250, 450);
    Image myCollage = ImageLib.overlay(crane, three, 1700, 700);
    CSE8ALib.explore(myCollage);








  }
}
