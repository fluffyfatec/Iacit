def cleaner():
    import shutil
    from datetime import date

    date_td = date.today()
    year_td = date_td.year
    shutil.rmtree(f"DF/{year_td}", ignore_errors=False, onerror=None)
    print("Todos arquivos csv's exluidos")

cleaner()