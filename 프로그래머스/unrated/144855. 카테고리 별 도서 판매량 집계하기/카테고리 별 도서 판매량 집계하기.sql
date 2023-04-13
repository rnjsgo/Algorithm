select CATEGORY, sum(sales) TOTAL_SALES
from BOOK join BOOK_SALES
    on BOOK.BOOK_ID=BOOK_SALES.BOOK_ID
where SALES_DATE like '2022-01%'
group by CATEGORY
order by CATEGORY 
