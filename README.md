# 📘 Use Case 4 (UC4) – Reservation Confirmation & Room Allocation

---

## 📌 Overview

Use Case 4 focuses on **finalizing bookings** by assigning **unique room IDs** and ensuring **zero double-booking**.

After processing booking requests (UC3), this stage:

* Allocates actual rooms
* Guarantees uniqueness
* Updates inventory instantly

---

## 🎯 Objective

* Assign unique room IDs to each booking
* Prevent duplicate room allocation
* Maintain strong booking integrity
* Synchronize inventory in real-time

---

## 🏗️ Key Data Structures

### 1. Track Booked Room IDs

```java
Set<String> bookedRoomIds = new HashSet<>();
```

* Ensures **no duplicate room IDs**
* Maintains global uniqueness

---

### 2. Room Allocation Mapping

```java
Map<RoomType, Set<String>> allocatedRooms = new HashMap<>();
```

* Maps each room type to its allocated room IDs
* Helps track assigned rooms per category

---

## 🧠 Key Concepts

### 🔹 Uniqueness Enforcement

Each room is assigned a **unique ID** using UUID.

### 🔹 Duplicate Prevention

HashSet ensures:

* No repeated room IDs
* No double booking

### 🔹 Atomic Allocation (Logical)

* Allocation + inventory update happen together
* Prevents inconsistent state

---

## ⚙️ Key Requirements

* Assign unique room IDs
* Prevent reuse of room IDs
* Update room availability immediately
* Maintain booking integrity

---

## 🎭 Actors

| Actor             | Role                            |
| ----------------- | ------------------------------- |
| Booking Service   | Processes and confirms bookings |
| Inventory Service | Maintains room availability     |

---

## 🔄 Flow of Execution

1. Dequeue booking request
2. Check room availability
3. Generate unique room IDs
4. Store IDs in HashSet
5. Map IDs to room type
6. Update inventory count

```
Dequeue → Allocate Room ID → Store in Set → Update Inventory
```

---

## ✅ Key Benefits

* ✔ Strong booking integrity
* ✔ Zero double-booking
* ✔ Instant inventory synchronization
* ✔ Clear room tracking
* ✔ Production-ready design

---

## ⚠️ Limitations of Previous Approach (UC3)

| Problem               | Description                        |
| --------------------- | ---------------------------------- |
| Room overlap          | Same room could be allocated twice |
| No uniqueness         | No tracking of actual room IDs     |
| Guest dissatisfaction | Conflicts during check-in          |

---

## 🚀 How UC4 Solves It

| Issue              | Solution                          |
| ------------------ | --------------------------------- |
| Duplicate booking  | HashSet ensures uniqueness        |
| No room tracking   | Map stores allocated rooms        |
| Inventory mismatch | Immediate update after allocation |

---

## 🧪 Example Output

```
Processing bookings...

✅ BOOKED: R1 Rooms: [SINGLE-a12bc]
✅ BOOKED: R2 Rooms: [SINGLE-x78yz]
❌ FAILED: R3 | Not enough rooms
```

---

## 🔮 Future Enhancements

* Thread-safe allocation (ConcurrentHashMap)
* Persistent storage (Database)
* Distributed locking (Redis)
* Payment confirmation before allocation
* Booking cancellation & rollback

---

## 🏁 Conclusion

UC4 ensures a **robust and reliable booking system** by:

* Guaranteeing unique room allocation
* Preventing duplicate bookings
* Maintaining real-time inventory consistency

This design reflects **real-world booking systems** used in:

* Hotels
* Airlines
* Ticketing platforms

---
