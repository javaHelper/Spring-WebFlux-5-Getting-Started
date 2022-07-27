# Spring WebFlux 5: Getting Started

- Find Products
GET -> `http://localhost:8080/products`

Response:

````sh
[
    {
        "id": "62e1177a18425678556ff2c5",
        "name": "Headphones",
        "price": 100.0
    },
    {
        "id": "62e1177a18425678556ff2c6",
        "name": "Shoes",
        "price": 220.0
    },
    {
        "id": "62e1177a18425678556ff2c7",
        "name": "Laptop",
        "price": 4000.0
    },
    {
        "id": "62e1177a18425678556ff2c8",
        "name": "Sony TV",
        "price": 750.0
    },
    {
        "id": "62e1177a18425678556ff2c9",
        "name": "Hero Car",
        "price": 7000.0
    },
    {
        "id": "62e1177a18425678556ff2ca",
        "name": "Cycle",
        "price": 600.0
    }
]
````
- Find By Id

GET -> `http://localhost:8080/products/62e1177a18425678556ff2c5`

- Create Product

````sh
curl --location --request POST 'http://localhost:8080/products' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Video Game",
    "price": 80
}'
````
Response:
````sh
{
    "id": "62e1187f18425678556ff2cb",
    "name": "Video Game",
    "price": 80.0
}
````

- Update Product

````sh
curl --location --request PUT 'http://localhost:8080/products/62e1187f18425678556ff2cb' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Video Game33",
    "price": 83
}'
````

- Delete Produ

GET -> `http://localhost:8080/products/62e1187f18425678556ff2cb`