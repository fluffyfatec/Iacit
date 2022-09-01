import numpy as np
import pandas as pd


def tratamento_dfs(df):

    # Apagando as linhas duplicadas
    df = df.drop_duplicates(subset=['Data', 'Hora UTC'], keep='first')

    # Ajustando Data ao padrão Br
    df['Data'] = pd.to_datetime(df['Data'], errors='coerce')
    df['Data'] = df['Data'].dt.strftime("%d/%m/%Y")

    # Juntando a Data à Hora
    df["DATAHORA DE CAPTAÇÃO"] = df["Data"] + ' ' + df["Hora UTC"]
    df['DATAHORA DE CAPTAÇÃO'] = df['DATAHORA DE CAPTAÇÃO'].replace({'0000 UTC': '00:00:00', '0100 UTC': '01:00:00',
                                                                     '0200 UTC': '02:00:00', '0300 UTC': '03:00:00',
                                                                     '0400 UTC': '04:00:00', '0500 UTC': '05:00:00',
                                                                     '0600 UTC': '06:00:00', '0700 UTC': '07:00:00',
                                                                     '0800 UTC': '08:00:00', '0900 UTC': '09:00:00',
                                                                     '1000 UTC': '10:OO:OO', '1100 UTC': '11:00:00',
                                                                     '1200 UTC': '12:00:00', '1300 UTC': '13:OO:OO',
                                                                     '1400 UTC': '14:00:00', '1500 UTC': '15:00:00',
                                                                     '1600 UTC': '16:00:00', '1700 UTC': '17:00:00',
                                                                     '1800 UTC': '18:00:00', '1900 UTC': '19:00:00',
                                                                     '2000 UTC': '20:00:00', '2100 UTC': '21:00:00',
                                                                     '2200 UTC': '22:00:00', '2300 UTC': '23:00:00',
                                                                     }, regex=True)

    # Apagando colunas
    if 'Unnamed: 19' in df.columns:
        df.drop('Unnamed: 19', inplace=True, axis=1)
    if ',,,,,,' in df.columns:
        df.drop(',,,,,,', inplace=True, axis=1)

    df.drop('Data', inplace=True, axis=1)
    df.drop('Hora UTC', inplace=True, axis=1)

    # Reorganizando a ordem das colunas
    df = df[['CODIGO (WMO)',
             'DATAHORA DE CAPTAÇÃO',
             'PRECIPITAÇÃO TOTAL, HORÁRIO (mm)',
             'PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)',
             'PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)',
             'PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)',
             'RADIACAO GLOBAL (Kj/m²)',
             'TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)',
             'TEMPERATURA DO PONTO DE ORVALHO (°C)',
             'TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)',
             'TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)',
             'TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)',
             'TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)',
             'UMIDADE REL. MAX. NA HORA ANT. (AUT) (%)',
             'UMIDADE REL. MIN. NA HORA ANT. (AUT) (%)',
             'UMIDADE RELATIVA DO AR, HORARIA (%)',
             'VENTO, DIREÇÃO HORARIA (gr) (° (gr))',
             'VENTO, RAJADA MAXIMA (m/s)',
             'VENTO, VELOCIDADE HORARIA (m/s)']]

    # Determinando como NaN valores em branco
    df.replace(r'^\s*$', np.nan, regex=True)

    return df
