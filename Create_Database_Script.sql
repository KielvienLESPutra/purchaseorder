-- Nyalakan DB postgres kemudian masuk dan dengan printah berikut:
-- psql -U postgres
-- Setelah masuk ketikan commend dibawah ini untuk membuat admin dan database.
CREATE USER kielvien12345 WITH PASSWORD 'boostbank12345';
CREATE DATABASE kielvien_lourensius_esp owner kielvien12345;

-- Setelah itu kemudia gunakan database atau connect to database yang baru dibuat.
-- Berikut printah yang digunakan.
-- \c kielvien_lourensius_esp
-- Setalah itu berikan privilages atau akses untuk DB, table, dan squence kepada user kielvien12345 dengan printah berikut ini/
GRANT ALL PRIVILEGES ON DATABASE kielvien_lourensius_esp TO kielvien12345;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO kielvien12345;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO kielvien12345;