CREATE TABLE city(
    city_id SERIAL PRIMARY KEY,
    city_name TEXT NOT NULL,
    city_description TEXT NOT NULL
);

CREATE TABLE place_category(
    place_category_id SERIAL PRIMARY KEY,
    place_category_name TEXT NOT NULL
);

CREATE TABLE place(
    place_id SERIAL PRIMARY KEY,
    city_id INT,
    place_category_id INT, 
    place_name TEXT NOT NULL,
    place_address TEXT NOT NULL,
    place_description TEXT NOT NULL,
    rating REAL,
    FOREIGN KEY (city_id) REFERENCES city(city_id),
    FOREIGN KEY (place_category_id) REFERENCES place_category(place_category_id)
);

CREATE TABLE quest(
    quest_id SERIAL PRIMARY KEY,
    place_category_id INT,
    quest_description TEXT NOT NULL,
    FOREIGN KEY (place_category_id) REFERENCES place_category(place_category_id)
);

CREATE TABLE users(
    users_id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    password TEXT NOT NULL,
    email TEXT NOT NULL,
    roles TEXT,
    coins INT
);