import java.util.ArrayList;
import java.util.Scanner;

public class aer174 {

    public static void main(String[] args) {

        int n; //quantitat d'anys
        Scanner sc = new Scanner(System.in);
        int i;
        int any;
        int s; //serie d'anys
        n = sc.nextInt();
        for (i = 0; i < n; i++) {
            any = sc.nextInt();
            s = 1;
            if (diferents(any)) {
                //amunt
                any++;
                while (diferents(any)) {
                    s++;
                    any++;
                }
                any=any-s-1;
                //avall
                while (diferents(any)) {
                    s++;
                    any--;
                }
            } else {
                //amunt
                any++;
                while (!diferents(any)) {
                    s++;
                    any++;
                }
                any=any-s-1;
                //avall
                while (!diferents(any)) {
                    s++;
                    any--;
                }
            }
            System.out.println(any+1 + " " + s);
        }

    }

    public static boolean diferents(int valor) {
        ArrayList<Integer> valors = new ArrayList<Integer>();
        boolean resposta = true;
        int j;  //digit a comparar
        valors.add(valor % 10);
        valor = valor / 10;

        while ((resposta) && (valor > 0)) {
            j = valor % 10;
            if (valors.contains(j)) {
                resposta = false;
            } else {
                valors.add(j);
                valor = valor / 10;
            }

        }
        return resposta;
    }
}
