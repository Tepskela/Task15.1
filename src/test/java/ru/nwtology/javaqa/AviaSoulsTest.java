package ru.nwtology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {

    @Test
    public void testCompareTo() {
        AviaSouls avia = new AviaSouls();
        Ticket ticket1 = new Ticket("UK", "SPB", 150, 5, 8);
        Ticket ticket2 = new Ticket("SPB", "UK", 200, 10, 15);
        Ticket ticket3 = new Ticket("UK", "SPB", 300, 6, 13);
        Ticket ticket4 = new Ticket("MSK", "UK", 350, 3, 10);
        Ticket ticket5 = new Ticket("UK", "SPB", 400, 15, 19);
        Ticket ticket6 = new Ticket("UK", "SPB", 150, 10, 16);
        Ticket ticket7 = new Ticket("MSK", "NW", 250, 13, 18);
        Ticket ticket8 = new Ticket("UK", "SPB", 200, 9, 19);
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);
        avia.add(ticket7);
        avia.add(ticket8);

        Ticket[] expected = {ticket1,ticket3, ticket5, ticket6, ticket8};
        Ticket[] actual = avia.search("UK", "SPB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTickets() {
        AviaSouls avia = new AviaSouls();
        Ticket ticket1 = new Ticket("UK", "SPB", 150, 5, 8); //3
        Ticket ticket2 = new Ticket("SPB", "UK", 200, 11, 15);//4
        Ticket ticket3 = new Ticket("UK", "SPB", 300, 6, 13); //7
        Ticket ticket4 = new Ticket("SPB", "UK", 350, 3, 10);//7
        Ticket ticket5 = new Ticket("UK", "SPB", 400, 15, 19);//4
        Ticket ticket6 = new Ticket("UK", "SPB", 150, 10, 16);//6
        Ticket ticket7 = new Ticket("SPB", "UK", 250, 13, 18); //5
        Ticket ticket8 = new Ticket("UK", "SPB", 200, 9, 19);//10
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);
        avia.add(ticket7);
        avia.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();


        Ticket[] expected = {ticket2,ticket7, ticket4};
        Ticket[] actual = avia.search("SPB", "UK");

        Assertions.assertArrayEquals(expected, actual);
    }

}