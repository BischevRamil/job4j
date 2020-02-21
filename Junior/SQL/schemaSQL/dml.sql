insert into rules (rule) values ('чтение'),('запись'),('удаление'),('конфигурирование');

insert into roles (role) values ('гость'),('пользователь'),('администратор'),('супервайзер');

insert into role_rules (role_id, rule_id) values (1, 1), (2, 1), (2, 2), (3, 1), (3, 2), (3, 3), (4, 1), (4, 2), (4, 3), (4, 4);

insert into users (name, role_id) values ('Иван', 1), ('Мария', 1), ('Дмитрий', 2), ('Саша', 2), ('Катя', 2), ('Гоги', 3), ('Петр', 4);

insert into category (category) values ('срочно'), ('второстепенно');

insert into state (state) values ('открыта'),('закрыта'),('к исполнению'),('в архив');

insert into items (user_id, category_id, state_id) values (3, 1, 1),(1, 2, 4),(6, 1, 3),(7, 2, 2),(2, 2, 1);

insert into comments (item_id, comment) values (1, 'че за?'), (3, 'отличный товар'), (3, 'не очень');

insert into attachs (item_id, attach) values (4, 'приложение 1'), (4, 'приложение 2'),  (5, 'приложение 3');

