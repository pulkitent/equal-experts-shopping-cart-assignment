# equal-experts-shopping-cart-assignment
Equal Experts shopping cart (code pairing or machine coding round) assignment

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
