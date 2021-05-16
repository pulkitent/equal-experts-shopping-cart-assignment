# equal-experts-shopping-cart-assignment
Equal Experts shopping cart (code pairing or machine coding round) assignment

For problem statement click this (check pdf here) - https://github.com/pulkitent/equal-experts-shopping-cart-assignment/blob/main/Problem%20Statement.pdf


# Version Number
72cf4fe47f85c39779267d0ecee07655a354e623


# Getting started (Run the application)
This assignment is getting driven by unit-tests or you can also go to ApplicationStartup.java and run the main method
(PS: No specific reason to make this project on Gradle)


# What the company is looking for or what are the company's expectations?

They are looking for people who can write code that has flexibility built-in, by adhering to the principles of Object-Oriented Development, and have the ability to deal with the real-life constraints/trade-offs while designing a system.

It is important to note that they are not looking for a GUI and they are not assessing you on the capabilities around code required to do the I/O. The focus is on the overall design. So, while building a solution, it would be nicer (not mandatory) if the input to the code is provided either via unit tests or a file. Using a command-line (for input) can be tedious and difficult to test, so it is best avoided (again not mandatory). Following is a list of things to keep in mind, before you submit your code for any LLD/OOD/OOPs round:

1. Clear identification of domain entities or classes and their relations with appropriate object modeling using composition.

2. Functionality should not be dumped in a single class, method, or file (don't create God class).

3. Write a clean Code with clear intention so as to have good readability (Proper Naming Conventions, Self-documenting code, Avoid redundant commenting, etc).

3. Clear and logical separation of responsibilities with proper boundaries (emphasis on single responsibility (SRP) for high cohesion).

4. Have you applied the principles of YAGNI and KISS?

5. Have you applied SOLID principles to your code?

6. Is the behavior of an object distinguished from its state and is the state encapsulated? 

7. Have you looked at basic refactoring to improve the design of your code?

8. Are the principles applied in a pragmatic way.

9. Code should be easily extensible & maintainable

11. Atomicity and Coverage of Unit Tests.

**Simplicity is the strongest trait of a piece of code. However, easily written code may not necessarily be simple code.**


# Why LLD/OOD/OOPs in software engineering interviews?

So main reason behind asking this kind of problems in an interview is to see whether a candidate can do the following:

1. Can a candidate write a working code in a given short span of time? So as to measure his/her delivery capability?

2. Can a candidate write highly readable, maintainable & extensible code? The intention must be clear by reading the code (Check 4 rules of simple design)

3. Can a candidate follow the principle of DRY (Don't Repeat Yourself) and avoid breaking encapsulation by following or Fat model pattern or Domain-Driven Design(DDD)? (Read tell don't ask principle and Law Demeter)

4. Can a candidate achieve the solution with a minimum number of elements using the YAGNI principle (that is without creating unnecessary interfaces etc)?


# Rules they want you to follow:

You should not use any external libraries to solve this problem, but you can use external libraries or tools for building or testing purposes. Specifically, you can use unit-testing libraries or build tools available for your chosen language (e.g., JUnit, Ant, NUnit, Rspec, Rake, etc.).

They assess a number of things including the design aspect of your solution and your object-oriented programming skills. While these are small problems, They expect you to submit what you believe is production-quality code; code that you’d be able to run, maintain and evolve. You don’t need to gold plate your solution, however, we are looking for something more than a bare-bones algorithm.


# Things I tried to follow in this project/repo:

1. Tried to create all the required domain entities/models as per the problem statement.

2. Tried not to break encapsulation by avoiding getters & setters (as much as possible).

3. Tried to have an immutable state with value objects (as much as possible) so as to avoid concurrency issues (Thread safety).

4. Tried to have readable methods & variables naming so as to clear the intention (4 rules of simple design).

5. Tried to have small & logical commits.

6. Tried to avoid code duplication by refactoring/reusing duplicate code (DRY).

7. Didn't make interfaces as per YAGNI principles because for now, I don't feel the need for the same (Yes, I am aware of this principle also - "Program to interfaces rather than concrete implementation").

8. Tried to put some comments so as to make business logic more understandable.

9. Wrote the job on every class so as to clear its use case.


# Things I could have done/improved in this project/repo if given more time :

1. TDD with 100% code coverage.

2. Code duplication can be further reduced to some extent.

3. Level of indentation can be further reduced in some methods by breaking them into smaller methods.

4. Encapsulation of behavior in some classes can be further improved.

5. More mocking and stubbing of test data in unit tests.


# Feedback I got after submitthing the assignment and I am also adding the counter points to that incorrect feedbacks

1. The solution currently models the collection of items in the cart as a List<Product> and returns this collection to consumers when they request the list of items in the cart. A better solution would have been to create a ShoppingCartItem class to better represent the domain.

Counterpoint - I don't agree to create a ShoppingCartItem class here because I don't see any noun named ShoppingCartItem in my problem statement. For now, List<Product> was serving the purpose. If ShoppingCartItem/CartItem/Item was written in the statement then obviously I would have created the corresponding domain entity. I think the reviewer isn't aware of this principle.


2. Adding the same product to the cart multiple times should increment the cart item count, not add the product again. The current implementation makes it very hard in the tests to ascertain the quantity of each product in the cart.

Counterpoint - Again I partially agree with this because I feel the reviewer is very much stubborn about his/her approach of going withShoppingCartItem solution. Also, he/she has mentioned that It was hard to test then it doesn't make sense to me because I just override equals & hashcode contracts in my model, and then testing was a cakewalk.


3. The total and tax calculations are currently embedded in the ShoppingCart class which results in the class doing more than it should. This functionality would be better off in a separate class

Counterpoint - I think the reviewer wasn't able to understand the intention here. I think the reviewer wasn't very much aware of how I implemented encapsulation here. So let me share my reasoning here, So in my domain, price is the data member (State) of the shopping class correct? Then according to the principle of encapsulation, all the related behaviors of the price should reside inside the shopping cart. In fact, I believe in fat models and thin services and If the reviewer is expecting me to create some other class (other than my domain entity) then that's feedback to him/her. He/She should go and learn Domain Model Pattern.

4. Too many classes - 10 classes are a bit too many for a problem of this complexity. Not sure the value of the following classes in the code: ProductType, User, and ApplicationStartup.

Counterpoint - This is the most eye-catching point to me. I would say may be I shouldn't have created User.java & ProductType enum but by reading "10 classes are a bit too many" I got stunned because according to the Domain model pattern (Object-Oriented Design) I feel we should create a class for every domain entity (noun) in our problem statement.
Moreover, If we would have removed ProductType & User class then I can still guarantee that at least 7-8 classes will be there, and also ApplicationStartup is just a startup class with the main method. Ideally, a smart reviewer should have ignored it by seeing that it's just a main class. Now, I am wondering whether he/she has actually put effort to open ApplicationStartup and see what's in it or not?
