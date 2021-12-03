public class StringReplacer implements StringTransformer {
    char target, nova;
    public StringReplacer(char target, char nova) {
        this.target = target;
        this.nova = nova;
    }
    @Override
    public void execute(StringDrink drink) {
        StringBuilder sb = new StringBuilder("");
        char[] ch = drink.getText().toCharArray();
        //String result = "";
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] == target){
                ch[i] = nova;
            }
            sb.append(ch[i]);
        }
        drink.setText(sb.toString());
    }
}

