Print all user names who have flats in PUNE:

SELECT u.name
FROM USER u
INNER JOIN FLAT f ON u.id = f.user_id
WHERE f.city = 'PUNE';

Print the number of flats in PUNE:

SELECT COUNT(*) AS number_of_flats_in_pune
FROM FLAT f
WHERE f.city = 'PUNE';

Print the number of users who have flats in PUNE:

SELECT COUNT(u.id) AS number_of_users_in_pune
FROM USER u
INNER JOIN FLAT f ON u.id = f.user_id
WHERE f.city = 'PUNE';

Print all user names who do not have a flat in LONDON:

SELECT u.name
FROM USER u
LEFT JOIN FLAT f ON u.id = f.user_id
WHERE f.city IS NULL OR f.city <> 'LONDON';

In order to make the query in D3 more efficient, which table and column should an index be created on?

city colum in FLAT table
