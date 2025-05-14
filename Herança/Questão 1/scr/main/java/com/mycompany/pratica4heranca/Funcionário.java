/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pratica4heranca;

/**
 *
 * @author Rafaela Penafiel
 */
public class Funcionário extends Pessoa {
    private double salário;
    
    public Funcionário (String RG, String nome, double salário){
        super (RG, nome);
        this.salário = salário;
    }

    public double getSalário() {
        return salário;
    }

    public void setSalário(double salário) {
        this.salário = salário;
    }
    public double aumentar_Salário (double percentual){
        salário += salário * percentual;
        return salário;
    }
}
