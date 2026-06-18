package service;

import model.Service;

import java.util.*;

/**
 * Handles add-on services for reservations.
 */
public class AddOnServiceImpl implements AddOnService {

    // Map<ReservationId, List of Services>
    private final Map<String, List<Service>> reservationServices = new HashMap<>();

    @Override
    public void addService(String reservationId, Service service) {
        reservationServices
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);

        System.out.println("Service added to " + reservationId + ": " + service.getName());
    }

    @Override
    public List<Service> getServices(String reservationId) {
        return reservationServices.getOrDefault(reservationId, new ArrayList<>());
    }

    @Override
    public double calculateTotalCost(String reservationId) {
        return reservationServices.getOrDefault(reservationId, new ArrayList<>())
                .stream()
                .mapToDouble(Service::getPrice)
                .sum();
    }
}