public class StringCaseChanger implements StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        StringBuilder sb = new StringBuilder("");
        char[] ch = drink.getText().toCharArray();
        //String result = "";
        for (int i = 0; i < ch.length; i++) {
            if(Character.isLowerCase(ch[i])){
                ch[i] = Character.toUpperCase(ch[i]);
            }
            else{
                ch[i] = Character.toLowerCase(ch[i]);
            }
            sb.append(ch[i]);
        }
        drink.setText(sb.toString());
    }
}
