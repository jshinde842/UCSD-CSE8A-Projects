class Sound {
  //Field that contains the samples in this Sound.
  private final int[] samples;
  //Constructor
  Sound(int[] samples){
    this.samples = samples;
  }
  //Returns the number of samples in this Sound.
  public int getNumSamples(){
    return this.samples.length;
  }
  //Returns the value (amplitude) of the sample at the given index.
  public int getSample(int index){
    return this.samples[index];
  }
  //Returns the samples array for this Sound.
  public int[] getSamples(){
    return this.samples;
  }
  //Produces a String representation of the Sound.
  public String toString(){
    String samplesRef = this.samples.toString();
    String s = samplesRef.substring(samplesRef.indexOf("@"));
    return "Sound[samples=" + "[" + this.samples.length + "]"+ s + "]";
  }
  //Returns a new Sound containing the samples from this Sound starting at index start (inclusive) and ending at index end (exclusive).
  public static Sound crop(Sound original, int start, int end){
    int arraySize = end - start;
    int[] croppedArray = new int[arraySize];
    for(int i = 0; i < arraySize; i += 1) {
      croppedArray[i] = original.getSample(start+i);
    }
    return new Sound(croppedArray);
  }
  //Returns a new Sound that has all the samples from the background sound, and starting at the provided index, has the values of the foreground sound added to the background.
  public static Sound mix(Sound background, Sound foreground, int index){
    int[] bgArray = background.getSamples();
    int[] fgArray = foreground.getSamples();
    int length = bgArray.length;
    int[] newArray = new int[length];
    for(int i = 0; i < length; i += 1){
      if(i < index || i >= index + fgArray.length){
        newArray[i] = bgArray[i];
      }
      else{
        newArray[i] = bgArray[i] + fgArray[i - index];
      }
    }
    Sound newSound = new Sound(newArray);
    return newSound;
  }
  //Returns a new Sound has the given number of samples all equal to 0.
  public static Sound silence(int numSamples){
    int[] newArray = new int[numSamples];
    for(int i = 0; i < numSamples; i += 1){
      newArray[i] = 0*i;
    }
    return new Sound(newArray);
  }
  //Returns a new Sound that has the original sound's samples scaled by the given ratio.
  public static Sound scaleVolume(Sound original, double ratio){
    int arrayLength = original.getNumSamples();
    int[] newArray = new int[arrayLength];
    for(int i = 0; i < arrayLength; i += 1){
      newArray[i] = (int)(ratio*original.getSample(i));
    }
    return new Sound(newArray);
  }
}
