import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	
	GradeBook gradeBook1;
	GradeBook gradeBook2;

	@BeforeEach
	void setUp() throws Exception {
		gradeBook1 = new GradeBook(5);
		gradeBook2 = new GradeBook(5);
		
		gradeBook1.addScore(88.3);
		gradeBook1.addScore(80.0);
		
		gradeBook2.addScore(73.6);
		gradeBook2.addScore(91.0);		
	}

	@AfterEach
	void tearDown() throws Exception {
		this.gradeBook1 = null;
		this.gradeBook2 = null;
	}

	@Test
	void testGetScoresSize() {
		assertEquals(gradeBook1.getScoresSize(), 2);
		assertEquals(gradeBook2.getScoresSize(), 2);
	}

	@Test
	void testToString() {
		assertEquals(gradeBook1.toString(), " 88.3 80.0");
		assertEquals(gradeBook2.toString(), " 73.6 91.0");
	}

	@Test
	void testAddScore() {
		boolean result1 = gradeBook1.addScore(100.0);
		assertTrue(result1);
		assertEquals(gradeBook1.toString(), " 88.3 80.0 100.0");
		
		boolean result2 = gradeBook2.addScore(32.4);
		assertTrue(result2);
		assertEquals(gradeBook2.toString(), " 73.6 91.0 32.4");
		
	}

	@Test
	void testSum() {
		assertEquals(gradeBook1.sum(), 168.3);
		assertEquals(gradeBook2.sum(), 164.6);
	}

	@Test
	void testMinimum() { 
		assertEquals(gradeBook1.minimum(), 80.0);
		assertEquals(gradeBook2.minimum(), 73.6);
	}

	@Test
	void testFinalScore() {
		assertEquals(Math.round(gradeBook1.finalScore()*10.0)/10.0, 88.3);
		assertEquals(Math.round(gradeBook2.finalScore()*10.0)/10.0, 91.0);
	}

}
