/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.dto;


/**
 *
 * @author simonecipullo
 */
public class Guarantees {

    private Long id;

    private String creditCard;

    private Integer securityCode;

    private String expiredCreditCard;

    private Double deposit;

    private Double total;

    private String cro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }


    public Integer getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(Integer securityCode) {
        this.securityCode = securityCode;
    }

    public String getExpiredCreditCard() {
        return expiredCreditCard;
    }

    public void setExpiredCreditCard(String expiredCreditCard) {
        this.expiredCreditCard = expiredCreditCard;
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

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }
    
    

}
