package library;

import java.util.*;

public class Customer {
	
	String name;
	String mobileNo;
	int booksIssued = 0;
	Book issuedBooks[] = new Book[3];
	Date issueDate[] = new Date[3];
	
	Customer(String name, String mobileNo)
	{
		this.name = name;
		this.mobileNo = mobileNo;
	}
	
	void display() {
		System.out.println("Name: "+ this.name);
		System.out.println("Mobile Number:"+ this.mobileNo);
		System.out.println("Books Issued: "+this.booksIssued);
		if(this.booksIssued == 0)
		{
			System.out.println(" ");
		}
		else {
			for(int i=0; i< this.booksIssued;i++)
			{
				Book t = this.issuedBooks[i];
				t.displaybook();
				System.out.println(this.issueDate[i]);
			}
		}
	}
	void addBook(Book b) {
		if(this.booksIssued == 3)
		{
			System.out.println("No more books can be issued. Maximum quantity reached!!");
		}
		else
		{
			Scanner inpOb = new Scanner(System.in);
			System.out.println("Enter the year in which issued: ");
			int year = inpOb.nextInt();
			
			System.out.println("Enter the month in which: ");
			int month = inpOb.nextInt();
			
			System.out.println("Enter the Date of the Month in which issued: ");
			int date = inpOb.nextInt();
			Date d = new Date(year-1900, month-1, date);
			this.issuedBooks[this.booksIssued] = b;
			this.issueDate[this.booksIssued++] = d;
		}	
	}
	
	Book[] removeTheElement(Book[] arr, int index)
    {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }
 
        Book[] anotherArray = new Book[arr.length - 1];
 
        for (int i = 0, k = 0; i < arr.length; i++) {
 
            if (i == index) {
                continue;
            }
 
            anotherArray[k++] = arr[i];
        }
 
        return anotherArray;
    }
	
	Date[] removeTheElement(Date[] arr, int index)
    {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }
 
        Date[] anotherArray = new Date[arr.length - 1];
 
        for (int i = 0, k = 0; i < arr.length; i++) {
 
            if (i == index) {
                continue;
            }
 
            anotherArray[k++] = arr[i];
        }
 
        return anotherArray;
    }
	

	
	void chargePenalty(int i) {
		int year, month, date;
		Scanner inpObj = new Scanner(System.in);
		System.out.println("Enter the current Year: ");
		year = inpObj.nextInt();
		
		System.out.println("Enter the current Month: ");
		month = inpObj.nextInt();
		
		System.out.println("Enter the current Date of the Month: ");
		date = inpObj.nextInt();
		
		Date d1 = new Date(year-1900, month-1, date);
		Date d2 = this.issueDate[i];
		
		System.out.println("Current Date is: "+ d1);
		System.out.println("Date: "+ d2);
		
		long difference = d1.getTime() - d2.getTime();
		float daysBetween = (difference / (1000*60*60*24));
		
		if(daysBetween>20)
		{
			
			System.out.println("Penalty Charged is: "+(daysBetween-20));
			System.out.println("\n--------------------------");
			/*
			System.out.println("Was the penalty paid ??");
			
			System.out.println("1. Yes\n2. No\nChoose one of the above");
			int choice;
			choice = inpObj.nextInt();
			if(choice == 1)
			{
				System.out.println("Book returned");
				this.issuedBooks = removeTheElement(this.issuedBooks, i); 
			}
			*/
		}
		this.issuedBooks = removeTheElement(this.issuedBooks, i);
		this.issueDate = removeTheElement(this.issueDate, i);
		this.booksIssued--;
		
	}
	
}
