create or replace function get_name_by_id(in_id integer)
returns VARCHAR(60)
as $$
select name from developer where id=in_id;
$$ language sql