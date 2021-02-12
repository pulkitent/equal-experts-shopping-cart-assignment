# equal-experts-shopping-cart-assignment
Equal Experts shopping cart (code pairing or machine coding round) assignment

For problem statement click this (check pdf here) - https://github.com/pulkitent/equal-experts-shopping-cart-assignment/blob/main/Problem%20Statement.pdf

# Version Number
72cf4fe47f85c39779267d0ecee07655a354e623

# Getting started (Run the application)
This assignment is getting driven by unit-tests or you can also go to ApplicationStartup.java and run the main method
(PS: No specific reason to make this project on Gradle)


# Things I tried to follow :
1. Tried to create all the required domain entities/models as per problem statement

2. Tried not to break encapsulation by avoiding getters & setters (as much as possible)

3. Tried to have immutable state with value objects (as much as possible) so as to avoid concurrency issues (Thread
   safety)

4. Tried to have readable methods & variables naming so as to clear the intention
   (4 rules of simple design).

5. Tried to have small & logical commits (Although submission should be anonymous hence I removed .git)

6. Tried to avoid code duplication by refactoring/reusing duplicate code (DRY)
   but still code duplication can be improved if given more time

7. Didn't make interfaces as per YAGNI principles because for now I don't feel the need for the same (Yes, I am aware of
   this principle also - "Program to interfaces rather than concrete implementation")

8. Tried to put some comments so as to make business logic more understandable


# Things I could have done/improved if given more time :
1. More mocking and stubbing of SUT in unit tests

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
