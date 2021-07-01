package main;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class JsonSimpleParser {

    public Root parse(String path) {
        Root root = new Root();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(path)) {
            JSONObject rootJsonObject = (JSONObject) parser.parse(reader);
            JSONArray ticketsJsonArray = (JSONArray) rootJsonObject.get("tickets");

            ArrayList<Ticket> tickets = new ArrayList<>();
            for (Object item : ticketsJsonArray) {
                JSONObject ticketObject = (JSONObject) item;

                Ticket ticket = new Ticket();
                ticket.setOrigin((String) ticketObject.get("origin"));
                ticket.setOriginName((String) ticketObject.get("origin_name"));
                ticket.setDestination((String) ticketObject.get("destination"));
                ticket.setDestinationName((String) ticketObject.get("destination_name"));
                ticket.setDepartureDate((String) ticketObject.get("departure_date"));
                ticket.setDepartureTime((String) ticketObject.get("departure_time"));
                ticket.setArrivalDate((String) ticketObject.get("arrival_date"));
                ticket.setArrivalTime((String) ticketObject.get("arrival_time"));
                ticket.setCarrier((String) ticketObject.get("carrier"));
                ticket.setStops((Long) ticketObject.get("stops"));
                ticket.setPrice((Long) ticketObject.get("price"));
                ticket.setFullDepartureTime(getFullTime(ticket.getDepartureDate(), ticket.getDepartureTime()));
                ticket.setFullArrivalTime(getFullTime(ticket.getArrivalDate(), ticket.getArrivalTime()));

                tickets.add(ticket);
            }
            root.setTickets(tickets);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return root;
    }

    private LocalDateTime getFullTime(String stringDate, String stringTime) {
        String stringFullTime = stringDate + " " + stringTime;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy H:mm");
        return LocalDateTime.parse(stringFullTime, formatter);
    }

    public double getAverageFlightTimeInMinutes(ArrayList<Ticket> tickets) {
        double totalTime = 0;
        int ticketsCount = tickets.size();
        for (Ticket ticket : tickets) {
            long flightTimeInMinutes = ticket.getFlightTimeInMinutes();
            totalTime += flightTimeInMinutes;
        }
        return totalTime/ticketsCount;
    }
    //90-й персентиль времени полета - те билеты, у которых время полета меньше, чем у 90% остальных.
    // Т.е. 10% с лучшим временем полета
    public ArrayList<Ticket> get90thPercentile(ArrayList<Ticket> tickets) {
        int tenPercentsOfTickets = tickets.size() / 10;
        ArrayList<Ticket> sortedTicketsByFlightTime = getSortedArrayListByFlightTime(tickets);
        ArrayList<Ticket> ninetiethPercentileTickets = new ArrayList<>();
        for (int i = 0; i < tenPercentsOfTickets; i++) {
            ninetiethPercentileTickets.add(sortedTicketsByFlightTime.get(i));
        }
        return ninetiethPercentileTickets;
    }

    private ArrayList<Ticket> getSortedArrayListByFlightTime(ArrayList<Ticket> tickets) {
        ArrayList<Ticket> sortedArrayListByFlightTime = new ArrayList<>();
        int tenPercentCount = tickets.size() / 10;

        Collections.sort(tickets, new Comparator<Ticket>() {
            @Override
            public int compare(Ticket o1, Ticket o2) {
                return o1.getFlightTimeInMinutes().compareTo(o2.getFlightTimeInMinutes());
            }
        });

        for (int i = 0; i < tenPercentCount; i++) {
            sortedArrayListByFlightTime.add(tickets.get(i));
        }

        return sortedArrayListByFlightTime;

    }
}
