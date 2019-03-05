package application;

public class HeroesNotFoundException extends RuntimeException {

    HeroesNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
