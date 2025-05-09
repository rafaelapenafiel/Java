/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rafae
 */
public class Aluno {
    private int ra;
    private String nome;
    private char sexo;
    private String rg;
    private String cpf;
    private Data dataNasc;
    
    public Aluno(int ra, String nome, char sexo, String rg, String cpf, Data dataNasc) {
        this.ra = ra;
        this.nome = nome;
        this.sexo = sexo;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        
    }

    public int getRa() {
        return ra;
    }
    
    public void setRa(int ra) {
        this.ra = ra;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome (String nome) {
        this.nome = nome;
    }
    
    public char getSexo() {
        return sexo;
    }
    
    public void setSexo (char sexo) {
        this.sexo = sexo; 
    }
    
    public String getRg() {
        return rg;
    }
    
    public void setRg (String rg) {
        this.rg = rg;
    }
    
    public String getCpf () {
        return cpf;
    }
    
    public void setCpf (String cpf) {
        this.cpf = cpf;
    }
    public Data getDataNasc(){
        return dataNasc;
    }
    public void setDataNasc(Data dataNasc){
        this.dataNasc = dataNasc;
    }
    
    
    public String toString() {
        return "Aluno{" +  "RA=" + ra + ", Nome='" + nome + '\'' + ", Sexo=" + sexo + ", RG='" + rg + '\'' + ", CPF='" + cpf + '\'' + ", Data de Nascimento='" + dataNasc.formatarData() + '\'' + '}';
                
    }
}
