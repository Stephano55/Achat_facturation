//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int nbr;
        Scanner sc = new Scanner(System.in);
        System.out.print("entrez le nombres d'articles que vou voulez achetez: ");
        nbr = sc.nextInt();
        Achat achat = new Achat(nbr);
        achat.acheter();
        System.out.println(achat.facture());
    }
}