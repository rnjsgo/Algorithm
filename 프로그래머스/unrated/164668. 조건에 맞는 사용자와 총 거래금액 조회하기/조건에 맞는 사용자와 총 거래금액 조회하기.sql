-- 코드를 입력하세요
SELECT USER_ID,NICKNAME,sum(price) TOTAL_SALES
from USED_GOODS_BOARD board join USED_GOODS_USER user
    on board.WRITER_ID=user.USER_ID	
where STATUS='DONE'
group by WRITER_ID
    having TOTAL_SALES>=700000
order by TOTAL_SALES