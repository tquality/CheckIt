# CheckIt 

![Maven Central](https://img.shields.io/maven-central/v/io.github.tquality/CheckIt.svg)

CheckIt is an easy to use class to assert and if the assert is not correct take a screenshot of the checkt webpage. The framework itself is split in several package with their own speciality. 

* DataCheck
* ObjectCheck
* StandardCheck

Next to these assert packages in the framework there is a class TakeScreenshot, this in order for you to use when needed seperate from the asserts.

## Datacheck
Datacheck contains all the classes to check the data on a webpage. In the current release we only check Text on the page, this is been done through the CheckText class. You can check the page source or with a check with xpath to find an element with the given text

## ObjectCheck
Objectcheck is the package with the classes containing check on the behaviour of the webelement. In this package we have 3 classes (CheckItIsDisplayed/CheckItIsEnabled/CheckItIsSelected). Every class checks a different status on how the object is viewed. In every class you can select the object using different selector types(name/id/xpath/cssselector/By object)

## StandardCheck
In the package StandardCheck you have several classes using more standard Asserts:

* CheckItBreaker: Simple breaker of a test and screenshot taker without checking specific status or objects.
* CheckItEquals: Checker if the given object is the same as the expected value, if not this will take a screenshot
* CheckItNotEqual: Checker if the given object is not the same as the expected value, if so this will take a screenshot
