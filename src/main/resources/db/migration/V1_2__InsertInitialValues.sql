WITH current_image_id AS (INSERT INTO images (url, thumbnail_url)
VALUES ('images/default/java.jpg', 'images/default/java_thumbnail.jpg')
RETURNING id)
INSERT INTO technologies (caption, image_id)
  SELECT 'Java', ci.id FROM current_image_id ci;

WITH current_image_id AS (INSERT INTO images (url, thumbnail_url)
VALUES ('images/default/js.jpg', 'images/default/js_thumbnail.jpg')
RETURNING id)
INSERT INTO technologies (caption, image_id)
  SELECT 'JavaScript', ci.id FROM current_image_id ci;

WITH current_image_id AS (INSERT INTO images (url, thumbnail_url)
VALUES ('images/default/vk.jpg', 'images/default/vk_thumbnail.jpg')
RETURNING id)
INSERT INTO contacts (title, description, url, image_id)
  SELECT 'Vk', 'Я в контакте', 'https://vk.com/hdgh0g', ci.id
  FROM current_image_id ci;

WITH current_image_id AS (INSERT INTO images (url, thumbnail_url)
VALUES ('images/default/facebook.jpg', 'images/default/facebook_thumbnail.jpg')
RETURNING id)
INSERT INTO contacts (title, description, url, image_id)
  SELECT 'Facebook', 'Я в фейсбуке', 'https://www.facebook.com/Hdgh0g', ci.id
  FROM current_image_id ci;

WITH current_image_id AS (INSERT INTO images (url, thumbnail_url)
VALUES ('images/default/tripsformer.jpg', 'images/default/tripsformer_thumbnail.jpg')
RETURNING id)
INSERT INTO projects (title, description, image_id)
    SELECT 'Tripsformer','"TripsFormer" - мобильное приложение и сайт для путешественников.
  Позволяет найти гидов в городах, посмотреть интересные места и памятники, создать маршрут по ним,
  вести свои расходы в путешествии, вести дневник, а так же сохранять информацию о купленных билетах.',
      ci.id FROM current_image_id ci;