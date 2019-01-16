Color grayscaleColor(Color c) {
  int grayLevel = (c.getRed() + c.getGreen() + c.getBlue())/3;
  return new Color(grayLevel, grayLevel, grayLevel);
}
Color blue = new Color(0, 0, 255);
Color blueColorExample1 = grayscaleColor(blue);
Color blueColorExample1Expect = new Color(85, 85, 85);

Color green = new Color(0, 150, 0);
Color greenColorExample2 = grayscaleColor(green);
Color greenColorExample2Expect = new Color(50, 50, 50);
//
Color[] grayscalePixels(Color[] originalPixels) {
  int size = originalPixels.length;
  Color[] newArray = new Color[size];
  for(int i = 0; i < size; i += 1) {
    newArray[i] = grayscaleColor(originalPixels[i]);
  }
  return newArray;
}
Color white = new Color(255, 255, 255);
Color[] colorArray1 = {white, white, white};
Color[] grayPixelsExample1 = grayscalePixels(colorArray1);
Color[] grayPixelsExample1Expect = {white, white, white};
Color violet = new Color(160, 32, 240);
Color[] colorArray2 = {violet, violet};
Color[] grayPixelsExample2 = grayscalePixels(colorArray2);
Color[] grayPixelsExample2Expect = {new Color(144, 144, 144), new Color(144, 144, 144)};
//
Image grayscale(Image original) {
  int width = original.getWidth();
  int height = original.getHeight();
  Color[] pixels = grayscalePixels(original.getPixels());
  return new Image(width, height, pixels);
}

Image greenChecker = readImage("image-files/checker5green.bmp");
Image grayExample1 = grayscale(greenChecker);

Image catDog = readImage("image-files/cute_cat_and_dog_3.jpg");
Image grayExample2 = grayscale(catDog);
//
Color complementColor(Color c) {
  int red = c.getRed();
  int blue = c.getBlue();
  int green = c.getGreen();
  return new Color(red, blue, green);
}

Color complementColorExample1 = complementColor(violet);
Color complementColorExample1Expect = new Color(160, 240, 32);

Color complementColorExample2 = complementColor(green);
Color complementColorExample2Expect = new Color(0, 0, 150);
//
Color[] complementPixels(Color[] originalPixels) {
  int size = originalPixels.length;
  Color[] newArray = new Color[size];
  for(int i = 0; i < size; i += 1) {
    newArray[i] = complementColor(originalPixels[i]);
  }
  return newArray;
}
Color[] complementPixelsExample1 = complementPixels(colorArray2);
Color[] complementPixelsExample1Expected = {new Color(160, 240, 32), new Color(160, 240, 32)};

Color turquoise = new Color(64, 224, 208);
Color[] colorArray3 = {turquoise, violet};
Color[] complementPixelsExample2 = complementPixels(colorArray3);
Color[] complementPixelsExample2Expected = {new Color(64, 208, 224), new Color(160, 240, 32)};
//
Image complement(Image original) {
  int width = original.getWidth();
  int height = original.getHeight();
  Color[] pixels = complementPixels(original.getPixels());
  return new Image(width, height, pixels);
}
Image complementExample1 = complement(greenChecker);
Image complementExample2 = complement(catDog);
//
Color chromascaleColor(Color c, Color target) {
  double ratio = ((c.getRed() + c.getGreen() + c.getBlue())/3);
  int redTarget = doubleToInt(ratio * target.getRed())/255;
  int greenTarget = doubleToInt(ratio * target.getGreen())/255;
  int blueTarget = doubleToInt(ratio * target.getBlue())/255;
  return new Color(redTarget, greenTarget, blueTarget);
}

Color chromascaleColorExample1 = chromascaleColor(turquoise, violet);
Color chromascaleColorExample1Expect = new Color(103, 20, 156);

Color chromascaleColorExample2 = chromascaleColor(violet, turquoise);
Color chromascaleColorExample2Expect = new Color(36, 126, 117);
//
Color[] chromascalePixels(Color[] originalPixels, Color target) {
  int size = originalPixels.length;
  Color[] newArray = new Color[size];
  for(int i = 0; i < size; i += 1) {
    newArray[i] = chromascaleColor(originalPixels[i], target);
  }
  return newArray;
}
Color[] colorArray4 = {turquoise, violet};
Color[] chromascalePixelsExample1 = chromascalePixels(colorArray4, blue);
Color[] chromascalePixelsExample1Expect = {new Color(0, 0, 165), new Color(0, 0, 144)};

Color[] chromascalePixelsExample2 = chromascalePixels(colorArray4, green);
Color[] chromascalePixelsExample2Expect = {new Color(0, 97, 0), new Color(0, 84, 0)};
//
Image chromascale(Image original, Color target) {
  int width = original.getWidth();
  int height = original.getHeight();
  Color[] pixels = chromascalePixels(original.getPixels(), target);
  return new Image(width, height, pixels);
}
Image chromascaleExample1 = chromascale(greenChecker, turquoise);
Image chromascaleExample2 = chromascale(catDog, violet);
//
Color gradientColor(Color color1, Color color2, double weightFor1){
  int redLevel1 = color1.getRed();
  int redLevel2 = color2.getRed();
  int redWeight = doubleToInt((redLevel1)*(weightFor1) + (redLevel2)*(1-weightFor1));
  int blueLevel1 = color1.getBlue();
  int blueLevel2 = color2.getBlue();
  int blueWeight = doubleToInt((blueLevel1)*(weightFor1) + (blueLevel2)*(1-weightFor1));
  int greenLevel1 = color1.getGreen();
  int greenLevel2 = color2.getGreen();
  int greenWeight = doubleToInt((greenLevel1)*(weightFor1) + (greenLevel2)*(1-weightFor1));
  return new Color(redWeight, greenWeight, blueWeight);
}
Color gradientColorExample1 = gradientColor(blue, white, 0.5);
Color gradientColorExample1Expect = new Color(0, 127, 75);

Color black = new Color(0,0,0);
Color gradientColorExample2 = gradientColor(black, white, 0.5);
//
Color[] gradientPixels(int numPixels, Color color1, Color color2){
  int size = numPixels;
  Color[] newArray = new Color[size];
  for(int i = 0; i < size; i += 1) {
    newArray[i] = gradientColor(color1, color2, 1 - (i*1.0)/size);
  }
  return newArray;
}
Color[] gradientPixelsExample1 = gradientPixels(3, black, white);
Color[] gradientPixelsExample1Expect = {new Color(0,0,0),new Color(85,85,85),new Color(170,170,170)};
Color[] gradientPixelsExample2 = gradientPixels(3, blue, white);
Color[] gradientPixelsExample2Expect = {new Color(0,0,255),new Color(85,85,255),new Color(170,170,255)};
//
Image gradient(int imageWidth, int imageHeight, Color color1, Color color2){
  int size = imageWidth*imageHeight;
  Color[] newArray = gradientPixels(size, color1, color2);
  return new Image(imageWidth, imageHeight, newArray);
}
Image gradientExample1 = gradient(1000, 1000, blue, white);
Image gradientExample2 = gradient(1000, 1000, green, black);
//
Color chromakeyColor(Color fgColor, Color bgColor, Color key, double threshold){
  Color chromakey;
    int redLevel1 = fgColor.getRed();
    int redLevel2 = key.getRed();
    int greenLevel1 = fgColor.getGreen();
    int greenLevel2 = key.getGreen();
    int blueLevel1 = fgColor.getBlue();
    int blueLevel2 = key.getBlue();
  double diff = (((redLevel1 - redLevel2)^2)+((greenLevel1 - greenLevel2)^2)+((blueLevel1 - blueLevel2)^2))/1000;
  if (diff >= threshold){
    chromakey = fgColor;
  }
  else {
    chromakey = bgColor;
  }
  return chromakey;
}
Color chromakeyColorExample1 = chromakeyColor(new Color(85,85,86), white, new Color(85,85,85), (0.0001) );
Color chromakeyColorExample1Expect = new Color(255,255,255);
Color chromakeyColorExample2 = chromakeyColor(white, black, new Color(0,0,1), 0.0001);
Color chromakeyColorExample2Expect = new Color(0,0,0);
//
Color[] chromakeyPixels(Color[] fgPixels, Color[] bgPixels, Color key, double threshold){
  int size = fgPixels.length;
  Color[] newArray = new Color[size];
  for(int i = 0; i < size; i += 1) {
    newArray[i] = chromakeyColor(fgPixels[i], bgPixels[i], key, threshold);
  }
  return newArray;
}
Color[] colorArray5 = {turquoise, black};
Color[] chromakeyPixelsExample1 = chromakeyPixels(gradientPixelsExample1, gradientPixelsExample2, new Color(85,85,85), 0.01);
Color[] chromakeyPixelsExample1Expect = {new Color(0,0,255),new Color(84,84,255),new Color(170, 170, 255)};
Color[] chromakeyPixelsExample2 = chromakeyPixels(chromascalePixelsExample1, gradientPixelsExample1, new Color(85,85,85), 0.01);
Color[] chromakeyPixelsExample2Expect = {new Color(0,0,0),new Color(84,84,84)};
//
Image chromakey(Image fg, Image bg, Color key, double threshold){
  int imgHeight = fg.getHeight();
  int imgWidth = fg.getWidth();
  Color[] pixelArray = chromakeyPixels(fg.getPixels(), bg.getPixels(), key, threshold);
  return new Image(imgWidth, imgHeight, pixelArray);
}
Image checker = readImage("image-files/checker5.bmp");
Image chromakeyExample1 = chromakey(checker, greenChecker, white, 0.5);
Image chromakeyExample2 = chromakey(greenChecker, checker, blue, 1);
