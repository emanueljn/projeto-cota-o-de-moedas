package Main;

import java.util.ArrayList;
import java.util.Date;
import Calcutation.Calculation;
import History.ConversionHistoty;

import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SeachInApi buscaApi = new SeachInApi();
        Calculation calculation = new Calculation();

        Coins moeda = buscaApi.buscarTaxasDeCambio();

        List<ConversionHistoty> historico = new ArrayList<>(); // Histórico de conversões

        int option = 0;

        Scanner reader = null;
        while (option != 8) {
            reader = new Scanner(System.in);

            System.out.println("********************************************");
            System.out.println("""
                    Seja bem-vindo/a ao Conversor de Moeda
                                    
                    Opções:
                                   
                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar =>> Real brasileiro
                    4) Real brasileiro =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Histórico de conversões
                    8) Sair
                    Escolha uma opção válida
                    """);
            System.out.println("********************************************");

            try {
                option = reader.nextInt();

                if (option >= 1 && option <= 7) {
                    double coinsInput;

                    switch (option) {
                        case 1:
                            System.out.println("Digite a quantidade de dólares a ser convertida:");
                            coinsInput = reader.nextDouble();
                            double currentExchangeRateArs = moeda.getArs();
                            double result = calculation.convertionCoins(coinsInput, currentExchangeRateArs);
                            System.out.println("Resultado da conversão: " + result);
                            historico.add(new ConversionHistoty("USD", "ARS", coinsInput, currentExchangeRateArs, new Date()));
                            break;
                        case 2:
                            System.out.println("Digite a quantidade de pesos argentinos a ser convertida:");
                            coinsInput = reader.nextDouble();
                            currentExchangeRateArs = 1.0 / moeda.getArs();
                            result = calculation.convertionCoins(coinsInput, currentExchangeRateArs);
                            System.out.println("Resultado da conversão: " + result);
                            double currentExchangeRateUsd = moeda.getUsd();
                            historico.add(new ConversionHistoty("ARS", "USD", coinsInput, currentExchangeRateUsd, new Date()));
                            break;
                        case 3:
                            System.out.println("Digite a quantidade de dólares a ser convertida:");
                            coinsInput = reader.nextDouble();
                            double currentExchangeRateBrl = moeda.getBrl();
                            result = calculation.convertionCoins(coinsInput, currentExchangeRateBrl);
                            System.out.println("Resultado da conversão: " + result);
                            historico.add(new ConversionHistoty("USD", "BRL", coinsInput, currentExchangeRateBrl, new Date()));
                            break;
                        case 4:
                            System.out.println("Digite a quantidade de reais brasileiros a ser convertida:");
                            coinsInput = reader.nextDouble();
                            currentExchangeRateBrl = 1.0 / moeda.getBrl();
                            result = calculation.convertionCoins(coinsInput, currentExchangeRateBrl);
                            System.out.println("Resultado da conversão: " + result);
                            double currentExchangeRatUsd = moeda.getUsd();
                            historico.add(new ConversionHistoty("BRL", "USD", coinsInput, currentExchangeRatUsd, new Date()));
                            break;
                        case 5:
                            System.out.println("Digite a quantidade de dólares a ser convertida:");
                            coinsInput = reader.nextDouble();
                            double currentExchangeRateCop = moeda.getCop();
                            result = calculation.convertionCoins(coinsInput, currentExchangeRateCop);
                            System.out.println("Resultado da conversão: " + result);
                            historico.add(new ConversionHistoty("USD", "COP", coinsInput, currentExchangeRateCop, new Date()));
                            break;
                        case 6:
                            System.out.println("Digite a quantidade de pesos colombianos a ser convertida:");
                            coinsInput = reader.nextDouble();
                            currentExchangeRateCop = 1.0 / moeda.getCop();
                            result = calculation.convertionCoins(coinsInput, currentExchangeRateCop);
                            System.out.println("Resultado da conversão: " + result);
                            currentExchangeRatUsd = moeda.getUsd();
                            historico.add(new ConversionHistoty("COP", "USD", coinsInput,  currentExchangeRatUsd, new Date()));
                            break;
                        case 7:
                            for (ConversionHistoty conversao : historico) {
                            System.out.println("Moeda Origem: " + conversao.getMoedaOrigem() +
                                    ", Moeda Destino: " + conversao.getMoedaDestino() +
                                    ", Valor Convertido: " + conversao.getValorConvertido() +
                                    ", Taxa de Câmbio: " + conversao.getTaxaCambio() +
                                    ", Data/Hora: " + conversao.getDataHora());
                    }}
                } else if (option == 8) {
                    System.out.println("Encerrando o programa...");
                    break;
                } else if (option != 8) {
                    System.out.println("Opção inválida! Por favor, escolha uma opção entre 1 e 8.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
                reader.nextLine(); // Limpe o buffer do scanner
            }
        }
        reader.close();}
}

