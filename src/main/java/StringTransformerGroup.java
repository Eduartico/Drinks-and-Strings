import java.util.List;

public class StringTransformerGroup implements StringTransformer
{
    List<StringTransformer> trans;
    public StringTransformerGroup(List<StringTransformer> listGiven)
    {
        trans = listGiven;
    }
    @Override
    public void execute(StringDrink drink)
    {
        for(StringTransformer listSearched:trans)
        {
            listSearched.execute(drink);
        }
    }
}
