<h3>To run the application:</h3>
You can type in the command ./mvnw spring-boot:run <br>
or <br>
You can go to QueueApplication.java and click on the run button.
<br>

<h3>Payload: </h3>
You can send in the payload in the following format: <br>
{<br>
"Account Number" : "1827332",<br>
"Type" : "Credit",<br>
"Amount" : "100",<br>
"Currency" : "INR",<br>
"AccountFrom" : "182736123"<br>
}<br>
to <strong>http://localhost:8080/sender </strong> in a <strong>POST</strong> request.

<h3> Database: </h3>
Here, a volatile DB is used H2 which resets after each application run.
<br> to access it, please go to <strong>http://localhost:8080/h2-console/ </strong> and enter in the following details: <br>
Driver Class = org.h2.Driver <br>
JDBC URL = jdbc:h2:mem:transaction_data <br>
username = admin<br>
password = password<br>
<h5> you can also check out the logs in the application terminal where you run the QueueApplication.</h5>
