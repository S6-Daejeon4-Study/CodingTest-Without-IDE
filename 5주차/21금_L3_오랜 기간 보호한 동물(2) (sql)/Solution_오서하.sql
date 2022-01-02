SELECT o.ANIMAL_ID, o.name
    FROM ANIMAL_INS i right outer join ANIMAL_OUTS o
    Using(ANIMAL_ID)
    where o.name is not null
    order by(abs(DATEDIFF(i.DATETIME, o.DATETIME))) desc
    limit 2;