CREATE TABLE category
(
    id         BIGINT       NOT NULL,
    created_at datetime     NULL,
    updated_at datetime     NULL,
    is_deleted BIT(1)       NOT NULL,
    title      VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BIGINT       NOT NULL,
    created_at    datetime     NULL,
    updated_at    datetime     NULL,
    is_deleted    BIT(1)       NOT NULL,
    title         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    price         DOUBLE       NOT NULL,
    image_url     VARCHAR(255) NULL,
    category_id   BIGINT       NULL,
    weight        INT          NOT NULL,
    height        INT          NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);
CREATE TABLE booking
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    user_id      BIGINT                NOT NULL,
    service_id   BIGINT                NOT NULL,
    booking_time datetime              NULL,
    status       VARCHAR(255)          NULL,
    CONSTRAINT pk_booking PRIMARY KEY (id)
);

CREATE TABLE category
(
    id         BIGINT       NOT NULL,
    created_at datetime     NULL,
    updated_at datetime     NULL,
    is_deleted BIT(1)       NOT NULL,
    title      VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE consultation
(
    id                BIGINT AUTO_INCREMENT NOT NULL,
    user_id           BIGINT                NOT NULL,
    consultation_time datetime              NULL,
    notes             VARCHAR(255)          NULL,
    CONSTRAINT pk_consultation PRIMARY KEY (id)
);

CREATE TABLE interior_services
(
    id                       BIGINT AUTO_INCREMENT NOT NULL,
    title                    VARCHAR(255)          NOT NULL,
    `description`            VARCHAR(1000)         NULL,
    service_type             VARCHAR(255)          NOT NULL,
    base_price               DECIMAL               NULL,
    estimated_duration_hours INT                   NULL,
    difficulty_level         VARCHAR(255)          NULL,
    is_active                BIT(1)                NULL,
    requires_on_site_visit   BIT(1)                NULL,
    minimum_project_size     VARCHAR(255)          NULL,
    maximum_project_size     VARCHAR(255)          NULL,
    created_at               datetime              NULL,
    updated_at               datetime              NULL,
    CONSTRAINT pk_interior_services PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BIGINT       NOT NULL,
    created_at    datetime     NULL,
    updated_at    datetime     NULL,
    is_deleted    BIT(1)       NOT NULL,
    title         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    price         DOUBLE       NOT NULL,
    image_url     VARCHAR(255) NULL,
    category_id   BIGINT       NULL,
    weight        INT          NOT NULL,
    height        INT          NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE residential_design_services
(
    id           BIGINT       NOT NULL,
    room_type    VARCHAR(255) NULL,
    design_style VARCHAR(255) NULL,
    CONSTRAINT pk_residential_design_services PRIMARY KEY (id)
);

CREATE TABLE service_exclusions
(
    service_id BIGINT       NOT NULL,
    exclusion  VARCHAR(255) NULL
);

CREATE TABLE service_inclusions
(
    service_id BIGINT       NOT NULL,
    inclusion  VARCHAR(255) NULL
);

CREATE TABLE user_roles
(
    user_id BIGINT       NOT NULL,
    `role`  VARCHAR(255) NULL
);

CREATE TABLE users
(
    id         BIGINT       NOT NULL,
    created_at datetime     NULL,
    updated_at datetime     NULL,
    is_deleted BIT(1)       NOT NULL,
    username   VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NULL,
    last_name  VARCHAR(255) NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE videos
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    title         VARCHAR(255)          NOT NULL,
    url           VARCHAR(255)          NOT NULL,
    `description` VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_videos PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE users
    ADD CONSTRAINT uc_users_username UNIQUE (username);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_SERVICE FOREIGN KEY (service_id) REFERENCES interior_services (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE consultation
    ADD CONSTRAINT FK_CONSULTATION_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE residential_design_services
    ADD CONSTRAINT FK_RESIDENTIAL_DESIGN_SERVICES_ON_ID FOREIGN KEY (id) REFERENCES interior_services (id);

ALTER TABLE service_exclusions
    ADD CONSTRAINT fk_service_exclusions_on_residential_design_design FOREIGN KEY (service_id) REFERENCES residential_design_services (id);

ALTER TABLE service_inclusions
    ADD CONSTRAINT fk_service_inclusions_on_residential_design_design FOREIGN KEY (service_id) REFERENCES residential_design_services (id);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_user_roles_on_user FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE service_inclusions
    DROP FOREIGN KEY FK6rafn2k535prohhumx3mqhhfj;

ALTER TABLE service_exclusions
    DROP FOREIGN KEY FK8y1hiks3ml8g84ae9c0wf2u8l;

CREATE TABLE videos
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    title         VARCHAR(255)          NOT NULL,
    url           VARCHAR(255)          NOT NULL,
    `description` VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_videos PRIMARY KEY (id)
);

ALTER TABLE service_exclusions
    ADD CONSTRAINT fk_service_exclusions_on_residential_design_design FOREIGN KEY (service_id) REFERENCES residential_design_services (id);

ALTER TABLE service_inclusions
    ADD CONSTRAINT fk_service_inclusions_on_residential_design_design FOREIGN KEY (service_id) REFERENCES residential_design_services (id);

DROP TABLE category_seq;

DROP TABLE interior_service;

DROP TABLE product_seq;

DROP TABLE users_seq;

ALTER TABLE interior_services
    DROP COLUMN price;

ALTER TABLE interior_services
    DROP COLUMN difficulty_level;

ALTER TABLE interior_services
    DROP COLUMN service_type;

ALTER TABLE users
    DROP COLUMN `role`;

ALTER TABLE interior_services
    MODIFY base_price DECIMAL;

ALTER TABLE interior_services
    ADD difficulty_level VARCHAR(255) NULL;

ALTER TABLE interior_services
    ADD service_type VARCHAR(255) NOT NULL;
ALTER TABLE service_inclusions
    DROP FOREIGN KEY FK6rafn2k535prohhumx3mqhhfj;

ALTER TABLE service_exclusions
    DROP FOREIGN KEY FK8y1hiks3ml8g84ae9c0wf2u8l;

CREATE TABLE videos
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    title         VARCHAR(255)          NOT NULL,
    url           VARCHAR(255)          NOT NULL,
    `description` VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_videos PRIMARY KEY (id)
);

ALTER TABLE service_exclusions
    ADD CONSTRAINT fk_service_exclusions_on_residential_design_design FOREIGN KEY (service_id) REFERENCES residential_design_services (id);

ALTER TABLE service_inclusions
    ADD CONSTRAINT fk_service_inclusions_on_residential_design_design FOREIGN KEY (service_id) REFERENCES residential_design_services (id);

DROP TABLE category_seq;

DROP TABLE interior_service;

DROP TABLE product_seq;

DROP TABLE users_seq;

ALTER TABLE interior_services
    DROP COLUMN price;

ALTER TABLE interior_services
    DROP COLUMN difficulty_level;

ALTER TABLE interior_services
    DROP COLUMN service_type;

ALTER TABLE users
    DROP COLUMN `role`;

ALTER TABLE interior_services
    MODIFY base_price DECIMAL;

ALTER TABLE interior_services
    ADD difficulty_level VARCHAR(255) NULL;

ALTER TABLE interior_services
    ADD service_type VARCHAR(255) NOT NULL;
CREATE TABLE booking
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    user_id      BIGINT                NOT NULL,
    service_id   BIGINT                NOT NULL,
    booking_time datetime              NULL,
    status       VARCHAR(255)          NULL,
    CONSTRAINT pk_booking PRIMARY KEY (id)
);

CREATE TABLE category
(
    id         BIGINT       NOT NULL,
    created_at datetime     NULL,
    updated_at datetime     NULL,
    is_deleted BIT(1)       NOT NULL,
    title      VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE consultation
(
    id                BIGINT AUTO_INCREMENT NOT NULL,
    user_id           BIGINT                NOT NULL,
    consultation_time datetime              NULL,
    notes             VARCHAR(255)          NULL,
    CONSTRAINT pk_consultation PRIMARY KEY (id)
);

CREATE TABLE interior_services
(
    id                       BIGINT AUTO_INCREMENT NOT NULL,
    title                    VARCHAR(255)          NOT NULL,
    `description`            VARCHAR(1000)         NULL,
    service_type             VARCHAR(255)          NOT NULL,
    base_price               DECIMAL               NULL,
    estimated_duration_hours INT                   NULL,
    difficulty_level         VARCHAR(255)          NULL,
    is_active                BIT(1)                NULL,
    requires_on_site_visit   BIT(1)                NULL,
    minimum_project_size     VARCHAR(255)          NULL,
    maximum_project_size     VARCHAR(255)          NULL,
    created_at               datetime              NULL,
    updated_at               datetime              NULL,
    CONSTRAINT pk_interior_services PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BIGINT       NOT NULL,
    created_at    datetime     NULL,
    updated_at    datetime     NULL,
    is_deleted    BIT(1)       NOT NULL,
    title         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    price         DOUBLE       NOT NULL,
    image_url     VARCHAR(255) NULL,
    category_id   BIGINT       NULL,
    weight        INT          NOT NULL,
    height        INT          NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE residential_design_services
(
    id           BIGINT       NOT NULL,
    room_type    VARCHAR(255) NULL,
    design_style VARCHAR(255) NULL,
    CONSTRAINT pk_residential_design_services PRIMARY KEY (id)
);

CREATE TABLE service_exclusions
(
    service_id BIGINT       NOT NULL,
    exclusion  VARCHAR(255) NULL
);

CREATE TABLE service_inclusions
(
    service_id BIGINT       NOT NULL,
    inclusion  VARCHAR(255) NULL
);

CREATE TABLE user_roles
(
    user_id BIGINT       NOT NULL,
    `role`  VARCHAR(255) NULL
);

CREATE TABLE users
(
    id         BIGINT       NOT NULL,
    created_at datetime     NULL,
    updated_at datetime     NULL,
    is_deleted BIT(1)       NOT NULL,
    username   VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NULL,
    last_name  VARCHAR(255) NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE videos
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    title         VARCHAR(255)          NOT NULL,
    url           VARCHAR(255)          NOT NULL,
    `description` VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_videos PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE users
    ADD CONSTRAINT uc_users_username UNIQUE (username);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_SERVICE FOREIGN KEY (service_id) REFERENCES interior_services (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE consultation
    ADD CONSTRAINT FK_CONSULTATION_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE residential_design_services
    ADD CONSTRAINT FK_RESIDENTIAL_DESIGN_SERVICES_ON_ID FOREIGN KEY (id) REFERENCES interior_services (id);

ALTER TABLE service_exclusions
    ADD CONSTRAINT fk_service_exclusions_on_residential_design_design FOREIGN KEY (service_id) REFERENCES residential_design_services (id);

ALTER TABLE service_inclusions
    ADD CONSTRAINT fk_service_inclusions_on_residential_design_design FOREIGN KEY (service_id) REFERENCES residential_design_services (id);

ALTER TABLE user_roles
    ADD CONSTRAINT fk_user_roles_on_user FOREIGN KEY (user_id) REFERENCES users (id);