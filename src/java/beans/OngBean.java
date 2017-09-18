/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import models.Ong;
import models.OngDAO;


/**
 *
 * @author pedro
 */
@ManagedBean
@SessionScoped
public class OngBean implements Serializable {

    
    private Ong ong = new Ong();
    private OngDAO ongDAO = new OngDAO();
    private List<Ong> ongs = new ArrayList<Ong>();
    
    public OngBean() {
    }
    
    public void insert(ActionEvent evt) {
        ongDAO.create(ong);
        showMessage("ONG criada com sucesso!" + ong.getName());
    }
    
    private void showMessage(String summary) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(summary));
    }
    
    public void clear() {
            ong = new Ong();
    }

    public Ong getOng() {
            return ong;
    }

    public void setOng(Ong ong) {
            this.ong = ong;
    }

    public List<Ong> getOngs() {
            return ongs;
    }

    public void setOngs(List<Ong> ongs) {
            this.ongs = ongs;
    }

    public Ong getNullOng() {
            return new Ong();
    }
}
