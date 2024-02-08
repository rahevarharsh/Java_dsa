public class Chocola {

    public static void main(String[] args) {
        int vertical[]={4,3,2,1,1};
        int horizontal[]={4,2,1};
        int i=0,j=0;
        int hp=1;
        int vp=1;
        int cost=0;
        while (i<vertical.length&&j<horizontal.length){
            if (vertical[i] >=horizontal[j]) {
                cost+=vertical[i++]*vp;
                hp++;
            }
            else{
                cost+=horizontal[j++]*hp;
                vp++;
            }
        }
        while (i<vertical.length){
            cost+=vertical[i++]*vp;
            hp++;
        }
        while (j<horizontal.length){
            cost+=horizontal[j++]*hp;
            vp++;
        }
        System.out.println(cost);
    }
}