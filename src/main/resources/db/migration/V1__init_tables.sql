CREATE TABLE questions (
  id SERIAL PRIMARY KEY NOT NULL,
  title VARCHAR(255) NOT NULL,
  description text,
  created_at TIMESTAMP NOT NULL DEFAULT NOW()
);