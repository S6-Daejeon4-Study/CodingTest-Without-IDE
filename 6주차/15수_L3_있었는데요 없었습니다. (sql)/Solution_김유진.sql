-- 코드를 입력하세요
SELECT INS.ANIMAL_ID,INS.NAME 
FROM ANIMAL_INS INS LEFT OUTER JOIN ANIMAL_OUTS OUTS 
ON INS.ANIMAL_ID = OUTS.ANIMAL_ID 
WHERE  INS.DATETIME > OUTS.DATETIME
ORDER BY INS.DATETIME