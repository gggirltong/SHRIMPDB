SHRIMPDB
===

Web application for managing and sharing geochronological data.  <br>
http://202.198.17.27/shrimpdb/home<br>

![SHRIMPDB](https://github.com/gggirltong/SHRIMPDB/blob/master/logo.png)   <br>
## Description of SHRIMPDB
Analytical method of zircon U-Pb age determination using the Sensitive High Resolution Ion Microprobe (SHRIMP) creates a new era in geochronological researches. The analytical data is precious for earth scientists. How to manage the data and make the data be reutilised by more scientists are two concern by earth scientists. SHRIMPDB is a database system for the advanced management and sharing of the data. This work was financially supported by National Science &Technology Infrastructure of Beijing SHRIMP Centre and National Science and Technology Support Program [2014BAK02B03] and the financial support from the National Major Scientific Instruments and Equipment Development Special Funds [2016YFF0103303].
## Screenshorts
* Homepage <br>
![Homepage](https://github.com/gggirltong/SHRIMPDB/blob/master/linkimages/figure%202.tif)

## Technique Overview
Java programing language combined with SpringMVC framework was used to construct the web application. Apache tomcat was selected as the webserver to offer communication with clients. HTML, CSS, JavaScript and JSP were utilized to generate dynamic page content.Cloud GIS API was used in the development of query methods. Many plug-ins including DataTables, echarts, inputfile, kindeeditor were adopted in the designation of the visualization of data

## Installation
#### Cloud hosting
visit http://202.198.17.27/shrimpdb/home<br>
creat individual account and use cloud based version
#### Self hosting
Install SHRIMPDB web application within your infrastructure:<br>
(make sure you have Apache Tomcat server and Mysql installed)<br>
* step 1  clone the SHRIMPDB respository into your own computer 
* step 2  put the shrimpdb folder in the path of webroot of Tomcat
* step 3  import the shrimpcenter.sql file into mysql database system
* step 4  open your tomcat service
* step 5  Open http://localhost:8080/shrimpdb in your browser. the 8080 is port number which is decided by the setting of your tomcat server
### Feedback
Please report any issues or feedback to Email(dyutong_he@163.com) at timeoff.management
