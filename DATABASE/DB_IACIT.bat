color 2

echo RESTORE BANCO DE DADOS IACIT

set "PGPASSWORD=123"
dropdb -h localhost -U postgres -p 5432 --if-exists -f db_iacit_api
timeout /t 5
createdb -h localhost -U postgres -p 5432 -T template0 db_iacit_api
timeout /t 5
pg_restore -h localhost -U postgres -p 5432 -d db_iacit_api c:\sql\db_iacit_api.backup
pause
