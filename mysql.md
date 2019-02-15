# MYSQL
MYSQL is a powerful database.
The notes are based on [MYSQL Schema and State](https://classes.engineering.wustl.edu/cse330/index.php?title=MySQL_Schema_and_State).  

**Contents**
* [Schema](#schema)
* [State](#state)
* [Selecting Data](#selecting-data)


## Schema
Schema: data structure

### Tables
List all tables:
```mysql
show tables;
```
Create a new table:
```mysql
create table TABLENAME (
	FIELDNAME DATATYPE OPTIONS,
	FIELDNAME DATATYPE OPTIONS,
	FIELDNAME DATATYPE OPTIONS,
	FIELDNAME DATATYPE OPTIONS
) TABLE_OPTIONS;
```
Get details of an existing table:
```mysql
describe TABLENAME;
```

### Data Types
#### String Data Types
character, text, blob, and enumberable
* **VARCHAR(#)**: a string at most # characters long (0 <= # <= 65,535)
* **CHAR(#)**: a string exactly # characters long (0 <= # <= 65,535)
* **TINYTEXT**: a text block at most 255 characters long
* **TEXT**: a text block at most 65,535 characters long
* **LONGTEXT**: a text block at most 4GB in length
* **BLOB**: a binary string at most 65 KB in length
* **MEDIUMBLOB**: a binary string at most 16 MB in length
* **LONGBLOB**: a binary string at most 4 GB in length
* **ENUM('a', 'b', 'c')**: an enumerable with choices a, b, and c

#### Numeric Data Types
* **TINYINT**: an integer n (-128 <= n <= 127)
* **TINYINT UNSIGNED**: an integer n (0 <= n <= 255)
* **SMALLINT**: an integer n  (-32,768 <= n <= 32,767)
* **SMALLINT UNSIGNED**: an integer n (0 <= n <= 65,535)
* **MEDIUMINT**: an integer n (-8,388,608 ≤ n ≤ 8,388,607)
* **MEDIUMINT UNSIGNED**: an integer n (0 ≤ n ≤ 16,777,215)
* **INT**: an integer n (-2,147,483,648 ≤ n ≤ 2,147,483,647)
* **INT UNSIGNED**: an integer n (0 ≤ n ≤ 4,294,967,295)
* **BIGINT**: an integer n (-9,223,372,036,854,775,808 ≤ n ≤ 9,223,372,036,854,775,807)
* **BIGINT UNSIGNED**: an integer n (0 ≤ n ≤ 18,446,744,073,709,551,615)
* **DECIMAL(#a, #b)**: a decimal number at most #a digits long, #b of which are after the decimal point.

#### Temporal Data Types
* **DATE**: a date d (1000-01-01 <= d <= 9999-12-13)
* **DATETIME**: a date with time d (1000-01-01 00:00:00 <= d <= 9999-12-31 23:59:59)
* **TIMESTAMP**: a date with time d (1970-01-01 00:00:01 UTC ≤ d ≤ 2038-01-19 03:14:07 UTC)
* **TIME**: a length onf time t (-838:59:59 <= t <= 838:59:59)
* **YEAR**: a year y (1901 <= y <= 2155)

### Field Options
* **NOT NULL**
* **DEFAULT 'DEFAULT-VALUE'**
* **AUTO_INCREMENT**

### Create a Table
```mysql
create table employees (
	id mediumint unsigned not null auto_increment,
	first_name varchar(30) not null,
	last_name varchar(40) not null,
	nickname varchar(20),
	department enum('CSE','BME','EECE','ESE','MEMS') not null default 'CSE',
	joined timestamp not null default current_timestamp,
	primary key (id)
) engine = InnoDB default character set = utf8 collate = utf8_general_ci;
```

### Keys
#### Primary Key
```mysql
primary key (column1, column2, column3)
```

#### Unique Key
```mysql
unique key INDEX_NAME (column1, column2, column3)
```

#### Foriegn Key
```mysql
foreign key (column1, column2, column3) references FOREIGN_TABLENAME (column1, column2, column3)
```

#### Syntax for Keys
Define keys in create table query
```mysql
create table TABLENAME (
	column,
	column,
	....,
	primary key (column1, column2, ...),
	unique key INDEXNAME (column1, column2, ...),
	foreign key (column1, column2, ...) references FOREIGN_TABLENAME (column1, column2, ...)
)
```
Define keys after create table query
```mysql
alter table TABLENAME add unique key INDEXNAME (column1, column2, ...);
alter table TABLENAME add foreign key (column1, column2, ...) references FOREIGN_TABLENAME (column1, column2, ...);
```


## State
### Inserting Data from a Query
```mysql
insert into TABLENAME (column1, column2, column3) values (value1_1, value2_1, value3_1), (value1_2, value2_2, value3_2), ...
```

### Inserting Data from a File
```mysql
LOAD DATA INFILE 'dataFile.txt' INTO TABLE table_name;
GRANT FILE on *.* to 'user'@'host';
LOAD DATA LOCAL INFILE '/home/linus_torvalds/Documents/dataFile.txt' INTO TABLE table_name;
```

### Updating Data
```mysql
update TABLENAME set column1=value1, column2=value2, column3=value3 where CONDITION
```

### Deleting Data
```mysql
delete from TABLENAME where CONDITION
```

## Selecting Data
select, from, where, order by, group by, join
```mysql
select column1, column2, column3 from TABLENAME;
```

### Joins
Inner Joins, Left Joins, Right Joins, Full Joins
```mysql
select column1, column2, column3 from TABLENAME1 join TABLENAME2 on CONDITION;
```

### Aggregation Clauses
avg, std, sum, min, max, count

