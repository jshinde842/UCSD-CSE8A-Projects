int lenSample = 20;
int [] array1 = {0, 1, 2, 3};
int [] array2 = {4, 5, 6, 7};
int [] array3 = {8, 9, 10};
int [] array4 = {12, 13, 14};
int [] array5 = {16, 17};
int [] array6 = {20, 21};
int [] cropArray = {2, 4, 7, 3, 67, 66, 65};
int [] volumeArray = {2, 4, 7, 3, 67, 66, 65};
// silence /////////////////////////////////////////////////////////////////////
int [] silence(int [] sound) {
  double factorForSilence = 0.0;
  int size = sound.length;
  int [] newArray = new int[size];
  for(int i = 0; i < size; i += 1) {
    newArray[i] = doubleToInt(sound[i] * factorForSilence);
  }
  return newArray;
}
int [] silenceArray1 = {1, 2, 3, 4};
int [] silence1 = silence(silenceArray1);
int [] silence1Ex = {0, 0, 0, 0};
int [] silenceArray2 = {5, 65, 76, 45, 43, 42};
int [] silence2 = silence(silenceArray2);
int [] silence2Ex = {0, 0, 0, 0, 0, 0};
int [] silenceArray3 = {98, 97, 65, 54, 32, 21, 12, 3};
int [] silence3 = silence(silenceArray3);
int [] silence3Ex = {0, 0, 0, 0, 0, 0, 0, 0};
// crop ////////////////////////////////////////////////////////////////////////
int [] crop(int [] sound, int startIndex, int endIndex) {
  int size = endIndex - startIndex;
  int [] newArray = new int[size];
  for(int i = 0; i < size; i += 1) {
    newArray[i] = sound[startIndex + i];
  }
  return newArray;
}
int [] crop1 = crop(cropArray, 0, 2);
int [] crop1Ex = {2, 4};
int [] crop2 = crop(cropArray, 0, 3);
int [] crop2Ex = {2, 4, 7};
int [] crop3 = crop(cropArray, 0, 4);
int [] crop3Ex = {2, 4, 7, 3};
// sineSound ///////////////////////////////////////////////////////////////////
int [] sineSound(int lenSample, int frequency, int amplitude) {
  int size = lenSample;
  int [] newArray = new int[size];
  for(int i = 0; i < size; i += 1) {
    newArray[i] = doubleToInt(sin(PI * 2 * frequency * i /22050) * amplitude);
  }
  return newArray;
}
 int [] sineSound1 = sineSound(lenSample, 100, 200);
 int [] sineSound1Ex = {0, 5, 11, 17, 22, 28, 34, 39, 45, 50, 56, 61, 67, 72, 77, 82, 88, 93, 98, 103};
 int [] sineSound2 = sineSound(lenSample, 150, 150);
 int [] sineSound2Ex = {0, 6, 12, 19, 25, 31, 38, 44, 50, 56, 62, 67, 73, 79, 84, 89, 94, 99, 104, 108};
 int [] sineSound3 = sineSound(lenSample, 200, 100);
 int [] sineSound3Ex = {0, 5, 11, 17, 22, 28, 33, 38, 44, 49, 53, 58, 63, 67, 71, 75, 79, 82, 85, 88};
// cosineSound /////////////////////////////////////////////////////////////////
int [] cosineSound(int lenSample, int frequency, int amplitude) {
  int size = lenSample;
  int [] newArray = new int[size];
  for(int i = 0; i < size; i += 1) {
    newArray[i] = doubleToInt(cos(PI * 2 * frequency * i /22050) * amplitude);
  }
  return newArray;
}
int [] cosineSound1 = cosineSound(lenSample, 100, 200);
int [] cosineSound1Ex = {200, 199, 199, 199, 198, 197, 197, 196, 194, 193, 191, 190, 188, 186, 184, 182, 179, 176, 174, 171};
int [] cosineSound2 = cosineSound(lenSample, 150, 150);
int [] cosineSound2Ex = {150, 149, 149, 148, 147, 146, 145, 143, 141, 139, 136, 133, 130, 127, 123, 120, 116, 112, 107, 103};
int [] cosineSound3 = cosineSound(lenSample, 200, 100);
int [] cosineSound3Ex = {100, 99, 99, 98, 97, 95, 94, 92, 89, 87, 84, 80, 77, 73, 69, 65, 61, 56, 51, 46};
// addSounds ///////////////////////////////////////////////////////////////////
int [] addSounds(int [] sound, int [] sound2) {
  int size = sound.length;
  int [] newArray = new int[size];
  for(int i = 0; i < size; i += 1) {
    newArray[i] = sound[i]+sound2[i];
  }
  return newArray;
}
int [] added1 = addSounds(array1, array2);
int [] added1Ex = {4, 6, 8, 10};
int [] added2 = addSounds(array3, array4);
int [] added2Ex = {20, 22, 24};
int [] added3 = addSounds(array5, array6);
int [] added3Ex = {36, 38};
// multiplySounds //////////////////////////////////////////////////////////////
int [] multiplySounds(int [] sound, int [] sound2) {
  int size = sound.length;
  int [] newArray = new int[size];
  for(int i = 0; i < size; i += 1) {
    newArray[i] = sound[i]+sound2[i];
  }
  return newArray;
}
int [] multiplied1 = multiplySounds(array1, array2);
int [] multiplied1Ex = {4, 6, 8, 10};
int [] multiplied2 = multiplySounds(array3, array4);
int [] multiplied2Ex = {20, 22, 24};
int [] multiplied3 = multiplySounds(array5, array6);
int [] multiplied3Ex = {36, 38};
// changeVolume ////////////////////////////////////////////////////////////////
int [] changeVolume(int [] sound, double factor) {
  int size = sound.length;
  int [] newArray = new int[size];
  for(int i = 0; i < size; i += 1) {
    newArray[i] = doubleToInt(sound[i] * factor);
  }
  return newArray;
}
int [] changedVolume1 = changeVolume(volumeArray, 0.5);
int [] changedVolume1Ex = {1, 2, 3, 1, 33, 33, 32};
int [] changedVolume2 = changeVolume(volumeArray, 2);
int [] changedVolume2Ex = {4, 8, 14, 6, 134, 132, 130};
int [] changedVolume3 = changeVolume(volumeArray, 10);
int [] changedVolume3Ex = {20, 40, 70, 30, 670, 660, 650};
