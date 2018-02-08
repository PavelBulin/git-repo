/**
* Java. Level 2. HomeWork5
*
* @author Pavel Bulin
* @version 08.02.2018
* @link https://github.com/PavelBulin/git-repo.git
*/


package Lesson5;

public class MainClassMasiv {
    public static void main(String[] args) {
        System.out.println("Время разбивки и склеивания halfMasiv: " + (halfМasiv() - (masiv()/2)) + " сек.");
    }


    public static double masiv(/*double t1*/) {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        double t1;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        double a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 2) * Math.cos(0.4f + i / 2));
        }
        t1 = (System.currentTimeMillis() - a) / 1000;
        System.out.println("Времмя masiv: " + (System.currentTimeMillis() - a) / 1000 + " сек.");
        return t1;
    }


    public static double halfМasiv() {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        double t2;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        double b = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        for (int i = 0; i < h; i++) {
            a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 2) * Math.cos(0.4f + i / 2));
        }

        for (int i = 0; i < a2.length; i++) {
            a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 2) * Math.cos(0.4f + i / 2));
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        t2 = (System.currentTimeMillis() - b) / 1000;
        return t2;
    }
}