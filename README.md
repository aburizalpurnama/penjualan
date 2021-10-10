# penjualan
Aplikasi Penjualan Sederhana

## setup docker container untuk database

docker run --rm --name penjualan-db -e POSTGRES_DB=penjualandb -e POSTGRES_USER=user -e POSTGRES_PASSWORD=TINv4bMVWKcZFtl7DZnk -e PGDATA=/var/lib/postgresql/data/pgdata -v "$PWD/penjualan-db:/var/lib/postgresql/data" -p 5432:5432 postgres:13