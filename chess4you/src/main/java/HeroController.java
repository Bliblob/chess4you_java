import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroController {

    private Gson gson;
    private Heroes heroes = new Heroes();

    public HeroController(){
        gson = new Gson();
    }

    @RequestMapping(method=GET,"/hero")
    public Hero getHero(@RequestParam(value="id") int id){

        return heroes.getHero(id);
    }

    @RequestMapping(method=GET, "/hero")
    public Hero getHero(){

        return heroes.getHeroes();
    }

    @RequestMapping(method=POST, "/hero")
    public void getHero(@RequestParam(value="name") String name){

        heroes.addHero(name);
    }
}
