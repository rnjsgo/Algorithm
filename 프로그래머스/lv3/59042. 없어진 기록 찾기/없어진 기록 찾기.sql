select outs.ANIMAL_ID,outs.NAME
from ANIMAL_OUTS outs left join ANIMAL_INS ins
on outs.ANIMAL_ID=ins.ANIMAL_ID
where ins.ANIMAL_ID is null