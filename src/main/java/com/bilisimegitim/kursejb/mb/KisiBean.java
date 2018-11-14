
package com.bilisimegitim.kursejb.mb;


import com.bilisimegitim.kursejb.entity.Kisi;
import com.bilisimegitim.kursejb.session.KisiFacade;
import java.math.BigDecimal;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "kisiBean")
@RequestScoped
public class KisiBean {
    
    @EJB
    private KisiFacade kisiFacade;
    
    private String ad;
    private String soyad;
    private BigDecimal maas;
    private Date dogtar;

  
    public KisiBean() {
        
        dogtar = new java.util.Date();
        
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public BigDecimal getMaas() {
        return maas;
    }

    public void setMaas(BigDecimal maas) {
        this.maas = maas;
    }

    

    public Date getDogtar() {
        return dogtar;
    }

    public void setDogtar(Date dogtar) {
        this.dogtar = dogtar;
    }
    
    
    public String kisiEkle()
    {
       Kisi k = new Kisi();
       k.setAd(this.ad);
       k.setSoyad(this.soyad);
       k.setMaas(this.maas);
       k.setDogtar(this.dogtar);
       kisiFacade.create(k);
       return "kisiListele.xhtml?faces-redirect=true";  
    }
    
    
    
    
    
    
}
