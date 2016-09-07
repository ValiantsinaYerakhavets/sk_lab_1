package lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {

    private String fileName;
    private int count;
    private String text;
    private String result;

    private int j;
    private int k;

    public Parser(String fileName) {
        this.fileName = fileName;
        this.count = 1;
        this.result = "";

        this.j = 0;
        this.k = 1;
    }

    public void parse() {
        try(Scanner in = new Scanner(new File(fileName))) {
            while(in.hasNextLine()) {
                text = in.nextLine();
                if(text.isEmpty()) {
                    count++;
                    System.out.println(result + "\n");
                    result = "";
                } else {
                    chooseMethod();
                }
            }
        } catch(FileNotFoundException e) {
            System.out.println("File hasn't been found!");
        }
    }

    private void chooseMethod() {
        switch(count) {
            case 1:
                method1();
                break;
            case 2:
                method2();
                break;
            case 3:
                method3();
                break;
            case 4:
                method4();
        }
    }

    private void method1() {

        int counter = -1;
        int n = text.length();

        for(int i=0; i<n; i++) {
            char ch = text.charAt(i);
            if(isPunctuation(ch)) {
                counter = 2;
            }
            if(counter == 0 && ch!=' ') {
                result+=ch;
            }
            if(Character.isLetter(ch)) {
                counter--;
            }
        }

    }

    private void method2() {

        result += text.charAt(0);

        for(int i=text.length()-1; i>=0; i--) {
            char ch = text.charAt(i);
            if(Character.isLetter(ch)) {
                result += ch;
                break;
            }
        }

    }

    private void method3() {

        int n = text.length();
        int counter = 0;

        for(int i=0; i<n; i++) {
            char ch = text.charAt(i);
            if(Character.isLetter(ch)) {
                counter++;
            }
            if(counter==1 || counter==3 || counter==5) {
                if(ch!=' ') {
                    result += ch;
                }
            }
        }
    }

    private void method4() {

        int n = text.length();

        for(int i=0; i<n; i++) {
            char ch = text.charAt(i);
            if(Character.isLetter(ch)) {
                j++;
            }
            if(j==k) {
                result += ch;
                break;
            }
        }
        k++;
        j = 0;
    }

    // helper

    private boolean isPunctuation(char ch) {
        String punctuations = ".,:;!?";
        int n = punctuations.length();
        for(int i = 0; i<n; i++) {
            if(ch == punctuations.charAt(i))
                return true;
        }
        return false;
    }

}
