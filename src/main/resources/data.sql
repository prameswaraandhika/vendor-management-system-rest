INSERT INTO tbl_vendor (id, name, address, email, created_by, updated_by, created_at, updated_at, delete_at, is_deleted)
VALUES
    ('3f6d8f5c-1f5b-4dbf-8f98-4dddf7f7a4b9', 'PT Indah Karya', 'Jl. Sudirman No.123, Jakarta', 'info@indahkarya.co.id', 'admin', 'admin', '2024-10-01 12:00:00', '2024-10-01 12:00:00', NULL, false),
    ('7b98a4e6-2f5d-47c7-87a9-bc8e2dff5b45', 'CV Sukses Jaya', 'Jl. Malioboro No.45, Yogyakarta', 'contact@suksesjaya.com', 'admin', 'admin', '2024-10-01 12:30:00', '2024-10-01 12:30:00', NULL, false),
    ('cc3e2db9-5b77-485e-9f84-caa6a6d87f92', 'UD Maju Makmur', 'Jl. Diponegoro No.67, Surabaya', 'sales@majucorp.com', 'admin', 'admin', '2024-10-01 13:00:00', '2024-10-01 13:00:00', NULL, false),
    ('e5ff47f1-1c0b-4f3b-a579-9dc2e812f80d', 'PT Sinar Baru', 'Jl. Ahmad Yani No.12, Bandung', 'cs@sinarbaru.id', 'admin', 'admin', '2024-10-01 13:30:00', '2024-10-01 13:30:00', NULL, false);

-- Insert roles data with UUIDs
INSERT INTO tbl_role (id, name, created_by, updated_by, created_at, updated_at, delete_at, is_deleted)
VALUES
    ('3f6d8f5c-1f5b-4dbf-8f98-4dddf7f7a4b9', 'ADMIN', 'system', 'system', NOW(), NOW(), NULL, FALSE),
    ('4a7d8f8e-2a1d-4abc-9dcd-3cdfd8c7e5bc', 'USER', 'system', 'system', NOW(), NOW(), NULL, FALSE);

-- -- Insert users data with BCrypt encoded passwords and UUIDs
-- INSERT INTO tbl_user (id, name, birth_date, username, password, created_by, updated_by, created_at, updated_at, delete_at, is_deleted, is_enabled)
-- VALUES
--     ('1b3e5c2d-7ad3-4bcf-91c1-ecb8f0e1f17b', 'Budi', '1990-05-12', 'budi@example.com', '$2a$10$wkhIwBd0d/8XEPLxEJZxWO9GYinN22TAYDX6Zq6cyRRvqpZT0Uwmy', 'system', 'system', NOW(), NOW(), NULL, FALSE, TRUE),
--     ('2d6f8b7e-8f4b-41bd-bbdd-5c9dc7b6e5ea', 'Siti', '1985-09-23', 'siti@example.com', '$2a$10$pBlSRFJw1qQkEdr9SxpqsOa6bqJmTAgTnCFSsFrrzg1WOMYkDgFZO', 'system', 'system', NOW(), NOW(), NULL, FALSE, TRUE),
--     ('7d4f6a5b-5c9d-4f9a-879b-2f7de0c7a8df', 'Agus', '1992-11-17', 'agus@example.com', '$2a$10$GmRtgiEV8nA/.Qp.TmywVuhEYAnS/iSQMdzfl6N20BY4tLrTfcwya', 'system', 'system', NOW(), NOW(), NULL, FALSE, TRUE);
--
-- -- Assign roles to users (many-to-many relationship) using UUIDs
-- INSERT INTO user_roles (user_id, role_id)
-- VALUES
--     ('1b3e5c2d-7ad3-4bcf-91c1-ecb8f0e1f17b', '3f6d8f5c-1f5b-4dbf-8f98-4dddf7f7a4b9'), -- Budi is ADMIN
--     ('1b3e5c2d-7ad3-4bcf-91c1-ecb8f0e1f17b', '4a7d8f8e-2a1d-4abc-9dcd-3cdfd8c7e5bc'), -- Budi is also USER
--     ('2d6f8b7e-8f4b-41bd-bbdd-5c9dc7b6e5ea', '4a7d8f8e-2a1d-4abc-9dcd-3cdfd8c7e5bc'), -- Siti is USER
--     ('7d4f6a5b-5c9d-4f9a-879b-2f7de0c7a8df', '4a7d8f8e-2a1d-4abc-9dcd-3cdfd8c7e5bc'); -- Agus is USER
