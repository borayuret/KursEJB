/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bilisimegitim.kursejb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BemB-2
 */
@Entity
@Table(name = "giris")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Giris.findAll", query = "SELECT g FROM Giris g")
    , @NamedQuery(name = "Giris.giriseYetkilimi", query = "SELECT g FROM Giris g WHERE g.kullanici = :kullanici and g.sifre = :sifre")
    , @NamedQuery(name = "Giris.findByKullanici", query = "SELECT g FROM Giris g WHERE g.kullanici = :kullanici")
    , @NamedQuery(name = "Giris.findBySifre", query = "SELECT g FROM Giris g WHERE g.sifre = :sifre")})
public class Giris implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "kullanici")
    private String kullanici;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "sifre")
    private String sifre;

    public Giris() {
    }

    public Giris(String kullanici) {
        this.kullanici = kullanici;
    }

    public Giris(String kullanici, String sifre) {
        this.kullanici = kullanici;
        this.sifre = sifre;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kullanici != null ? kullanici.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Giris)) {
            return false;
        }
        Giris other = (Giris) object;
        if ((this.kullanici == null && other.kullanici != null) || (this.kullanici != null && !this.kullanici.equals(other.kullanici))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bilisimegitim.kursejb.entity.Giris[ kullanici=" + kullanici + " ]";
    }
    
}
