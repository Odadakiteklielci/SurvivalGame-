import java.util.Scanner;

public abstract class NormalLoc extends Location {
Scanner scan = new Scanner(System.in);
    NormalLoc(Player player, String name) {
        super(player);
        this.name = name;
    }
    public boolean getLocation() {
        return true;
    }
}
