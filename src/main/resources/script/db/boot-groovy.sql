-- Table: t_user

-- DROP TABLE t_user;

CREATE TABLE t_user
(
  id bigserial NOT NULL,
  version bigint NOT NULL,
  address character varying(200) NOT NULL,
  email character varying(255) NOT NULL,
  password character varying(30) NOT NULL,
  phone character varying(255) NOT NULL,
  user_name character varying(10) NOT NULL,
  CONSTRAINT t_user_pkey PRIMARY KEY (id),
  CONSTRAINT t_user_email_key UNIQUE (email)
) ;


-- Table: t_permission

-- DROP TABLE t_permission;

CREATE TABLE t_permission
(
  id                     BIGSERIAL              NOT NULL,
  version                BIGINT                 NOT NULL,
  url                    CHARACTER VARYING(255) NOT NULL,
  permission_description CHARACTER VARYING(255) NOT NULL,
  permission_name        CHARACTER VARYING(32)  NOT NULL,
  CONSTRAINT t_permission_pkey PRIMARY KEY (id),
  CONSTRAINT t_permission_url_key UNIQUE (url)
);

-- Table: t_role

-- DROP TABLE t_role;
CREATE TABLE t_role
(
  id               BIGSERIAL              NOT NULL,
  version          BIGINT                 NOT NULL,
  role_type        CHARACTER VARYING(16)  NOT NULL,
  role_description CHARACTER VARYING(255) NOT NULL,
  role_name        CHARACTER VARYING(32)  NOT NULL,
  CONSTRAINT t_role_pkey PRIMARY KEY (id),
  CONSTRAINT t_role_role_type_key UNIQUE (role_type)
);

-- Table: t_role_permission

-- DROP TABLE t_role_permission;

CREATE TABLE t_role_permission
(
  id            BIGSERIAL NOT NULL,
  version       BIGINT    NOT NULL,
  role_id       BIGINT    NOT NULL,
  permission_id BIGINT    NOT NULL,
  CONSTRAINT t_role_permission_pkey PRIMARY KEY (id)
);

-- Table: t_user_role

-- DROP TABLE t_user_role;

CREATE TABLE t_user_role
(
  id      BIGSERIAL NOT NULL,
  version BIGINT    NOT NULL,
  role_id BIGINT    NOT NULL,
  user_id BIGINT    NOT NULL,
  CONSTRAINT t_user_role_pkey PRIMARY KEY (id)
)

