package Coords;

import Geom.Point3D;

public class MyCoords implements coords_converter {
	
	final double earthR = 6371000;
	
	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		double lonNorm = getLon(gps);
		double p1_x = gps.x() + (180/Math.PI)*(Math.asin(local_vector_in_meter.x()/earthR));
		double p1_y = gps.y() + (180/Math.PI)*(Math.asin(local_vector_in_meter.y()/(earthR*lonNorm)));
		double p1_z = gps.z() + local_vector_in_meter.z();
		Point3D newPoint = new Point3D(p1_x, p1_y, p1_z);
		return newPoint;	
	}

	
	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
		double lonNorm = getLon(gps0);
		double Dis_x = Math.sin((gps1.x()-gps0.x())*(Math.PI/180))*earthR;
		double Dis_y = Math.sin((gps1.y()-gps0.y())*(Math.PI/180))*lonNorm*earthR;
		double Dis_z = gps1.z()-gps0.z();
		double distance = Math.sqrt((Dis_x*Dis_x) + (Dis_y*Dis_y));
		return distance;
	}

	
	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		double lonNorm = getLon(gps0);
		double vec_X = Math.sin((gps1.x()-gps0.x())*(Math.PI/180))*earthR;
		double vec_Y = Math.sin((gps1.y()-gps0.y())*(Math.PI/180))*earthR*lonNorm;
		double vec_Z = gps1.z()-gps0.z();
		Point3D newVector = new Point3D(vec_X, vec_Y, vec_Z);
		return newVector;
	}

	
	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		double longps0 = Math.toRadians(gps0.y()); 
		double longps1 = Math.toRadians(gps1.y()); 
		double latgps0 = Math.toRadians(gps0.x()); 
		double latgps1 = Math.toRadians(gps1.x()); 
		double delta = longps1 - longps0;
		double left = Math.sin(delta)*Math.cos(latgps1);
		double right = Math.cos(latgps0)*Math.sin(latgps1)-Math.sin(latgps0)*Math.cos(latgps1)*Math.cos(delta);
		double	azimut = Math.atan2(left, right);
		//*distance*//
		double distance = distance3d(gps0,gps1);
		//*elevation*//
		azimut = Math.toDegrees(azimut);
		if(azimut<0) azimut+=360;
		double high = gps1.z() - gps0.z();
		double elevation = Math.toDegrees(Math.asin(high/distance));
		double arr[] = {azimut,elevation,distance};
		return arr;
	}

	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		return ((-180<=p.x() && p.x()<=180) &&
				(-90<=p.y() && p.y()<=90) && 
				(-450<=p.z() && p.z()<=9000));
	}
	
	private double getLon(Point3D point) {
		return Math.cos(point.x()*(Math.PI/180));
	}
}
