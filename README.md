# 📘 Use Case 2 (UC2) – Search Available Rooms

## 📌 Overview

Use Case 2 allows users to **search for available rooms** in the system.
It retrieves room data from the inventory and displays only rooms that have **available count greater than zero**.

---

## 🎯 Objective

* Show all available rooms to the user
* Filter out rooms with zero availability
* Provide room details like:

  * Room Type
  * Available Count
  * Price

---

## 🏗️ Components Involved

### 1. **SearchController**

* Acts as the entry point for UC2
* Calls the service layer
* Displays results to the user

### 2. **SearchService**

* Interface defining search functionality

### 3. **SearchServiceImpl**

* Implements search logic
* Fetches data from InventoryService
* Filters available rooms

### 4. **InventoryService**

* Provides room count and price data

### 5. **RoomInventory Model**

* Represents room details (type, count, price)

---

## 🔄 Flow of Execution

1. User triggers search (via `SearchController`)
2. Controller calls `SearchService`
3. Service fetches:

  * Room counts
  * Room prices
4. Filters rooms where:

   ```
   count > 0
   ```
5. Returns list of available rooms
6. Controller displays results

---

## ⚙️ Key Logic

```java
if (count > 0) {
    result.add(new RoomInventory(type, count, price));
}
```

---

## ✅ Expected Output

### Case 1: Rooms Available

```
✅ Available Rooms:
RoomInventory{roomType=SINGLE, count=5, price=1200.0}
RoomInventory{roomType=DOUBLE, count=3, price=2000.0}
RoomInventory{roomType=SUITE, count=1, price=5000.0}
```

### Case 2: No Rooms Available

```
❌ No rooms available
```

---

## 🚫 Exception Handling Strategy

* ❌ No exception is thrown if no rooms are available
* ✅ Empty list is returned instead
* Improves user experience and prevents application crash

---

## 🧠 Design Decisions

* Uses **InventoryService** as a data source (separation of concerns)
* Uses **RoomInventory model** for structured data
* Avoids exposing internal data structures directly
* Keeps logic simple and scalable

---

## 🚀 Future Enhancements

* Filter by price range
* Filter by room type
* Add date-based availability
* Pagination for large datasets

---

## 🏁 Conclusion

UC2 successfully enables users to:

* View available rooms
* Get real-time inventory data
* Experience smooth and crash-free search functionality

---
