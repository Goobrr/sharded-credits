package credits;

import arc.*;
import arc.math.*;
import arc.struct.*;
import arc.util.*;

public class CreditSystem{
    private static float recentTimer = 0f;
    public static int credits;
    public static int recentCredits;
    public static int nextid = -1;

    public static Seq<String> reasons = new Seq<>();
    public static IntSeq values = new IntSeq();
    public static IntMap<Integer> recent = new IntMap<>();

    public static void init(){
        credits = Core.settings.getInt("sharded-credits", 1000);
        reasons.clear();
        values.clear();
        recent.clear();
    }

    public static void update(){
        recentTimer = Mathf.clamp(recentTimer -= Time.delta, 0f, 1200f);
        if(recentTimer == 0 && !recent.isEmpty()){
            recent.clear();
            recentCredits = 0;
        }
    }

    public static int register(String reason, int amount){
        nextid++;
        reasons.add(reason);
        values.add(amount);
        return nextid;
    }

    public static void trigger(int id){
        credits += values.get(id);
        Core.settings.put("sharded-credits", credits);

        recentTimer = 1200f;
        recentCredits += values.get(id);
        recent.put(id, recent.containsKey(id) ? recent.get(id) + 1 : 1);

        Log.info(recentCredits);
    }
}
