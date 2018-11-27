package Algorithms;

import Coords.MyCoords;
import GIS.GIS_element;
import GIS.Meta_data;
import Geom.GeomElement;
import Geom.Geom_element;
import Geom.Point3D;

public class toGIS_element implements GIS_element{

	private String[] data;
	private String[] Elements;
	private MyCoords mycoords = new MyCoords();
	private Point3D myPoint;

	
	public toGIS_element(String[] s, String[] elements) {
		this.data = s;
		this.Elements = elements;
		myPoint = new Point3D(s,6,7,8);
	}
	
	public toGIS_element(String[] s) {
		this.data = s;
		myPoint = new Point3D(s,6,7,8);
	}

	@Override
	public Geom_element getGeom() {
		GeomElement G = new GeomElement(data);
		return G;
	}

	@Override
	public Meta_data getData() {
		metaData metadata = new metaData(data, Elements);
		return metadata;
	}
	
	/*public String getName() {
		int index = getElementIndex(Elements, "SSID");
		return data[index];
		}*/
	
	public String getName() {
		return data[1];
	}
	public Point3D getPoint() {
		return myPoint;
	}
	
	@Override
	public void translate(Point3D vec) {
		myPoint = mycoords.add(this.myPoint, vec);
	}
	
	public int getElementIndex(String[] Elements, String element) {
		int index=-1;
		for (int i = 0; i < Elements.length; i++) {
			if(Elements[i].equals(element)) return i;
		}
		return index;
	}


}
