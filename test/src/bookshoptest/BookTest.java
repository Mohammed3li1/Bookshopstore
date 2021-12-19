package bookshoptest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class BookTest {

	books Books;
	
	@Before
	
	public void before_test() {
		Books=new books(5,"SQL","Engineer Writer",250);
		System.out.println("the book information is true");
	}
	
			
	@Test
	public void test() {
		Assert.assertTrue(10>=Books.totalofbooks(10));
	}
	
	@After
	public void after_test() {
		System.out.println("All searches are completed");
		
	}

}