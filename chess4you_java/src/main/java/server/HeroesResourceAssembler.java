package server;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@Component
public class HeroesResourceAssembler implements ResourceAssembler<Hero, Resource<Hero>> {

    @Override
    public Resource<Hero> toResource(Hero hero) {

        return new Resource<>(hero,
                linkTo(methodOn(HeroesController.class).getHero(hero.getId())).withSelfRel(),
                linkTo(methodOn(HeroesController.class).getAllHeroes()).withRel("hero"));
    }
}
