package application;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Hero {

    public @Id @GeneratedValue Long id;
    public String name;

    public Hero(){}
    public Hero(String name){
        this.name = name;
    }
}
