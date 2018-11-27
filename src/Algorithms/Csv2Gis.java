package Algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import GIS.GIS_element;
import GIS.GIS_layer;

public class Csv2Gis {
	private static GIS_element myGISElement;
	private static ArrayList<String[]> myStringElements;
	private static GIS_layer myGISLayer;
	private static Set<GIS_element> mySet= new HashSet<>();
	
	
	public static GIS_element myGISelement (String[] s) {
		myGISElement = new toGIS_element(s);
		return myGISElement;
	}
	
	public static GIS_layer myGISlayer (GIS_element element) {
		myGISLayer = new toGIS_layer(mySet);
		myGISLayer.add(element);
		return myGISLayer;
	}
	
}
