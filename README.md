CS 485 – Database Management System (Fall 2025)    
Group Assignment #3 – Software Integration  
Grade: 10 points (which is 10% of the semester)    
Due Date: Set on Moodle.  
Late Submissions: There is a cumulative penalty of -0.5 points per day after the deadline. After  
Dec 4, late submissions will no longer be accepted.  

### Assignment

Using the same groups and same Database design from Group Assignments #1 and #2,  
your team will now create a Java application using JDBC to interact with your Database from the previous group assignment.  

You need to create a full CRUD for one table in your Database. It is recommended you  
chose a table that has no FKs, and few attributes, which are simpler. However, you cannot choose  
a Client/Customer/User table that is essentially a simple variation of the lectures examples.    

You must open the connections to your DB using JDBC in Java. You cannot rely on  
JPA/Hibernate or other frameworks to automatically store/fetch data.  

Interface is free form, and it can even be command-line or textual interface. But you must  
provide some form of interface for someone to use all CRUD functions (as they wish) in your table  
by running your code.  

You need to provide a SQL Script to create the table used in your code. Make sure it is on  
the project root folder with “sql” extension.    

Your code must use MVC and follow the classroom standard. For example, only DAO  
classes can have SQL commands/statements/queries. Testing is required in this assignment for  
the DAO class (at least 60% statement/line coverage for your DAO).  

Submit on Moodle the source codes (with the script) as a compacted zip file, or a link to  
your public GitHub repository.   


### what we are implementing:


Stage: @id_stage, name_stage, size, layout

1, Graveyard, large, walk off
2, Lab, medium, traditional

create table Stage(
id_stage int not null auto_increment,
name_stage varchar(20) not null,
size varchar(10) not null,
layout blob, //actually varchar  
constraint Stage_PK primary key (id_stage)
);

insert into stage(name_stage, size, layout)
values(‘Graveyard’, ‘large’, ‘walk off’);

insert into stage(name_stage, size, layout)
values(‘Lab’, ‘medium’, ‘traditional’);



