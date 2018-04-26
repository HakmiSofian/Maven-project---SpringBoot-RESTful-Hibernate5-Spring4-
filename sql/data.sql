insert into public.asset (asset_id, asset_name) values (1, 'asset 1');
insert into public.asset (asset_id, asset_name) values (2, 'asset 2');
insert into public.asset (asset_id, asset_name) values (3, 'asset 3');
insert into public.asset (asset_id, asset_name) values (4, 'asset 4');

insert into public.category (category_id, category_name) values (1, 'category 1');
insert into public.category (category_id, category_name) values (2, 'category 2');
insert into public.category (category_id, category_name) values (3, 'category 3');
insert into public.category (category_id, category_name) values (4, 'category 4');

insert into public.category_asset (asset_id, category_id) values (1, 1);
insert into public.category_asset (asset_id, category_id) values (1, 2);
insert into public.category_asset (asset_id, category_id) values (1, 3);
insert into public.category_asset (asset_id, category_id) values (1, 4);
insert into public.category_asset (asset_id, category_id) values (2, 2);
insert into public.category_asset (asset_id, category_id) values (2, 3);
insert into public.category_asset (asset_id, category_id) values (2, 4);
insert into public.category_asset (asset_id, category_id) values (3, 3);
insert into public.category_asset (asset_id, category_id) values (3, 4);
insert into public.category_asset (asset_id, category_id) values (4, 4);