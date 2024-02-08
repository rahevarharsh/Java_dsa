public class Goal_Parser_Interpretation {
    public static String interpret(String command) {
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i <command.length() ; i++) {
            if (command.charAt(i) == 'G') {
                s.append(command.charAt(i));
            }
            else if(command.charAt(i) == '('&& command.charAt(i+1) == ')'){
                s.append('o');
                i++;
            }
            else if(command.charAt(i) == '('&& command.charAt(i+1) == 'a'){
                s.append('a');
                s.append('l');
                i +=3;
            }
        }
        return s.toString();
    }
    public static void main(String[] args) {
    String s = "G()()()()(al)";
        System.out.println(interpret(s));
    }
}
