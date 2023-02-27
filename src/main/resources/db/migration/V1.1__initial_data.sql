INSERT INTO roles(id, name)
VALUES('88a0ff34-8d3d-4d88-baf2-8de10f76390c', 'ROLE_ADMIN');
INSERT INTO roles(id, name)
VALUES('dff9e818-2a59-4eb2-a250-0c094183dada', 'ROLE_USER');

INSERT INTO employees (id, document, first_name, last_name, email, birth_date, address, phone, status, active)
            VALUES('50d5721b-6acc-4fb2-95a0-3df969094f4c', '1717744310', 'Diego', 'Acosta',
            'dacosta@gmail.com','1988-03-15 00:00:00', 'Quito', '0998348309', 'VACUNADO', true);

INSERT INTO users (id, password, username)
VALUES('50d5721b-6acc-4fb2-95a0-3df969094f4c', '$2a$10$gRde6y2LNyQwT6rVqem3qugYCqKDwgsqP/N1D2DHWr7tO2jupzLtG', 'admin');

INSERT INTO vaccines (id, name, description) VALUES('a2f10bdc-2b24-4bce-8af3-c8db26c18381',
'Sputnik', 'Vacuna del laboratorio Sputnik');
INSERT INTO vaccines (id, name, description) VALUES('0ca8779a-c383-41f6-9226-b075ce10ea40',
'AstraZeneca', 'Vacuna del laboratorio AstraZeneca');
INSERT INTO vaccines (id, name, description) VALUES('00011019-1e6c-47bd-bc5a-b25dc9bd504f',
'Pfizer', 'Vacuna del laboratorio Pfizer');
INSERT INTO vaccines (id, name, description) VALUES('fb581ff9-805b-4e3a-b234-78801fe61aab',
'JhonsonAndJhonson', 'Vacuna del laboratorio JhonsonAndJhonson');

INSERT INTO employees_vaccines (id, employee_id, vaccine_id, vaccination_date, dose)
VALUES('aac00a21-f42b-4c98-9f26-ca0137c08952', '50d5721b-6acc-4fb2-95a0-3df969094f4c',
'00011019-1e6c-47bd-bc5a-b25dc9bd504f', '2022-05-01 12:58:00', 2);

INSERT INTO users_roles (user_id, rol_id)
VALUES('50d5721b-6acc-4fb2-95a0-3df969094f4c', '88a0ff34-8d3d-4d88-baf2-8de10f76390c');