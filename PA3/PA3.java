String path = ("data/hurricanes/harvey.csv");
int colIndex = 4;
int latColIndex = 2;
int longColIndex = 3;
int radColIndex = 4;
String row14Path = readLine(path,14);


String commafy(String string1){
  String cSC = concat(",", concat(string1, ","));
  return cSC;
}

String jayshinde = commafy("jayshinde");
String jayshindeEx = ",jayshinde,";

String politz = commafy("politz");
String politzEx = ",politz,";

String EleanorRooseveltCollege = commafy("EleanorRooseveltCollege");
String EleanorRooseveltCollegeEx = ",EleanorRooseveltCollege,";


// #1
String harveyRow0 = readLine(path,0);
String katiaRow0 = readLine("data/hurricanes/katia.csv",0);
String donRow0 = readLine("data/hurricanes/don.csv",0);

int numColumns(String row14Path){
  return count(row14Path, ",") + 1;
}

int numColumns = numColumns(row14Path);

String harveyRow0 = readLine(path,0);
int colNumHarvey = numColumns(harveyRow0);
int colNumHarveyEx = 6;

String katiaRow0 = readLine("data/hurricanes/katia.csv",0);
int colNumKatia = numColumns(katiaRow0);
int colNumKatiaEx = 6;

String donRow0 = readLine("data/hurricanes/don.csv",0);
int colNumDon = numColumns(donRow0);
int colNumDonEx = 6;



// #2
String dataAtColumn(String row14Path, int colIndex) {
  return substring(row14Path, indexOfNth(row14Path, ",", colIndex - 1)+1, indexOfNth(row14Path, ",", colIndex));
}

String dataAtColumn = dataAtColumn(row14Path, colIndex);


String row20Path = readLine(path,20);
int colIndexDAC1 = 2;
String harveyColDAC = dataAtColumn(row20Path, colIndexDAC1);
String harveyColDACEx = "21.7";

String row21Path = readLine(path,21);
int colIndexDAC2 = 3;
String harveyColDAC2 = dataAtColumn(row21Path, colIndexDAC2);
String harveyColDAC2Ex = "-92.6";

String row22Path = readLine(path,22);
int colIndexDAC3 = 4;
String harveyColDAC3 = dataAtColumn(row22Path, colIndexDAC3);
String harveyColDAC3Ex = "40";



// #3
int intAtColumn(String row14Path, int colIndex){
String data = substring(row14Path, indexOfNth(row14Path, ",", colIndex - 1)+1, indexOfNth(row14Path, ",", colIndex));
  int integerIn = parseInt(data);
  return integerIn;
}

int intAtColumn = intAtColumn(row14Path, colIndex);

String row13Path = readLine(path,13);
int colIndexIAC1 = 4;
int harveyIAC1 = intAtColumn(row13Path, colIndexIAC1);
int harveyIAC1Ex = 40;

String row16Path = readLine(path,16);
int colIndexIAC2 = 4;
int harveyIAC2 = intAtColumn(row16Path, colIndexIAC2);
int harveyIAC2Ex = 35;

String row15Path = readLine(path,15);
int colIndexIAC3 = 4;
int harveyIAC3 = intAtColumn(row15Path, colIndexIAC3);
int harveyIAC3Ex = 35;



// #4
double doubleAtColumn(String row14Path, int colIndex){
  String sData = substring(row14Path, indexOfNth(row14Path, ",", colIndex - 1)+1, indexOfNth(row14Path, ",", colIndex));
  return parseDouble(sData);
}

double doubleAtColumn = doubleAtColumn(row14Path, colIndex);

String row30Path = readLine(path,30);
int colIndexDoubleAC1 = 4;
double harveyDoubleAC1 = doubleAtColumn(row30Path, colIndexDoubleAC1);
double harveyDoubleAC1Ex = 85.0;

String row31Path = readLine(path,31);
int colIndexDoubleAC2 = 4;
double harveyDoubleAC2 = doubleAtColumn(row31Path, colIndexDoubleAC2);
double harveyDoubleAC2Ex = 85.0;

String row32Path = readLine(path,32);
int colIndexDoubleAC3 = 4;
double harveyDoubleAC3 = doubleAtColumn(row32Path, colIndexDoubleAC3);
double harveyDoubleAC3Ex = 85.0;



// #5
double getLatitude(String row14Path){
  String lat = substring(row14Path, indexOfNth(row14Path, ",", latColIndex - 1)+1, indexOfNth(row14Path, ",", latColIndex));
  double latDouble = parseDouble(lat);
  return latDouble;
}

double getLatitude = getLatitude(row14Path);

String row40Path = readLine(path,40);
double harveyLat1 = getLatitude(row40Path);
double harveyLat1Ex = 26.3;

String row41Path = readLine(path,41);
double harveyLat2 = getLatitude(row41Path);
double harveyLat2Ex = 26.4;

String row42Path = readLine(path,42);
double harveyLat3 = getLatitude(row42Path);
double harveyLat3Ex = 26.5;


// #6
double getLongitude(String row14Path){
  String longi = substring(row14Path, indexOfNth(row14Path, ",", longColIndex - 1)+1, indexOfNth(row14Path, ",", longColIndex));
  double longDouble = parseDouble(longi);
  return longDouble;
}

double getLongitude = getLongitude(row14Path);

String row50Path = readLine(path,50);
double harveyLong1 = getLongitude(row50Path);
double harveyLong1Ex = -96.6;

String row51Path = readLine(path,51);
double harveyLong2 = getLongitude(row51Path);
double harveyLong2Ex = -96.7;

String row52Path = readLine(path,52);
double harveyLong3 = getLongitude(row52Path);
double harveyLong3Ex = -96.8;


// # 7
double radiusFromRow(String row14Path){
  String rData = substring(row14Path, indexOfNth(row14Path, ",", radColIndex - 1)+1, indexOfNth(row14Path, ",", radColIndex));
  double radOut = parseDouble(rData) * 20;
  return radOut;
}

double radiusFromRow = radiusFromRow(row14Path);

String row60Path = readLine(path,60);
double harveyRad1 = radiusFromRow(row60Path);
double harveyRad1Ex = 2200.0;

String row61Path = readLine(path,61);
double harveyRad2 = radiusFromRow(row61Path);
double harveyRad2Ex = 2000.0;

String row62Path = readLine(path,62);
double harveyRad3 = radiusFromRow(row62Path);
double harveyRad3Ex = 1800.0;
