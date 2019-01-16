String path = "data/special_events_list_datasd.csv";
String events = readFile(path);
String eventsHeader = readLine(path, 0);
int numEvents = 2542;
int numColumns = count(eventsHeader, ",") + 1;
//
int wholeNumberDataColIndex = 6;
String wholeNumberDataHeaderLabel = substring(eventsHeader, indexOfNth(eventsHeader, ",", 5)+1, indexOfNth(eventsHeader, ",", 6));
// For Exp Participants
int numericalDataColIndex = 10;
String numericalDataHeaderLabel = substring(eventsHeader, indexOfNth(eventsHeader, ",", 9)+1, indexOfNth(eventsHeader, ",", 10));
// For Latitude
int stringDataColIndex = 0;
String stringDataHeaderLabel = dataAtColumn(eventsHeader, stringDataColIndex);
// For Event Title
int nonNumericalAttendanceEventID = 51282;
//Row Index 50
int missingCoordEventID = 50928;
//Row Index 42
int numEventTypes = 7;
