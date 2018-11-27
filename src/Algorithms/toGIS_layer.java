package Algorithms;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import GIS.GIS_element;
import GIS.GIS_layer;
import GIS.Meta_data;

public class toGIS_layer implements GIS_layer {

	private Set<GIS_element> mySet;
	private Meta_data myMetaData;
	
	public toGIS_layer(Set<GIS_element> set) {
		this.mySet=set;
	}
	
	
	@Override
	public int size() {
		int size = mySet.size();
		return size;
	}

	@Override
	public boolean isEmpty() {
		return mySet.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return mySet.contains(o);
	}

	@Override
	public Iterator<GIS_element> iterator() {
		return mySet.iterator();
	}

	@Override
	public Object[] toArray() {
		return mySet.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return mySet.toArray(a);
	}

	@Override
	public boolean add(GIS_element e) {
		return mySet.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return mySet.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return mySet.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends GIS_element> c) {
		return mySet.addAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return mySet.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return mySet.removeAll(c);
	}

	@Override
	public void clear() {
		mySet.clear();
	}

	@Override
	//TODO:
	public Meta_data get_Meta_data() {
		return null;
	}

}
