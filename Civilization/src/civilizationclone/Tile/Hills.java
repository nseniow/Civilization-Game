package civilizationclone.Tile;

import static civilizationclone.Tile.Resource.NONE;
import java.util.EnumSet;
import java.util.Set;

public class Hills extends Tile {

    static Set<Improvement> possibleImprovement = EnumSet.of(Improvement.MINE);

    public Hills() {
        super(false, 2);

    }

    @Override
    public void calcOutput() {
        setFoodOutput(1 + getImprovement().getFoodBonus() + getResource().getFoodBonus());
        setGoldOutput(getImprovement().getGoldBonus() + getResource().getGoldBonus());
        setProductionOutput(1 + getImprovement().getProductionBonus() + getResource().getProductionBonus());
        setScienceOutput(getImprovement().getScienceBonus() + getResource().getTechBonus());
        calcTechBonus();
    }

    @Override
    public Set<Improvement> getPossibleImprovements() {
        Set<Improvement> improve = possibleImprovement;
        if (this.getResource() != NONE) {
            improve.add(this.getResource().getImprovementType());
        }
        return improve;
    }

}
