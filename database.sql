-- Creazione del database (se non esiste già)
CREATE DATABASE IF NOT EXISTS my_guitar;

-- Seleziona il database da usare
USE my_guitar;

-- Creazione della tabella dream_guitar (per le chitarre)
CREATE TABLE IF NOT EXISTS dream_guitar (
    id INT PRIMARY KEY,
    price DECIMAL(10, 2) NOT NULL
    );

CREATE TABLE IF NOT EXISTS dream_guitar_components (
    guitar_id INT,
    component_name VARCHAR(100) NOT NULL ,
    component_value VARCHAR(100) NOT NULL ,
    PRIMARY KEY (guitar_id, component_name),
    FOREIGN KEY (guitar_id) REFERENCES dream_guitar(id) ON DELETE CASCADE
    );

-- Creazione della tabella users (per gli utenti)
CREATE TABLE IF NOT EXISTS users (
    username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    role ENUM('BASE', 'PREMIUM') NOT NULL,
    email VARCHAR(255),
    address VARCHAR(255),
    dream_guitar_id INT DEFAULT NULL,
    FOREIGN KEY (dream_guitar_id) REFERENCES dream_guitar(id) ON DELETE SET NULL
    );