
-- export CONTAINER_NAME=postgres
-- docker exec -it ${CONTAINER_NAME} psql -Upostgres -a postgres -c 'SELECT * FROM hero;'
-- SELECT * FROM hero;
--  id | hp | iq | magic | name | power | speed | strength | telekinesis | weakness 
-- ----+----+----+-------+------+-------+-------+----------+-------------+----------

INSERT INTO HERO VALUES (1, 80, 85, 0,  'Iron Man',      'Being Rich',  50, 20, 0,  'Magnets'        );
INSERT INTO HERO VALUES (2, 90, 40, 10, 'Thor',          'Lightning',   95, 20, 0,  'Magic'          );
INSERT INTO HERO VALUES (3, 90, 40, 0,  'Superman',      'Strength',    97, 70, 0,  'Kryptonite'     );
INSERT INTO HERO VALUES (4, 60, 50, 0,  'Storm',         'Meteorology', 60, 10, 0,  'Michael Fish'   );
INSERT INTO HERO VALUES (5, 80, 50, 10, 'Wonder Woman',  'Strength',    90, 20, 0,  'Greek gods'     );
INSERT INTO HERO VALUES (6, 60, 50, 90, 'Scarlet Witch', 'Magic',       10, 10, 10, 'Dorothy`s house');
INSERT INTO HERO VALUES (7, 99, 10, 0,  'One Punch Man', 'Strength',    99, 99, 0,  'None'           );