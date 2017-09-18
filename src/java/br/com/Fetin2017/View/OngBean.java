/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Fetin2017.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.Fetin2017.Model.ONG;
import br.com.Fetin2017.Controller.DAO.ONGDAO;

/**
 *
 * @author pedro
 */

@ManagedBean
@SessionScoped
public class OngBean implements Serializable {

    
    private ONG ong = new ONG();
    private ONGDAO ongDAO = new ONGDAO();
    private List<ONG> ongs = new ArrayList<ONG>();
    
    public OngBean() {
    }
    
    public void insert(ActionEvent evt) {
        ongDAO.insert(ong);
        showMessage("ONG criada com sucesso!" + ong.getName());
    }
    
    private void showMessage(String summary) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(summary));
    }
    
    public void clear() {
            ong = new ONG();
    }

    public ONG getOng() {
            return ong;
    }

    public void setOng(ONG ong) {
            this.ong = ong;
    }

    public List<ONG> getOngs() {
            return ongs;
    }

    public void setOngs(List<ONG> ongs) {
            this.ongs = ongs;
    }

    public ONG getNullOng() {
            return new ONG();
    }
}
