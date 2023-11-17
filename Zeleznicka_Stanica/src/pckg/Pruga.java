package pckg;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;



class Pruga {
    private Queue<String> vozoviNaPruzi = new LinkedList<>();

    public synchronized void pristigaoVoz(String voz) {
        if (vozoviNaPruzi.size() < 5) {
            vozoviNaPruzi.add(voz);
            System.out.println(voz + " je pristigao na prugu.");
            oslobodiPrugu();
        } else {
            prebaciVozNaDruguPruzu(voz);
        }
    }

    private synchronized void oslobodiPrugu() {
        new Thread(() -> {
            try {
                Thread.sleep(new Random().nextInt(7000) + 2000); // Nasumično vreme zadržavanja na pruzi 2-8 sekundi
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!vozoviNaPruzi.isEmpty()) {
                String prviVoz = vozoviNaPruzi.poll();
                System.out.println(prviVoz + " je napustio prugu.");
                oslobodiPrugu();
            }
        }).start();
    }

    private synchronized void prebaciVozNaDruguPruzu(String voz) {
        System.out.println("Pruga zauzeta. Prebacivanje " + voz + " na drugu prugu.");
        // Implementirati logiku prebacivanja voza na drugu prugu
    }
}