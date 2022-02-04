select co.continent, TRUNCATE(SUM(ci.population)/COUNT(ci.population),0)
-- select co.name, SUM(ci.population)
-- select co.name, COUNT(ci.population)
from country co
join city ci
on ci.countrycode = co.code
group by co.continent;