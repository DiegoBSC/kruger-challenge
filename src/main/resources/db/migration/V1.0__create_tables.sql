CREATE TABLE employees (
	id uuid NOT NULL,
	document varchar(150) NOT NULL,
	first_name varchar(150) NOT NULL,
	last_name varchar(150) NOT NULL,
	email varchar(100) NOT NULL,
	phone varchar(100),
	birth_date timestamp,
	address varchar(300),
	status varchar(100),
	active boolean NOT NULL DEFAULT true,
	CONSTRAINT const_dni UNIQUE (document),
	CONSTRAINT employees_pkey PRIMARY KEY (id)
);

CREATE TABLE users (
	id uuid NOT NULL,
	username varchar(150) NOT NULL,
	password varchar(255) NOT NULL,
	active boolean NOT NULL DEFAULT true,
	CONSTRAINT users_pkey PRIMARY KEY (id),
	CONSTRAINT fk_user_employee FOREIGN KEY (id) REFERENCES employees(id)
);

CREATE TABLE roles (
	id uuid NOT NULL,
	name varchar(150) NOT NULL,
	active boolean NOT NULL DEFAULT true,
	CONSTRAINT roles_pkey PRIMARY KEY (id),
	CONSTRAINT roles_name_key UNIQUE (name)
);

CREATE TABLE users_roles (
	user_id uuid NOT NULL,
	rol_id uuid NOT NULL,
	CONSTRAINT users_roles_pkey PRIMARY KEY (user_id, rol_id),
	CONSTRAINT fk_rol_user FOREIGN KEY (rol_id) REFERENCES roles(id),
	CONSTRAINT fk_user_rol FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE vaccines (
	id uuid NOT NULL,
	name varchar(150) NOT NULL,
	description varchar(255) NOT NULL,
	active boolean NOT NULL DEFAULT true,
	CONSTRAINT vaccines_pkey PRIMARY KEY (id)
);

CREATE TABLE employees_vaccines (
	id uuid NOT NULL,
	employee_id uuid NOT NULL,
	vaccine_id uuid NOT NULL,
	vaccination_date timestamp,
	dose int8 NOT NULL,
	active boolean NOT NULL DEFAULT true,
	CONSTRAINT employees_vaccines_pkey PRIMARY KEY (id),
	CONSTRAINT fk_employee_vaccine FOREIGN KEY (employee_id) REFERENCES employees(id),
	CONSTRAINT fk_vaccine_employee FOREIGN KEY (vaccine_id) REFERENCES vaccines(id)
);




