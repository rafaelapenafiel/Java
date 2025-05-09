package aula;

import javax.swing.JOptionPane;

public class Principal {
    
    public static void main(String[] args) {
       String input = JOptionPane.showInputDialog("Digite um número inteiro:");
       int valor = Integer.parseInt(input);
       if (valor%2==0){
           System.out.println("O número é par");
       }
       else {
           System.out.println("O número é ímpar");
       }
    }
        
}
