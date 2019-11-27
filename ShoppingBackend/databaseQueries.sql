create table Category(
  id identity,
  name varchar(50),
  description varchar(255),
  image_url varchar(50),
  is_active BOOLEAN,
  
  constraint pk_category_id primary key(id)

);