package com.company;

import com.company.model.BusinessClassTickets;
import com.company.model.LowCostTickets;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Kateryna Basova KHNUE
 * @version 22 of June 2020
 *
 * Classname Main
 * The main class where all actions will be executed
 *
 * Laboratory work №2. Object-oriented programming,  JavaCollectionFramework
 * Choose a subject according to your number. Develop a service using all your best in OOP and Java collections.
 * Six methods must be written like in the following example. A point for each one.
 *
 * /----------------  Subjects according to my birthday (16 of October --> variant 6) ------------------
 * 6. Air fly : low-cost and business-class.
 **/
public class Main {

    public static void main(String[] args) {

        // There are 2 Flights types: low-cost and business-class.
        // 1. Create two appropriate classes and 5 objects of each one.

        // creating low-cost ticket objects
        LowCostTickets ticket1 = new LowCostTickets("Kharkiv - Bratislava", 15.00, 1799.4, 10.00);
        LowCostTickets ticket2 = new LowCostTickets("Hong Kong - Bangkok", 25.00, 1728, 20);
        LowCostTickets ticket3 = new LowCostTickets("Vienna - Barcelona", 20.00, 1780, 10.00);
        LowCostTickets ticket4 = new LowCostTickets("Cagliari - Milan", 30.00, 884.9, 10.00);
        LowCostTickets ticket5 = new LowCostTickets("London - Paris", 15.00, 472.2, 15.00);

        // creating business class ticket objects
        BusinessClassTickets ticket6 = new BusinessClassTickets("Bratislava - Kharkiv", 200, 1799.4);
        BusinessClassTickets ticket7 = new BusinessClassTickets("Bangkok - Hong Kong", 430, 1728);
        BusinessClassTickets ticket8 = new BusinessClassTickets("Barcelona - Vienna", 180, 1780);
        BusinessClassTickets ticket9 = new BusinessClassTickets("Milan - Cagliari", 210, 884.9);
        BusinessClassTickets ticket10 = new BusinessClassTickets("Paris - London", 450, 884.9);

        // create an Array List to store all tickets
        List<IAccounting> tickets = new ArrayList<>();

        // filling up the Array List
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);
        tickets.add(ticket9);
        tickets.add(ticket10);

        // -------------------------------------------------------------------
        // 2. Calculate the total revenue of all flights.
        double totalRevenue = tickets.stream().mapToDouble(IAccounting::getPrice).sum();
        System.out.println("The total revenue of all flights: " + totalRevenue);

        // -------------------------------------------------------------------
        // 3. Find a ticket with the highest price.

        // using stream to get ticket with the highest price
        IAccounting highestPriceTicket = tickets.stream()
                    .max(Comparator.comparingDouble(IAccounting::getPrice))
                    .orElse(null);
        // printing the result
        System.out.println("A ticket with the highest price: " + highestPriceTicket);

        // -------------------------------------------------------------------
        // 4. Find a ticket with the lowest price.

        // using stream to get ticket with the lowest price
        IAccounting lowestPriceTicket = tickets.stream()
                .min(Comparator.comparingDouble(IAccounting::getPrice))
                .orElse(null);
        // printing the result
        System.out.println("A ticket with the lowest price: " + lowestPriceTicket);

        // -------------------------------------------------------------------
        // 5. Define the average price among all tickets.

        // using stream to get the average price among all tickets
        double averagePrice = tickets.stream().mapToDouble(IAccounting::getPrice)
                .average().orElse(0);

        System.out.println("The average price among all tickets: " + averagePrice);

        // -------------------------------------------------------------------
        // 6. Which type of Flight has more revenue: low-cost and business-class?

        // using stream to sum revenue for business class flights
        double businessClassRevenue = tickets.stream().filter(el -> el instanceof BusinessClassTickets)
                .mapToDouble(IAccounting::getPrice).sum();
        System.out.println("Business class flights revenue is: " + businessClassRevenue);

        // using stream to sum revenue for low-cost flights
        double LowCostRevenue = tickets.stream().filter(el -> el instanceof LowCostTickets)
                .mapToDouble(IAccounting::getPrice).sum();
        System.out.println("Low-cost flights revenue is: " + LowCostRevenue);

        // printing comparison result
        if (businessClassRevenue > LowCostRevenue) {
            System.out.println("Busines class flight type has more revenue than low-cost.");
        } else if (businessClassRevenue < LowCostRevenue) {
            System.out.println("Low-cost flight type has more revenue than busines class .");
        } else {
            System.out.println("Both flight types have the save revenue.");
        }
    }
}
