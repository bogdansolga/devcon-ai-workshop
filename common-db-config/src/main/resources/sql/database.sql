-- run these commands before starting the project, in order to setup the database and the connecting user
CREATE USER devcon_ai_workshop_admin WITH PASSWORD 'sU5YgsbPbRx2ZYn';

CREATE DATABASE devcon_ai_workshop;
GRANT ALL PRIVILEGES ON DATABASE devcon_ai_workshop TO devcon_ai_workshop_admin;
GRANT ALL ON SCHEMA public TO devcon_ai_workshop;