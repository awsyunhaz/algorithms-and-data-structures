# Write your MySQL query statement below
select Email from
(select Email, count(*) as cnt
from Person
group by Email) a
where a.cnt>=2

select Email
from Person
group by Email
having count(Id)>=2
