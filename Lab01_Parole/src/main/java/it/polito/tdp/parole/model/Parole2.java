package it.polito.tdp.parole.model;

import java.util.*;

public class Parole2 {
		
	ArrayList<String> parole;
	
	public Parole2() {

		parole = new ArrayList<>();
	}
	
	public void addParola(String p) {

		parole.add(p);
	}
	
	public class comp implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return o1.compareTo(o2);
		}
		
	}
	
	public List<String> getElenco() {
		
		Collections.sort(parole, new comp());
		
		return parole;
	}
	
	public void reset() {
	
		parole.clear();
	}
	
	public void eliminaParola(String p) {
		parole.remove(p);
	}

}
