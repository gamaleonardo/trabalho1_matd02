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
public class Relacao {
    private Usuario user;
    private Dispositivo device;
    
    public Usuario getUsuario(){
        return this.user;
    }
    public void setUsuario(Usuario u){
        this.user = u;
    }
    public Dispositivo getDispositivo(){
        return this.device;
    }
    public void setDispositivo(Dispositivo d){
        this.device = d;
    }
    
}
