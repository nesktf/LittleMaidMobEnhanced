package littleMaidMobX.registry;

import java.util.HashSet;

import littleMaidMobX.model.maid.ModelLittleMaid_AC;
import littleMaidMobX.model.maid.ModelLittleMaid_Archetype;
import littleMaidMobX.model.maid.ModelLittleMaid_Aug;
import littleMaidMobX.model.maid.ModelLittleMaid_Orign;
import littleMaidMobX.model.maid.ModelLittleMaid_SR2;

public class ModelRegistry {

    public static final HashSet<Class> list = new HashSet<Class>();
    static {
        list.add(ModelLittleMaid_AC.class);
        list.add(ModelLittleMaid_Archetype.class);
        list.add(ModelLittleMaid_Aug.class);
        list.add(ModelLittleMaid_Orign.class);
        list.add(ModelLittleMaid_SR2.class);
    }

}
