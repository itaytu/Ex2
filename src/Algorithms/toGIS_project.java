package Algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import GIS.GIS_layer;
import GIS.GIS_project;
import GIS.Meta_data;

public class toGIS_project implements GIS_project {

	private Set<GIS_layer> myProject;
	
	public toGIS_project(Set<GIS_layer> layerToAdd) {
		this.myProject = layerToAdd;
	}
	
	@Override
	public int size() {
		return myProject.size(); 
	}

	@Override
	public boolean isEmpty() {
		return myProject.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return myProject.contains(o);
	}

	@Override
	public Iterator<GIS_layer> iterator() {
		return myProject.iterator();
	}

	@Override
	public Object[] toArray() {
		return myProject.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return myProject.toArray(a);
	}

	@Override
	public boolean add(GIS_layer e) {
		return myProject.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return myProject.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return myProject.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends GIS_layer> c) {
		return myProject.addAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return myProject.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return myProject.removeAll(c);
	}

	@Override
	public void clear() {
		myProject.clear();
	}

	@Override
	//TODO:
	public Meta_data get_Meta_data() {
		return null;
	}

}
