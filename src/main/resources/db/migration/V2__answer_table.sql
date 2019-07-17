CREATE TABLE answers
(
    id SERIAL PRIMARY KEY NOT NULL,
    description TEXT NOT NULL,
    question_id INTEGER NOT NULL REFERENCES questions(id)
);