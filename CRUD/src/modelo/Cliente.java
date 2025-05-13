/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Rafaela Penafiel
 */
public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
    private java.sql.Date dataNascimento;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    public String getEndereco(){
        return endereco;
    }
    
    public java.sql.Date getDataNascimento(){
        return dataNascimento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public void setDataNascimento(java.sql.Date dataNascimento){
        this.dataNascimento = dataNascimento;
    }

}
