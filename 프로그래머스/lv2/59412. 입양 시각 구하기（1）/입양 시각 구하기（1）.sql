-- 코드를 입력하세요
SELECT convert(substring(DATETIME,12,2),signed) HOUR, count(*) COUNT
from ANIMAL_OUTS
group by hour
        having hour>=9 and hour<20
order by hour

