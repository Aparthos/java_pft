package pl.stqa.pft.mantis.applicationmanager;

import javax.swing.text.html.parser.Entity;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;

public class HttpSession {

    private CloseableHttpClinet httpclient;
    private ApplicationManager app;


    public HttpSession(ApplicationManager app) {


      this.app = app;

      httpclient = HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategy()).build();


    }


public boolean login (String username, String password) throws IOException {


      HttpPost post = new HttpPost(app.getProperty("web.baseURL") + "/login.php");
      List <NameValuePair> params = new ArrayList<String>();
      params.add(new BasicNameValuePair("username", username));
      params.add(new BasicNameValuePair("password", password));
      params.add(new BasicNameValuePair("secure_session", "on"));
      params.add(new BasicNameValuePair("return", "index.php"));
      post.setEntity(new UrlEncodedFormEntity(params));
      CloseableHttpResponse response = httpclient.execute(post);
      String body = getTextForm(response);
      return body.contains(String.format("<span class=\"italic\">%s</span>", username));

}

private String getTextForm (CloseableHttpResponse response) throws IOException {

      try {

        return EntityUtils.toString(response.getEntity);

      } finally {

        response.close();

      }


}

public boolean isLoggedInAs (String username) throws IOException {

      HttpGet get = new HttpGet(app.getProperty("web.baseUrl") + "/index.php");
      CloseableHttpResponse response = httpclient.execute(get);
      String body = getTextForm(response);
      return body.contains(String.format("<span class=\"italic\">%s</span>"));





}



}
