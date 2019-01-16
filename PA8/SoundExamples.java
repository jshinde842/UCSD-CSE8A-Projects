import java.util.Arrays;

class SoundExamples{
  public static void main(String[] args){
    Sound sound1 = new Sound(new int[] {3, 4, 5});
    Sound sound2 = new Sound(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
    Sound sound3 = new Sound(new int[] {1, 1, 1});
    // getNumSamples Example 1
    int getNumSamplesExample1 = sound1.getNumSamples();
    int getNumSamplesExample1Expect = 3;
    System.out.println("getNumSamplesExample1:        "+getNumSamplesExample1);
    System.out.println("getNumSamplesExample1 expect: "+getNumSamplesExample1Expect);
    //getNumSamples Example 2
    int getNumSamplesExample2 = sound2.getNumSamples();
    int getNumSamplesExample2Expect = 10;
    System.out.println("getNumSamplesExample2:        "+getNumSamplesExample2);
    System.out.println("getNumSamplesExample2 expect: "+getNumSamplesExample2Expect);
    //getSample Example 1
    int getSampleExample1 = sound2.getSample(5);
    int getSampleExample1Expect = 5;
    System.out.println("getSampleExample1:        "+getSampleExample1);
    System.out.println("getSampleExample1 expect: "+getSampleExample1Expect);
    //getSample Example 2
    int getSampleExample2 = sound2.getSample(9);
    int getSampleExample2Expect = 9;
    System.out.println("getSampleExample2:        "+getSampleExample2);
    System.out.println("getSampleExample2 expect: "+getSampleExample2Expect);
    //getSamples Example 1
    int[] getSamplesExample1 = sound1.getSamples();
    int[] getSamplesExample1Expect = {3, 4, 5};
    System.out.println("getSamplesExample1:         "+sound1.toString());
    System.out.println("getSamplesExample1 expect:  "+"Sound[samples=[3]@...]");
    System.out.println("getSamplesExample1 samples:        "+Arrays.toString(sound1.getSamples()));
    System.out.println("getSamplesExample1 samples expect: "+Arrays.toString(getSamplesExample1));
    //getSamples Example 2
    int[] getSamplesExample2 = sound2.getSamples();
    int[] getSamplesExample2SamplesExpect = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println("getSamplesExample2:         "+sound2.toString());
    System.out.println("getSamplesExample2 expect:  "+"Sound[samples=[10]@...]");
    System.out.println("getSamplesExample2 samples:        "+Arrays.toString(sound2.getSamples()));
    System.out.println("getSamplesExample2 samples expect: "+Arrays.toString(getSamplesExample2));
    //crop Example 1
    Sound cropExample1 = Sound.crop(sound1, 0, 1);
    int[] cropExample1SamplesExpect = {3};
    System.out.println("cropExample1:         "+cropExample1);
    System.out.println("cropExample1 expect:  "+"Sound[samples=[1]@...]");
    System.out.println("cropExample1 samples:        "+Arrays.toString(cropExample1.getSamples()));
    System.out.println("cropExample1 samples expect: "+Arrays.toString(cropExample1SamplesExpect));
    //crop Example 2
    Sound cropExample2 = Sound.crop(sound2, 0, 2);
    int[] cropExample2SamplesExpect = {0, 1};
    System.out.println("cropExample2:         "+cropExample2);
    System.out.println("cropExample2 expect:  "+"Sound[samples=[2]@...]");
    System.out.println("cropExample2 samples:        "+Arrays.toString(cropExample2.getSamples()));
    System.out.println("cropExample2 samples expect: "+Arrays.toString(cropExample2SamplesExpect));
    //mix Example 1
    Sound mixExample1 = Sound.mix(sound2, sound1, 0);
    int[] mixExample1SamplesExpect = {3, 5, 7, 3, 4, 5, 6, 7, 8, 9};
    System.out.println("mixExample1:         "+mixExample1);
    System.out.println("mixExample1 expect:  "+"Sound[samples=[10]@...]");
    System.out.println("mixExample1 samples:        "+Arrays.toString(mixExample1.getSamples()));
    System.out.println("mixExample1 samples expect: "+Arrays.toString(mixExample1SamplesExpect));
    //mix Example 2
    Sound mixExample2 = Sound.mix(sound2, sound3, 4);
    int[] mixExample2SamplesExpect = {0, 1, 2, 3, 5, 6, 7, 7, 8, 9};
    System.out.println("mixExample2:         "+mixExample2);
    System.out.println("mixExample2 expect:  "+"Sound[samples=[10]@...]");
    System.out.println("mixExample2 samples:        "+Arrays.toString(mixExample2.getSamples()));
    System.out.println("mixExample2 samples expect: "+Arrays.toString(mixExample2SamplesExpect));
    //silence Example 1
    Sound silenceExample1 = Sound.silence(3);
    int[] silenceExample1SamplesExpect = {0, 0, 0};
    System.out.println("silenceExample1:         "+silenceExample1);
    System.out.println("silenceExample1 expect:  "+"Sound[samples=[3]@...]");
    System.out.println("silenceExample1 samples:        "+Arrays.toString(silenceExample1.getSamples()));
    System.out.println("silenceExample1 samples expect: "+Arrays.toString(silenceExample1SamplesExpect));
    //silence Example 2
    Sound silenceExample2 = Sound.silence(6);
    int[] silenceExample2SamplesExpect = {0, 0, 0, 0, 0, 0};
    System.out.println("silenceExample2:         "+silenceExample2);
    System.out.println("silenceExample2 expect:  "+"Sound[samples=[6]@...]");
    System.out.println("silenceExample2 samples:        "+Arrays.toString(silenceExample2.getSamples()));
    System.out.println("silenceExample2 samples expect: "+Arrays.toString(silenceExample2SamplesExpect));
    //scaleVolume Example 1
    Sound scaleVolumeExample1 = Sound.scaleVolume(sound2, 0.5);
    int[] scaleVolumeExample1SamplesExpect = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4};
    System.out.println("scaleVolumeExample1:         "+scaleVolumeExample1);
    System.out.println("scaleVolumeExample1 expect:  "+"Sound[samples=[10]@...]");
    System.out.println("scaleVolumeExample1 samples:        "+Arrays.toString(scaleVolumeExample1.getSamples()));
    System.out.println("scaleVolumeExample1 samples expect: "+Arrays.toString(scaleVolumeExample1SamplesExpect));
    //scaleVolume Example 2
    Sound scaleVolumeExample2 = Sound.scaleVolume(sound1, 2);
    int[] scaleVolumeExample2SamplesExpect = {6, 8, 10};
    System.out.println("scaleVolumeExample2:         "+scaleVolumeExample2);
    System.out.println("scaleVolumeExample2 expect:  "+"Sound[samples=[3]@...]");
    System.out.println("scaleVolumeExample2 samples:        "+Arrays.toString(scaleVolumeExample2.getSamples()));
    System.out.println("scaleVolumeExample2 samples expect: "+Arrays.toString(scaleVolumeExample2SamplesExpect));
  }
}
