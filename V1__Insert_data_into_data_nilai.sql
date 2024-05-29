CREATE TABLE IF NOT EXISTS public.data_nilai (
    id serial4 NOT NULL,
    "name" varchar(255) NOT NULL,
    score int4 NOT NULL,
    emotion varchar(255) NOT NULL,
    created timestamp NOT NULL,
    CONSTRAINT data_nilai_pkey PRIMARY KEY (id)
);

