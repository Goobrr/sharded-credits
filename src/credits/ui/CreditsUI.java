package credits.ui;

import arc.scene.*;
import arc.struct.IntMap.*;

import arc.util.*;
import mindustry.ui.fragments.*;

import static credits.CreditSystem.*;

public class CreditsUI extends Fragment{

    @Override
    public void build(Group parent){
        parent.fill(t -> {
            t.bottom().left();

            t.labelWrap(() -> {
                StringBuilder totals = new StringBuilder();

                for(Entry<Integer> entry : recent){
                    totals.append(reasons.get(entry.key));
                    totals.append(" x");
                    totals.append(entry.value);
                    totals.append(" \n");
                }

                totals.append(credits);

                if(!recent.isEmpty()){
                    if(recentCredits < 0){
                        totals.append(" [scarlet]");
                    }else{
                        totals.append(" [green]+");
                    }
                    totals.append(recentCredits);
                }

                return totals;
                })
                .bottom().left()
                .get().setAlignment(Align.bottomLeft);
            });
    }
}
