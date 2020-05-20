# Design Patterns
My learning notes and exercises on design patterns.

## Creational Patterns
#### Abstract Factory
Provide an interface for creating families of related or dependent objects without specifying their concrete classes.

#### Builder
Separate the construction of a complex object from its representation so that the same construction process can create different representations.

#### Factory Method
Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.

#### Prototype a.k.a Clone
Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype.

#### Singleton
Ensure a class only has one instance, and provide a global point of access to it.


## Structural Patterns
#### Adapter
Convert the interface of a class into another interface clients expect. Adapter lets classes work together that couldn't otherwise because of incompatible interfaces.

#### Bridge
Decouple an abstraction from its implementation so that the two can vary independently.

#### Composite
Compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly.

#### Decorator
Attach additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

#### Facade
Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.

#### Flyweight a.k.a Cache
Use sharing to support large numbers of fine-grained objects efficiently.

## Behavioral Patterns


## Support Principles
S.O.L.I.D. Principles of Object Oriented Class Design

### Single-responsibility principle
A class should have one and only one reason to change, meaning that a class should have only one job.
### Open-closed principle
A module should be open for extension but closed for modification.

### Liskov substitution principle
Subclasses should be substitutable for their base classes.

### Interface segregation principle
A client should never be forced to implement an interface that it doesn't use or clients shouldn't be forced to depend on methods they do not use.

### Dependency Inversion Principle
Depend upon Abstractions. Do not depend upon concretions.


## References
* Design Patterns: Elements of Reusable Object-Oriented Software
* Design Principles and Design Patterns
* [RefactoringGuru](https://refactoring.guru/design-patterns)
* [JournalDev](https://www.journaldev.com/java/design-patterns)