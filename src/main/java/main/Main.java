package main;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        JsonSimpleParser parser = new JsonSimpleParser();
        String inPath = "/Users/artemtopoev/Desktop/Test tasks/Idea platform/IdeaProjectTestTask/src/main/resources/tickets.json";
        String outPath = "/Users/artemtopoev/Desktop/Test tasks/Idea platform/IdeaProjectTestTask/src/main/resources/result.txt";
        Root root = parser.parse(inPath);
        StringBuilder text = new StringBuilder();

        ArrayList<Ticket> tickets = root.getTickets();

        double averageFlightTime = parser.getAverageFlightTimeInMinutes(tickets);
        String averageFlightTimeString = "Среднее время полета в минутах: " + averageFlightTime + "\n";
        text.append(averageFlightTimeString);
        System.out.println(averageFlightTimeString);

        ArrayList<Ticket> ninetiethPercentileTickets = parser.get90thPercentile(tickets);
        System.out.println("90-й персентиль");
        text.append("90-й персентиль:\n");
        for (int i = 0; i < ninetiethPercentileTickets.size(); i++) {
            int serialNumber = i + 1;
            String s = serialNumber + ") Время рейса в минутах: "
                    + ninetiethPercentileTickets.get(i).getFlightTimeInMinutes();
            System.out.println(s);
            text.append(s);
        }

        TextFile.createTextFile(outPath, text);

    }

}
