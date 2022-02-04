select n.continent, floor(avg(c.population))
from city c join country n on c.countrycode = n.code
group by n.continent