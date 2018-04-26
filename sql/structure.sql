CREATE TABLE public.asset
(
  asset_id TINYINT(4) NOT NULL UNIQUE,
  asset_name VARCHAR(8) UNIQUE,
  PRIMARY KEY (asset_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE public.category
(
  category_id TINYINT(4) NOT NULL UNIQUE,
  category_name VARCHAR(11) UNIQUE,
  PRIMARY KEY (category_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE public.category_asset
(
  asset_id TINYINT(4) NOT NULL,
  category_id TINYINT(4) NOT NULL,
  PRIMARY KEY (asset_id,category_id),
  KEY asset_id (asset_id),
  CONSTRAINT category_asset_fk_asset_id FOREIGN KEY (asset_id) REFERENCES public.asset(asset_id),
  CONSTRAINT category_asset_fk_category_id FOREIGN KEY (category_id) REFERENCES public.category(category_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
