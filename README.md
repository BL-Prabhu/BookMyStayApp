# 📘 Use Case 5: Add-On Service Selection

---

## 📌 Overview

This module enables guests to enhance their booking experience by adding optional services such as **breakfast, spa, and airport pickup**.
It supports multiple services per reservation and calculates the total additional cost.

---

## 🎯 Goal

Enhance bookings with optional services and ensure accurate and automated cost calculation.

---

## 🧠 Key Concepts

* One-to-many mapping (One reservation → Multiple services)
* Composition (Services attached to reservation)
* Extensible service model

---

## 🗂️ Key Data Structures

* `Map<String, List<Service>>`

    * Maps **Reservation ID → List of Services**

---

## ⚙️ Features

* Add multiple services to a reservation
* View all selected services
* Calculate total add-on cost
* Easy to extend with new services

---

## 👥 Actors

* Guest
* Service Management Module

---

## 🔄 Flow

1. Guest selects an add-on service
2. Service is added to the reservation
3. Stored in a map against reservation ID
4. Multiple services can be added
5. Total cost is calculated when required

---

## 📦 Project Structure

```text
model/
  ├── Service.java
  ├── Reservation.java
  └── RoomType.java

service/
  ├── AddOnService.java
  └── AddOnServiceImpl.java

controller/
  └── ServiceController.java

main/
  └── BookMyStayApplication.java
```

---

## ▶️ How to Run

1. Compile the project
2. Run `BookMyStayApplication.java`
3. Observe console output

---

## 💻 Sample Output

```text
Service added to RES123: Breakfast
Service added to RES123: Spa
Service added to RES123: Airport Pickup

Services for Reservation RES123:
- Breakfast (₹500.0)
- Spa (₹1500.0)
- Airport Pickup (₹800.0)

Total Add-on Cost for RES123: ₹2800.0
```

---

## ✅ Benefits

* Flexible service attachment
* Clean mapping between reservation and services
* Accurate billing
* Easy future expansion

---

## ⚠️ Limitations of Previous Approach

* Manual service handling
* Billing errors
* No structured mapping
* Difficult to scale

---

## 🚀 Future Enhancements

* Categorize services (Food, Travel, Wellness)
* Integrate with billing module
* Add discount and offers
* Store data in database
* Expose REST APIs

---
