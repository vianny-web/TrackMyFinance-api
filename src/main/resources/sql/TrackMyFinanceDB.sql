CREATE TABLE "user" (
    id SERIAL PRIMARY KEY,
    login VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TYPE category_type AS ENUM ('SUPERMARKET', 'TRANSPORT', 'HOUSING', 'OTHERS');
CREATE TYPE transaction_type AS ENUM ('EXPENDITURE', 'INCOME');

CREATE TABLE transaction (
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES "user"(id) ON DELETE CASCADE,
    transaction transaction_type NOT NULL,
    amount DECIMAL(10, 2),
    datatime timestamptz,
    category category_type NOT NULL
);

INSERT INTO "user" (login, password)
VALUES
    ('user1', 'password1'),
    ('user2', 'password2'),
    ('user3', 'password3');