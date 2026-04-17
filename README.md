# Real-Time Log Analytics Service (Sliding Window)

A Spring Boot based **Real-Time Log Analytics Service** that processes logs and computes metrics like **error count, total logs, and error rate** within a **sliding time window**.

This project demonstrates:

* Sliding Window Pattern
* Queue (Deque) based real-time processing
* Thread-safe service design
* REST API based log ingestion
* Real-time metrics calculation

---

# Features

* Ingest logs in real time
* Maintain only last **60 seconds** logs
* Get total logs count
* Get error logs count
* Get error rate %
* Thread-safe sliding window implementation
* O(1) real-time processing

---

# Problem This Project Solves

Monitoring systems need answers like:

* How many errors in last 60 seconds?
* Is traffic increasing suddenly?
* Is system failing right now?
* What is current error rate?

Instead of scanning entire logs, this service:

* Keeps only **recent logs**
* Removes old logs automatically
* Computes metrics instantly

---

# Architecture

Client → REST API → Sliding Window Service → Queue (Deque) → Metrics

Logs are stored in memory using a **Deque**.
Old logs are automatically removed when they fall outside the time window.

---

# Tech Stack

* Java 17+
* Spring Boot
* REST API
* Lombok
* Deque (ArrayDeque)
* Sliding Window Algorithm

---

#  API Endpoints

## Add Log

POST /logs

Request:

```json
{
  "level": "ERROR",
  "message": "Database failed"
}
```

Response:

```
Log added
```

## Get Total Logs

GET /logs/count

Response:

```
4
```

## Get Error Count

GET /logs/errors

Response:

```
2
```

## Get Error Rate

GET /logs/error-rate

Response:

```
50.0
```

# Sliding Window Logic

* Add new log to queue.
* Remove logs older than 60 seconds.
* Compute metrics from remaining logs.

---

# How To Run

Clone repository:
git clone https://github.com/your-username/log-analytics-service.git
Go to project:
cd log-analytics-service
Run application
mvn spring-boot:run
Server starts at:
http://localhost:8080

