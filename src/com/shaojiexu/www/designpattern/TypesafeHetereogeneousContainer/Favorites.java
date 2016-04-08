package com.shaojiexu.www.designpattern.TypesafeHetereogeneousContainer;

import java.util.HashMap;
import java.util.Map;

public class Favorites {

	private Map<Class<? extends Object>, Object> favorites = new HashMap<>();

	public <T> void setFavorite(Class<T> type, T thing) {
		if(type == null)
			throw new NullPointerException("Type is null");
		favorites.put(type, thing);
	}

	public <T> T getFavorite(Class<T> klass) {
		return klass.cast(favorites.get(klass));
	}

	public static void main(String[] args) {
		Favorites f = new Favorites();
		f.setFavorite(String.class, "Java");
		f.setFavorite(String.class, "Java1");
		f.setFavorite(Integer.class, 123456);
		f.setFavorite(Number.class, 9876L);
		String s = f.getFavorite(String.class);
		System.out.println(s);
		int i = f.getFavorite(Integer.class);
		System.out.println(i);
		long l = (long) f.getFavorite(Number.class);
		System.out.println(l);
	}

}
