## Prereqs

1. [Java SDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) 
1. [MySql Service](https://dev.mysql.com/downloads/installer/)


## Setup Instructions

1. Start MySQL
2. In Pom.XML modify the username/password to your MySQL Password
3. In intellij, right click on pom.xml, Maven -> Generate Sources and update folders
4. Retrieve google cloud credentials
   1. Save credentials in json fild
   2. Open intellij, Run -> Edit configurations
   3. Under program arguments, paste the following. Replace the file path with the path to your google cloud credentials:
      4. `-DGOOGLE_APPLICATION_CREDENTIALS='C:\Users\Vincent\Downloads\GOOGLE_CLOUD_CRED.json'`
