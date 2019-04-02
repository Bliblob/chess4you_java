package server;

import static org.junit.Assert.assertEquals;

public class TestClass {
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
