select concat('/home/grep/src/',board.BOARD_ID,'/',FILE_ID,FILE_NAME,FILE_EXT) FILE_PATH
from USED_GOODS_BOARD board join USED_GOODS_FILE file 
    on board.BOARD_ID=file.BOARD_ID
where board.BOARD_ID = (
                    select BOARD_ID
                    from USED_GOODS_BOARD
                    order by VIEWS desc
                    limit 1
    )
order by FILE_ID desc