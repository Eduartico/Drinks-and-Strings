import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderingStrategyTest {

    public StringRecipe getRecipe() {
        StringInverter a = new StringInverter();
        StringCaseChanger b = new StringCaseChanger();
        StringReplacer c = new StringReplacer('A', 'X');
        List<StringTransformer> transformers = new ArrayList<>();
        transformers.add(a);
        transformers.add(b);
        transformers.add(c);
        return new StringRecipe(transformers);
    }

        @Test
        public void impatientStrategy () {
            StringBar stringBar = new StringBar();
            StringDrink drink = new StringDrink("AbCd-aBcD");
            StringRecipe recipe = getRecipe();
            ImpatientStrategy strategy = new ImpatientStrategy();
            HumanClient client = new HumanClient(strategy);
            // Recipe is ordered immediately
            client.wants(drink, recipe, stringBar);
            assertEquals("dCbX-DcBa", drink.getText());
        }
        @Test
        public void smartStrategyStartOpened () {
            StringBar stringBar = new StringBar();
            StringDrink drink = new StringDrink("AbCd-aBcD");
            StringRecipe recipe = getRecipe();
            SmartStrategy strategy = new SmartStrategy();
            HumanClient client = new HumanClient(strategy);
            // Recipe is ordered immediately as happy hour was already under way
            stringBar.startHappyHour();
            client.wants(drink, recipe, stringBar);
            assertEquals("dCbX-DcBa", drink.getText());
        }
        @Test
        public void smartStrategyStartClosed () {
            StringBar stringBar = new StringBar();
            StringDrink drink = new StringDrink("AbCd-aBcD");
            StringRecipe recipe = getRecipe();
            SmartStrategy strategy = new SmartStrategy();
            HumanClient client = new HumanClient(strategy);
            stringBar.addObserver(client); // this is important!
            client.wants(drink, recipe, stringBar);
            assertEquals("AbCd-aBcD", drink.getText());
            // Recipe is only ordered here
            stringBar.startHappyHour();
            assertEquals("dCbX-DcBa", drink.getText());
        }
    }

