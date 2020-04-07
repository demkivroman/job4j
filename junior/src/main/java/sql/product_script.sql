--Написать запрос получение всех продуктов с типом "СЫР"
select  p.name,p.expired_date,p.price, t.name as category from product p inner join type t on p.type_id = t.id where t.name='cheeze';
--Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select * from product where name like '%ice%';

--Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select * from product p where p.expired_date >= '2020-05-01' and p.expired_date <= '2020-05-31';

--Написать запрос, который выводит самый дорогой продукт.
select * from product where price = (select max(price) from product);

--Написать запрос, который выводит количество всех продуктов определенного типа.
select t.name,count(p.type_id) as quantity from product p inner join type t on p.type_id=t.id group by t.name; 

--Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select * from product p inner join type t on p.type_id=t.id where t.name='milk' or t.name='cheeze';

--Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
select t.name from product p inner join type t on p.type_id=t.id group by t.name having count(p.type_id) < 10;

--Вывести все продукты и их тип
select p.id, p.name, p.expired_date,p.price, t.name from product p inner join type t on p.type_id = t.id;

