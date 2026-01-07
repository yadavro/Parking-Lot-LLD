# 🚗 Parking Lot System (LLD – Java)

## 📌 Overview

This project is a **Low-Level Design (LLD)** implementation of a **Parking Lot System** using **pure Java and Object-Oriented Design principles**.
It demonstrates how real-world parking systems can be modeled using **SOLID principles** and common **design patterns**.

The project is intentionally **framework-independent** (no Spring) to focus on **core design and clarity**, making it ideal for **interviews and system design practice**.

---

## 🎯 Features

* Supports multiple vehicle types:

  * Motorcycle
  * Car
  * Truck
* Supports multiple parking spot sizes:

  * Small
  * Medium
  * Large
* Multi-floor parking support
* Automatic ticket generation
* Hourly fee calculation
* Extensible design for pricing strategies

---

## 🧱 Design Principles Used

* **OOP Concepts**

  * Encapsulation
  * Inheritance
  * Polymorphism
  * Abstraction
* **SOLID Principles**

  * Open/Closed Principle
  * Single Responsibility Principle
* **Design Patterns**

  * Singleton → `ParkingLot`
  * Factory → `VehicleFactory`
  * Strategy → Fee calculation

---

## 📂 Project Structure

```
parking-lot/
│
├── src/main/java/com/parkinglot/
│
│── enums/
│   ├── VehicleType.java
│   ├── SpotType.java
│   └── TicketStatus.java
│
│── model/
│   ├── vehicle/
│   │   ├── Vehicle.java
│   │   ├── Car.java
│   │   ├── Motorcycle.java
│   │   └── Truck.java
│   │
│   ├── parking/
│   │   ├── ParkingLot.java
│   │   ├── ParkingFloor.java
│   │   └── ParkingSpot.java
│   │
│   └── ticket/
│       └── Ticket.java
│
│── strategy/
│   ├── FeeCalculationStrategy.java
│   └── HourlyFeeStrategy.java
│
│── factory/
│   └── VehicleFactory.java
│
│── Main.java
│
└── README.md
```

---

## 🅿️ Parking Rules

| Vehicle Type | Allowed Spot Types   |
| ------------ | -------------------- |
| Motorcycle   | Small, Medium, Large |
| Car          | Medium, Large        |
| Truck        | Large                |

---

## 🔁 Application Flow

### 🚗 Parking a Vehicle

1. Vehicle arrives at the parking lot
2. System searches for a suitable free spot
3. Spot is allocated
4. Ticket is generated with entry time

### 🚙 Unparking a Vehicle

1. Ticket is provided
2. Spot is freed
3. Exit time is recorded
4. Parking fee is calculated

---

## 💰 Fee Calculation Logic

* Pricing strategy: **Hourly**
* Minimum charge: **1 hour**
* Cost per hour: **₹50**

```java
Math.ceil((exitTime - entryTime) / (1000 * 60 * 60)) * 50
```

> Even a stay of a few seconds is charged as 1 hour.

---

## ▶️ How to Run

### Prerequisites

* Java 8 or higher
* Any IDE (IntelliJ / Eclipse / VS Code)

### Steps

1. Clone the repository
2. Open in IDE
3. Run:

   ```
   Main.java
   ```

---

## 🖥️ Sample Output

```text
Vehicle parked. Ticket issued.
Vehicle unparked. Fee = ₹50.0
```

---

## 🔧 Possible Enhancements

* Multiple entry and exit gates
* Per-minute billing
* Vehicle-based pricing
* Electric vehicle charging spots
* REST APIs (Spring Boot)
* Concurrency handling

---

## 🧠 Interview Explanation (Quick)

> “I designed the parking lot using a Singleton for global state, a Factory for vehicle creation, and a Strategy pattern for flexible fee calculation. The system is open for extension without modifying existing code.”

---

## 📜 License

This project is for **learning and interview preparation purposes**.
