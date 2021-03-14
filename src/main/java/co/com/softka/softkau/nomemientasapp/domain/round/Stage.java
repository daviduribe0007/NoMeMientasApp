package co.com.softka.softkau.nomemientasapp.domain.round;

import co.com.sofka.domain.generic.Entity;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.StageId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.valuesobjects.DiceFace;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Stage extends Entity<StageId> {
    private final List<DiceFace> diceFacesVible;


    public Stage(StageId entityId, List<DiceFace> diceFacesVible) {
        super(entityId);
        this.diceFacesVible = new ArrayList<>();

    }


    public void addDiceFaceVisible(DiceFace diceFace){
        diceFacesVible.add(diceFace);
    }

    public  List<DiceFace> showDiceFaces(){
        return diceFacesVible;
    }
}
