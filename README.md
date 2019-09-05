Parsing a JSON file and insert all data in a H2 database using Spring Boot JPA. The JSON file contains details about books and its reviews from reviewers. We need to insert details of a book corresponding to its review details to the database. Moreover we have provided two API operations. One to get total JSON list converted from database object which reproduces the original JSON file and another API which takes "title"(Book's Title) as HTTP request parameter and gives a response JSON of only that book details and its review details as well.

We used Mockito Junit test framework to test API which takes title parameter.

EXECUTION:

1. After Successful execution, open your browser and hit http://localhost:8080/book/get

This will show you actual data in json format serialized from database.

2. Hit http://localhost:8080/h2-console

provide username as "kishor" and url as "jdbc:h2:mem:bookdb" and then connect. You will be able to see table structure and data.

3. Hit http://localhost:8080/getBook/Java%20book and it will return all details in json format for title Java Book.
