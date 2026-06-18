# 🏨 BookMyStay – Room Inventory Management (Use Case 1)

## 📌 Overview

BookMyStay is a hotel booking system.
This module implements **Use Case 1: Room Inventory Setup & Management** using Core Java.

It provides a centralized way to manage hotel room inventory, including:

* Room types
* Availability counts
* Pricing

The system ensures **fast lookup, clean design, and scalability**.

---

## 🎯 Objective

To maintain a **single source of truth** for hotel room inventory with:

* O(1) access time
* Consistent data handling
* Easy extensibility for future features (booking, payments, etc.)

---

## 🧩 Features

* Add new room types (Single, Double, Suite)
* Update room availability count
* Update room pricing
* Fetch room details
* View complete inventory
* Thread-safe operations

---

## 🏗️ Project Structure

```
com.bookmystay
│
├── controller
│     └── InventoryController.java
│
├── service
│     ├── InventoryService.java
│     └── InventoryServiceImpl.java
│
├── model
│     ├── RoomType.java
│     └── RoomInventory.java
│
├── exception
│     └── RoomNotFoundException.java
│
└── MainApplication.java
```

---

## ⚙️ Tech Stack

* Java 17+
* Core Java Collections
* ConcurrentHashMap (for thread safety)

---

## 🧠 Key Design Concepts

### 1. Data Structure

* `ConcurrentHashMap<RoomType, RoomInventory>`
* Provides:

    * O(1) lookup
    * Thread-safe operations

### 2. Object-Oriented Design

* Encapsulation using `RoomInventory`
* Enum for fixed room types
* Service layer abstraction

### 3. Separation of Concerns

* Controller → Handles flow
* Service → Business logic
* Model → Data representation
* Exception → Error handling

---

## 🔄 Use Case Flow

```
Admin Action → Controller → Service → Inventory Map → Response
```

### Example Flow:

1. Add room type
2. Store in inventory
3. Update count/price
4. Fetch and confirm availability

---

## 🚀 How to Run

### 1. Compile

```bash
javac com/bookmystay/MainApplication.java
```

### 2. Run

```bash
java com.bookmystay.MainApplication
```

---

## 🧪 Sample Execution

```
Added: SINGLE
Added: DOUBLE
Updated count: SINGLE
Updated price: DOUBLE
RoomInventory{roomType=SINGLE, availableCount=8, pricePerNight=2000.0}
RoomInventory{roomType=DOUBLE, availableCount=5, pricePerNight=3700.0}
```

---

## 📏 Coding Standards Followed

* PascalCase → Class names
* camelCase → Methods & variables
* UPPER_CASE → Constants
* Proper JavaDocs for all classes
* Clean package structure

---

## ⚠️ Limitations

* No booking functionality yet
* No database persistence
* No concurrency locking for reservations

---

## 🔮 Future Enhancements

* Booking system (Use Case 2)
* Room locking (prevent double booking)
* Payment integration
* REST APIs (Spring Boot)
* Database integration (MySQL/PostgreSQL)
* Distributed cache (Redis)

---

## 👨‍💻 Author

Prabhu Nagamani

---

## 📌 Version

v1.0 – Use Case 1 (Room Inventory Management)
