INSERT INTO students (id, age, deleted, name) VALUES (1, "21", 0, "Pesho");
INSERT INTO students (id, age, deleted, name) VALUES (2, "22", 0, "Gosho");
INSERT INTO students (id, age, deleted, name) VALUES (3, "23", 1, "Anna");

INSERT INTO courses (id, name, price) VALUES (1, "Spring", 100);
INSERT INTO courses (id, name, price) VALUES (2, "JavaScript", 5);

INSERT INTO orders (id, course_id, student_id) VALUES (1, 1, 1);
INSERT INTO orders (id, course_id, student_id) VALUES (2, 1, 2);
INSERT INTO orders (id, course_id, student_id) VALUES (3, 2, 2);