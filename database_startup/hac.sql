create table users(
    id serial primary key,
    username text not null,
    email text not null,
    password text not null,
    role text not null default 'USER'
);
create table quest(
    id serial primary key,
    title text not null,
    city text not null,
    location text not null,
    points int not null check(points>0),
    is_active boolean default TRUE
);
CREATE TABLE completed_quests (
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    quest_id INT REFERENCES quests(id) ON DELETE CASCADE,
    completion_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id, quest_id)
);
create table partners(
    id serial primary key,
    business_name text not null,
    adress text not null
);
create table rewards(
    id serial primary key,
    partner_id int REFERENCES partners(id) on DELETE CASCADE,
    name text not null,
    cost int not null,
    expiry_date DATE
);
create table user_rewards(
    user_id int REFERENCES user(id) on DELETE CASCADE,
    reward_id int REFERENCES rewards(id) on DELETE CASCADE,
    is_used boolean DEFAULT FALSE,
    primary key (user_id,reward_id)
);