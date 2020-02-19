CREATE TABLE attachs
(
  attachs_id bigint NOT NULL,
  item_id bigint NOT NULL,
  attach varchar(50) NOT NULL
);

ALTER TABLE attachs ADD CONSTRAINT pk_attachs
  PRIMARY KEY (attachs_id);

CREATE TABLE category
(
  category varchar(50) NOT NULL
);

ALTER TABLE category ADD CONSTRAINT pk_category
  PRIMARY KEY (category);

CREATE TABLE comments
(
  comments_id bigint NOT NULL,
  item_id bigint NOT NULL,
  comment varchar(50) NOT NULL
);

ALTER TABLE comments ADD CONSTRAINT pk_comments
  PRIMARY KEY (comments_id);

CREATE TABLE items
(
  items_id bigint NOT NULL,
  user_id bigint NOT NULL,
  category varchar(50) NOT NULL,
  state varchar(50) NOT NULL
);

ALTER TABLE items ADD CONSTRAINT pk_items
  PRIMARY KEY (items_id);

CREATE TABLE role_rules
(
  role varchar(50) NOT NULL,
  rule varchar(50) NOT NULL
);

CREATE TABLE roles
(
  role varchar(50) NOT NULL
);

ALTER TABLE roles ADD CONSTRAINT pk_roles
  PRIMARY KEY (role);

CREATE TABLE rules
(
  rule varchar(50) NOT NULL
);

ALTER TABLE rules ADD CONSTRAINT pk_rules
  PRIMARY KEY (rule);

CREATE TABLE state
(
  state varchar(50) NOT NULL
);

ALTER TABLE state ADD CONSTRAINT pk_state
  PRIMARY KEY (state);

CREATE TABLE users
(
  users_id bigint NOT NULL,
  name varchar(50) NOT NULL,
  role varchar(50) NOT NULL
);

ALTER TABLE users ADD CONSTRAINT pk_users
  PRIMARY KEY (users_id);

ALTER TABLE attachs ADD CONSTRAINT fk_attachs_items_id
  FOREIGN KEY (item_id) REFERENCES items (items_id);

ALTER TABLE comments ADD CONSTRAINT fk_comments_items_id
  FOREIGN KEY (item_id) REFERENCES items (items_id);

ALTER TABLE items ADD CONSTRAINT fk_items_category
  FOREIGN KEY (category) REFERENCES category (category);

ALTER TABLE items ADD CONSTRAINT fk_items_state
  FOREIGN KEY (state) REFERENCES state (state);

ALTER TABLE items ADD CONSTRAINT fk_items_users_id
  FOREIGN KEY (user_id) REFERENCES users (users_id);

ALTER TABLE role_rules ADD CONSTRAINT fk_role_rules_role
  FOREIGN KEY (role) REFERENCES roles (role);

ALTER TABLE role_rules ADD CONSTRAINT fk_role_rules_rule
  FOREIGN KEY (rule) REFERENCES rules (rule);

ALTER TABLE users ADD CONSTRAINT fk_users_role
  FOREIGN KEY (role) REFERENCES roles (role);

