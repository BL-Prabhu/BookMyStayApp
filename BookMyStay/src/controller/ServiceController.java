package controller;

import model.Service;
import service.AddOnService;

import java.util.List;

public class ServiceController {

    private final AddOnService addOnService;

    public ServiceController(AddOnService addOnService) {
        this.addOnService = addOnService;
    }

    public void addService(String reservationId, String serviceName, double price) {
        addOnService.addService(reservationId, new Service(serviceName, price));
    }

    public void viewServices(String reservationId) {
        List<Service> services = addOnService.getServices(reservationId);

        System.out.println("Services for Reservation " + reservationId + ":");
        for (Service s : services) {
            System.out.println("- " + s);
        }
    }

    public void getTotalCost(String reservationId) {
        double total = addOnService.calculateTotalCost(reservationId);
        System.out.println("Total Add-on Cost for " + reservationId + ": ₹" + total);
    }
}