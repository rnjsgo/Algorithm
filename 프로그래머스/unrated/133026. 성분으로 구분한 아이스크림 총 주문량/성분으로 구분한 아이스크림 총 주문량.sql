-- 코드를 입력하세요
select INGREDIENT_TYPE , sum(TOTAL_ORDER) TOTAL_ORDER
from 
    FIRST_HALF A join ICECREAM_INFO B
    on A.FLAVOR=B.FLAVOR
group by INGREDIENT_TYPE
order by TOTAL_ORDER;