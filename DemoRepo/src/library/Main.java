package library;
import java.util.*;


public class Main {

	public static void main(String[] args) {
		
		Customer cstList[] = new Customer[1000];
		Book books[] = new Book[1000];
		int l=0;
		int m = 0;
		
		cstList[l++] = new Customer("Ravindra", "9846646545");
		
		books[m++] = new Book(1, "ADBMS", "Dr.Raghuram", "Educational");
		books[m++] = new Book(2, "Harry-Potter", "J.K.Rowling", "Fiction");
		books[m++] = new Book(3, "Alchemist", "Paulo-Coehlo", "Adventure");
		books[m++] = new Book(4, "Data-Structures", "Dr.Lydia_Jain", "Educational");
		books[m++] = new Book(5, "The_Last_Song", "Nicholas_Spark", "Drama");
		books[m++] = new Book(6, "Goosebumps", "R.L.Stine", "Horror");
		books[m++] = new Book(7, "Macbeth", "Shakespear", "Fiction");
		books[m++] = new Book(8, "Dictionary_of_Statistics", "Dr.Raghuram", "Educational");
		books[m++] = new Book(9, "The_ABC_Murders", "Agatha_Christe", "Crime/Fiction");
		books[m++] = new Book(10, "Crooked_House", "Agatha_Christe", "Crime/Fiction");
		

		loop: while(true)
		{
			System.out.println("----------------------------------");
			System.out.println("1. Issue a Book\n2. Return a book\n3. See all books\n4. Search a Book\n5. Details of all customers\n6. Add Customer\n7. Exit Program");
			Scanner inpObj= new Scanner(System.in);
			System.out.println("Enter your choice: ");
			int choice = inpObj.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter the name of the customer: ");
				String nme = inpObj.next();
				System.out.println("Enter mobile number of the customer: ");
				String num = inpObj.next();
				int flag = 0;
				for(int i=0; i<l; i++)
				{
					flag = 0;
					if(cstList[i].name.equals(nme) && cstList[i].mobileNo.equals(num))
					{
						Customer temp = cstList[i];
						System.out.println("Enter the id of the book to be issued: ");
						int tempId = inpObj.nextInt();
						Book b = new Book();
						for(int j=0; j<m; j++)
						{
							if(books[j].id == tempId)
								b = books[j];
						}
						temp.addBook(b);
						cstList[i] = temp;
						cstList[i].display();
						flag = 1;
					}
				
				}
				if(flag == 0)
				{
					System.out.println("Customer does not exist!!\nAdd the customer data");
					System.out.println("------------------------------------");
				}
				break;
			case 2:
				System.out.println("Enter the name of the customer: ");
				String nam = inpObj.next();
				System.out.println("Enter mobile number of the customer: ");
				String nu = inpObj.next();
				System.out.println("Enter the ID of the book to be returned: ");
				int tempID = inpObj.nextInt();
				for(int i =0; i<l; i++)
				{
					if(cstList[i].name.equals(nam) && cstList[i].mobileNo.equals(nu))
					{
						for(int j=0; j<cstList[i].booksIssued; j++)
						{
							if(cstList[i].issuedBooks[j].id == tempID)
							{
								cstList[i].chargePenalty(j);
							}
						}
					}
				}
				break;
			case 3:
				for(int i=0;i<m;i++)
				{
					books[i].displaybook();
				}
				break;
			case 4:
				System.out.println("1. By Name\n2. By Author\n3. By Genre");
				int choice1 = inpObj.nextInt();
				switch(choice1)
				{
				case 1:
					System.out.println("Enter the name of the book");
					String temp1 = inpObj.next();
					int f = 0;
					for(int i=0;i<m;i++)
					{
						if(books[i].name.equals(temp1))
						{
							books[i].displaybook();
							f = 1;
						}
						else
							continue;
					}
					
					if(f == 0)
						System.out.println("No Match Found");
					break;
				case 2:
					System.out.println("Enter the name of the Author");
					String temp2 = inpObj.next();
					f = 0;
					for(int i=0;i<m;i++)
					{
						if(books[i].author.equals(temp2))
						{
							books[i].displaybook();
							f = 1;
						}
						else
							continue;
					}
					
					if(f == 0)
						System.out.println("No Match Found");
					break;
				case 3:
					System.out.println("Enter the Genre of the book");
					String temp3 = inpObj.next();
					f = 0;
					for(int i=0;i<m;i++)
					{
						if(books[i].genre.equals(temp3))
						{
							books[i].displaybook();
							f = 1;
						}
						else
							continue;
					}
					
					if(f == 0)
						System.out.println("No Match Found");
				}
			
				break;
			case 5:
				for(int i=0; i<l; i++)
					cstList[i].display();
				break;
			case 6:
				System.out.println("Enter the name of the customer: ");
				String n = inpObj.next();
				System.out.println("Enter mobile number of the customer: ");
				String nm = inpObj.next();
				Customer cst = new Customer(n, nm);
				cstList[l] = cst;
				cstList[l].display();
				l++;
				System.out.println("Customer Added!!");
				break;
			case 7:
				System.out.println("Program Ended");
				break loop;
			default:
				System.out.println("Enter a valid choice!!");
			}	
		}
		
	}

}
