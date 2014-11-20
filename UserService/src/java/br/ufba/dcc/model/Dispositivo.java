/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufba.dcc.model;

/**
 *
 * @author leonardo
 */
public class Dispositivo {
    private String descricao;
    private int id;
    
    public String getDescricao(){
        return this.descricao;
    }
    public void setDescricao(String d){
        this.descricao = d;
    }
    public int getID(){
        return this.id;
    }
    public void setID(int i){
        this.id = i;
    }
}
