String CSELat = "32.8819";
String CSELong = "-117.2338";
String destData = readLine(path,destRow);
String destRowFirstCol = substring(destData,0,indexOfNth(destData,",",0));
String destLat = substring(destData,indexOfNth(destData,",",latColIndex - 1)+1,indexOfNth(destData,",",latColIndex));
String destLong = substring(destData,indexOfNth(destData,",",longColIndex - 1)+1,indexOfNth(destData,",",longColIndex));
String destLabel = substring(destData,indexOfNth(destData,",",labelColIndex-1)+1,indexOfNth(destData,",",labelColIndex));
