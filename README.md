# QuickStop Essentials

CPAN-228 Web Application Development
Assignment 0: Project Planning & GitHub Setup

## Group Information

Group Assignment: New Group 8  
Group Name: QuickStop Devs

## Group Members

* Amber Forrest
* Garv Dugh
* Murat Sasmaz

## Project Category

Category 1: E-Commerce Platform

## Project Description

QuickStop Essentials is our group project idea for the E-Commerce Platform category.

The main idea is to create a mobile-friendly app for people who are on the go and need urgent daily items. For example, a driver may need motor oil or windshield washer fluid, a student may need a phone charger, or someone may need personal care items like deodorant, shampoo, toothpaste, or basic clothing.

Users can open the app, choose a nearby pickup location, check which products are in stock, place an order, and pick up the order quickly.

This is not just a normal online store. It is more like a quick pickup app for urgent daily needs.

## Product Categories

We plan to use four main product categories:

1. Auto Essentials
   Motor oil, oil filter, air filter, wiper blades, windshield washer fluid, phone charger

2. Personal Care
   Shampoo, deodorant, perfume, toothpaste, hand sanitizer, wet wipes

3. Tech Essentials
   USB-C cable, iPhone cable, power bank, phone holder, earbuds

4. Basic Clothing
   Socks, t-shirts, hoodies, gloves, winter hats

## Main User Flow

The basic flow of the app is:

1. The user opens the app.
2. The user chooses a nearby pickup location.
3. The user checks available products and stock.
4. The user adds products to the cart.
5. The user places an order.
6. The user picks up the order from the selected pickup location.

## Main Entities

Our main entities are:

* User
* Product
* Brand
* Category
* Inventory
* Pickup Location
* Order
* Order Item

## Simple Relationship Summary

* A user can place many orders.
* An order can have many order items.
* A product belongs to a brand and category.
* Inventory connects products with pickup locations.
* A pickup location can have many products in stock.
* A pickup location can also be connected to many orders.

## Files in This Repository

The main final file for submission is:

**QuickStop_Essentials_Assignment_0_Final.docx**

Other files in this repository are supporting files, such as:

* ER diagram image
* Wireframe document
* Draft documents from group members

## Planned Technologies

For the next assignments, we plan to use:

* Spring Boot
* Spring Web
* Thymeleaf
* Spring Data JPA
* Spring Security
* Spring Data REST
* H2 Database or MySQL

## Note

This is Assignment 0, so it is mainly the planning phase. No full coding is required yet. This repository is used to share our project plan, domain model, ER diagram, and wireframes.
