SELECT concat(name,"(",SUBSTR(occupation,1,1),")")
FROM OCCUPATIONS 
ORDER BY name; 
SELECT concat("There are a total of ",O.count," ",LOWER(O.occupation),"s.")
FROM (
    SELECT count(*) as count,occupation 
    FROM OCCUPATIONS 
    GROUP BY occupation 
    ORDER BY occupation 
) as O 
ORDER BY O.count;
