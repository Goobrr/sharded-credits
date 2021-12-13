package credits;

import arc.*;
import arc.func.*;

public class Creditor {
    public int id;

    /** Registers a listener to an event which adds an amount to the total credits if check returns true */
    public <T> Creditor(Class<T> event, Boolf<T> check, String reason, int amount){
        id = CreditSystem.register(reason, amount);
        Events.on(event, e -> {
            if(check.get(e)){
                CreditSystem.trigger(id);
            }
        });
    }
}
