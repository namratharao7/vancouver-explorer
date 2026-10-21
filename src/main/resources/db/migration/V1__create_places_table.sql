CREATE TABLE places (
    id VARCHAR(100) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(100) NOT NULL,
    neighbourhood VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    estimated_cost DOUBLE PRECISION NOT NULL,
    indoor BOOLEAN NOT NULL
);