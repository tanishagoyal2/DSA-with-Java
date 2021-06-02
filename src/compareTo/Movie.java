package compareTo;

import java.util.*;

public class Movie{
	
	public double rating;
	public String name;
	int year;
	
	/*
	 * public int compareTo(Movie m){ return this.year-m.year; }
	 */
	Movie(double d,String name,int year){
		this.rating=d;
		this.name=name;
		this.year=year;
	}
	
	public static void main(String args[]) {
		ArrayList<Movie> al=new ArrayList<Movie>();
		al.add(new Movie(8.8,"abc",2015));
		al.add(new Movie(8.7,"abcx",2018));
		al.add(new Movie(8.9,"abcg",2009));
		al.add(new Movie(6.7,"abcy",2013));
		Collections.sort(al,new YearSorting());
		System.out.println("after sorting");
		for(Movie m:al) {
			System.out.println(m.name+"  "+m.rating+"  "+m.year);
		}
	}
}


class YearSorting implements Comparator<Movie>{
	public int compare(Movie m1,Movie m2) {
		return Integer.compare(m1.year,m2.year);
	}
}