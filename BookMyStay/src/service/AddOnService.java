package service;

import model.Service;
import java.util.List;

public interface AddOnService {

    void addService(String reservationId, Service service);

    List<Service> getServices(String reservationId);

    double calculateTotalCost(String reservationId);
}