import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy
{
    List<StringDrink> Drinks = new ArrayList<>();
    List<StringRecipe> Recipes = new ArrayList<>();
    List<StringBar> Bars = new ArrayList<>();
    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar)
    {
        if(!bar.isHappyHour())
        {
            Drinks.add(drink);
            Recipes.add(recipe);
            Bars.add(bar);
        }
        else {bar.order(drink,recipe);}
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        for(int i = 0; i < Drinks.size() ; i++)
        {
            bar.order(Drinks.get(i),Recipes.get(i));
        }
        Drinks.clear();
        Recipes.clear();
    }

    @Override
    public void happyHourEnded(StringBar bar) {}
}
