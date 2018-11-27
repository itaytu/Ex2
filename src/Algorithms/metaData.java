package Algorithms;

import java.text.SimpleDateFormat;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import GIS.Meta_data;
import Geom.Point3D;


public class metaData implements Meta_data {

	String[] data;
	String[] elements;
	long date;
	static final Long duration = (long) ((120*60) * 1000);
	

	public metaData(String[] s,String[] element) {
		this.data=s;
		this.elements= element;
	}

	
	@Override
	public long getUTC() {
		int index = getTimeIndex(elements, "FirstSeen");
		String time = data[index]; 
		SimpleDateFormat df;
		if(time.contains("-")) df = new SimpleDateFormat("yyyy-dd-MM hh:mm:ss");
		else df = new SimpleDateFormat("yyyy/dd/MM hh:mm:ss");
		java.util.Date dt;
		try {
			dt = df.parse(time);
			Long l = dt.getTime()+duration;
			return l;
		} catch (ParseException | java.text.ParseException e) {
			e.printStackTrace();
		}                                      		
		return -1;
	}

	@Override
	public Point3D get_Orientation() {
		return null;
	}
	
	public String toString() {
		String meta="";
		meta+="MacAdress: " + data[0] + "\n";
		meta+="SSID: " + data[1] + "\n";
		meta+="Capabilites: " + data[2] + "\n";
		meta+="Channel: " + data[4] + "\n";
		meta+="RSSI: " + data[5] + "\n";
		meta+="Type: " + data[10] + "\n";
		return meta;
	}
	
	
	public int getTimeIndex(String[] Elements, String element) {
		int index=-1;
		for (int i = 0; i < Elements.length; i++) {
			if(Elements[i].equals(element)) return i;
		}
		return index;
	}

	

}
