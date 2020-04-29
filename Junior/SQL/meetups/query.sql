--Нужно написать запрос, который получит список всех заяков и количество подтвердивших участников.

select m.name as meetup_name, count(u.status) as status_true from meetups m left join users u on m.id=u.id_meetup where u.status group by m.name;

-- Нужно получить все совещания, где не было ни одной заявки на посещения.

select m.name as meetup_name from meetups m left join users u on m.id=u.id_meetup group by m.name having count(u.id_meetup)=0;
