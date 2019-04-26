@FileScannerTest
Feature: Files Information

  As a user
  I want to scan all the files in specific directory
  So that I can find the supported files

  Scenario Outline: Retrieve all the supported files information
    Given I have specified directory "<FileDirectory>" in the file system
    Then I should retrieve all the supported files information

    Examples:
      | FileDirectory                    |
      | C:\Gireesh\FileTypes |
