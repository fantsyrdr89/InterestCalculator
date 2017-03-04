# eightbitsakathebigbyte.InterestCalculator
Source Repository for the Interest Calculator project

mysql CLI commands for setting up local db

mySql> Create database interestCalculatorDatabase;

mySql> CREATE TABLE account(accountID INT NOT NULL AUTO_INCREMENT, accountType VARCHAR(50) NOT NULL, balance BIGINT NOT NULL, interestRate VARCHAR(10) NOT NULL, overDraftPenalty BIGINT, requiredMinimumBalance BIGINT, PRIMARY KEY (accountID));

mySql> CREATE TABLE transactions(accountID INT NOT NULL AUTO_INCREMENT, description VARCHAR(100) NOT NULL, date VARCHAR(10) NOT NULL, amount BIGINT NOT NULL, PRIMARY KEY (accountID));
