# eightbitsakathebigbyte.InterestCalculator
Source Repository for the Interest Calculator project

mysql CLI commands for setting up local db

mySql> Create database interestCalculatorDatabase;

mySql> CREATE TABLE account(accountID INT NOT NULL AUTO_INCREMENT, accountType VARCHAR(50) NOT NULL, balance BIGINT NOT NULL, interestRate VARCHAR(10) NOT NULL, overDraftPenalty BIGINT, requiredMinimumBalance BIGINT, PRIMARY KEY (accountID));

mySql> CREATE TABLE transactions(accountID INT NOT NULL AUTO_INCREMENT, description VARCHAR(100) NOT NULL, date VARCHAR(10) NOT NULL, amount BIGINT NOT NULL, PRIMARY KEY (accountID));




Calculations:

Formula being used for compound interest calculations:
i=P(1+r/n)^nt+ M*[(1+r/n)^nt-1]/(r/n)-P

where all monetary input values are in pennies:

i: calculated interest

P: principal in pennies

r: interest rate in decimal format (interval value for the calculateSimpleInterest() and calculateComplexInterest() methods)

n: number of compound events/yr (frequency value used in the calculateComplexInterest() method)

t: time in years

M: recurring debit/credit in pennies

Assumptions:

1) The recurring payments are made monthly

2) The interest on the principal and recurring payments is calculated at the end of the period of interest. 
