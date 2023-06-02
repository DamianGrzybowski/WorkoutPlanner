# WorkoutPlanner

This is a web-based application developed using Spring Boot, Spring MVC, Spring Data JPA, Spring Security, Hibernate, MySQL, and JSP. The Workout Planner Application allows users to create personalized training plans, perform CRUD operations on exercises, manage workout days, and associate workout days with training plans.

## Features
### User Management:
- User Registration: New users can create an account to access the application.
- During user registration, an email message is sent with a confirmation link .
- User Login: Registered users can securely log in to the application.
- If a user forgets their password, they have the option to reset it by receiving a password reset link sent to their provided email address.
- The user has the option to edit their data or delete their account, but only after confirming their credentials by providing their password.
### Exercise Management:
- CRUD Operations: Users can perform Create, Read, Update, and Delete operations on exercises.
### Workout Day Management:
- CRUD Operations: Users can create, view, update, and delete workout days.
- Exercise Assignment: Users can add exercises to specific workout days.
### Training Plan Management:
- CRUD Operations: Users can create, view, update, and delete training plans.
- Workout Day Association: Users can assign workout days to training plans.
- During the deletion of a training plan, the user can choose whether to delete the plan along with all the assigned training days or to delete only the plan itself.
## Technologies Used
- Spring Boot: A framework for creating Java applications with ease.
- Spring MVC: A web framework for building robust and scalable web applications.
- Spring Data JPA: Provides support for data access using the Java Persistence API (JPA).
- Spring Security: Offers security features for protecting the application and managing user authentication.
- Hibernate: An object-relational mapping (ORM) framework for Java.
- MySQL: A popular relational database management system used for data storage.
- JSP: JavaServer Pages technology for dynamic web page generation.

## Future updates
- Downloading a list of exercises from an external API and adding them to the database upon application startup.
- The user can only edit and delete the exercises they have created themselves. It is not possible to modify the exercises obtained from the external API.



If you have any ideas for what can be added to the application, feel free to share!
