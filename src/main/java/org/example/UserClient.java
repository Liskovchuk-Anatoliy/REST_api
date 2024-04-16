package org.example;

public class ClietApi {
    private static final String API_URL = "http://94.198.50.185:7081/api/users";
    private static String sessionId;

    public static void main(String[] args) throws Exception {
        HttpClient httpClient = HttpClients.createDefault();

        // Step 1: Получить список всех пользователей
        HttpGet httpGet = new HttpGet(API_URL);
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String responseBody = EntityUtils.toString(entity);

        // Получаем session id из куки
        sessionId = response.getFirstHeader("Set-Cookie").getValue();
}
