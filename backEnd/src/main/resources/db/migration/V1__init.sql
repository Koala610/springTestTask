
CREATE TABLE IF NOT EXISTS users
(
    id serial NOT NULL,
    username character varying(255) COLLATE pg_catalog."default" NOT NULL,
    password character varying(255) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT users_username_key UNIQUE (username)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS users
    OWNER to postgres;


CREATE TABLE IF NOT EXISTS students
(
    id serial NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    age integer,
    surname character varying(255) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default",
    curatorid integer NOT NULL,
    CONSTRAINT students_pkey PRIMARY KEY (id),
    CONSTRAINT curator_id FOREIGN KEY (curatorid)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS students
    OWNER to postgres;