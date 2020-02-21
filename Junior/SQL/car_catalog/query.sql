--Вывести список всех машин и все привязанные к ним детали.
select c.name, cb.name, ce.name, ct.name from car c left join car_body cb on c.body_id=cb.id left join car_engine ce on c.engine_id=ce.id left join car_transmission ct on c.transmission_id=ct.id;


--Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.
--кузов
select cb.* from car_body cb left join car c on cb.id=c.body_id where c.name is null;
--двигатель
select ce.* from car_engine ce left join car c on ce.id=c.engine_id where c.name is null;
--трансмиссия
select ct.* from car_transmission ct left join car c on ct.id=c.transmission_id where c.name is null
