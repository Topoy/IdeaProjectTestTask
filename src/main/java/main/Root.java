package main;

import java.util.ArrayList;
import java.util.List;

public class Root {
    ArrayList<Ticket> tickets = new ArrayList<>();

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }
}
