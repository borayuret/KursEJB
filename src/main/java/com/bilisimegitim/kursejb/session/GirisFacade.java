/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bilisimegitim.kursejb.session;

import com.bilisimegitim.kursejb.entity.Giris;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author BemB-2
 */
@Stateless
public class GirisFacade extends AbstractFacade<Giris> {

    @PersistenceContext(unitName = "com.bilisimegitim_KursEJB_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GirisFacade() {
        super(Giris.class);
    }
    
    public boolean giriseYetkilimi(String p_kullanici, String p_sifre)
    {
       
           
        try {
            Giris g = em.createNamedQuery("Giris.giriseYetkilimi", Giris.class).setParameter("kullanici", p_kullanici).setParameter("sifre", p_sifre).getSingleResult();
            
            if (g != null) {
                return true;
            } else {
                return false;
            }
        } 
        catch (Exception e) {
            
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hata", "Kullanıcı adı ya da şifre yanlış!"));
            return false;
        }
        
        
    }
    
}
