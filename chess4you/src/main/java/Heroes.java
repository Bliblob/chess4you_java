import java.util.ArrayList;

public class Heroes {

    private ArrayList<Hero> heroesList = new ArrayList<>();

    public void addHero(String name){

        heroesList.add(new Hero(heroesList.size() + 1, name));
    }

    public Hero getHero(int id){
        try {
            return heroesList.get(id);
        } catch (Exception e){
            return null;
        }
    }

    public ArrayList<Hero> getHeroes(){
        return  heroesList;
    }
}
