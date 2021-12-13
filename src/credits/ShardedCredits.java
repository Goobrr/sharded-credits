package credits;

import arc.*;
import credits.ui.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;

public class ShardedCredits extends Mod{

    public ShardedCredits(){
        CreditSystem.init();
        CreditEvents.init();

        Events.on(Trigger.update.getClass(), h -> {
            CreditSystem.update();
        });

        Events.on(ClientLoadEvent.class, h -> {
            new CreditsUI().build(Vars.ui.hudGroup);
        });
    }

}
