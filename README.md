# Makkajai Dev Challenge – Sales Tax Calculator

This project is a Java-based command-line application built for the Makkajai Developer Challenge. It calculates the sales tax for a list of purchased items based on whether the items are exempt or imported, and provides a receipt with the total sales tax and final price.

---

## 🚀 Features

- Calculates **basic sales tax (10%)** for general goods
- Applies **import duty (5%)** for imported items
- Recognizes **exempt items** like books, food, and medical products
- Rounds taxes to the nearest **0.05** as required
- Clean receipt output with line items, total taxes, and total amount
- Follows SOLID principles and uses **Strategy** and **Factory** design patterns

---

## 🧱 Tech Stack

- Java 17+
- IntelliJ IDEA
- Git for version control

---

Design Overview
🔄 Strategy Pattern
TaxStrategy interface allows encapsulating different tax calculation logic.

Implemented via StandardTaxStrategy and ExemptTaxStrategy.

🏭 Factory Pattern
ItemFactory creates the correct subclass (TaxableItem or ExemptItem) with the appropriate TaxStrategy.

🧱 Abstraction & Polymorphism
Item is abstract and extended by TaxableItem and ExemptItem.

ReceiptItem and Receipt depend on the base class, enabling polymorphic behavior.


| Principle                 | Application                                                  |
| ------------------------- | ------------------------------------------------------------ |
| **S**ingle Responsibility | Parsing, Tax Logic, Receipt printing are separated           |
| **O**pen/Closed           | New item types or tax rules can be added via subclasses      |
| **L**iskov Substitution   | `ExemptItem` and `TaxableItem` can replace `Item`            |
| **I**nterface Segregation | Only necessary methods exposed through interfaces            |
| **D**ependency Inversion  | Receipt relies on abstractions, not concrete implementations |




