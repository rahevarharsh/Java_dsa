public class DefIP {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i <address.length() ; i++) {
            if (address.charAt(i) =='.' ) {
                sb.append('[');
                sb.append('.');
                sb.append(']');
            }
            else{
                sb.append(address.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
