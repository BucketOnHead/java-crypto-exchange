INSERT INTO secret_keys(access_type, key_value)
VALUES ('ADMIN', 'ImAHundredPercentAdminHonestly_001');

INSERT INTO admins(secret_key_id)
VALUES (SELECT keys.secret_key_id
        FROM secret_keys AS keys
        WHERE keys.key_value = 'ImAHundredPercentAdminHonestly_001')