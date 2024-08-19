public class Marketplace extends NormalLoc {
    public Marketplace(Player player) {
        super(player, "Silah Marketi");
    }

    @Override
    public boolean getLocation() {
        System.out.println("Para : " + player.getMoney());
        System.out.println("1. Silahlar");
        System.out.println("2. Zırhlar");
        System.out.println("3. Çıkış");
        System.out.print("Seçiminiz : ");
        int selTool = scan.nextInt();
        int selItemID;
        switch (selTool) {
            case 1:
                selItemID = weaponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selItemID = armorMenu();
                buyArmor(selItemID);
                break;
            default:
                break;
        }
        return true;
    }

    public int armorMenu() {
        System.out.println("1. Hafif\t<Para : 15 - Koruma : 1>");
        System.out.println("2. Orta\t<Para : 25 - Koruma : 3>");
        System.out.println("3. Ağr\t<Para : 40 - Koruma : 5>");
        System.out.println("4. Çıkış");
        System.out.print("Silah Seciniz : ");
        int selArmorID = scan.nextInt();
        return selArmorID;
    }

    public void buyArmor(int itemID) {
        int avoid = 0, price = 0;
        String aName = null;
        switch (itemID) {
            case 1:
                avoid = 1;
                aName = "Hafif Zirh";
                price = 15;
                break;
            case 2:
                avoid = 3;
                aName = "Orta Zirh";
                price = 15;
                break;
            case 3:
                avoid = 5;
                aName = "Ağır) Zırh";
                price = 40;
                break;
            case 4:
                System.out.println("Çikış Yapılıyor.");
        }
        if (price > 0) {
            if (player.getMoney() > price) {
                player.getInv().setArmor(avoid);
                player.getInv().setaName(aName);
                player.setMoney(player.getMoney() - price);
                System.out.println(aName + " satin aldiniz, Engellenen Hasar : " + player.getInv().getArmor());
                System.out.println("Kalan Para :" + player.getMoney());
            } else {
                System.out.println("Para yetersiz. !");
            }
        }
    }

    public int weaponMenu() {
        System.out.println("1. Tabanca\t <Para : 25 - Hasar : 2>");
        System.out.println("2. Kılıç\t <Para : 35 - Hasar : 3>");
        System.out.println("3. Tüfek\t <Para : 45 - Hasar : 7>");
        System.out.println("4. Çıkış");
        System.out.print("Silah Seçiniz : ");
        return scan.nextInt();
    }


    public void buyWeapon(int itemID) {
        int damage = 0, price = 0;
        String wName = null;
        switch (itemID) {
            case 1:
                damage = 2;
                wName = "Tabanca";
                price = 25;
                break;
            case 2:
                damage = 3;
                wName = "Kılıç";
                price = 35;
                break;
            case 3:
                damage = 7;
                wName = "Tüfek";
                price = 45;
                break;
            case 4:
                System.out.println("Mağazadan çıkıldı...");
                break;
            default:
                System.out.println("Geçersiz İşlem !");
                break;
        }
        if(price>0) {
            if (player.getMoney() > price) {
                player.getInv().setDamage(damage);
                player.getInv().setwName(wName);
                player.setMoney(player.getMoney() - price);
                System.out.println(wName + " Satın aldınız... \nÖnceki Hasar : " + player.getDamage() +
                        "\nYeni Hasar: " + player.getTotalDamage() +
                        "\nKalan Para: " + player.getMoney());
            } else {
                System.out.println("Bakiye yetersiz. !");
            }
        }
    }
}