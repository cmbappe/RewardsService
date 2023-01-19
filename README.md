# RewardsService
 Problem:

A retailer offers a rewards program to its customers awarding points based on each recorded purchase as follows:

For every dollar spent over $50 on the transaction, the customer receives one point.
In addition, for every dollar spent over $100, the customer receives another point.
Ex: for a $120 purchase, the customer receives
(120 - 50) x 1 + (120 - 100) x 1 = 90 points


Given a record of every transaction during a three-month period, calculate the reward points earned for each customer per month and total. 

Tables and initial data

Customer
| ID | Name             |
| ---|:----------------:|
| 1  | Christian Mbappe |
| 2  | John Doe         |
| 3  | Allie Burnrow    |

Transaction
| ID | Anount | Transaction_date | Customer_id|
| ---|--------|:----------------:| ----------:|
| 1  | 120.0	 | 2022-11-24	      | 1          |
|	2  | 40.0	  | 2022-12-15	      | 1          |
| 3	 | 70.0	  | 2023-01-03       |	1          |
| 4	 | 160.0 	| 2023-01-15       |	2          |
| 5	 | 95.0	  | 2023-01-16       |	2          |
| 6	 | 50.0	  | 2022-11-30       |	3          |
| 7  |	100.0	 | 2022-12-23       |	3          |



Endpoints:
- http://localhost:8080/rewards-service/customers/{id} (Get customer's total points)
Example: http://localhost:8080/rewards-service/customers/1
  ![Total points Customer 1 ](assets/total_points_customer_1.png?raw=true "Total points Customer 1")
  Example: http://localhost:8080/rewards-service/customers/3
  ![Total points Customer 3 ](assets/total_points_customer_3.png?raw=true "Total points Customer 3")
  Example: http://localhost:8080/rewards-service/customers/5
  ![Customer not found ](assets/customer_not_found_message.png?raw=true "Customer not found")

- http://localhost:8080/rewards-service/customers/{id}/{month} (Get customer's points of the month)
Example: http://localhost:8080/rewards-service/customers/1/1
  ![Monthly points Customer 1 month 1 ](assets/monthly_points_customer_1_month_1.png?raw=true "Monthly points Customer 1 month 1")
  Example: http://localhost:8080/rewards-service/customers/3/4
  ![Month not found ](assets/month_not_found_message.png?raw=true "Month not found")

- http://localhost:8080/swagger-ui/index.html (Api documentation)
  ![Api Documentation](assets/api_documentation.png?raw=true "Api documentation")

- http://localhost:8080/actuator/health (Api health check)
  ![Health check](assets/health_check.png?raw=true "Health check")

Unit Tests

![Unit Tests](assets/Unit_tests.png?raw=true "Unit tests")
