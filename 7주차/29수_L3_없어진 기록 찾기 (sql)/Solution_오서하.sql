SELECT o.ANIMAL_ID , o.NAME
FROM ANIMAL_INS i right outer  join ANIMAL_OUTS o
on o.ANIMAL_ID = i.ANIMAL_ID
where i.ANIMAL_ID is null
order by ANIMAL_ID, NAME;