--Написать запрос получение всех продуктов с типом "СЫР"
select p.name, t.name from product p left join type t on p.type_id=t.id where t.name like 'сыр';

--Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select name from product where name='мороженое';

--Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select * from product where expired_date>(date_trunc('month', current_date)+interval '1 month') and expired_date<(date_trunc('month', current_date)+interval '2 month');

--Написать запрос, который выводит самый дорогой продукт.
select * from product order by price desc limit 1;

--Написать запрос, который выводит количество всех продуктов определенного типа.
select t.name, count(*) from type t left join product p on t.id=p.type_id group by t.name;

--Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select p.name, t.name from product p left join type t on p.type_id=t.id where t.name like 'сыр' or t.name like 'молоко';


--Написать запрос, который выводит тип продуктов, которых осталось меньше 4 штук.
select t.name, count(*) from type t left join product p on t.id=p.type_id group by t.name having count(*)<4;

--Вывести все продукты и их тип.
select p.name, t.name from product p left join type t on t.id=p.type_id;
