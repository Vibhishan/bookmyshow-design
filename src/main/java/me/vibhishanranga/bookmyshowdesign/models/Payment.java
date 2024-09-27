package me.vibhishanranga.bookmyshowdesign.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Payment extends BaseModel{
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private Date timeOfPayment;

    private double amount;

    private String referenceId;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    // 1 Payment -> 1 Ticket
    // M Payments -> 1 Ticket
    @ManyToOne
    private Ticket ticket;
}
