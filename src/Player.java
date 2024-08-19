import java.util.Scanner;

public class Player {
    private int health, damage,money,fullHealth;
    private String name,cName;
    Inventory inv;


    Scanner scan = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inv = new Inventory();
    }

    public void selectCha() {
        switch (chaMenu()) {
            case 1:
                initPlayer("Samuray", 5, 21, 15);
                break;
            case 2:
                initPlayer("Okçu", 7, 18, 20);
                break;
            case 3:
                initPlayer("Şovalye", 8, 24, 5);
                break;
            default:
                initPlayer("Samuray", 5, 21, 15);
                break;
        }
            System.out.println("Karakter Oluşturuldu ! Adı=" + getcName() + " ,Hasar=" + getDamage() + " ,Sağlık="
                    + getHealth() + " ,Para=" + getMoney());
    }



    public int chaMenu() {
        System.out.println("Lütfen bir karakter seçiniz : ");
        System.out.println("1- Samuray \t Hasar : 5 \t Sağlik :21 \t Para :15");
        System.out.println("2- Okçu \t Hasar : 7 \t Sağlık :18 \t Para :20");
        System.out.println("3- Sovalye \t Hasar : 8 \t Sağlik :24 \t Para :5");
        System.out.print("Karater Seciminiz : ");
        int chaID = scan.nextInt();

        while (chaID < 1 ||chaID > 3){
            System.out.print("Lütfen geçerli bir karakter seçiniz : ");
            chaID = scan.nextInt();

        }

        return chaID;
    }

    public int getTotalDamage(){
      return  (this.getDamage() + this.getInv().getDamage());
    }

    public void initPlayer(String cName, int dmg, int hlthy, int mny) {
        setcName(cName);
        setDamage(dmg);
        setHealth(hlthy);
        setMoney(mny);
        setFullHealth(hlthy);
    }


    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcName() {
        return cName;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }



    public int getFullHealth() {
        return fullHealth;
    }

    public void setFullHealth(int fullHealth) {
        this.fullHealth = fullHealth;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }
}
