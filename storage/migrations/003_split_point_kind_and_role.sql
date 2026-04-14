ALTER TABLE points ADD COLUMN point_kind TEXT NOT NULL DEFAULT 'navigation';
ALTER TABLE points ADD COLUMN biz_role TEXT NOT NULL DEFAULT '';

UPDATE points
SET
    point_kind = CASE
        WHEN type = 'charge' THEN 'charge'
        WHEN type = 'initial' THEN 'initial'
        ELSE 'navigation'
    END,
    biz_role = CASE
        WHEN type = 'feed' THEN 'feed'
        ELSE ''
    END;
