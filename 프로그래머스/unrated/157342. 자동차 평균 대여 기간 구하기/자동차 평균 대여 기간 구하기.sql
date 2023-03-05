-- 코드를 입력하세요
select CAR_ID,round(avg(timestampdiff(day,START_DATE,END_DATE))+1,1) AVERAGE_DURATION
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by CAR_ID
having avg(timestampdiff(day,START_DATE,END_DATE))>=6
order by AVERAGE_DURATION desc,CAR_ID desc;