package pk.edu.pl.terminarz.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pk.edu.pl.model.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalTime;

public class ItemTest {
	private Item it;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		it = new Item();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		String start = "12:00";
		it.setStart(start);
		assertEquals(LocalTime.parse(start, DateTimeFormatter.ofPattern("HH:mm")), it.getStart());
	}

	@Test
	public void test2() {
		String end = "12:00";
		it.setEnd(end);
		assertEquals(LocalTime.parse(end, DateTimeFormatter.ofPattern("HH:mm")), it.getEnd());
	}

	@Test
	public void test3() {
		String dat = "01-01-2000";
		it.setDate(dat);
		assertEquals(LocalDate.parse(dat, DateTimeFormatter.ofPattern("dd-MM-yyyy")), it.getDate());
	}
	
	@Test
	public void test4() {
		String owner = "Jan Kowalski";
		it.setOwner(owner);
		assertEquals(owner, it.getOwner());
	}
	
	@Test
	public void test5() {
		String job = "Zrobić zakupy !!!!!";
		it.setJob(job);
		assertEquals(job, it.getJob());
	}
	
}
