package mathquiz;
import java.util.Random;
import java.util.*;

/**
 *
 * @author risus
 */
public class MathQuiz {

    /**
     * @param args the command line arguments
     */
    static int skor;
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("============================");
        System.out.println("\tMath QuIz");
        System.out.println("============================");
        menu();
    }
    
    public static void menu(){
        int mode;
        Scanner  scan = new Scanner(System.in);
        System.out.println("(1) Mode 1");
        System.out.println("(2) Mode 2");
        System.out.println("Pilih Mode:");
        mode = scan.nextInt();
        switch(mode){
            case 1: easy_mode();
                    break;
            case 2 :hard_mode();
                    break;
            default: menu();
                    break;
        }
    }
    public static void easy_mode(){
        Scanner  scan = new Scanner(System.in);
        int hasil = 0;
        int state = 0;
        skor = 0;
        int  jwb = 0;
        int soal = 0;
        int a = 0; int b = 0;
        char opr = ' ';
        Boolean flag = true;
        while(flag == true){
        int operasi;
        a = random(0,9);
        b = random(0,9);
        operasi = random(1,3);
        switch(operasi){
            case 1: hasil = a+b; opr = '+';
                    break;
            case 2: hasil = a-b; opr = '-';
                    break;
            case 3: hasil = a*b; opr = '*';
                    break;
        }
        state = random(1,2);
        if(state == 1){
            soal = hasil;
        } else {
            soal = random(0,9);
        }
        System.out.println(a + " " + opr + " " + b + " = " + soal);
        System.out.print("True(1) Or False(0) ? ");
        jwb = scan.nextInt();
        if(jwb == 1){
            if(soal == hasil)
                skor += 10;
            else
                flag = false;
        }
        if(jwb == 0){
            if(soal != hasil)
                skor += 10;
            else
                flag = false;
        }
        }
        System.out.println("Permainan Selesai, Skor Anda: " + skor);
    }
    
    public static void hard_mode(){
        Scanner  scan = new Scanner(System.in);
        skor = 0;
        int operasi = 0;
        int hasil = 0;
        int jwb = 0;
        char opr = ' ';
        int a = 0; int b = 0;
        Boolean flag = true;
        while(flag){
            a = random(0,9);
            b = random(0,9);
            operasi = random(1,3);
            switch(operasi){
            case 1: hasil = a+b; opr = '+';
                    break;
            case 2: hasil = a-b; opr = '-';
                    break;
            case 3: hasil = a*b; opr = '*';
                    break;
            }
            System.out.print(a + " " + opr + " " + b + "= ? ");
            jwb = scan.nextInt();
            if(jwb == hasil)
                skor += 10;
            else
                flag = false;
        }
        System.out.println("Permainan Selesai, Skor Anda: " + skor);
    }
    public static int random(int min, int max){
        Random rnd = new Random();
        return min + rnd.nextInt((max-min) + 1);
    }
}