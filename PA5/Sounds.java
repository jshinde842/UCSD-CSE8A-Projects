int [] cos = cosineSound(220500, 200, 20);
int [] sine = sineSound(220500, 200, 20);
int [] coolWave = multiplySounds(cos, sine);
//
int [] sine2 = sineSound(220500, 150, 20);
int [] chord = addSounds(sine, sine2);
//
int [] soundA = readSound("sound-files/my-soundA.wav");
int [] soundB = readSound("sound-files/my-soundB.wav");
int [] soundACropped = crop(soundA, 1, 121715);
int [] soundBCropped = crop(soundB, 1, 121715);
int [] mySound = addSounds(soundACropped, soundBCropped);
