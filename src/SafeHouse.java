public class SafeHouse extends NormalLoc{


    SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean getLocation() {
        player.setHealth(player.getFullHealth());
        System.out.println("Güvenli Eve Geldiniz...\n" +
                "Sağlık Düzeyiniz En üst Seviyede: "+player.getFullHealth());
        return true;
    }
}
