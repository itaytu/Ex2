package File_format;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Algorithms.toGIS_element;
import Algorithms.toGIS_layer;
import Algorithms.toGIS_project;
import GIS.GIS_element;
import GIS.GIS_layer;
import GIS.GIS_project;

public class MultiCSV {

	private static GIS_project myProject;
	private static ArrayList<String> myFiles;
	private static GIS_layer myLayer;
	//private static ArrayList<String[]> myElements;
	//private static GIS_element myElement;

	public static void main(String...args) throws IOException{
		String directoryPath = "C:\\Users\\Itayt\\eclipse-workspace\\Ex2\\OOP_EX2-EX4\\OOP_EX2-Ex4\\src";
		myProject =  parseForCsvFiles(directoryPath);
		ProjectToKML(myProject, "C:/Users/Itayt/newkml.kml");
	}

	//code from https://coderanch.com/t/544063/java/Finding-CSV-files-directory

	public static GIS_project parseForCsvFiles(String parentDirectory){
		myFiles = new ArrayList<>();
		File[] filesInDirectory = new File(parentDirectory).listFiles();
		for(File f : filesInDirectory){
			if(f.isDirectory()){
				parseForCsvFiles(f.getAbsolutePath());
			}
			String filePath = f.getAbsolutePath();
			String fileExtenstion = filePath.substring(filePath.lastIndexOf(".") + 1,filePath.length());
			if("csv".equals(fileExtenstion)){
				myFiles.add(filePath);
				//System.out.println("CSV file found -> " + filePath);
			}
		}  
		createProject(myFiles);
		return myProject;
	}

	public static void ProjectToKML(GIS_project myProject, String outputAdress) throws IOException {
		ArrayList<String> content =new ArrayList<String>();
		String kmlstart = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n";
		String kmlduc = "<Document>";
		String kmlduce = "</Document>";
		String kmlend = "</kml>";
		content.add(kmlstart);
		content.add(kmlduc);
		try {
			FileWriter fw = new FileWriter(outputAdress);
			BufferedWriter bw = new BufferedWriter(fw);
			Iterator<GIS_layer> layerIT = myProject.iterator(); 
			while(layerIT.hasNext()) {
				System.out.println("numoffiles");
				GIS_layer tempLayer = layerIT.next();
				Iterator<GIS_element> ElementIT = tempLayer.iterator();
				while(ElementIT.hasNext()) {
					System.out.println("numoflayers");
					toGIS_element tempElement = (toGIS_element) ElementIT.next();
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
					content.add(kmlduce);
					content.add(kmlend);
					for (int i = 0; i < content.size(); i++) {
						bw.write(content.get(i));
					}
					bw.close();
				} 
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}


	public static void createProject(ArrayList<String> myFiles) {
		Set<GIS_layer> project = new HashSet<>();
		myProject = new toGIS_project(project);
		Set<GIS_element> mySet = new HashSet<>();
		myLayer  = new toGIS_layer(mySet);
		for (int i = 0; i < myFiles.size(); i++) {
			ArrayList<String[]> tmp = CSVreader.reader(myFiles.get(i));
			for (int j = 0; j < tmp.size(); j++) {
				GIS_element tmpElement = new toGIS_element(tmp.get(i));
				myLayer.add(tmpElement);
			}
			myProject.add(myLayer);
			myLayer.clear();			
		}
	}


	public static ArrayList<String> getMyFiles() {
		return myFiles;
	}


}
