package co.com.softka.softkau.nomemientasapp.domain.round;

import co.com.sofka.domain.generic.Entity;
import co.com.softka.softkau.nomemientasapp.domain.game.values.identities.PlayerId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.identities.StageId;
import co.com.softka.softkau.nomemientasapp.domain.round.values.valuesobjects.DiceFace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stage extends Entity<StageId> {
    private final List<DiceFace> diceFacesVible;
    private final Map<PlayerId, BetOnStage> betsOnStage;


    public Stage(StageId entityId, List<DiceFace> diceFacesVible) {
        super(entityId);
        this.diceFacesVible = new ArrayList<>();
        this.betsOnStage = new HashMap<>();

    }

    public void addDiceFaceVisible(DiceFace diceFace) {
        diceFacesVible.add(diceFace);
    }


    public void addBetsOnStage(PlayerId playerId, BetOnStage betOnStage) {
        this.betsOnStage.put(playerId, betOnStage);

    }

    public Map<PlayerId, BetOnStage> betsOnStage() {
        return betsOnStage;
    }

    public List<DiceFace> diceFacesVible() {
        return diceFacesVible;
    }
}
