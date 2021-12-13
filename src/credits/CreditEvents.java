package credits;

import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;

public class CreditEvents{
    public static void init(){
        new Creditor(BlockBuildEndEvent.class, b -> {
            if(b.tile.block() == Blocks.router && b.team == Vars.player.team()){
                for(int i = 0; i < 4; i++){
                    if(b.tile.nearby(i).block() == Blocks.router){
                        return true;
                    }
                }
            }
            return false;
        },
        "Routers chained", -5);

        new Creditor(SectorCaptureEvent.class, e -> true, "Sector captured", 100);
        new Creditor(SectorCaptureEvent.class, e -> true, "Sector lost", -250);

        new Creditor(ResearchEvent.class, e -> true, "Research progressed", 50);
    }
}
