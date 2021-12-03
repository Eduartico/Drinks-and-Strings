import java.util.List;

public class StringRecipe {
    List<StringTransformer> trans;
    public StringRecipe(List<StringTransformer> trans){
        this.trans = trans;
    }
    public void mix(StringDrink drink){
        List<StringTransformer> trans = this.trans;
        for (StringTransformer former : trans) {
            former.execute(drink);
        }
    }
}
