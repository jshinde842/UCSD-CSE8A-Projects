import java.util.Arrays;

class SoundOfData{
  public static Sound soundForRow(CSV csv,int rowIndex, Sound clip){
    int windVal = Integer.parseInt(csv.getData(rowIndex, 4));
    Sound scaledWind = Sound.scaleVolume(clip, windVal);
    return scaledWind;
  }
  public static Sound dataToSound(CSV csv, Sound clip){
    int size = clip.getNumSamples()*(csv.getNumRows()-1);
    int[] newArray = new int[size];
    Sound sound = new Sound(newArray);
    for(int i = 0; i < csv.getNumRows(); i += 1){
      Sound tempClip = SoundOfData.soundForRow(csv, i, clip);
      sound = Sound.mix(sound,tempClip, (i-1)*tempClip.getNumSamples());
    }
    return sound;
  }
  public static void main(String[] args){
    CSV cindyData = new CSV(Media.readFile("data/cindy.csv"));
    CSV leeData = new CSV(Media.readFile("data/lee.csv"));
    CSV irmaData = new CSV(Media.readFile("data/irma.csv"));
    int[] wind = Media.readSound("sounds/wind.wav");
    Sound windSound = new Sound(wind);
    //soundForRow Examples
    int[] soundArray1 = {2, 4, 6, 8, 10};
    Sound sound1 = new Sound(soundArray1);
    int[] soundArray2 = {5, 6, 7, 8, 9};
    Sound sound2 = new Sound(soundArray2);
    Sound soundForRow4 = SoundOfData.soundForRow(cindyData, 3, sound1);
    int[] soundForRow4Expect = {80, 160, 240, 320, 400};
    System.out.println("soundForRow4:        " +  soundForRow4);
    System.out.println("soundForRow4 expect: " + "Sound[samples=[5]@...]");
    System.out.println("soundForRow4 samples:        " + Arrays.toString(soundForRow4.getSamples()));
    System.out.println("soundForRow4 samples expect: " + Arrays.toString(soundForRow4Expect));
    Sound soundForRow10 = SoundOfData.soundForRow(irmaData, 9, sound2);
    int[] soundForRow10Expect = {550, 660, 770, 880, 990};
    System.out.println("soundForRow10:        " +  soundForRow10);
    System.out.println("soundForRow10 expect: " + "Sound[samples=[5]@...]");
    System.out.println("soundForRow10 samples:        " + Arrays.toString(soundForRow10.getSamples()));
    System.out.println("soundForRow10 samples expect: " + Arrays.toString(soundForRow10Expect));
    Sound windCrop = Sound.crop(windSound, 1300000, 1350000);
    int[] windCropArray = windCrop.getSamples();
    Sound soundForRow30 = SoundOfData.soundForRow(irmaData, 29, windCrop);
    int[] soundForRow30Array = soundForRow30.getSamples();
    Media.saveSound(soundForRow30Array, "sound/hurricane.wav");
    //DataToSound Examples
    CSV csv1 = new CSV("Date,Time,Lat,Long,Wind,Pressure\n Dec 5,02:00 GMT,21.3,-84.6,50,970");
    CSV csv2 = new CSV("Date,Time,Lat,Long,Wind,Pressure\n Dec 6,08:00 GMT,18.7,-89.3,55,967");
    System.out.println("csv1: "+csv1);
    System.out.println("csv2: "+csv2);
    int[] array1 = {1, 5, 20};
    Sound soundArray3 = new Sound(array1);
    Sound dataToSound1 = SoundOfData.dataToSound(csv1, new Sound(soundArray1));
    int[] dataToSound1Ex = {800, 2400, 4000};
    System.out.println("dataToSound1 expect: " + "Sound[samples=[3]@...]");
    System.out.println("dataToSound1 samples:        " + Arrays.toString(dataToSound1.getSamples()));
    System.out.println("dataToSound1 samples expect: " + Arrays.toString(dataToSound1Ex));

    int[] array2 = {1, 4, 7, 10, 13};
    Sound soundArray4 = new Sound(array2);
    Sound dataToSound2 = SoundOfData.dataToSound(csv2, new Sound(soundArray2));
    int[] dataToSound2Ex = {50,150};
    System.out.println("dataToSound2:        " + dataToSound2);
    System.out.println("dataToSound2 expect: " + "Sound[samples=[5]@...]");
    System.out.println("dataToSound2 samples:        " + Arrays.toString(dataToSound2.getSamples()));
    System.out.println("dataToSound2 samples expect: " + Arrays.toString(dataToSound2Ex));
  }
}
