SELECT 
  max(case when OCCUPATION='Doctor' then name end) 'Doctor',
  max(case when OCCUPATION='Professor' then name end) 'Professor',
  max(case when OCCUPATION='Singer' then name end) 'Singer',
  max(case when OCCUPATION='Actor' then name end) 'Actor'
FROM (
    SELECT *, ROW_NUMBER() OVER (PARTITION BY OCCUPATION ORDER BY NAME) RN
    FROM OCCUPATIONS ) AS O
GROUP BY RN;