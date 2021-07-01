package main;

import java.time.Duration;
import java.time.LocalDateTime;

public class Ticket {
    private String origin;
    private String originName;
    private String destination;
    private String destinationName;
    private String departureDate;
    private String departureTime;
    private String arrivalDate;
    private String arrivalTime;
    private String carrier;
    private long stops;
    private long price;
    private LocalDateTime fullDepartureTime;
    private LocalDateTime fullArrivalTime;
    private Long flightTimeInMinutes;

    public Long getFlightTimeInMinutes() {
        return Duration.between(fullDepartureTime, fullArrivalTime).toMinutes();
    }


    public LocalDateTime getFullDepartureTime() {
        return fullDepartureTime;
    }

    public void setFullDepartureTime(LocalDateTime fullDepartureTime) {
        this.fullDepartureTime = fullDepartureTime;
    }

    public LocalDateTime getFullArrivalTime() {
        return fullArrivalTime;
    }

    public void setFullArrivalTime(LocalDateTime fullArrivalTime) {
        this.fullArrivalTime = fullArrivalTime;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOrigin_name() {
        return originName;
    }

    public void setOriginName(String origin_name) {
        this.originName = origin_name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public long getStops() {
        return stops;
    }

    public void setStops(long stops) {
        this.stops = stops;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
