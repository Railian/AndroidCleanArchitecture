# Android Clean Architecture

The example of Clean architecture in Android using:
- **Kotlin** as the main language,
- **RxJava** as reactive way of data flow,
- **ViewModel** and **LiveData** for presentation layer,
- **Dagger 2** as an injector of dependencies.

The application is divided into 5 main modules:
- **Domain Contract (Core)**
- **Domain Logic (Business Logic)**
- **Platform**
- **Presentation**
- **Dependency Resolver**

<img src="https://lh6.googleusercontent.com/jpY-L2ccqlLLkyFGMlKMPmsZK5yN_iH4xX9Idxo9cFWSO2XTPwvf1a0TsL8w1XIcDjGhROYnAw8c8RE2LhaN=w2880-h1712-rw" width="400">

## Domain Contract (Core)

The core of the whole application is **Domain Contract**, were
you can find interfaces of _data sources_, _repositories_, _managers_,
_use cases_ and data classes of _entities_.

It does not have any implementation. This is only the contract for
the application.

## Domain Logic (Business Logic)
> dependencies: **Domain Contract**

This in the business logic of the application which is not depend
on **Platform** or **Presentation** layers.

Here you can find _repositories_ and _use cases_ implementations or
implementation of other interfaces from **Domain Contract** which is
not depend on **Platform**

## Platform
> dependencies: **Domain Contract**

In this module you should implement your _networking_, work with
_database_, _cache_ or different _managers_ and _use cases_ which
is depend on **Platform** (system or other three-part libraries).

## Presentation
> dependencies: **Domain Contract**

The layer for the implementation of view. It is include _view models_,
_activities_, _fragments_, _list adapters_, _view holders_,
_custom views_ and different _UI utils_.


## Dependency Resolver
> dependencies: **Domain Contract**, **Domain Logic**, **Platform**,
**Presentation**

This is the injector module which resolve all dependencies using dagger.
