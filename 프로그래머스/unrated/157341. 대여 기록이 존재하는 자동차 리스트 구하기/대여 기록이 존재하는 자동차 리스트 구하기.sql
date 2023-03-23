-- 코드를 입력하세요
SELECT distinct(car.CAR_ID) CAR_ID
from CAR_RENTAL_COMPANY_CAR car join CAR_RENTAL_COMPANY_RENTAL_HISTORY history 
        on car.CAR_ID=history.CAR_ID
where car.CAR_TYPE='세단' and history.START_DATE like '2022-10%'
order by car.CAR_ID desc