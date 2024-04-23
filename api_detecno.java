import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpHeaders;

public class api_detecno {
    public static String peticion(String xmlBody) throws Exception {
        // URL de la solicitud
        URI url = URI.create("https://detecnorecepcion.mx:447/Recepcion/Validame/cfdiWSRecepcion_Servicio/Service1.svc");
        // Crear un cliente HTTP
        HttpClient client = HttpClient.newHttpClient();
        // Crear una solicitud POST
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .header("Content-Type", "text/xml; charset=utf-8")
                .header("SOAPAction", "http://tempuri.org/IService1/validarXML")
                .POST(HttpRequest.BodyPublishers.ofString(xmlBody))
                .build();
        // Realizar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Obtener el cuerpo de la respuesta
        String responseBody = response.body();
        return responseBody;
    }


    public static void main(String[] args) throws Exception {
        String xmlBody = """
            <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:tem="http://tempuri.org/">
            <soapenv:Header/>
            <soapenv:Body>
            <tem:validarXML>
            <tem:usuario>wsS&amp;C951211TQ1</tem:usuario>
            <tem:password>eo@W@AqkU9</tem:password>
            <tem:licencia>GTERjKOeYppTnR152nrkKxqo0Z8YCA-8fMP76cYOHn8=</tem:licencia>
            <tem:xmlPassed> <cfdi:Comprobante Version="4.0" Serie="EST" Folio="7703714" Fecha="2023-12-06T00:57:46" FormaPago="99" NoCertificado="00001000000506121124" SubTotal="1735.99" Moneda="MXN" Exportacion="01" Total="2013.74" TipoDeComprobante="I" MetodoPago="PPD" LugarExpedicion="06500" Sello="RxSdoxxJQw80QD70T6nRuX2WmsYpBxcF+5UR5+i+EPrcxyRhJgs2lOLK/9mGHQRxs3aMHEteMRAParuGsMkd7zcxL+1kswRiGbuZkurqZP6PjH0LNGjO+EQL8J7QknU6nc83Uc4UwJEfAUfXMvxL1/bm9CSZMv0U3XV0LN1YQwOOlmmsF9HaYepgcpF54b4ahODTqR17j4CGCoIUXUOuYiJuAHynWTORpRrwPdP96ATUv/ergqu2Gdnzqv9ylnWRFmxqSa46Du02wmUZsTmltkDUf2D0dgVP10LqicMiBUQ7chEAondy616w/wVyfANeCAUGeKkTiZ6YaSJEf7Nmew==" Certificado="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" xsi:schemaLocation="http://www.sat.gob.mx/cfd/4 http://www.sat.gob.mx/sitio_internet/cfd/4/cfdv40.xsd" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:cfdi="http://www.sat.gob.mx/cfd/4"><cfdi:Emisor Rfc="TME840315KT6" Nombre="TELEFONOS DE MEXICO" RegimenFiscal="601"/><cfdi:Receptor Rfc="S&amp;C951211TQ1" Nombre="KANDELIUM MEXICO" UsoCFDI="G03" DomicilioFiscalReceptor="66000" RegimenFiscalReceptor="601"/><cfdi:Conceptos><cfdi:Concepto ClaveProdServ="81161700" Cantidad="1.00" ClaveUnidad="E48" Unidad="Servicio" Descripcion="SERVICIOS DE TELECOMUNICACIONES" ValorUnitario="1735.99" Importe="1735.99" ObjetoImp="02"><cfdi:Impuestos><cfdi:Traslados><cfdi:Traslado Base="1735.99" Impuesto="002" TipoFactor="Tasa" TasaOCuota="0.160000" Importe="277.75"/></cfdi:Traslados></cfdi:Impuestos></cfdi:Concepto></cfdi:Conceptos><cfdi:Impuestos TotalImpuestosTrasladados="277.75"><cfdi:Traslados><cfdi:Traslado Base="1735.99" Impuesto="002" TipoFactor="Tasa" TasaOCuota="0.160000" Importe="277.75"/></cfdi:Traslados></cfdi:Impuestos><cfdi:Complemento><tfd:TimbreFiscalDigital xsi:schemaLocation="http://www.sat.gob.mx/TimbreFiscalDigital http://www.sat.gob.mx/sitio_internet/cfd/TimbreFiscalDigital/TimbreFiscalDigitalv11.xsd" Version="1.1" UUID="7cd24913-2488-4807-acdd-edef6d7ad5ae" FechaTimbrado="2023-12-06T17:20:48" RfcProvCertif="TME840315KT6" Leyenda="ValorDelAtributoLeyenda" NoCertificadoSAT="00001000000508680418" SelloCFD="RxSdoxxJQw80QD70T6nRuX2WmsYpBxcF+5UR5+i+EPrcxyRhJgs2lOLK/9mGHQRxs3aMHEteMRAParuGsMkd7zcxL+1kswRiGbuZkurqZP6PjH0LNGjO+EQL8J7QknU6nc83Uc4UwJEfAUfXMvxL1/bm9CSZMv0U3XV0LN1YQwOOlmmsF9HaYepgcpF54b4ahODTqR17j4CGCoIUXUOuYiJuAHynWTORpRrwPdP96ATUv/ergqu2Gdnzqv9ylnWRFmxqSa46Du02wmUZsTmltkDUf2D0dgVP10LqicMiBUQ7chEAondy616w/wVyfANeCAUGeKkTiZ6YaSJEf7Nmew==" SelloSAT="Dovv7tk98VZqAqXWmyxQpuL7fqOrUYu83sp+tvL9pUG5N3JPzsgy3kceOn2i/A9bDNsoWSq91vDGpaO6oFgCOEPTxJfuUFAO/7jlqn5a63t022vXiuHe6GKYC6OMq+xVJdj39Halcq8y4Z8NAkwkrraXsSb6h8kOlSG18SgpuREviSCWSmxXurEAB0zjS/AsK127WM4atx8tZpEXgNWYRD1Ql31hr9poO4DaEKyRpkSzqqMnc3UbDQMM3znZmb82krhIdVs6H6PRg0WlYGB9CxjnlUl9flEFU7f7HqT0sZgo8Z/LurbL72Uc1WVRL3WDsWtfhgMtHHDVhFgj96Xomw==" xmlns:tfd="http://www.sat.gob.mx/TimbreFiscalDigital"/></cfdi:Complemento></cfdi:Comprobante>
            </tem:xmlPassed>
            </tem:validarXML>
            </soapenv:Body>
            </soapenv:Envelope>
        """;
        String response = peticion(xmlBody);
        System.out.println("Response: " + response);
    }
}

