String path = "data/special_events_list_datasd.csv";
int latColIndex = 10;
int longColIndex = 11;
int typeColIndex = 2;
int attendColIndex = 5;
String row14Path = readLine(path, 14);
String csvTable = readFile(path);
//Method 1
boolean hasLat(String row14Path){
  String latitude = substring(row14Path, indexOfNth(row14Path, ",", 9)+1, indexOfNth(row14Path, ",", 10));
  boolean isLat = !stringEquals(latitude, "");
  return isLat;
}
boolean hasLat = hasLat(row14Path);

boolean isLat15 = hasLat(readLine(path, 15));
boolean isLat15Ex = true;

boolean isLat16 = hasLat(readLine(path, 16));
boolean isLat16Ex = true;

boolean isLat42 = hasLat(readLine(path, 42));
boolean isLat42Ex = false;
//Method 2
boolean hasLong(String row14Path){
  String longitude = substring(row14Path, indexOfNth(row14Path, ",", 10)+1, length(row14Path));
  boolean isLong = !stringEquals(longitude, "");
  return isLong;
}
boolean hasLong = hasLong(row14Path);

boolean isLong15 = hasLong(readLine(path, 15));
boolean isLong15Ex = true;

boolean isLong16 = hasLong(readLine(path, 16));
boolean isLong16Ex = true;

boolean isLong42 = hasLong(readLine(path, 42));
boolean isLong42Ex = false;
//Method(s) 3

//isNorthOf
double coordLatitude = 32.77171359;

boolean isNorthOf(String row14Path, double coordLatitude){
  String dataLatitude = dataAtColumn(row14Path, latColIndex);
  boolean isLatNorth = coordLatitude < parseDouble(dataLatitude);
  return isLatNorth;
}

boolean isNorthOf = isNorthOf(row14Path, coordLatitude);

String row17Path = readLine(path, 17);
boolean isNorth17 = isNorthOf(row17Path, coordLatitude);
boolean isNorth17Ex = true;

String row39Path = readLine(path, 39);
boolean isNorth39 = isNorthOf(row39Path, coordLatitude);
boolean isNorth39Ex = false;

String row40Path = readLine(path, 40);
boolean isNorth40 = isNorthOf(row40Path, coordLatitude);
boolean isNorth40Ex = false;

//isSouthOf
boolean isSouthOf(String row14Path, double coordLatitude){
  String dataLatitude1 = dataAtColumn(row14Path, latColIndex);
  boolean isLatSouth = coordLatitude > parseDouble(dataLatitude1);
  return isLatSouth;
}

boolean isSouthOf = isSouthOf(row14Path, coordLatitude);

String row17Path = readLine(path, 17);
boolean isSouth17 = isSouthOf(row17Path, coordLatitude);
boolean isSouth17Ex = false;

String row39Path = readLine(path, 39);
boolean isSouth39 = isSouthOf(row39Path, coordLatitude);
boolean isSouth39Ex = true;

String row40Path = readLine(path, 40);
boolean isSouth40 = isSouthOf(row40Path, coordLatitude);
boolean isSouth40Ex = true;

//isEastOf

double coordLongitude = -117.149901;

boolean isEastOf(String row14Path, double coordLongitude){
  String eastLong = substring(row14Path, indexOfNth(row14Path, ",", 10)+1, length(row14Path));
  boolean isLongEast = parseDouble(eastLong) > coordLongitude;
  return isLongEast;

}

boolean isEastOf = isEastOf(row14Path, coordLongitude);

String row17Path = readLine(path, 17);
boolean isEast17 = isEastOf(row17Path, coordLongitude);
boolean isEast17Ex = false;

String row39Path = readLine(path, 39);
boolean isEast39 = isEastOf(row39Path, coordLongitude);
boolean isEast39Ex = true;

String row40Path = readLine(path, 40);
boolean isEast40 = isEastOf(row40Path, coordLongitude);
boolean isEast40Ex = false;

//isWestOf

boolean isWestOf(String row14Path, double coordLatitude){
  String westLong = substring(row14Path, indexOfNth(row14Path, ",", 10)+1, length(row14Path));
  boolean isLongWest = parseDouble(westLong) < coordLatitude;
  return isLongWest;
}

boolean isWestOf = isWestOf(row14Path, coordLongitude);

String row17Path = readLine(path, 17);
boolean isWest17 = isWestOf(row17Path, coordLongitude);
boolean isWest17Ex = true;

String row39Path = readLine(path, 39);
boolean isWest39 = isWestOf(row39Path, coordLongitude);
boolean isWest39Ex = false;

String row40Path = readLine(path, 40);
boolean isWest40 = isWestOf(row40Path, coordLongitude);
boolean isWest40Ex = true;

//Method 4

boolean inBox(String row14Path, double SWLat, double SWLong, double NELat, double NELong){
  boolean isRowLessNE = isWestOf(row14Path, NELong) && isSouthOf(row14Path, NELat);
  boolean isRowMoreSW = isEastOf(row14Path, SWLong) && isNorthOf(row14Path, SWLat);
  boolean rowInBox = isRowLessNE && isRowMoreSW;
  return rowInBox;

}

//row308
double SWLat = 32.7328019;
double SWLong = -117.147906;
//row33
double NELat = 32.7477532;
double NELong = -117.0999832;


boolean inBox = inBox(row14Path, SWLat, SWLong, NELat, NELong);

boolean inBox17 = inBox(row17Path, SWLat, SWLong, NELat, NELong);
boolean inBox17Ex = false;

boolean inBox39 = inBox(row39Path, SWLat, SWLong, NELat, NELong);
boolean inBox39Ex = true;

boolean inBox40 = inBox(row40Path, SWLat, SWLong, NELat, NELong);
boolean inBox40Ex = false;

//
String givenEvent = "FARMERS";
boolean eventOfType(String row14Path, String givenEvent){
  String eventType = dataAtColumn(row14Path, typeColIndex);
  boolean isEventSame = stringEquals(eventType, givenEvent);
  return isEventSame;
}



boolean isEventSameTest14 = eventOfType(row14Path, givenEvent);
boolean isEventSameTest14Ex = true;

boolean isEventSameTest17 = eventOfType(row17Path, givenEvent);
boolean isEventSameTest17Ex = true;

String row31Path = readLine(path, 31);
boolean isEventSameTest31 = eventOfType(row31Path, givenEvent);
boolean isEventSameTest31Ex = false;

//

boolean hasNumAttend(String row14Path){
  String eventAttend = dataAtColumn(row14Path, attendColIndex);
  boolean isAttendNum = !stringEquals(eventAttend, "");
  return isAttendNum;
}


boolean is17AttendNum = hasNumAttend(row17Path);
boolean is17AttendNumEx = true;

boolean is39AttendNum = hasNumAttend(row39Path);
boolean is39AttendNumEx = true;

boolean is40AttendNum = hasNumAttend(row40Path);
boolean is40AttendNumEx = true;

//

String events = readFile(path);
String hasCoords = filter(filter(events, r -> hasLat(r)), r -> hasLong(r));
String UCSDEvents = filter(hasCoords, r -> inBox(r,32.8678,-117.2496,32.8938,-117.2238));
int numUCSDEvents = numRows(UCSDEvents)-1;
boolean drawMyTable = drawGeoTable(csvTable, 10);

//5a
String givenEventConcert = "CONCERTS";
String eventsWithLong = filter(events,r -> hasLong(r));
String eventsWithConcertAndLong = filter(eventsWithLong, r -> eventOfType(r, givenEventConcert));
double easternmostConcert = maxDouble(eventsWithConcertAndLong, longColIndex);

//5b
String givenEventConcert = "ATHLETIC";
String eventsWithLatitude = filter(events, r -> hasLat(r));
String northOfH8 = filter(eventsWithLatitude, r -> isNorthOf(r, 32.7263));
String northOfH8AndAthletic = filter(northOfH8, r -> eventOfType(r, givenEventConcert));
int numNorthOfH8AndAthletic = numRows(northOfH8AndAthletic);

String southOfH8 = filter(eventsWithLatitude, r -> isSouthOf(r, 32.7263));
String southOfH8AndAthletic = filter(southOfH8, r -> eventOfType(r, givenEventConcert));
int numSouthOfH8AndAthletic = numRows(southOfH8AndAthletic);

boolean moreNorthAthletics = numNorthOfH8AndAthletic > numSouthOfH8AndAthletic;


String inBalboa = filter(eventsWithLong, r -> hasLat(r));
String inBalboaWithLongLat = filter(inBalboa, r -> inBox(r, 32.7189, -117.1593, 32.7409, -117.1338));
int medRowAtBalboaFestivals = numColumns(inBalboaWithLongLat)/2;
String row1716Path = readLine(path, medRowAtBalboaFestivals);
int medAtBalboaFestivals = 2000;
