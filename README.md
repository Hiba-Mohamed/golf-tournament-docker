# Golf Tournament API - Setup Guide

## Prerequisites
Before getting started, ensure you have the following installed:
- **IntelliJ IDEA**
- **Docker Desktop**
- **MySQL**
- **Postman**

## Steps to Get the Project Running

1. **Clone the Repository**
   - Open IntelliJ IDEA.
   - Select the option: **"Clone Repository"**.
   - Clone the repository using the provided HTTP link.

2. **Change Directory**
   - Navigate to the project directory.

3. **Build the Project**
   - Run the following commands:
     ```sh
     mvn install
     mvn clean package
     ```

4. **Start Docker Containers**
   - Ensure Docker Desktop is running.
   - Execute the following command:
     ```sh
     docker-compose up --build
     ```

5. **Verify Running Containers**
   - After running the above command, you will see two containers:
     1. **golf-tournament-docker** (MySQL Database)
        - MySQL version: `8.0`
        - Ports: `3306:3306`
     2. **golf-tournament-api** (Application API)
        - Ports: `8080:8080`
   - The database will be pre-populated with **3 sample members** and **2 sample tournaments**.

## Using Postman to Test API Endpoints

### Member Endpoints

- **Get all members:**
  ```http
  GET http://localhost:8080/allMembers
  ```
- **Add a new member:**
  ```http
  POST http://localhost:8080/addMember
  ```
  **Request Body:**
  ```json
  {
    "firstName": "John",
    "lastName": "Doe",
    "emailAddress": "doej@example.com",
    "phoneNumber": "1234567890",
    "startOfMembershipDate": "2025-01-01",
    "durationOfMembershipInDays": 365,
    "address": "123 Main St, Springfield, IL"
  }
  ```
- **Search member by first name:**
  ```http
  GET http://localhost:8080/getMemberByFirstName/Michael
  ```
- **Search member by last name:**
  ```http
  GET http://localhost:8080/getMemberByLastName/Smith
  ```
- **Search member by phone number:**
  ```http
  GET http://localhost:8080/getMemberByPhoneNumber/555-5678
  ```
- **Search member by start date:**
  ```http
  GET http://localhost:8080/getMemberByStartDate/2023-11-20
  ```

### Tournament Endpoints

- **Get all tournaments:**
  ```http
  GET http://localhost:8080/allTournaments
  ```
- **Add a new tournament:**
  ```http
  POST http://localhost:8080/addTournament
  ```
  **Request Body:**
  ```json
  {
    "startDate": "2025-05-01",
    "endDate": "2025-05-03",
    "location": "Greenfield Golf Course",
    "entryFee": 100.0,
    "cashPrizeAmount": 5000.0,
    "participatingMemberIds": [3, 2]
  }
  ```
- **Search tournament by start date:**
  ```http
  GET http://localhost:8080/getTournamentByStartDate/2025-04-10
  ```
- **Search tournament by location:**
  ```http
  GET http://localhost:8080/getTournamentByLocation/Pebble Beach
  ```
- **Search members by tournament ID:**
  ```http
  GET http://localhost:8080/getMembersInTournamentWithId/2
  ```
- **Search members by tournament start date:**
  ```http
  GET http://localhost:8080/getMembersByTournamentStartDate/2025-05-01
  ```

