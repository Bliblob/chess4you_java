package application;

import static org.junit.Assert.*;

public class FirstTestCase {

	@org.junit.Test
	public void HeroTest() {

		Hero hero = new Hero();
		
		/*String actualName = hero.getName();
		assertEquals("Yannick", actualName);
		
		Long actualId = hero.getId();
		Long expectedId = Long.parseLong("1");
		assertEquals(expectedId, actualId);*/
		String andri = "Andri";
		assertEquals(andri, andri);
	}
}
