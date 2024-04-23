import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpHeaders;
//import java.net.http.HttpBodyPublishers;

public class get {
    public static void main(String[] args) throws Exception {
        System.out.println("--------------------------------------------------------------------0--------------------------------------------------------------------");
        // URL de la solicitud
        System.out.println("--------------------------------------------------------------------1--------------------------------------------------------------------");
        URI url = URI.create("https://apexapi.qa.grupotimexico.com/ords/piloto/interfase/get/usuarios");
        System.out.println("--------------------------------------------------------------------2--------------------------------------------------------------------");
        // Cuerpo de la solicitud en formato JSON
        String jsonBody = """
            {
                "key_cia":"13c09130-770d-ef34-b627-a171803d0cb5",
                "rfc_cia":"GCO1609307S5",
                "rfc_proveedor":"SGP190923628"
            }
        """;
        System.out.println("--------------------------------------------------------------------3--------------------------------------------------------------------");
        // Crear un cliente HTTP
        HttpClient client = HttpClient.newHttpClient();
        System.out.println("--------------------------------------------------------------------4--------------------------------------------------------------------");
        // Crear una solicitud POST
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
                System.out.println("--------------------------------------------------------------------5--------------------------------------------------------------------");
        // Realizar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("--------------------------------------------------------------------6--------------------------------------------------------------------");
        // Obtener el cuerpo de la respuesta
        String responseBody = response.body();

        // Imprimir la respuesta
        System.out.println("--------------------------------------------------------------------RESPUESTA--------------------------------------------------------------------");
        System.out.println("Response: " + responseBody);
    }
}

