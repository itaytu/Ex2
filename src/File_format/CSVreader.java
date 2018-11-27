package File_format;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVreader {

	//private ArrayList<GIS_Object> myUsers;
	private static String []Elements;
	private static ArrayList<String[]> myData;
	//TODO:
	//private int width, length, rowIndex;

	public static ArrayList<String[]> reader(File file) {
		File newFile = new File(file.toString());
		String line = "";
		myData = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(newFile));
			br.readLine();
			String element = br.readLine();
			Elements= element.split(",");
			//System.out.println(Elements.toString());
			while((line = br.readLine() )!= null) {
				String [] lineDataDetails = line.split(",");
				myData.add(lineDataDetails);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("The file " + file.toString() + " wasn't found " + e);
		}
		return myData;
	}


	public static ArrayList<String[]> reader(String fileName) {
		
		File file = new File(fileName);
		String line = "";
		myData = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			br.readLine();
			String element = br.readLine();
			Elements= element.split(",");
			//System.out.println(Elements.toString());
			while((line = br.readLine() )!= null) {
				String [] lineDataDetails = line.split(",");
				myData.add(lineDataDetails);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("The file " + file.toString() + " wasn't found " + e);
		}
		return myData;
	}


	public String[] getElements() {
		return Elements;
	}
	
	
		
	public ArrayList<String[]> getMyData() {
		return myData;
	}



	/*	public static void main(String[] args) {

		String csvFile = "C:/Users/Itayt/eclipse-workspace/Ex2/OOP_EX2-EX4/OOP_EX2-Ex4/src/WigleWifi_20171201110209.csv";
		reader(csvFile);
		for (int i = 0; i < myData.size(); i++) {
			System.out.println(Arrays.toString(myData.get(i)));
		}
	}*/


}
