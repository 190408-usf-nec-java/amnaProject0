 CREATE TABLE Accounts
(
  account_id int PRIMARY KEY,
 
  account_name varchar(50)
 
);


create table customers (
	id SERIAL primary key,
	first_name VARCHAR(40),
	last_name VARCHAR(40),
	email VARCHAR(254)
); 
---have to make these null

CREATE TABLE joint_accounts
 (
  id int,
 
  account_id int,
 
  CONSTRAINT cust_acct_pk PRIMARY KEY (id, account_id),
 
  CONSTRAINT FK_Customer
 
      FOREIGN KEY (id) RE FERENCES customers(id),
 
  CONSTRAINT FK_Account
 
      FOREIGN KEY (account_id) REFERENCES Accounts (account_id)
 
);



select * from customers;


 
CREATE TABLE transactions
 
(
 
  transaction_id SERIAL PRIMARY KEY,
 
  transactions_account int,
 
  deposit NUMERIC,
  withdraw NUMERIC,
  balance NUMERIC,
 
  CONSTRAINT FK_acct_id
 
      FOREIGN KEY (transactions_account) REFERENCES Accounts (account_id)
 
);
--have to give these a default = 0


create role jdbc LOGIN password 'p4ssw0rd';
grant select, update, INSERT on table followers to jdbc;


