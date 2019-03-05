package application;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class HeroesController {

    private final HeroesRepository repository;
    private final HeroesResourceAssembler assembler;

    HeroesController(HeroesRepository repository,
                     HeroesResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/heroes")
    Resources<Resource<Hero>> getAllHeroes() {
        List<Resource<Hero>> heroes =  repository.findAll().stream()
            .map(assembler::toResource)
                .collect(Collectors.toList());

        return new Resources<>(heroes,
                linkTo(methodOn(HeroesController.class).getAllHeroes()).withSelfRel());
    }

    @PostMapping("/heroes")
    Hero addHero(@RequestBody Hero hero){
        return repository.save(hero);
    }

    @GetMapping("/heroes/{id}")
    Resource<Hero> getHero(@PathVariable Long id){

        Hero hero =  repository.findById(id)
                .orElseThrow(()-> new HeroesNotFoundException(id));

        return assembler.toResource(hero);
    }

    @PutMapping("/heroes/{id}")
    Hero putHero(@RequestBody Hero newHero, @PathVariable Long id) {

        return repository.findById(id)
                .map(hero -> {
                    hero.setName(newHero.getName());
                    return repository.save(hero);
                })
                .orElseGet(()-> {
                    newHero.setId(id);
                    return repository.save(newHero);
                });
    }

    @DeleteMapping("heroes/{id}")
    void deleteHero(@PathVariable Long id){
        repository.deleteById(id);
    }
}
