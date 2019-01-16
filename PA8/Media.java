import java.awt.Color;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.*;
import sound.*;
import image.*;

class Media {
/*
NOTE that a version of Media could use Sound, but we choose int[]
*/

  /**
   * Reads a file from the given path into a String. Produces an error if the
   * path does not exist or the file cannot be read.
   * 
   * @param path the path to read the file from
   * @return the contents as a String
   */
  public static String readFile(String path) {
    try {
      final Path filePath = Paths.get(path);
      final List<String> contents = Files.readAllLines(filePath);
      StringBuilder result = new StringBuilder();
      for(String s: contents) { result.append(s + "\n"); }
      return result.toString();
    }
    catch (IOException ioe) {
      throw new RuntimeException(ioe.toString());
    }
  }

  /**
   * Reads a file from the given path into an integer array, assuming the file
   * is an audio file. Always tries to read the file at a rate of 22050 Hz
   * 
   * @param path the path to read the file from
   * @return the sound as an array of samples of amplitudes
   */
  public static int[] readSound(String path) {
    SimpleSound sound = new SimpleSound(path);
    SoundSample[] ss = sound.getSamples();
    int rate = (int)sound.getSamplingRate();
    if(rate == 22050) {
      int[] samples = new int[ss.length];
      for(int i = 0; i < ss.length; i += 1) {
        samples[i] = ss[i].getValue();
      }
      return samples;
    }
    else if(rate == 44100) {
      int[] samples = new int[ss.length / 2];
      for(int i = 0; i < samples.length - 1; i += 2) {
        samples[i] = ss[i * 2].getValue();
      }
      return samples;
    }
    else {
      throw new RuntimeException("Unknown sampling rate from audio file: " + rate);
    }
  }

  /**
   * Reads a file from the given path into an Image object, assuming the file
   * is a png or bmp file.
   * 
   * @param path the path to read the image from
   * @return an Image object with pixels read from the given file
   */
  public static Image readImage(String path) {
    SimplePicture pic = new SimplePicture(path);
    Pixel[] pixels = pic.getPixels();
    Color[] colors = new Color[pixels.length];
    for (int i = 0; i < colors.length; i += 1) {
      colors[i] = new Color(pixels[i].getRed(), pixels[i].getGreen(), pixels[i].getBlue());
    }
    return new Image(pic.getWidth(), pic.getHeight(), colors);
  }

  /**
   * Opens an interactive explore window that interprets an integer array as an
   * array of samples of a sound.
   * 
   * @param sound the sound as an array of samples
   * @return always returns true
   */
  public static boolean explore(int[] sound) {
    new SimpleSound(sound).explore();
    return true;
  }

  /**
   * Opens an interactive explore window that interprets an Image object
   * as an image.
   * 
   * @param picture the Image object to explore
   * @return always returns true
   */
  public static boolean explore(Image picture) {
    SimplePicture picToExplore = new SimplePicture(picture.getWidth(), picture.getHeight());
    for (int i = 0; i < picture.size(); i += 1) {
      picToExplore.setBasicPixel(i % picture.getWidth() , i / picture.getWidth() , picture.getPixels()[i].getRGB());
    }
    picToExplore.explore();
    return true;
  }

  /**
   * Saves the given image in a file at the specified path. The given path is
   * created if it does not exist, and overwritten if it does exist.
   * 
   * @param picture the Image to save
   * @param destinationPath the path to save it at
   */
  static void saveImage(Image picture, String destinationPath) {
    SimplePicture pic = new SimplePicture(picture.getWidth(), picture.getHeight());
    for (int i = 0; i < picture.size(); i += 1) {
      pic.setBasicPixel(i % picture.getWidth() , i / picture.getWidth() , picture.getPixels()[i].getRGB());
    }
    pic.write(destinationPath);
  }

  /**
   * Saves the given sound in a file at the specified path. The given path is
   * created if it does not exist, and overwritten if it does exist.
   * 
   * @param sound the sound to save
   * @param destinationPath the path to save it at
   */
  static void saveSound(int[] sound, String destinationPath) {
    SimpleSound s = new SimpleSound(sound);
    s.write(destinationPath);
  }

}
