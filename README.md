# GoMedia Automation Test

Demonstration to automate the single page application as the url:
 https://skyronic.github.io/vue-spa/#/


## Getting Started



### Prerequisites

Software required

- IntelliJ IDE (Community Edition) 
https://www.jetbrains.com/idea/download/#section=mac

- JDK 11 or above 
https://openjdk.java.net/install/index.html

Google Chrome web browser

### Installing

Extract/clone to your required directory.
Open the project folder in Intelli J

Ensure Project SDK is installed.
Go to File -> Project Structure -> Project

## Running the tests

The tests can be run from a multiple of ways

Using a JUnit runner file

To run the tests go to:
src => main => java => runnerfiles

Run from the feature file (more descriptive on what the tests are doing)

To run the test go to:
src => test => resources => features


### Break down into end to end tests

There are 3 test:

1) Test that the page loads onto the correct url, displays 3 item, check the display order and prices

2) Test that the selected product go to the correct page, checks the instock value and that the add to cart button is present.
Second part of the test is to add the item to the cart, verify that the cart has been updated and the in stock value as has also been updated.

3) This will test whether an out of stock item can be added to the cart, by first adding all items to the cart then attempting to add another item.

All the tests have been created to provide positive results, to fail the test just change any of the value highlight in blue in the feature filed.



## Authors

* **Stephen Hunte** - *Initial work* 

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

