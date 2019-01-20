
CREATE TABLE if not exists user(
                   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
                   user_name VARCHAR(255) ,
                   password VARCHAR(255)
);

CREATE TABLE if not exists role(
                   id int not null auto_increment primary key ,
                   name VARCHAR(255)
);

CREATE TABLE if not exists department(
                         id int not null auto_increment primary key ,
                         name VARCHAR(255)
);

CREATE TABLE if not exists employee(
                       id int not null auto_increment primary key ,
                       first_name varchar(30),
                       last_name varchar(30),
                       salary int,
                       date_of_birth date,
                       hire_date date
);

CREATE TABLE user_roles (
                          user_id INT NOT NULL,
                          role_id INT NOT NULL,

                          FOREIGN KEY (user_id) REFERENCES user (id),
                          FOREIGN KEY (role_id) REFERENCES role(id),

                          UNIQUE (user_id, role_id)
);

CREATE TABLE department_employee(
                                  department_id int,
                                  employee_id int,
                                  foreign key (department_id) references department(id),
                                  foreign key (employee_id) references employee(id),
                                  unique (department_id, employee_id)
);

