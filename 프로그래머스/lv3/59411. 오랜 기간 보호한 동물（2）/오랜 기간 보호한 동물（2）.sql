select ins.ANIMAL_ID, ins.NAME
from ANIMAL_INS ins join ANIMAL_OUTS outs
    on ins.ANIMAL_ID=outs.ANIMAL_ID
order by timestampdiff(second,ins.DATETIME,outs.DATETIME) desc
limit 2
