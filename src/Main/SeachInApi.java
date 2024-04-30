package Main;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SeachInApi {
    public Coins buscarTaxasDeCambio() {
        String endereco = "https://v6.exchangerate-api.com/v6/55e934781a30d63ccbfe90f4/latest/USD"; // Endereço da API

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();

        // Desserializando o JSON para o objeto DataApi
        Gson gson = new Gson();
        DataApi dataApi = gson.fromJson(json, DataApi.class);

        // Obtendo o objeto JSON das taxas de conversão
        JsonObject conversionRatesObject = dataApi.conversion_rates().getAsJsonObject();

        // Obtendo os valores individuais das taxas de conversão
        double usd = conversionRatesObject.get("USD").getAsDouble();
        double brl = conversionRatesObject.get("BRL").getAsDouble();
        double ars = conversionRatesObject.get("ARS").getAsDouble();
        double cop = conversionRatesObject.get("COP").getAsDouble();

        // Criando um objeto Coins com base nos dados da API
        return new Coins(usd, brl, ars, cop);
    }
}