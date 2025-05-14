/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pratica4heranca;

/**
 *
 * @author Rafaela Penafiel
 */
public class Pratica4Heranca {

    public static void main(String[] args) {
        Funcionário f1 = new Funcionário("12345678900", "Martha", 3000.0);
        Funcionário f2 = new Funcionário("98765432133", "Jonathan", 2000.0);
        
        System.out.println("RG: " + f1.getRG()+ " Nome: " + f1.getNome()+ " Salário: " + f1.getSalário());
        System.out.println("RG: " + f2.getRG()+ " Nome: " + f2.getNome()+ " Salário: " + f2.getSalário());
        
        f1.aumentar_Salário(0.10);
        f2.aumentar_Salário(0.10);
        
        System.out.println("RG: " + f1.getRG()+ " Nome: " + f1.getNome()+ " Salário após aumento: "+ f1.getSalário());
        System.out.println("RG: " + f2.getRG()+ " Nome: " + f2.getNome()+ " Salário após aumento: "+ f2.getSalário());
        
    }
}
