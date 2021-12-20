public class HumanClient implements Client
{
    private OrderingStrategy ClassOrdering;

    public HumanClient(OrderingStrategy HumanOrdering) {ClassOrdering = HumanOrdering;}

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {ClassOrdering.wants(drink,recipe,bar);}

    @Override
    public void happyHourStarted(Bar bar) {ClassOrdering.happyHourStarted((StringBar)bar);}

    @Override
    public void happyHourEnded(Bar bar) {}
}
