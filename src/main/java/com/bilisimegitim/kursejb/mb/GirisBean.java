
package com.bilisimegitim.kursejb.mb;

import com.bilisimegitim.kursejb.session.GirisFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named(value = "girisBean")
@RequestScoped
public class GirisBean {
    
   @EJB
   private GirisFacade girisFacade; 

   private String kullanici;
   private String sifre;
    
    
    public GirisBean() {
        
        kullanici = "muammer";
        sifre = "demir";
        
    }

    public String getKullanici() {
        return kullanici;
    }

    public void setKullanici(String kullanici) {
        this.kullanici = kullanici;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    
    public String giriseYetkilimi()
    {
       boolean sonuc = girisFacade.giriseYetkilimi(kullanici, sifre);
       
       if (sonuc)
       {
           return "menu.xhtml?faces-redirect=true";
       }    
       else
       {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hata", "Kullanıcı adı ya da şifre yanlış!"));
           return null;
       }
    }
    
    
    
    
}
