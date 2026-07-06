# 🏨 BookMyStay – Complete Hotel Booking System

## 📌 Overview

**BookMyStay** is a scalable hotel booking system built using Core Java.
It demonstrates real-world system design by implementing multiple use cases that cover:

* Inventory management
* Room search
* Booking processing
* Room allocation
* Add-on services
* Booking history & reporting

The system is designed with **clean architecture, scalability, and performance** in mind.

---

## 🎯 Objectives

* Maintain a **single source of truth** for room inventory
* Provide **real-time room availability**
* Ensure **fair and consistent booking processing**
* Prevent **double booking issues**
* Support **additional services & billing**
* Maintain **booking history for reporting**

---

## 🏗️ Overall Architecture

```
Controller Layer → Service Layer → Data Structures → Response
```

### Key Principles:

* Separation of Concerns
* Object-Oriented Design
* Thread Safety
* Scalability

---

## ⚙️ Tech Stack

* Java 17+
* Core Java Collections
* ConcurrentHashMap
* Queue (LinkedList)
* HashMap / HashSet

---

# 📘 Use Cases Overview

---

## 🧩 UC1: Room Inventory Management

### 📌 Description

Manages hotel room inventory including types, availability, and pricing.

### ✅ Features

* Add room types
* Update availability & price
* Fetch room details
* View full inventory

### 🧠 Key Concept

* `ConcurrentHashMap<RoomType, RoomInventory>` for O(1) lookup & thread safety

---

## 🔍 UC2: Search Available Rooms

### 📌 Description

Displays only rooms that are currently available.

### ✅ Features

* Filter rooms with `count > 0`
* Show room type, count, and price

### 🧠 Key Logic

```java
if (count > 0) {
    result.add(room);
}
```

---

## 📥 UC3: Booking Request (Queue System - FCFS)

### 📌 Description

Processes booking requests using **First-Come-First-Served (FIFO)**.

### ✅ Features

* Queue-based booking system
* Fair allocation
* Sequential processing

### 🧠 Data Structure

```java
Queue<Reservation> bookingQueue = new LinkedList<>();
```

---

## 🏨 UC4: Reservation Confirmation & Room Allocation

### 📌 Description

Allocates rooms and ensures **no duplicate booking**.

### ✅ Features

* Unique Room ID generation
* Prevent double booking
* Real-time inventory update

### 🧠 Data Structures

```java
Set<String> bookedRoomIds
Map<RoomType, Set<String>> allocatedRooms
```

---

## ➕ UC5: Add-On Service Selection

### 📌 Description

Allows users to add optional services like breakfast, spa, etc.

### ✅ Features

* Multiple services per booking
* Cost calculation
* Flexible service model

### 🧠 Data Structure

```java
Map<String, List<Service>>
```

---

## 📊 UC6: Booking History & Reporting

### 📌 Description

Maintains complete booking records for tracking and reporting.

### ✅ Features

* Store all bookings
* Cancel reservations
* Generate reports

### 🧠 Data Structure

```java
List<Reservation>
```

---

# 🔄 End-to-End Flow

```
Search Rooms → Request Booking → Queue Processing → Room Allocation
→ Add Services → Store in History → Generate Report
```

---

# 🧪 Sample Execution

```
Added: SINGLE
Added: DOUBLE

Available Rooms:
SINGLE - 5
DOUBLE - 3

Processing bookings...
✅ BOOKED: RES1
❌ FAILED: RES2

Services Added:
Breakfast, Spa

Booking Report:
RES1 | CONFIRMED
RES2 | FAILED
```

---

# 📁 Project Structure

```
com.bookmystay
│
├── controller
├── service
├── model
├── exception
└── main
```

---

# ✅ Key Benefits

* ✔ Fast lookup (O(1))
* ✔ Fair booking system (FIFO)
* ✔ No double booking
* ✔ Scalable design
* ✔ Clean separation of layers
* ✔ Real-world system simulation

---

# ⚠️ Current Limitations

* No database integration
* No REST APIs
* No distributed system support
* Limited concurrency handling in advanced scenarios

---

# 🚀 Future Enhancements

* Spring Boot REST APIs
* Database (MySQL/PostgreSQL)
* Payment integration
* Distributed queue (Kafka/RabbitMQ)
* Redis caching
* Booking cancellation & refund system
* Analytics dashboard

---

# 👨‍💻 Author

**Prabhu Nagamani**

---

# 📌 Version

**v1.0 – Complete System (UC1 to UC6)**
