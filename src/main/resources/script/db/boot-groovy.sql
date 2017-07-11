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
)

