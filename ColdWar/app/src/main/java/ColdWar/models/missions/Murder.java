/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.models.missions;

import ColdWar.models.ApplicationInstance;
import ColdWar.models.player.IPlayer;
import java.util.Random;

/**
 * Murder mission.
 * Extends the AbstractExtraMission abstract class.
 */
public class Murder extends AbstractExtraMission{

    private final Random rnd;
    
    public Murder(){
        super(MissionType.MURDER);
        rnd = new Random();
    }
    
    /**
     * {@inheritDoc} 
     */
    @Override
    public IPlayer playMission(IPlayer player) {
        int randomIndex = ApplicationInstance.getInstance().getPlayers().get().indexOf(player);
        while(randomIndex == ApplicationInstance.getInstance().getPlayers().get().indexOf(player)){
            randomIndex = rnd.nextInt(ApplicationInstance.getInstance().getPlayers().get().size());
        }
        player.setExtraMission(super.getMissionType(), ApplicationInstance.getInstance().getPlayer(randomIndex).get());
        return ApplicationInstance.getInstance().getPlayer(randomIndex).get();
    }
}
