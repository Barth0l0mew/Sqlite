public class NorthWind {
    /*
	https://github.com/KirillovItstep/classworks/tree/main/NorthWind
    https://github.com/KirillovItstep/classworks/tree/main/NorthWind
     через постгресс
     */

}
/*
--Напишите запрос для получения алфавитного списка продуктов, не снятых с производства (discontinued = false) (id и названий). 
SELECT product_id,product_name 
 FROM products 
 WHERE discontinued = 0 
 ORDER BY product_name; 
-- Написать запрос для получения общего количества продуктов, количества продуктов, не снятых и снятых с производства
select discontinued,  count (product_name) from products group by discontinued;
SELECT COUNT(*) FROM products
 UNION
 SELECT COUNT(*) FROM products WHERE discontinued = 1
 UNION
 SELECT COUNT(*) FROM products WHERE discontinued = 0; 

-- Написать запрос для получения самого дорогого и самого дешевого продукта (названия и цену за упаковку). 
select product_name, unit_price from products where unit_price = (select max (unit_price) from products) or unit_price= (select min(unit_price) from products );

--Вывести категории продуктов, поставщиков для каждой категории и количество поставляемых товаров (если это количество больше 1)
--heven
--Отсортировать продукты по возрастанию цены 
select product_name, unit_price from products order by unit_price;
Написать запрос для получения списка продуктов, не снятых с производства, для которых стоимость находится в пределах между $15 и $25. 
select product_name, unit_price from products where discontinued=0 and unit_price between 15 and 25;
--Написать запрос для получения списка продуктов, не снятых с производства, стоимость которых выше средней цены. 
select product_name, unit_price from products where discontinued=0 and unit_price> (select avg(unit_price) from products);
--Написать запрос для получения списка продуктов (название, цена за упаковку) десяти наиболее дорогих продуктов, отличающихся по цене.

select product_name, unit_price from products order by unit_price desc limit 10 ;
-- Написать запрос, в котором вывести список продуктов, их категорию и поставщиков (название компании, контактное лицо). 
select  product_name, category_name, company_name from products  
inner join categories on products.category_id=categories.category_id
inner join suppliers on suppliers.supplier_id=products.supplier_id; 
--Создать триггер, который добавляет в новую таблицу территории при добавлении ее в основную таблицу 
CREATE TABLE new_territories (
    territory_id character varying(20) NOT NULL PRIMARY KEY,
    territory_description bpchar NOT NULL,
    region_id smallint NOT NULL,
	FOREIGN KEY (region_id) REFERENCES region
); 
-- не работает триггер в постгресс
create trigger new_terr after insert on territories 
begin
insert into new_territories (territory_description, region_id)
values 
(new.territory_description, new.region_id);
end;

---
--Вывести категории продуктов, поставщиков для каждой категории и количество поставляемых товаров (если это количество больше 1) 
SELECT Count(product_name) FROM Products GROUP BY Discontinued having Discontinued=1; 
SELECT categories.category_name, suppliers.company_name,SUM(units_in_stock)
 FROM products
 JOIN categories ON
 categories.category_id=products.category_id
 JOIN suppliers ON
 suppliers.supplier_id=products.supplier_id
 GROUP BY categories.category_name,suppliers.company_name
 HAVING SUM(units_in_stock)>1
 ORDER BY category_name; 
--Написать запрос для получения списка продуктов (название, количество в запасе, заказанное количество), количество которых в запасе меньше заказанного. 

--существет ли продукт стоимостью больше 1000
select exists (select * from products where unit_price>1000);
 */
