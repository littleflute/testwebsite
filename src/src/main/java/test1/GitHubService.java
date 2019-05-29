package test1;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.*;
import com.google.gson.JsonElement;
import okhttp3.ResponseBody;
 
public interface GitHubService {
  @GET("users/{person}/repos")
  Call<ResponseBody> listRepos(@Path("person") String user);
}
 