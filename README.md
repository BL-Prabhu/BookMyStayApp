# 📘 Use Case 3 (UC3) – Booking Request (First-Come-First-Served)

---

## 📌 Overview

Use Case 3 introduces a **Booking Queue System** that processes room reservations using the **First-Come-First-Served (FCFS)** principle.

Instead of handling booking requests in parallel (which can cause inconsistencies), requests are **queued and processed sequentially**, ensuring fairness and reliability.

---

## 🎯 Objective

* Accept booking requests from users
* Maintain strict **arrival order (FIFO)**
* Allocate rooms fairly during high demand
* Prevent inconsistent or duplicate bookings

---

## 🏗️ Key Data Structures

### Queue for Booking Requests

```java
Queue<Reservation> bookingQueue = new LinkedList<>();
```

* Stores incoming booking requests
* Ensures **FIFO (First-In-First-Out)** processing
* Maintains order of arrival

---

## 🧠 Key Concepts

### 1. FIFO Principle

* Requests are processed in the exact order they arrive
* First request → First processed

### 2. Fair Allocation

* Every user gets equal opportunity
* No request skipping or priority bias

### 3. Request Ordering

* Ensures predictable system behavior
* Important during peak traffic

---

## ⚙️ Key Requirements

* Accept booking requests
* Add requests to queue
* Process requests sequentially
* Allocate rooms based on availability
* Handle high-traffic scenarios safely

---

## 🎭 Actors

| Actor                 | Role                                 |
| --------------------- | ------------------------------------ |
| Guest                 | Sends booking request                |
| Booking Queue Service | Manages queue and processes requests |

---

## 🔄 Flow of Execution

1. Guest sends booking request
2. Request is added to queue
3. System processes requests one-by-one
4. Room availability is checked
5. Booking is confirmed or rejected

```
Booking Request → Enqueue → Process → Allocate Room
```

---

## ✅ Key Benefits

* ✔ Predictable booking order
* ✔ No race conditions at request level
* ✔ Fair allocation for all users
* ✔ Handles high traffic efficiently
* ✔ Real-world booking simulation

---

## ⚠️ Limitations of Previous Approach

| Problem                 | Description                         |
| ----------------------- | ----------------------------------- |
| Parallel Requests       | Multiple users booking at same time |
| Race Conditions         | Same room booked multiple times     |
| Inconsistent Allocation | Unfair booking results              |

---

## 🚀 How UC3 Solves It

| Issue              | Solution               |
| ------------------ | ---------------------- |
| Concurrency issues | Queue-based processing |
| Double booking     | Sequential execution   |
| Unfair allocation  | FIFO ordering          |

---

## 🔮 Future Enhancements

* Priority queue (VIP users)
* Timeout for stale requests
* Distributed queue (Kafka / RabbitMQ)
* Retry mechanism for failed bookings
* Payment integration before confirmation

---

## 🏁 Conclusion

UC3 ensures a **fair, consistent, and scalable booking system** by:

* Enforcing strict request order
* Eliminating race conditions
* Providing real-world reliability during peak demand

---
