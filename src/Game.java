import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scan = new Scanner(System.in);


    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Macera Oyununa Hoşgeldiniz\n" +
                "Başlamadan önce isminizi giriniz: ");
        String playerName = sc.nextLine();
        player = new Player(playerName);
        player.selectCha();
        scan.nextLine();
        start();


    }



    public void start() {
        while (true) {

            System.out.println();
            System.out.println("==============================");
            System.out.println();
            System.out.println("Eylem gerçekleştirmek için bir yer seçiniz : ");
            System.out.println("1. Güvenli Ev -- > Size ait güvenli bir mekan, düşman yok !");
            System.out.println("2. Mağara -- > Karşınıza belki zombi cıkabilir !");
            System.out.println("3. Orman -- > Karşınıza belki vampir çıkabilir !");
            System.out.println("4. Nehir -- > Karşınıza belki ayı çıkabilir !");
            System.out.println("5. Mağaza -- > Silah veya Zırh alabilirsiniz!");
            int selloc = scan.nextInt();
            while (!(selloc==1 || selloc==2 || selloc==3 || selloc==4 || selloc==5 )) {
                System.out.print("Lütfen geçerli bir yer seçiniz : ");
            }
            switch (selloc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new Marketplace(player);
                    break;
                default:
                    location = new SafeHouse(player);
                    break;
            }
            if (location.getClass().getName().equals("SafeHouse")) {
                if (player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()) {
                    System.out.println("Tebrikler Oyunu Kazandinız !");
                    break;
                }
            }
            if (!location.getLocation()) {
                System.out.println("Oyun Bitti!");
            }
        }
    }

}
