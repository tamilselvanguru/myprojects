package junit;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
/*
 * Test comment
 */
@RunWith(Parameterized.class)
public class JunitParametarizedTest {

	private int number;
	private String name;

	public JunitParametarizedTest(int number, String name) {
		this.number = number;
		this.name = name;
	}

	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] { { 1, "Tamil" }, { 2, "Pranith" },
				{ 3, "Sangeetha" } });
	}

	@Test
	public void myTest() {
		System.out.println("No: " + number);
		System.out.println("Name: " + name);
	}

}
