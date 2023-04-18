select outs.ANIMAL_ID,outs.NAME
from ANIMAL_OUTS outs
where outs.ANIMAL_ID  not in (select ANIMAL_ID from ANIMAL_INS)
order by ANIMAL_ID