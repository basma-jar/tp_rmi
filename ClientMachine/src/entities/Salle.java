/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;


/**
 *
 * @author basma
 */

public class Salle implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private Long id;
    private String code;
        public Salle() {
    }

    public Salle(String code) {
        this.code = code;
    }

    public Salle(Long id, String code) {
        this.id = id;
        this.code = code;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

     public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salle)) {
            return false;
        }
        Salle other = (Salle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Salle[ id=" + id + " ]";
    }
    
}
