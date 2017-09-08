CREATE TABLE posts
(
  id BIGSERIAL PRIMARY KEY NOT NULL,
  title VARCHAR(1024) NOT NULL,
  creation_time TIMESTAMP NOT NULL,
  full_text TEXT NOT NULL
);

CREATE TABLE posts_tags
(
  post_id BIGINT REFERENCES posts (id) ON DELETE CASCADE,
  tag VARCHAR(256) NOT NULL,
  PRIMARY KEY (post_id, tag)
);

WITH current_post_id AS (
  INSERT INTO posts (title, creation_time, full_text)
  VALUES ('Первая запись в этом блоге', now(),
          E'Всем привет! \n Это будет короткая запись. Наконец-то я дошел до того, чтобы начать вести дневник. Что же из этого выйдет?')
RETURNING id)
INSERT INTO posts_tags
  SELECT cpi.id, unnest(ARRAY['дневник','тестируем'])
  FROM current_post_id cpi;