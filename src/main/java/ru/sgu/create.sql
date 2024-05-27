CREATE TABLE employeesAge(
    id SERIAL PRIMARY KEY,
    employeeName VARCHAR(300) NOT NULL,
    age INTEGER NOT NULL
);
INSERT INTO employeesAge (employeeName, age)
VALUES ('Кирилл', 18), ('Саша', 20), ('Катя', 25);


CREATE TABLE departmentLocation(
    id SERIAL PRIMARY KEY,
    departmentName VARCHAR(300) NOT NULL,
    location VARCHAR(300) NOT NULL
);
INSERT INTO departmentLocation (departmentName, location)
VALUES ('IT', 'Саратов'), ('HR', 'Москва');

CREATE TABLE departmentSalary(
    id SERIAL PRIMARY KEY,
    employeeId INTEGER NOT NULL,
    departmentId INTEGER NOT NULL,
    salary INTEGER NOT NULL,
    CONSTRAINT fk_ds_employee_id
      FOREIGN KEY(employeeId)
        REFERENCES employeesAge(id),
    CONSTRAINT fk_ds_department_id
      FOREIGN KEY(departmentId)
        REFERENCES departmentLocation(id)
);
INSERT INTO departmentSalary (employeeId, departmentId, salary)
VALUES (1, 1, 30000), (2, 1, 20000), (3, 2, 40000);


CREATE TABLE departmentEmployee(
    id SERIAL PRIMARY KEY,
    employeeId INTEGER NOT NULL,
    departmentId INTEGER NOT NULL,
    CONSTRAINT fk_de_department_id
      FOREIGN KEY(departmentId)
        REFERENCES departmentLocation(id),
    CONSTRAINT fk_de_employee_id
      FOREIGN KEY(employeeId)
        REFERENCES employeesAge(id)
);
INSERT INTO departmentEmployee (employeeId, departmentId)
VALUES (1, 1), (2, 1), (3, 2);