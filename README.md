# Ex2-Ex4
OOP project for Geometric and Geographic points 

In this project we implemented a simple method to turn CSV files into Objects in java, containing Geometric, Giographic and other data 
(such as: Name, LastSeen, Type etc.). After turning the files into objects we used a method to turn those objects into KML files.

# Project Hierarchy
The Hierarchy of this project is as follows:
  1. A CSV file is turned into an ArrayList containing Arrays of Strings.
  2. Every row in the ArrayList(Every Array of Strings) is then converted into a GIS_element.
  3. After we finish creating all the GIS_elements from the ArrayList we create a GIS_layer containing a Set of GIS_element.
  4. After we finish scanning the CSV file, we scan for other CSV files (if wanted) and so on, and then we go over steps 1-3 again.
  5. When we finish Scanning for the CSV files we want (a folder containing a few CSV files for example) we create a GIS_project 
     containing a Set of GIS_layer.
  6. After we finish creating the GIS_project we can create a KML file containing all the relevant data we want in order to open the new
     file with Google Earth.

# How to use project
Short explanation on how to use the project:
 A) If only one CSV file is wanted use the following steps:
    1. open the mainTest class and create a String for the CSVfile directory path (for example: "C:/Folder_name/File_name.csv").
    2. Create a String for the new KML file output path as desired (for example: "C:/Desired_folder_name/new_file_name.kml").
    3. Use the function Csv2Kml.writeFileKML(CSVfile String, KMLfile String).
    
 B) If a few CSV files are desired use the Following steps:
    1. open the mainTest class and create a String for the folder directory path containing the CSV files 
    (for example: "C:/Folder_name").
    2. Create a String for the KML file output path as desired (for example: "C:/Desired_folder_name/new_file_name.kml").
    3. Create a new GIS_project and scan the folder by using the MultiCSV.parseForCsvFiles.
    3. Use the function MultiCSV.ProjectToKML to take the project and create a new KML file with the output path.
 
