CREATE TABLE IF NOT EXISTS public.data_nilai (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    score INT NOT NULL,
    emotion VARCHAR(255) NOT NULL,
    created DATE NOT NULL
);
