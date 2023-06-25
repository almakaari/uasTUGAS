package org.tubesUAS;

public class Antrian {
    Quwewe first;

    Antrian() {
        first = null;
    }

    void enQueue(String nama) {
        Quwewe antrian_baru = new Quwewe(nama);
        if (first == null) {
            first = antrian_baru;
        } else {
            Quwewe elemenSementara = first;
            while (elemenSementara.next != null) {
                elemenSementara = elemenSementara.next;
            }
            elemenSementara.next = antrian_baru;

        }
    }
    void deQueue(){
        if(first == null){
            System.out.println("Antrian Kosong");
        }
        else{
            first = first.next;
        }
    }
    boolean isEmpty(){
        return first == null;
    }
    void print(){
        Quwewe elemenSementara = first;
        int count = 0;
        if(elemenSementara == null){
            System.out.println("Antrian Kosong");
        }else{
            while(elemenSementara != null){
                count++;
                count++;
                System.out.printf("|  %-3s|               %-15s | \n", count, elemenSementara.nama );
                elemenSementara = elemenSementara.next;
            }
        }

    }
}
