package chuidiang;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
public class Consume {	
	
	private static HttpURLConnection connection;
	
		public static void main(String[] args) {
		
			try {
				URL url = new URL("https://apiecommerce.pagosinteligentes.com:8070/CheckOut/MethodGenerateTransaction");
				connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("POST");
				connection.setRequestProperty("Content-Type", "application/json; utf-8");
				connection.setRequestProperty("Accept", "application/json");
				connection.setDoOutput(true);
				String jsonInputString ="{\"generateTransaction\":{"
						+ "\"security\":{"
							+ "\"accountId\": 30336,"
							+ " \"token\": \"bflMObSMSnyvysHpC72*\"},"
							
						+ "\"infoPayment\":{"
							+ "\"amount\": 10000,"
							+ " \"tax\":10,"
							+ " \"description\":\"Prueba Java\","
							+ " \"toolId\": 5,"
							+ " \"registryToolId\": 0,"
							+ " \"currency\": \"COP\"},"
							
						+ "\"infoClient\":{"
							+ "\"name\":\"Pagos Inteligentes\","
							+ " \"idType\":\"CC\","
							+ " \"idNumber\":\"123456789\","
							+ " \"email\":\"comprobantes@pagosinteligentes.com\","
							+ " \"phone\":\"573213285290\"},"
							
						+ " \"infoAdditional\":{"
							+ "\"disabledPaymentMethod\": \"20,21,24\","
							+ " \"infoAdditional\": 0, "
							+ "\"urlResponseOk\": \"https://sag.pagosinteligentes.com:8140/\","
							+ " \"urlResponseFail\": \"https://sag.pagosinteligentes.com:8140/\","
							+ " \"urlResponsePending\": \"https://sag.pagosinteligentes.com:8140/\","
							+ " \"urlNotificationPost\":\" https://sag.pagosinteligentes.com:8140/\", "
							+ "\"photo\": \"https://dl.dropboxusercontent.com/s/jghrtm678do5fts/carrito.jpg?dl=0\","
							+ " \"cashDiscount\": 100,"
							+ " \"expiredCashDiscount\": \"2021/12/31\","
							+ " \"deliveryAddres\": true,"
							+ " \"ammountShipping\": 0 }"
					+ " }}";
				
				System.out.println(jsonInputString);
				try(OutputStream os = connection.getOutputStream()) {
				    byte[] input = jsonInputString.getBytes("utf-8");
				    os.write(input, 0, input.length);			
				}
				try(BufferedReader br = new BufferedReader(
						  new InputStreamReader(connection.getInputStream(), "utf-8"))) {
						    StringBuilder response = new StringBuilder();
						    String responseLine = null;
						    while ((responseLine = br.readLine()) != null) {
						        response.append(responseLine.trim());
						    }
						    System.out.println(response.toString());
						}
			
			}catch (MalformedURLException e){
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			
		}

	}


