import pandas as pd
import logging
from pandas.core.frame import DataFrame
from conexaoBD import ConexaoBD


class CleaningData:

    logging.basicConfig(filename="log.txt", level=logging.DEBUG,
                        format="%(asctime)s %(message)s", filemode="a")

    def __int__(self, rad, precip, vento, atm, temp, umi):
        self.__rad = rad
        self.__precip = precip
        self.__vento = vento
        self.__atm = atm
        self.__temp = temp
        self.__umi = umi

    def getRad(self):
        return self.__rad

    def getPrecip(self):
        return self.__precip

    def getVento(self):
        return self.__vento

    def getAtm(self):
        return self.__atm

    def getTemp(self):
        return self.__temp

    def getUmi(self):
        return self.__umi

    def tratamento_dfs(self, df: DataFrame):

        try:

            pd.options.mode.chained_assignment = None

            # Apagando as linhas duplicadas
            df = df.drop_duplicates(subset=['Data', 'Hora UTC'], keep='first')

            for col in df.columns:
                mask = (df[col] == ',9')
                df.loc[mask, col] = '0,9'

                mask = (df[col] == ',8')
                df.loc[mask, col] = '0,8'

                mask = (df[col] == ',7')
                df.loc[mask, col] = '0,7'

                mask = (df[col] == ',6')
                df.loc[mask, col] = '0,6'

                mask = (df[col] == ',5')
                df.loc[mask, col] = '0,5'

                mask = (df[col] == ',4')
                df.loc[mask, col] = '0,4'

                mask = (df[col] == ',3')
                df.loc[mask, col] = '0,3'

                mask = (df[col] == ',2')
                df.loc[mask, col] = '0,2'

                mask = (df[col] == ',1')
                df.loc[mask, col] = '0,1'

                mask = (df[col] == ',0')
                df.loc[mask, col] = '0'

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

            # Apagando vírgulas em sequência errôneas
            df = df.replace({',,,,,,,,,,,,,': ''}, regex=True)
            df = df.replace({',,,,,,,,,,,,': ''}, regex=True)

            # Apagando vírgulas de valores floating
            df = df.replace({',': '.'}, regex=True)

            # Redeterminando valores Nan
            df = df.astype(object).where(pd.notnull(df), None)

            # Convertendo a datetime
            df['DATAHORA DE CAPTAÇÃO'] = pd.to_datetime(df['DATAHORA DE CAPTAÇÃO'], errors='raise', dayfirst=True)

            # Renomeando Colunas
            df = df.rename({'CODIGO (WMO)': 'cod_wmo', 'RADIACAO GLOBAL (Kj/m²)': 'radiacao_global',
                            'DATAHORA DE CAPTAÇÃO': 'datahora_captacao',
                            'PRECIPITAÇÃO TOTAL, HORÁRIO (mm)': 'precipitacaototal',
                            'VENTO, VELOCIDADE HORARIA (m/s)': 'vento_velocidade',
                            'VENTO, RAJADA MAXIMA (m/s)': 'vento_rajada_max',
                            'VENTO, DIREÇÃO HORARIA (gr) (° (gr))': 'vento_direcao_horario',
                            'PRESSAO ATMOSFERICA AO NIVEL DA ESTACAO, HORARIA (mB)': 'pressao_atm_estacao',
                            'PRESSÃO ATMOSFERICA MIN. NA HORA ANT. (AUT) (mB)': 'pressao_atm_min',
                            'PRESSÃO ATMOSFERICA MAX.NA HORA ANT. (AUT) (mB)': 'pressao_atm_max',
                            'TEMPERATURA DO AR - BULBO SECO, HORARIA (°C)': 'temperatura_ar',
                            'TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)': 'temperatura_min',
                            'TEMPERATURA MÁXIMA NA HORA ANT. (AUT) (°C)': 'temperatura_max',
                            'TEMPERATURA DO PONTO DE ORVALHO (°C)': 'temperatura_ponto_orvalho',
                            'TEMPERATURA ORVALHO MIN. NA HORA ANT. (AUT) (°C)': 'temperatura_orvalho_min',
                            'TEMPERATURA ORVALHO MAX. NA HORA ANT. (AUT) (°C)': 'temperatura_orvalho_max',
                            'UMIDADE RELATIVA DO AR, HORARIA (%)': 'umidade_relativa_ar',
                            'UMIDADE REL. MIN. NA HORA ANT. (AUT) (%)': 'umidade_relativa_min',
                            'UMIDADE REL. MAX. NA HORA ANT. (AUT) (%)': 'umidade_relativa_max'}, axis=1)

            # Desmembrando os dataframes por tabela do banco
            cleaningData = CleaningData()

            cleaningData.desmembrar_dfs(df)

        except:
            logging.debug("- ERRO: tratamento dos CSVs não pode ser concluída (CSVs/cleaningData.py)")
            raise

    def desmembrar_dfs(self, df: DataFrame):

        # Criando objeto e determinando atributos da instância
        dfFiltrado = CleaningData()

        dfFiltrado.__rad = df[['cod_wmo', 'radiacao_global', 'datahora_captacao']]

        dfFiltrado.__atm = df[['cod_wmo', 'pressao_atm_estacao', 'pressao_atm_min',
                                'pressao_atm_max', 'datahora_captacao']]

        dfFiltrado.__umi = df[['cod_wmo', 'umidade_relativa_ar', 'umidade_relativa_min',
                                'umidade_relativa_max', 'datahora_captacao']]

        dfFiltrado.__temp = df[['cod_wmo', 'temperatura_ar', 'temperatura_min',
                                 'temperatura_max', 'temperatura_ponto_orvalho',
                                 'temperatura_orvalho_min', 'temperatura_orvalho_max', 'datahora_captacao']]

        dfFiltrado.__vento = df[['cod_wmo', 'vento_velocidade', 'vento_rajada_max',
                                  'vento_direcao_horario', 'datahora_captacao']]

        dfFiltrado.__precip = df[['cod_wmo', 'precipitacaototal', 'datahora_captacao']]

        # Transferindo o dataframe filtrado e desmembrado ao método de povoamento do banco
        cbd = ConexaoBD()

        cbd.povoar_banco(dfFiltrado.getRad(), 'radiacao_global')
        cbd.povoar_banco(dfFiltrado.getPrecip(), 'precipitacao')
        cbd.povoar_banco(dfFiltrado.getVento(), 'vento')
        cbd.povoar_banco(dfFiltrado.getAtm(), 'pressao_atmosferica')
        cbd.povoar_banco(dfFiltrado.getTemp(), 'temperatura')
        cbd.povoar_banco(dfFiltrado.getUmi(), 'umidade')


