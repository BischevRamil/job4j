INSERT INTO roles VALUES ('administrator');

INSERT INTO roles VALUES ('visitor');

INSERT INTO roles VALUES ('supervisor');

INSERT INTO rules VALUES ('read and write');

INSERT INTO rules VALUES ('only read');

INSERT INTO rules VALUES ('root');

INSERT INTO category VALUES ('urgently');

INSERT INTO category VALUES ('secondary');

INSERT INTO state VALUES ('not accepted for execution');

INSERT INTO state VALUES ('accepted for execution');

INSERT INTO state VALUES ('executed');

INSERT INTO users VALUES (1, 'Ivan', 'visitor');

INSERT INTO users VALUES (2, 'Petr', 'administrator');

INSERT INTO users VALUES (3, 'Vova', 'supervisor');

INSERT INTO items VALUES (1, 1, 'urgently', 'accepted for execution');

INSERT INTO items VALUES (2, 1, 'secondary', 'executed');

INSERT INTO comments VALUES (1, 1, 'какого лешего эта заявка не выполнена');

INSERT INTO comments VALUES (2, 1, 'товар отстой...');

INSERT INTO attachs VALUES (1, 1, 'application #1');

INSERT INTO attachs VALUES (2, 1, 'application #2');

INSERT INTO role_rules VALUES ('administrator', 'read and write');

INSERT INTO role_rules VALUES ('visitor', 'only read');

INSERT INTO role_rules VALUES ('supervisor', 'read and write');

INSERT INTO role_rules VALUES ('supervisor', 'root');
