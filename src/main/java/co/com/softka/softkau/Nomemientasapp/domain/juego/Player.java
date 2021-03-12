package co.com.softka.softkau.Nomemientasapp.domain.juego;

import co.com.sofka.domain.generic.Entity;
import co.com.softka.softkau.Nomemientasapp.domain.juego.values.valuesObjects.Capital;
import co.com.softka.softkau.Nomemientasapp.domain.juego.values.PlayerId;
import co.com.softka.softkau.Nomemientasapp.domain.juego.values.valuesObjects.Name;

public class Player extends Entity<PlayerId> {

    private final Name name;
    private Capital capital;


    public Player(PlayerId entityId, Name name, Capital capital) {
        super(entityId);
        this.name = name;
        this.capital = capital;
    }
}
