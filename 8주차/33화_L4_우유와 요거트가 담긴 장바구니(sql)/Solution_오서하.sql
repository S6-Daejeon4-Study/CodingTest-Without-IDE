-- 코드를 입력하세요
SELECT p1.CART_ID 
FROM CART_PRODUCTS p1 
WHERE p1.CART_ID in
    (
        SELECT p2.CART_ID 
        FROM CART_PRODUCTS p2 
        WHERE p2.NAME = 'Milk'
    ) AND p1.NAME = 'Yogurt';
    