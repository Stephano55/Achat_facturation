import java.util.Scanner;

public class Achat {
    private String[] articles = {"pomme", "fraise", "banane","mangue"};
    private double[] prix ={19.0, 50.0, 20.0, 13.0};
    private String[] acquisitions = new java.lang.String[0];
    private static int instanceA;
    private double price = 0.0;
    private double totale;
    protected int taille;
    private double montantAchat;
    private double montantTtc;
    private double reduction;
    private double TVA;
    public Achat(int pTaille){//Création d'un tableau d'articles vide
        instanceA++;
        this.taille = pTaille;
        this.acquisitions = new String[pTaille];
    }
    public static int getInstanceA(){return instanceA;}
    public String[] getArticles(){return articles;}
    public double[] getPrix() {
        return prix;
    }

    public  double getTotale(){return totale;}

    public int getTaille() {
        return taille;
    }

    public void setArticles(String[] articles) {
        this.articles = articles;
    }
    public void acheter(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Remplissez votre pannier ^-^ ");
        for (int i = 0; i < this.taille; i++){
            System.out.println("Articles "+i+" :");
            acquisitions[i] =sc.nextLine();
        }
        rechercher();
        setMontantAchat(this.price);
        //facture();
    }
    public double rechercher() {
        for (int i = 0; i < this.taille; i++) {
            boolean found = false;
            for (int j = 0; j < articles.length; j++) {
                if (acquisitions[i].equals(articles[j])) {
                    price += this.prix[j];
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Article " + acquisitions[i] + " non trouvé.");
            }
        }
        System.out.println(price);
        return price;
    }
    public void setMontantAchat(double prixTotal) {
        this.montantAchat = price;
        this.setReduction();
        this.setTVA();
    }
    private void setReduction(){
        if(this.montantAchat<200.0){this.reduction =0.0;}
        else{
            this.reduction = (this.montantAchat * 15)/100;
        }
    }
    private void setTVA(){
        this.TVA= (this.montantAchat*20)/100;
    }
    public void setMontantTtc() {
        double monTtc;
        monTtc = this.montantAchat + this.TVA-this.reduction;
        this.montantTtc = monTtc;
        this.setReduction();
        this.setTVA();
    }
    public String facture(){
        this.setMontantTtc();
        return "\t\tFacture numero "+this.instanceA+"\nMontant HT: "+this.montantAchat+
                " Ar\nRéduction: "+this.reduction+" Ar\nTVA: "+this.TVA+" Ar\nTotale: "+this.montantTtc+" Ar TTC";

    }
}
