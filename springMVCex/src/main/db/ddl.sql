DROP TABLE tbl_todo;

CREATE TABLE tbl_todo(
                         tno INT AUTO_INCREMENT PRIMARY KEY,
                         title VARCHAR (100) NOT NULL,
                         dueDate DATE NOT NULL,
                         writer VARCHAR(50) NOT NULL,
                         done TINYINT DEFAULT 0
);