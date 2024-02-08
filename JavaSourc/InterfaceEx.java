public class InterfaceEx {
    public static void main(String[] args) {
      Game g= new Game();
      g.player();
      g.Numplayer();
      g.playerCount();
    }
}

interface ChaseKey{
    void player();
    void Numplayer();
}

interface Ludo{
    void player();
    void playerCount();
}

class Game implements ChaseKey,Ludo{
    @Override
    public void player() {
        System.out.println("hello ");
    }

    @Override
    public void Numplayer() {
        System.out.println("2");
    }

    @Override
    public void playerCount() {
        System.out.println("4");
    }
}
