SELECT MEMBER_ID, member_name, gender, to_char(date_of_birth, 'YYYY-mm-dd') DATE_OF_BIRTH
from member_profile
where gender = 'W' and to_char(date_of_birth,'mm')='03' and TLNO is not null
order by member_id asc;
