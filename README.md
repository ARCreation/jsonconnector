# jsonconnector
JSON connection codes for android

JSON connector version 1.0 for android sdk over API 23.

Android sdk version over API 23 deprecated using org.apache.http connection code.

Re-work httppost on existing code to urlconnection.


* Example for your code

JSONConnector.connect_object(url_string, query_string);
-> For get JSONObject

JSONConnector.connect_array(url_string, query_string);
-> For get JSONArray

* Explain for url_string and query_string

If url equals http://www.xxx.com/test.php?name=hayden&value=1

-> url_string : http://www.xxx.com/test.php
-> query_string : name=hayden&value=1

Code -> JSONConnector.connect_object("http://www.xxx.com/test.php", "name=hayden&value=1");
