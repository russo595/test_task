package ab.model;

import static java.util.Arrays.*;
import static org.junit.Assert.*;

import org.junit.Test;

import ab.v6.model.AddressBook;
import ab.v6.model.AddressRec;

public class AddressBookTest {
	
	@Test
	public void test_find(){
		
		AddressBook book = new AddressBook();
		
		AddressRec rec1 = new AddressRec("a", "b");
		AddressRec rec2 = new AddressRec("a", "c");
		AddressRec rec3 = new AddressRec("b", "c");
		
		book.add(rec1);
		book.add(rec2);
		book.add(rec3);
		
		assertEquals(asList(), book.find("d"));
		assertEquals(asList(rec1, rec2), book.find("a"));
		assertEquals(asList(rec1, rec3), book.find("b"));
		assertEquals(asList(rec2, rec3), book.find("c"));
	}
	
	
	@Test
	public void test_get(){
		
		AddressBook book = new AddressBook();
		
		String name = "someName";
		String adr = "someAdr";
		
		book.add(name, adr);
		
		assertEquals(null, book.get(-1));
		assertEquals(new AddressRec(name, adr), book.get(0));
		assertEquals(null, book.get(1));
		
	}

}
