package pckg;

import java.util.Random;

public class ZeleznickaStanica {
    public static void main(String[] args) {
        Pruga pruga1 = new Pruga();
        Pruga pruga2 = new Pruga();
        Pruga pruga3 = new Pruga();
        Pruga pruga4 = new Pruga();

        for (int i = 1; i <= 10; i++) {
            String voz = "Voz " + i;
            int destinacijaPruga = new Random().nextInt(4) + 1; // Nasumično odabira destinaciju pruge
            int vremeDolaska = new Random().nextInt(7000) + 2000; // Nasumično vreme dolaska između 2-8 sekundi

            switch (destinacijaPruga) {
                case 1:
                    pruga1.pristigaoVoz(voz);
                    break;
                case 2:
                    pruga2.pristigaoVoz(voz);
                    break;
                case 3:
                    pruga3.pristigaoVoz(voz);
                    break;
                case 4:
                    pruga4.pristigaoVoz(voz);
                    break;
            }

            try {
                Thread.sleep(vremeDolaska);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}