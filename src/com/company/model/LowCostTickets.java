package com.company.model;

import com.company.IAccounting;
import java.util.Objects;

/**
 * @author Kateryna Basova KHNUE
 * @version 1.0
 * Classname LowCostTickets
 * Class represents a low-cost class flight ticket.
 * Lab Work 2.
 **/
public class LowCostTickets implements IAccounting {
    private String flight; // cities names: from - to
    private double ticketPrice; // price for ticket
    private double kilometers; //distance between cities
    private double priceForBag; // price for the bag

    // Class constructor without parameters
    public LowCostTickets() {
    }

    // Class constructor with parameters
    public LowCostTickets(String flight, double ticketPrice, double kilometers, double priceForBag) {
        this.flight = flight;
        this.ticketPrice = ticketPrice;
        this.kilometers = kilometers;
        this.priceForBag = priceForBag;
    }

    // getters and setters
    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public double getKilometers() {
        return kilometers;
    }

    public void setKilometers(double kilometers) {
        this.kilometers = kilometers;
    }

    public double getPriceForBag() {
        return priceForBag;
    }

    public void setPriceForBag(double priceForBag) {
        this.priceForBag = priceForBag;
    }

    // method to calculate the total price
    @Override
    public double getPrice() {
        return this.getTicketPrice() + this.getPriceForBag();
    }

    // overriding method toString
    @Override
    public String toString() {
        return "LowCostTickets{" +
                "flight='" + flight + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", kilometers=" + kilometers +
                ", priceForBag=" + priceForBag +
                '}';
    }

    // overriding method equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LowCostTickets that = (LowCostTickets) o;
        return Double.compare(that.getTicketPrice(), getTicketPrice()) == 0 &&
                Double.compare(that.getKilometers(), getKilometers()) == 0 &&
                Double.compare(that.getPriceForBag(), getPriceForBag()) == 0 &&
                getFlight().equals(that.getFlight());
    }

    // overriding method hashCode
    @Override
    public int hashCode() {
        return Objects.hash(getFlight(), getTicketPrice(), getKilometers(), getPriceForBag());
    }
}
