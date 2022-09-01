import pandas as pd


def tratamento_cabecalho(df):

    pd.options.mode.chained_assignment = None

    df['REGIAO'] = df.loc[0][1]
    df['UF'] = df.loc[1][1]
    df['ESTACAO'] = df.loc[2][1]
    df['CODIGO (WMO)'] = df.loc[3][1]
    df['LATITUDE'] = df.loc[4][1]
    df['LONGITUDE'] = df.loc[5][1]
    df['ALTITUDE'] = df.loc[6][1]
    df['DATA DE FUNDACAO'] = df.loc[7][1]

    # Apagando duplicadas
    df = df.drop_duplicates(subset=['REGIAO', 'UF'], keep='first')

    # Apagando vírgulas extras
    cols = ["REGIAO", "UF", "ESTACAO", "CODIGO (WMO)", "LATITUDE", "LONGITUDE", "ALTITUDE", "DATA DE FUNDACAO"]
    df[cols] = df[cols].replace({',,,,,,,,,,,,,': ''}, regex=True)
    df[cols] = df[cols].replace({',,,,,,,,,,,,': ''}, regex=True)
    df[cols] = df[cols].replace({',': '.'}, regex=True)

    # Convertendo a datetime
    df['DATA DE FUNDACAO'] = pd.to_datetime(df['DATA DE FUNDACAO'], errors='coerce')

    # Config para visualizar todas as colunas
    pd.set_option('display.max_columns', None)

    return df


