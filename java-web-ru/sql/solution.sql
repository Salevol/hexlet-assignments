select
    first_name,
    birthday
from
    users
where
    birthday > '1999-10-23'
ORDER BY
    first_name
LIMIT 3;