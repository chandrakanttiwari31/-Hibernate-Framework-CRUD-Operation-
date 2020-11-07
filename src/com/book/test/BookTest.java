package com.book.test;

import java.util.List;
import java.util.Scanner;

import com.book.dao.BookDao;
import com.book.dao.BookDaoImpl;
import com.book.pojo.Book;

public class BookTest {

	private static BookDao bookdao;

	public static void main(String[] args) {
		int bookId,ch ;
		boolean result;
		String bookName;
		double bookPrice;
		
		Book book=null;
		bookdao = new BookDaoImpl();
		Scanner sc=new Scanner(System.in);
		
		
		
		do
		{
			System.out.println("1 for  add ");
			System.out.println("2 for update ");
			System.out.println("3 for delete ");
			System.out.println("4 for get book");
			System.out.println("5 for get allbook");
			
			System.out.println("Enter Your Choice");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				book=new Book();
				System.out.println("Book Adding process");
				System.out.println("enter book name");
				book.setBookName(sc.next());
				
				System.out.println("Enter book price");
				book.setBookPrice(sc.nextDouble());
				
			result=bookdao.addbook(book);
				if(result)
					System.out.println("successfully add");
				else
					System.out.println("not added");
				
				break;
				
			case 2:
				System.out.println("Book Update process");
				System.out.println("enter the existing id which you want to update");
				book=new Book();
				book.setBookId(sc.nextInt());
				System.out.println("enter book name");
				book.setBookName(sc.next());
				System.out.println("enter book price");
				book.setBookPrice(sc.nextDouble());
				
				result=bookdao.updatebook(book);
				if(result)
					System.out.println("successfully update");
				else
					System.out.println("not updated");
				
				
				
				break;
				
			case 3:
				
				System.out.println("Book delete operation");
				book =new Book();
				System.out.println("enter book id which  you want to delete");
				book.setBookId(sc.nextInt());
				result=bookdao.deletebook(book);
				if(result)
					System.out.println("successfully deleted");
				else
					System.out.println("not not deleted");
				
				break;
			case 4:
				System.out.println("Get Book Detail");
				System.out.println("Enter Book Id which you want to get");
				book=bookdao.getbook(sc.nextInt());
				System.out.println(book);
				break;
			case 5:
				System.out.println("Show all book");
				List<Book> l = bookdao.getAllBook();
			if (!l.isEmpty()) {

				for (Book b : l) {

					System.out.println(b);
				}
			} else
				System.out.println(" Book List Is empty");
			break;
				
			
			
			
		default:
			System.out.println("Operations Done");
		}
		System.out.println("Do You Eant To Continue...If Yes Enter Y....:");
		ch = sc.next().charAt(0);
	} while (ch == 'y' || ch == 'Y');
	}

}
