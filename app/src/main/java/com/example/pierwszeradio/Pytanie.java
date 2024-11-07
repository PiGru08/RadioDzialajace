package com.example.pierwszeradio;

public class Pytanie {
    private String trescPytania;
    private String[] odpowiedzi = new String[3];
    private int poprawnaOdpowiedz;
    private boolean czyUdzielonoPoprawnejOdpowiedzi;

    public Pytanie(String trescPytania, String odpowiedzA, String odpowiedzB, String odpowiedzC, int poprawnaOdpowiedz) {
        this.trescPytania = trescPytania;
        this.odpowiedzi = new String[]{odpowiedzA,odpowiedzB,odpowiedzC};
        this.poprawnaOdpowiedz = poprawnaOdpowiedz;
        czyUdzielonoPoprawnejOdpowiedzi = false;
    }

    public void sprawdzOdpowiedz(int udzielona){
        if(udzielona == poprawnaOdpowiedz){
            czyUdzielonoPoprawnejOdpowiedzi = true;
        }else{
            czyUdzielonoPoprawnejOdpowiedzi = false;
        }
    }

    public String getTrescPytania() {
        return trescPytania;
    }

    public String[] getOdpowiedzi() {
        return odpowiedzi;
    }

    public int getPoprawnaOdpowiedz() {
        return poprawnaOdpowiedz;
    }

    public boolean isCzyUdzielonoPoprawnejOdpowiedzi() {
        return czyUdzielonoPoprawnejOdpowiedzi;
    }
}
