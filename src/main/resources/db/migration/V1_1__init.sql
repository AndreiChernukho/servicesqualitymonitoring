CREATE TABLE IF NOT EXISTS category
(
    id   BIGSERIAL    NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS company
(
    id   BIGSERIAL    NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    unn  INTEGER      NOT NULL
);

CREATE TABLE IF NOT EXISTS service
(
    id   BIGSERIAL    NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS rating
(
    id            BIGSERIAL NOT NULL PRIMARY KEY,
    comment       TEXT      NULL,
    rating        INTEGER   NOT NULL,
    creation_date TIMESTAMP NOT NULL DEFAULT now(),
    category_id   BIGSERIAL NOT NULL,
    company_id    BIGSERIAL NOT NULL,
    service_id    BIGSERIAL NOT NULL,
    CONSTRAINT fk_rating_category FOREIGN KEY (category_id) REFERENCES category (id),
    CONSTRAINT fk_rating_company FOREIGN KEY (company_id) REFERENCES company (id),
    CONSTRAINT fk_rating_service FOREIGN KEY (service_id) REFERENCES service (id)
);
