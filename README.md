# Prospecta-Assignment

# FakeStoreAPI

FakeStoreAPI is a Spring Boot-based project designed to provide a simple and efficient API for managing and interacting with products in a fake store. The application demonstrates the usage of RESTful services, exception handling, and a layered architecture.

## Table of Contents
- [Features](#features)
- [Directory Structure](#directory-structure)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [Usage](#usage)
  - [Get Products by Category](#get-products-by-category)
  - [Add a New Product](#add-a-new-product)
- [Contributing](#contributing)

## Features
- RESTful API for managing products.
- Comprehensive exception handling with custom exceptions.
- Lightweight and extensible architecture.

## Directory Structure
```plaintext
.idea/
FakeStoreAPI/
.mvn/wrapper/
    maven-wrapper.properties
src/
    main/java/com/fakestore/FakeStoreAPI/
        controller/
            ProductController.java
        entity/
            Product.java
            Rating.java
        exception/
            ErrorDetails.java
            GlobalExceptionHandler.java
            ProductNotFoundException.java
        service/
            ProductService.java
            ProductServiceImpl.java
        FakeStoreApiApplication.java
    resources/
test/java/com/fakestore/FakeStoreAPI/
.gitattributes
.gitignore
mvnw
mvnw.cmd
part3.txt
pom.xml
```

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.8+
- An IDE such as IntelliJ IDEA or Eclipse (optional)

### Installation
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd FakeStoreAPI
   ```

### Running the Application
1. Build the project:
   ```bash
   ./mvnw clean install
   ```
2. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

The application will start on `http://localhost:8080` by default.

## Usage

### Get Products by Category
Endpoint: `GET /store-api/v1/products/category/{category}`

**Example Request:**
```bash
GET http://localhost:8080/store-api/v1/products/category/men's clothing
```

**Example Response:**
```json
[
  {
    "id": 1,
    "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
    "price": 109.95,
    "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
    "category": "men's clothing",
    "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
    "rating": {
      "rate": 3.9,
      "count": 120
    }
  },
  {
    "id": 2,
    "title": "Mens Casual Premium Slim Fit T-Shirts ",
    "price": 22.3,
    "description": "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.",
    "category": "men's clothing",
    "image": "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg",
    "rating": {
      "rate": 4.1,
      "count": 259
    }
  }
]
```
Response Code: `200`

### Add a New Product
Endpoint: `POST /store-api/v1/products/`

**Request Body:**
```json
{
  "title": "Men's Shirt",
  "price": 699,
  "description": "Trendy men shirt",
  "category": "clothing",
  "image": "https://www.aristobrat.in/cdn/shop/files/BusinessClassShirt_White7.jpg?v=1724325491&width=500"
}
```

**Example Response:**
```json
{
  "id": 21,
  "title": "Men's Shirt",
  "price": 699.0,
  "description": "Trendy men shirt",
  "category": "clothing",
  "image": "https://www.aristobrat.in/cdn/shop/files/BusinessClassShirt_White7.jpg?v=1724325491&width=500",
  "rating": {
    "rate": 0.0,
    "count": 0
  }
}
```
Response Code: `201`

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.




