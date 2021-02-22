CREATE TABLE IF NOT EXISTS click (
    clk bytea
);

CREATE TABLE IF NOT EXISTS  click_sum (
    clk_count bigint NOT NULL
);

INSERT INTO click_sum
    (clk_count)
SELECT 0
WHERE
    NOT EXISTS (
        SELECT * FROM click_sum
    );
