FROM postgres:latest
ENV POSTGRES_PASSWORD password
ENV POSTGRES_DB click_db
ADD init/10_init_table.sql /docker-entrypoint-initdb.d/