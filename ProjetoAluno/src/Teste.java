/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author rafae
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Data dataNascimento = new Data(20,4,2006);
        
        Aluno aluno1 = new Aluno(110050588, "Rafaela", 'F', "63.091.974-4", "523.251.628-00", dataNascimento);
        
        System.out.println(aluno1);
    }
    
}
