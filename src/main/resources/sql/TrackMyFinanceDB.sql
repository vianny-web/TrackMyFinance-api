CREATE TABLE "user" (
    id SERIAL PRIMARY KEY,
    login VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TYPE category_type AS ENUM ('Supermarket', 'Transport', 'Housing', 'Other');
CREATE TYPE transaction_type AS ENUM ('Expenditure', 'Income');

CREATE TABLE transactions (
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES "user"(id) ON DELETE CASCADE,
    transaction transaction_type NOT NULL,
    amount DECIMAL(10, 2),
    datatime timestamptz,
    category category_type NOT NULL
);