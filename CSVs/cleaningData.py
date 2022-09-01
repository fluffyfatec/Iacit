import numpy as np
import pandas as pd


def tratamento_dfs(df):

    pd.options.mode.chained_assignment = None

    # Apagando as linhas duplicadas
    df = df.drop_duplicates(subset=['Data', 'Hora UTC'], keep='first')

    # Resolvendo o problema dos números que começam com vírgula
    mask = (df['PRECIPITAÇÃO TOTAL, HORÁRIO (mm)'] == ',9')
    df.loc[mask, 'PRECIPITAÇÃO TOTAL, HORÁRIO (mm)'] = '0,9'

    mask = (df['PRECIPITAÇÃO TOTAL, HORÁRIO (mm)'] == ',8')
    df.loc[mask, 'PRECIPITAÇÃO TOTAL, HORÁRIO (mm)'] = '0,8'

    mask = (df['PRECIPITAÇÃO TOTAL, HORÁRIO (mm)'] == ',7')
    df.loc[mask, 'PRECIPITAÇÃO TOTAL, HORÁRIO (mm)'] = '0,7'

    mask = (df['PRECIPITAÇÃO TOTAL, HORÁRIO (mm)'] == ',6')
    df.loc[mask, 'PRECIPITAÇÃO TOTAL, HORÁRIO (mm)'] = '0,6'

    mask = (df['PRECIPITAÇÃO TOTAL, HORÁRIO (mm)'] == ',5')
    df.loc[mask, 'PRECIPITAÇÃO TOTAL, HORÁRIO (mm)'] = '0,5'

    mask = (df['PRECIPITAÇÃO TOTAL, HORÁRIO (mm)'] == ',4')
    df.loc[mask, 'PRECIPITAÇÃO TOTAL, HORÁRIO (mm)'] = '0,4'

    mask = (df['PRECIPITAÇÃO TOTAL, HORÁRIO (mm)'] == ',3')
    df.loc[mask, 'PRECIPITAÇÃO TOTAL, HORÁRIO (mm)'] = '0,3'

    mask = (df['PRECIPITAÇÃO TOTAL, HORÁRIO (mm)'] == ',2')
    df.loc[mask, 'PRECIPITAÇÃO TOTAL, HORÁRIO (mm)'] = '0,2'

    mask = (df['PRECIPITAÇÃO TOTAL, HORÁRIO (mm)'] == ',1')
    df.loc[mask, 'PRECIPITAÇÃO TOTAL, HORÁRIO (mm)'] = '0,1'

    mask = (df['PRECIPITAÇÃO TOTAL, HORÁRIO (mm)'] == ',0')
    df.loc[mask, 'PRECIPITAÇÃO TOTAL, HORÁRIO (mm)'] = '0'

    mask = (df['VENTO, VELOCIDADE HORARIA (m/s)'] == ',9')
    df.loc[mask, 'VENTO, VELOCIDADE HORARIA (m/s)'] = '0,9'

    mask = (df['VENTO, VELOCIDADE HORARIA (m/s)'] == ',8')
    df.loc[mask, 'VENTO, VELOCIDADE HORARIA (m/s)'] = '0,8'

    mask = (df['VENTO, VELOCIDADE HORARIA (m/s)'] == ',7')
    df.loc[mask, 'VENTO, VELOCIDADE HORARIA (m/s)'] = '0,7'

    mask = (df['VENTO, VELOCIDADE HORARIA (m/s)'] == ',6')
    df.loc[mask, 'VENTO, VELOCIDADE HORARIA (m/s)'] = '0,6'

    mask = (df['VENTO, VELOCIDADE HORARIA (m/s)'] == ',5')
    df.loc[mask, 'VENTO, VELOCIDADE HORARIA (m/s)'] = '0,5'

    mask = (df['VENTO, VELOCIDADE HORARIA (m/s)'] == ',4')
    df.loc[mask, 'VENTO, VELOCIDADE HORARIA (m/s)'] = '0,4'

    mask = (df['VENTO, VELOCIDADE HORARIA (m/s)'] == ',3')
    df.loc[mask, 'VENTO, VELOCIDADE HORARIA (m/s)'] = '0,3'

    mask = (df['VENTO, VELOCIDADE HORARIA (m/s)'] == ',2')
    df.loc[mask, 'VENTO, VELOCIDADE HORARIA (m/s)'] = '0,2'

    mask = (df['VENTO, VELOCIDADE HORARIA (m/s)'] == ',1')
    df.loc[mask, 'VENTO, VELOCIDADE HORARIA (m/s)'] = '0,1'

    mask = (df['VENTO, VELOCIDADE HORARIA (m/s)'] == ',0')
    df.loc[mask, 'VENTO, VELOCIDADE HORARIA (m/s)'] = '0'

    mask = (df['PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)'] == ',9')
    df.loc[mask, 'PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)'] = '0,9'

    mask = (df['PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)'] == ',8')
    df.loc[mask, 'PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)'] = '0,8'

    mask = (df['PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)'] == ',7')
    df.loc[mask, 'PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)'] = '0,7'

    mask = (df['PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)'] == ',6')
    df.loc[mask, 'PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)'] = '0,6'

    mask = (df['PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)'] == ',5')
    df.loc[mask, 'PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)'] = '0,5'

    mask = (df['PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)'] == ',4')
    df.loc[mask, 'PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)'] = '0,4'

    mask = (df['PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)'] == ',3')
    df.loc[mask, 'PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)'] = '0,3'

    mask = (df['PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)'] == ',2')
    df.loc[mask, 'PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)'] = '0,2'

    mask = (df['PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)'] == ',1')
    df.loc[mask, 'PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)'] = '0,1'

    mask = (df['PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)'] == ',0')
    df.loc[mask, 'PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)'] = '0'

    mask = (df['PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)'] == ',9')
    df.loc[mask, 'PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)'] = '0,9'

    mask = (df['PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)'] == ',8')
    df.loc[mask, 'PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)'] = '0,8'

    mask = (df['PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)'] == ',7')
    df.loc[mask, 'PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)'] = '0,7'

    mask = (df['PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)'] == ',6')
    df.loc[mask, 'PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)'] = '0,6'

    mask = (df['PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)'] == ',5')
    df.loc[mask, 'PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)'] = '0,5'

    mask = (df['PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)'] == ',4')
    df.loc[mask, 'PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)'] = '0,4'

    mask = (df['PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)'] == ',3')
    df.loc[mask, 'PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)'] = '0,3'

    mask = (df['PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)'] == ',2')
    df.loc[mask, 'PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)'] = '0,2'

    mask = (df['PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)'] == ',1')
    df.loc[mask, 'PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)'] = '0,1'

    mask = (df['PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)'] == ',0')
    df.loc[mask, 'PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)'] = '0'

    mask = (df['PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)'] == ',9')
    df.loc[mask, 'PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)'] = '0,9'

    mask = (df['PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)'] == ',8')
    df.loc[mask, 'PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)'] = '0,8'

    mask = (df['PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)'] == ',7')
    df.loc[mask, 'PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)'] = '0,7'

    mask = (df['PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)'] == ',6')
    df.loc[mask, 'PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)'] = '0,6'

    mask = (df['PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)'] == ',5')
    df.loc[mask, 'PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)'] = '0,5'

    mask = (df['PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)'] == ',4')
    df.loc[mask, 'PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)'] = '0,4'

    mask = (df['PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)'] == ',3')
    df.loc[mask, 'PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)'] = '0,3'

    mask = (df['PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)'] == ',2')
    df.loc[mask, 'PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)'] = '0,2'

    mask = (df['PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)'] == ',1')
    df.loc[mask, 'PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)'] = '0,1'

    mask = (df['PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)'] == ',0')
    df.loc[mask, 'PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)'] = '0'

    mask = (df['RADIACAO GLOBAL (Kj/m²)'] == ',9')
    df.loc[mask, 'RADIACAO GLOBAL (Kj/m²)'] = '0,9'

    mask = (df['RADIACAO GLOBAL (Kj/m²)'] == ',8')
    df.loc[mask, 'RADIACAO GLOBAL (Kj/m²)'] = '0,8'

    mask = (df['RADIACAO GLOBAL (Kj/m²)'] == ',7')
    df.loc[mask, 'RADIACAO GLOBAL (Kj/m²)'] = '0,7'

    mask = (df['RADIACAO GLOBAL (Kj/m²)'] == ',6')
    df.loc[mask, 'RADIACAO GLOBAL (Kj/m²)'] = '0,6'

    mask = (df['RADIACAO GLOBAL (Kj/m²)'] == ',5')
    df.loc[mask, 'RADIACAO GLOBAL (Kj/m²)'] = '0,5'

    mask = (df['RADIACAO GLOBAL (Kj/m²)'] == ',4')
    df.loc[mask, 'RADIACAO GLOBAL (Kj/m²)'] = '0,4'

    mask = (df['RADIACAO GLOBAL (Kj/m²)'] == ',3')
    df.loc[mask, 'RADIACAO GLOBAL (Kj/m²)'] = '0,3'

    mask = (df['RADIACAO GLOBAL (Kj/m²)'] == ',2')
    df.loc[mask, 'RADIACAO GLOBAL (Kj/m²)'] = '0,2'

    mask = (df['RADIACAO GLOBAL (Kj/m²)'] == ',1')
    df.loc[mask, 'RADIACAO GLOBAL (Kj/m²)'] = '0,1'

    mask = (df['RADIACAO GLOBAL (Kj/m²)'] == ',0')
    df.loc[mask, 'RADIACAO GLOBAL (Kj/m²)'] = '0'

    mask = (df['TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)'] == ',9')
    df.loc[mask, 'TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)'] = '0,9'

    mask = (df['TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)'] == ',8')
    df.loc[mask, 'TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)'] = '0,8'

    mask = (df['TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)'] == ',7')
    df.loc[mask, 'TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)'] = '0,7'

    mask = (df['TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)'] == ',6')
    df.loc[mask, 'TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)'] = '0,6'

    mask = (df['TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)'] == ',5')
    df.loc[mask, 'TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)'] = '0,5'

    mask = (df['TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)'] == ',4')
    df.loc[mask, 'TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)'] = '0,4'

    mask = (df['TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)'] == ',3')
    df.loc[mask, 'TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)'] = '0,3'

    mask = (df['TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)'] == ',2')
    df.loc[mask, 'TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)'] = '0,2'

    mask = (df['TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)'] == ',1')
    df.loc[mask, 'TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)'] = '0,1'

    mask = (df['TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)'] == ',0')
    df.loc[mask, 'TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)'] = '0'

    mask = (df['TEMPERATURA DO PONTO DE ORVALHO (°C)'] == ',9')
    df.loc[mask, 'TEMPERATURA DO PONTO DE ORVALHO (°C)'] = '0,9'

    mask = (df['TEMPERATURA DO PONTO DE ORVALHO (°C)'] == ',8')
    df.loc[mask, 'TEMPERATURA DO PONTO DE ORVALHO (°C)'] = '0,8'

    mask = (df['TEMPERATURA DO PONTO DE ORVALHO (°C)'] == ',7')
    df.loc[mask, 'TEMPERATURA DO PONTO DE ORVALHO (°C)'] = '0,7'

    mask = (df['TEMPERATURA DO PONTO DE ORVALHO (°C)'] == ',6')
    df.loc[mask, 'TEMPERATURA DO PONTO DE ORVALHO (°C)'] = '0,6'

    mask = (df['TEMPERATURA DO PONTO DE ORVALHO (°C)'] == ',5')
    df.loc[mask, 'TEMPERATURA DO PONTO DE ORVALHO (°C)'] = '0,5'

    mask = (df['TEMPERATURA DO PONTO DE ORVALHO (°C)'] == ',4')
    df.loc[mask, 'TEMPERATURA DO PONTO DE ORVALHO (°C)'] = '0,4'

    mask = (df['TEMPERATURA DO PONTO DE ORVALHO (°C)'] == ',3')
    df.loc[mask, 'TEMPERATURA DO PONTO DE ORVALHO (°C)'] = '0,3'

    mask = (df['TEMPERATURA DO PONTO DE ORVALHO (°C)'] == ',2')
    df.loc[mask, 'TEMPERATURA DO PONTO DE ORVALHO (°C)'] = '0,2'

    mask = (df['TEMPERATURA DO PONTO DE ORVALHO (°C)'] == ',1')
    df.loc[mask, 'TEMPERATURA DO PONTO DE ORVALHO (°C)'] = '0,1'

    mask = (df['TEMPERATURA DO PONTO DE ORVALHO (°C)'] == ',0')
    df.loc[mask, 'TEMPERATURA DO PONTO DE ORVALHO (°C)'] = '0'

    mask = (df['TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)'] == ',9')
    df.loc[mask, 'TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)'] = '0,9'

    mask = (df['TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)'] == ',8')
    df.loc[mask, 'TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)'] = '0,8'

    mask = (df['TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)'] == ',7')
    df.loc[mask, 'TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)'] = '0,7'

    mask = (df['TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)'] == ',6')
    df.loc[mask, 'TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)'] = '0,6'

    mask = (df['TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)'] == ',5')
    df.loc[mask, 'TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)'] = '0,5'

    mask = (df['TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)'] == ',4')
    df.loc[mask, 'TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)'] = '0,4'

    mask = (df['TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)'] == ',3')
    df.loc[mask, 'TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)'] = '0,3'

    mask = (df['TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)'] == ',2')
    df.loc[mask, 'TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)'] = '0,2'

    mask = (df['TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)'] == ',1')
    df.loc[mask, 'TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)'] = '0,1'

    mask = (df['TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)'] == ',0')
    df.loc[mask, 'TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)'] = '0'

    mask = (df['TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)'] == ',9')
    df.loc[mask, 'TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)'] = '0,9'

    mask = (df['TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)'] == ',8')
    df.loc[mask, 'TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)'] = '0,8'

    mask = (df['TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)'] == ',7')
    df.loc[mask, 'TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)'] = '0,7'

    mask = (df['TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)'] == ',6')
    df.loc[mask, 'TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)'] = '0,6'

    mask = (df['TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)'] == ',5')
    df.loc[mask, 'TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)'] = '0,5'

    mask = (df['TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)'] == ',4')
    df.loc[mask, 'TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)'] = '0,4'

    mask = (df['TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)'] == ',3')
    df.loc[mask, 'TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)'] = '0,3'

    mask = (df['TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)'] == ',2')
    df.loc[mask, 'TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)'] = '0,2'

    mask = (df['TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)'] == ',1')
    df.loc[mask, 'TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)'] = '0,1'

    mask = (df['TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)'] == ',0')
    df.loc[mask, 'TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)'] = '0'

    mask = (df['TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)'] == ',9')
    df.loc[mask, 'TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)'] = '0,9'

    mask = (df['TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)'] == ',8')
    df.loc[mask, 'TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)'] = '0,8'

    mask = (df['TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)'] == ',7')
    df.loc[mask, 'TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)'] = '0,7'

    mask = (df['TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)'] == ',6')
    df.loc[mask, 'TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)'] = '0,6'

    mask = (df['TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)'] == ',5')
    df.loc[mask, 'TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)'] = '0,5'

    mask = (df['TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)'] == ',4')
    df.loc[mask, 'TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)'] = '0,4'

    mask = (df['TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)'] == ',3')
    df.loc[mask, 'TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)'] = '0,3'

    mask = (df['TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)'] == ',2')
    df.loc[mask, 'TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)'] = '0,2'

    mask = (df['TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)'] == ',1')
    df.loc[mask, 'TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)'] = '0,1'

    mask = (df['TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)'] == ',0')
    df.loc[mask, 'TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)'] = '0'

    mask = (df['TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)'] == ',9')
    df.loc[mask, 'TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)'] = '0,9'

    mask = (df['TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)'] == ',8')
    df.loc[mask, 'TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)'] = '0,8'

    mask = (df['TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)'] == ',7')
    df.loc[mask, 'TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)'] = '0,7'

    mask = (df['TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)'] == ',6')
    df.loc[mask, 'TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)'] = '0,6'

    mask = (df['TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)'] == ',5')
    df.loc[mask, 'TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)'] = '0,5'

    mask = (df['TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)'] == ',4')
    df.loc[mask, 'TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)'] = '0,4'

    mask = (df['TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)'] == ',3')
    df.loc[mask, 'TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)'] = '0,3'

    mask = (df['TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)'] == ',2')
    df.loc[mask, 'TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)'] = '0,2'

    mask = (df['TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)'] == ',1')
    df.loc[mask, 'TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)'] = '0,1'

    mask = (df['TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)'] == ',0')
    df.loc[mask, 'TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)'] = '0'

    mask = (df['VENTO, RAJADA MAXIMA (m/s)'] == ',9')
    df.loc[mask, 'VENTO, RAJADA MAXIMA (m/s)'] = '0,9'

    mask = (df['VENTO, RAJADA MAXIMA (m/s)'] == ',8')
    df.loc[mask, 'VENTO, RAJADA MAXIMA (m/s)'] = '0,8'

    mask = (df['VENTO, RAJADA MAXIMA (m/s)'] == ',7')
    df.loc[mask, 'VENTO, RAJADA MAXIMA (m/s)'] = '0,7'

    mask = (df['VENTO, RAJADA MAXIMA (m/s)'] == ',6')
    df.loc[mask, 'VENTO, RAJADA MAXIMA (m/s)'] = '0,6'

    mask = (df['VENTO, RAJADA MAXIMA (m/s)'] == ',5')
    df.loc[mask, 'VENTO, RAJADA MAXIMA (m/s)'] = '0,5'

    mask = (df['VENTO, RAJADA MAXIMA (m/s)'] == ',4')
    df.loc[mask, 'VENTO, RAJADA MAXIMA (m/s)'] = '0,4'

    mask = (df['VENTO, RAJADA MAXIMA (m/s)'] == ',3')
    df.loc[mask, 'VENTO, RAJADA MAXIMA (m/s)'] = '0,3'

    mask = (df['VENTO, RAJADA MAXIMA (m/s)'] == ',2')
    df.loc[mask, 'VENTO, RAJADA MAXIMA (m/s)'] = '0,2'

    mask = (df['VENTO, RAJADA MAXIMA (m/s)'] == ',1')
    df.loc[mask, 'VENTO, RAJADA MAXIMA (m/s)'] = '0,1'

    mask = (df['VENTO, RAJADA MAXIMA (m/s)'] == ',0')
    df.loc[mask, 'VENTO, RAJADA MAXIMA (m/s)'] = '0'

    # Ajustando Data ao padrão Br
    df['Data'] = pd.to_datetime(df['Data'], errors='coerce')
    df['Data'] = df['Data'].dt.strftime("%d/%m/%Y")

    # Juntando a Data à Hora
    df["DATAHORA DE CAPTAÇÃO"] = df["Data"] + ' ' + df["Hora UTC"]
    df['DATAHORA DE CAPTAÇÃO'] = df['DATAHORA DE CAPTAÇÃO'].replace({'0000 UTC': '00', '0100 UTC': '01',
                                                                     '0200 UTC': '02', '0300 UTC': '03',
                                                                     '0400 UTC': '04', '0500 UTC': '05',
                                                                     '0600 UTC': '06', '0700 UTC': '07',
                                                                     '0800 UTC': '08', '0900 UTC': '09',
                                                                     '1000 UTC': '10', '1100 UTC': '11',
                                                                     '1200 UTC': '12', '1300 UTC': '13',
                                                                     '1400 UTC': '14', '1500 UTC': '15',
                                                                     '1600 UTC': '16', '1700 UTC': '17',
                                                                     '1800 UTC': '18', '1900 UTC': '19',
                                                                     '2000 UTC': '20', '2100 UTC': '21',
                                                                     '2200 UTC': '22', '2300 UTC': '23',
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

    # Apagando vírgulas em sequência errôneas
    df = df.replace({',,,,,,,,,,,,,': ''}, regex=True)
    df = df.replace({',,,,,,,,,,,,': ''}, regex=True)

    # Apagando vírgulas de valores floating
    df = df.replace({',': '.'}, regex=True)

    # Redeterminando valores Nan para NULL
    df.fillna("NULL", inplace=True)

    # Convertendo a datetime
    df['DATAHORA DE CAPTAÇÃO'] = pd.to_datetime(df['DATAHORA DE CAPTAÇÃO'], errors='raise', dayfirst=True)

    return df
