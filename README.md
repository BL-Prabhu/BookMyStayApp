# 📘 Use Case 6: Booking History & Reporting

## 📌 Overview

This module maintains a complete history of all bookings, enabling tracking, cancellation, and reporting.

---

## 🎯 Goal

Maintain a reliable and structured booking history for audit and reporting.

---

## 🧠 Key Concepts

* Ordered data storage (List)
* Historical tracking
* Audit trail
* Reporting system

---

## 🗂️ Data Structure

* `List<Reservation>` → Stores all confirmed bookings

---

## ⚙️ Features

* Store confirmed bookings
* Cancel reservations
* Retrieve booking history
* Generate reports

---

## 👥 Actors

* Admin
* Reporting Service

---

## 🔄 Flow

Booking Confirmed → Add to List → Store → Retrieve → Report

---

## 💻 Sample Output

===== BOOKING REPORT =====
RES1 | SINGLE | Rooms: 1 | Status: CANCELLED
RES2 | SINGLE | Rooms: 2 | Status: CONFIRMED

---

## ✅ Benefits

* Full audit trail
* Easy reporting
* Better customer support

---

## 🚀 Future Enhancements

* Database integration
* Export reports (PDF/CSV)
* Analytics dashboard
