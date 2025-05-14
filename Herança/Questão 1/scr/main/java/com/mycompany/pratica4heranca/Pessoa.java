/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pratica4heranca;

/**
 *
 * @author Rafaela Penafiel
 */
public class Pessoa {
    private String RG;
    private String nome;
    
    public Pessoa (String RG, String nome){
        this.RG = RG;
        this.nome = nome;
    }

    public String getRG() {
        return RG;
    }

    public String getNome() {
        return nome;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
