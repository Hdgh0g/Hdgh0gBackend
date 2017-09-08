CREATE TABLE images_with_caption (
  id BIGSERIAL PRIMARY KEY NOT NULL,
  caption VARCHAR(256),
  image_id BIGINT REFERENCES images
)