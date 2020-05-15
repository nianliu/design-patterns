# Design Patterns





The Acyclic Dependencies Principle (ADP)
The dependencies betwen packages must not form cycles.

The Stable Dependencies Principle (SDP)
Depend in the direction of stability.

The Stable Abstractions Principle (SAP)
Stable packages should be abstract packages.

## Creational Patterns
#### Abstract Factory
Provide an interface for creating families of related or dependent objects without specifying their concrete classes.

#### Builder
Separate the construction of a complex object from its representation so that the same construction process can create different representations.

#### Factory Method
Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.

#### Prototype
Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype.

#### Singleton
Ensure a class only has one instance, and provide a global point of access to it.


## Structural Patterns
#### Adapter
Convert the interface of a class into another interface clients expect. Adapter lets classes work together that couldn't otherwise because of incompatible interfaces.


## Behavioral Patterns


## Support Principles

*S.O.L.I.D. Principles of Object Oriented Class Design*

### Single-responsiblity principle
A class should have one and only one reason to change, meaning that a class should have only one job.
###
O - Open-closed principle
L - Liskov substitution principle
I - Interface segregation principle
D - Dependency Inversion Principle


The Open Closed Principle (OCP) 1
A module should be open for extension but closed for modification.

The Liskov Substitution Principle (LSP)
Subclasses should be substitutable for their base classes.

The Dependency Inversion Principle (DIP)
Depend upon Abstractions. Do not depend upon concretions.

The Release Reuse Equivalency Principle (REP)
The granule of reuse is the granule of release.

The Common Closure Principle (CCP)
Classes that change together, belong together.

The Common Reuse Principle (CRP)
Classes that aren’t reused together should not be grouped together.


## References
* [RefactoringGuru](https://refactoring.guru/design-patterns)
* [JournalDev](https://www.journaldev.com/java/design-patterns)
* Design Patterns: Elements of Reusable Object-Oriented Software
