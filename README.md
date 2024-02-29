# Amazon Seller Retail Application
Spring Boot RESTful API that updates Seller Retail statistics in the database and caches responses at certain time intervals.
Domain attributes and documentation were taken here: https://developer-docs.amazon.com/sp-api/docs/seller-retail-reports-attributes

### Features
- Registration of a new user
- User authorization
- Output of statistics for the specified date (or date range)
- Output of statistics for the specified ASIN (or list of ASINs)
- Output of aggregate statistics for all dates
- Summary statistics for all ASINs
- Updating all statistics at certain time intervals from the "test_report.json" file

### Getting started
To start application, the only thing that you need to do is to install and configure Java and MongoDB.
After successful application startup, you can use it in next ways:
- Sending request directly to the host: http://localhost:8080/api
- Interacting through Swagger UI: http://localhost:8080/api/swagger-ui/index.html
- Using Postman collection from the [here](AmazonSellerRetail.postman_collection.json)

### Used technologies
- Java 17
- Spring Boot 3.2.3
- Spring Web (REST API)
- Spring Data & Validation (MongoDB)
- Spring Cache
- Spring Security (JWT)
- Mapstruct
- Mockito & JUnit
- Testcontainers
- Swagger
