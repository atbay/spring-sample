 -- create database
CREATE DATABASE sampledb
  WITH OWNER = spring
       TEMPLATE = template0
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'ja_JP.UTF-8'
       LC_CTYPE = 'ja_JP.UTF-8'
       CONNECTION LIMIT = -1;

COMMENT ON DATABASE sampledb
  IS 'SPRING_SAMPLE';