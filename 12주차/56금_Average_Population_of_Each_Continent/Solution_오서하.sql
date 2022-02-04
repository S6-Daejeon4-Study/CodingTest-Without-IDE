select c.continent, floor(avg(t.population))
from country c join city t
on c.code = t.countrycode
where (c.continent, t.population) in
(
    select c.continent, t.population 
    from country c join city t 
    on c.code = t.countrycode
)
group by c.continent;