/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author simonecipullo
 */
@Entity
@Table(name = "guarantees")
public class GuaranteesModel implements Serializable {

    private static final long serialVersionUID = 7526471155622776147L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    @Column(name = "credit_card")
    private String creditCard;

    @Column(name = "security_code")
    private Integer securityCode;

    @Column(name = "date_of_expired")
    private String expiredCreditCard;

    @Column(name = "deposit")
    private Double deposit;

    @Column(name = "total")
    private Double total;

    @Column(name = "cro")
    private String cro;

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getExpiredCreditCard() {
        return expiredCreditCard;
    }

    public void setExpiredCreditCard(String expiredCreditCard) {
        this.expiredCreditCard = expiredCreditCard;
    }

   

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public Integer getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(Integer securityCode) {
        this.securityCode = securityCode;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}
