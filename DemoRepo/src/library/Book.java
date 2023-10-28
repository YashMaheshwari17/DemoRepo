package library;

import java.util.*;

public class Book {
	
	int id;
	String name;
	String author;
	String genre;
	
	Book(){
		
	}
	
	Book(int id, String name, String author, String genre)
	{
		this.id = id;
		this.name = name;
		this.author = author;
		this.genre = genre;
	}
	
	void displaybook() {
		System.out.println("--------------------------------------");
		System.out.println("ID: "+ this.id);
		System.out.println("Name: "+this.name);
		System.out.println("Author: "+this.author);
		System.out.println("Genre: "+ this.genre);
	}

}
