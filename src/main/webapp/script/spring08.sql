select * from qna;

update qna set title='update test', contents='update Test' where num=33;

select * from qna order by ref desc, step asc;

delete QNA where num=105;