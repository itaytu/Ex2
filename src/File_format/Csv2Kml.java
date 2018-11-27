package File_format;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import Algorithms.toGIS_element;
import Algorithms.toGIS_layer;

import java.util.Iterator;

import GIS.GIS_element;
import GIS.GIS_layer;

public class Csv2Kml {
	
	//private String csvfile;
	//private String output;
	
		private static toGIS_layer myLayer;
		private static toGIS_element myElement;
	
		public Csv2Kml(String csvFile, String output) {
		//	this.csvfile=csvFile;
		//	this.output=output;
			CSVreader.reader(csvFile);
			writeFileKML(csvFile,output);
		}
		
		
		public static void writeElement(toGIS_element element) {
			myElement= element;
		}
		
		public static void writeLayer(toGIS_layer layer) {
			myLayer= layer;
		}
		

		public static void writeFileKML(String inputAdress, String outputAdress) {	
			ArrayList<String> content =new ArrayList<String>();
			ArrayList<String[]> get=CSVreader.reader(inputAdress);
			Set<GIS_element> mySet = new HashSet<>();
			toGIS_layer myLayer = new toGIS_layer(mySet);
			for (int i = 0; i < get.size(); i++) {
				toGIS_element myElement = new toGIS_element(get.get(i));
				myLayer.add(myElement);
			}
			String kmlstart = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
					"<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n";
			String kmlduc = "<Document>";
			String kmlduce = "</Document>";
			String kmlend = "</kml>";
			content.add(kmlstart);
			content.add(kmlduc);

			try{
				FileWriter fw = new FileWriter(outputAdress);
				BufferedWriter bw = new BufferedWriter(fw);
				Iterator<GIS_element> iterator = myLayer.iterator(); 
				while(iterator.hasNext()) {
					toGIS_element tempElement = (toGIS_element) iterator.next();
					String kmlelement ="<Placemark>\n" +
							"<name>"+tempElement.getName()+"</name>\n" +
							"<description>\n" + tempElement.getData() +"\n" + "</description>\n" +
							"<Point>\n" +
							"<coordinates>" + tempElement.getPoint().get_x() + ","  
											+ tempElement.getPoint().get_y() +  "," 
											+ tempElement.getPoint().get_z() + "</coordinates>" +		
							"</Point>\n" +
							"</Placemark>\n";
					content.add(kmlelement);
				}
				content.add(kmlduce);
				content.add(kmlend);
				for (int i = 0; i < content.size(); i++) {
					bw.write(content.get(i));
				}
				bw.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		public static void main(String[] args) {
			String csvFile = "C:/Users/Itayt/eclipse-workspace/Ex2/OOP_EX2-EX4/OOP_EX2-Ex4/src/WigleWifi_20171201110209.csv";
			CSVreader.reader(csvFile);
			String output = "C:/Users/Itayt/one.kml";	
			writeFileKML(csvFile,output);
			
		}

}
