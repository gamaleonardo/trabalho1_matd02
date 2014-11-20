
-- Database: cjweb1

-- DROP DATABASE cjweb1; ************* COMANDO 1!

CREATE DATABASE cjweb1
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'en_US.UTF-8'
       LC_CTYPE = 'en_US.UTF-8'
       CONNECTION LIMIT = -1;

COMMENT ON DATABASE cjweb1
  IS 'Banco de dados do Curso de Java Web Fundamental';

-- Table: "Usuarios"

-- DROP TABLE "Usuarios"; ************* COMANDO 2!

CREATE TABLE "Usuarios"
(
  id serial NOT NULL, -- Identificador do Usuário
  nome character varying(50),
  login character varying(20),
  senha character varying(32),
  CONSTRAINT "Usuarios_pkey" PRIMARY KEY (id),
  CONSTRAINT "Usuarios_login_key" UNIQUE (login)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Usuarios"
  OWNER TO postgres;
COMMENT ON COLUMN "Usuarios".id IS 'Identificador do Usuário';

