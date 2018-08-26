ALTER TABLE `studio`.`member_information` 
CHANGE COLUMN `grade` `grade` VARCHAR(2050) NOT NULL DEFAULT '0000' ;
select * from punch_the_clock order by punch_id desc;
select * from punch_the_clock where user_id='fffa8e8b56b3e8c6' order by punch_date desc Limit 0, 5;

select * from user_information where user_id not in (select user_id from admin_rights);