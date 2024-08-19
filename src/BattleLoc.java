public abstract class BattleLoc extends Location {
    Obstacle obstacle;
    protected String award;

    BattleLoc(Player player, String name, Obstacle obstacle) {
        super(player);
        this.name = name;
        this.obstacle = obstacle;
    }

    public boolean getLocation() {
        // Buraları sen yazdın sorun çıkarsa video 77
        if (obstacle.getName() == "Ayı") {
            System.out.println("Şu an nehirdesin.\n"
                    + "Suyun şırıltısını kulaklarında hissediyorsun.\n"
                    + "Duymuşsun daha önce bu nehre gelenlerden çok dönebilen olmadı\n"
                    + "Nehirdeki ayı efsanesi dillerden dile dolaşmasına rağmen dönen kimse olmadığından \n"
                    + "bunlar şu anda sadece söylentiden ibaret.\n"
                    + "Yürüdün ve karşına " + obstacle.obstacleCount() + " tane ayı çıktı.");
        }
        if (obstacle.getName() == "Zombi") {
            System.out.println("Şu an mağaraya girdin.\n"
                    + "Burası çok karanlık ve yürümekte zorlanıyorsun\n"
                    + "Burun direğini kıracak cinsten bir koku seni karşılıyor\n"
                    + "Bu mağarada zombi olduğunu söyleyenler olmuştu fakat inanmamıştın \n"
                    + "Bunlar şu anda sadece söylentiden ibaret.\n"
                    + "Yürüdün ve karşına " + obstacle.obstacleCount() + " tane zombi çıktı.");
        }
        if (obstacle.getName() == "Vampir") {
            System.out.println("Şu an ormandasın.\n"
                    + "Her taraf ağaç dolu.\n"
                    + "Değişik hayvanların seslerini işitmek çok zor değil.\n"
                    + "Daha önce vampirler tarafından ısırıldığını söyleyenleri tedavi etmiştin \n"
                    + "Bunlar şu anda sadece söylentiden ibaret.\n"
                    + "Yürüdün ve karşına " + obstacle.obstacleCount() + " tane vampir çıktı.");
        }
        System.out.print("<S>avaş veya <K>aç: ");
        int say = obstacle.obstacleCount();
        String hamleSec = scan.nextLine();
        hamleSec = hamleSec.toUpperCase();
        if (hamleSec.equals("S")) {
            if (combat(say)) {
                System.out.println("Bravo " + player.getName() + "! Tüm " + obstacle.getName() + "lari temizledin.");
                if (this.award.equals("yemek") && player.getInv().isFood() == false) {
                    System.out.println(this.award + " kazandın.");
                    player.getInv().setFood(true);
                } else if (this.award.equals("içme suyu") && player.getInv().isWater() == false) {
                    System.out.println(this.award + " kazandın.");
                    player.getInv().setWater(true);
                } else if (this.award.equals("yakacak odun") && player.getInv().isFirewood() == false) {
                    System.out.println(this.award + " kazandın.");
                    player.getInv().setFirewood(true);
                }
                return true;
            } else {
                if (player.getHealth() <= 0) {
                    System.out.println("Maalesef " + player.getName() + "... öldün.");
                    return false;
                }

            }

        }
        return true;
    }


    public boolean combat(int obsCount) {
        int defObsHealth = obstacle.getHealth();
        for (int i = 0; i < obsCount; i++) {
            playerStats();
            enemyStats();
        }
        while (player.getHealth() > 0 && obstacle.getHealth() > 0) {
            System.out.print("<V>ur veya <K>ac :");
            String selCase = scan.nextLine();
            selCase = selCase.toUpperCase();
            if (selCase.equals("V")) {
                System.out.println("Siz vurdunuz !");
                obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                System.out.println("Oyuncu Canı:" + player.getHealth());
                System.out.println(obstacle.getName() + " Cani:" + obstacle.getHealth());
                afterHit();
                if(obstacle.getHealth() > 0) {
                    System.out.println();
                    System.out.println("Canavar size vurdu !");
                    player.setHealth(player.getHealth() - (obstacle.getDamage() - player.getInv().getArmor()));

                }
                afterHit();

            }
            else {
                return false;
            }
            if (obstacle.getHealth()  < player.getHealth()) {
                System.out.println("Tum dusmanları yendiniz !");
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("Guncel Paraniz : " + player.getMoney());
                obstacle.setHealth(defObsHealth);
            }
            else {
                return false;
            }
        }


        return true;
    }


    public void playerStats() {
        System.out.println("Oyuncu Degerleri\n ---------- ");
        System.out.println("Can:" + player.getHealth());
        System.out.println("Hasar:" + player.getTotalDamage());
        System.out.println("Para:" + player.getMoney());
        if (player.getInv().getDamage() > 0) {
            System.out.println("Silah:" + player.getInv().getwName());

            if (player.getInv().getArmor() > 0) {
                System.out.println("Zarh:" + player.getInv().getaName());
            }
        }
    }

    public void enemyStats() {
        System.out.println("\n" + obstacle.getName() + " Degerleri\n -------------- ");
        System.out.println("Can:" + obstacle.getHealth());
        System.out.println("Hasar:" + obstacle.getDamage());
        System.out.println("Odül:" + obstacle.getAward());
    }

    public void afterHit() {
        System.out.println("Oyuncu Cani:" + player.getHealth());
        System.out.println(obstacle.getName() + " Can1:" + obstacle.getHealth());
    }
}




