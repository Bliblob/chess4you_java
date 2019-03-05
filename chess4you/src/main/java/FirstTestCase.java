import static org.junit.Assert.*;

public class FirstTestCase {

	@org.junit.Test
	public void test() {
		Hero hero = new Hero();
		String name = hero.getName();
		assertEquals("Yannick", name);
	}

}
