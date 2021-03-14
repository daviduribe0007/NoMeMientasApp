package co.com.softka.softkau.nomemientasapp.domain.round;

import co.com.sofka.domain.generic.Entity;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.StageId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.valuesobjects.DiceFace;

import java.util.List;
import java.util.Set;

public class Stage extends Entity<StageId> {
    private final List<DiceFace> diceFacesVible;
    private final Set<toBet> betsPlayers;

    public Stage(StageId entityId, List<DiceFace> diceFacesVible, Set<toBet> betsPlayers) {
        super(entityId);
        this.diceFacesVible = diceFacesVible;
        this.betsPlayers = betsPlayers;
    }

    public  List<DiceFace> showDiceFaces(){
        return diceFacesVible;
    }
}
