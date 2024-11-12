select *
from pg_catalog.pg_tables
where schemaname like 'public';

select *
from information_schema.columns
where table_name in ('authors', 'books')
