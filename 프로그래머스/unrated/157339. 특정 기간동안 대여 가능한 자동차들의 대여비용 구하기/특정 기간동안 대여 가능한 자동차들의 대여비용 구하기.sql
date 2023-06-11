select distinct car.CAR_ID,car.CAR_TYPE,ROUND(car.DAILY_FEE*30*(100-plan.DISCOUNT_RATE)/100) as FEE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY history join CAR_RENTAL_COMPANY_CAR car
    on history.CAR_ID=car.CAR_ID join (
                                        select *
                                        from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                                        where DURATION_TYPE="30일 이상") plan
    on car.CAR_TYPE=plan.CAR_TYPE	
where car.CAR_TYPE in ("세단","SUV") and car.CAR_ID not in (
                                    select CAR_ID
                                    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                                    where START_DATE<="2022-11-30" and
                                         END_DATE>="2022-11-01" )        
having FEE>=500000 and FEE<2000000
order by FEE desc, CAR_TYPE, CAR_ID desc