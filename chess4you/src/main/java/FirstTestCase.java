import static org.junit.Assert.*;

public class FirstTestCase {

	@org.junit.Test
	public void test1() {
		Hero hero = new Hero();
		
		String name = hero.getName();
		assertEquals("Yannick", name);
		
		int id = hero.getId();
		assertEquals(1, id);
	}
}
