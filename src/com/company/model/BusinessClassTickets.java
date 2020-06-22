package com.company.model;

import com.company.IAccounting;
import java.util.Objects;

/**
 * @author Kateryna Basova KHNUE
 * @version 1.0
 * Classname BusinessClassTickets
 * Class represents a business class flight ticket.
 * Lab Work 2.
 **/
public class BusinessClassTickets implements IAccounting {
    private String flight; // cities names: from - to
    private double ticketPice; // price for ticket
    private double kilometers; // distance between cities

    // Class constructor without parameters
    public BusinessClassTickets() {
    }

    // Class constructor with parameters
    public BusinessClassTickets(String flight, double ticketPice, double kilometers) {
        this.flight = flight;
        this.ticketPice = ticketPice;
        this.kilometers = kilometers;
    }

    // getters and setters
    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public double getTicketPice() {
        return ticketPice;
    }

    public void setTicketPice(double ticketPice) {
        this.ticketPice = ticketPice;
    }

    public double getKilometers() {
        return kilometers;
    }

    public void setKilometers(double kilometers) {
        this.kilometers = kilometers;
    }

    // method to calculate the total price
    @Override
    public double getPrice() {
        return this.getTicketPice();
    }

    // overriding method toString
    @Override
    public String toString() {
        return "BusinessClassTickets{" +
                "flight='" + flight + '\'' +
                ", price=" + ticketPice +
                ", kilometers=" + kilometers +
                '}';
    }

    // overriding method equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessClassTickets that = (BusinessClassTickets) o;
        return Double.compare(that.getTicketPice(), getTicketPice()) == 0 &&
                Double.compare(that.getKilometers(), getKilometers()) == 0 &&
                getFlight().equals(that.getFlight());
    }

    // overriding method hashCode
    @Override
    public int hashCode() {
        return Objects.hash(getFlight(), getTicketPice(), getKilometers());
    }
}
