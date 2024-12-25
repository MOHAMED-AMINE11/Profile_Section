package ma.ensa.profile_section.api;

import ma.ensa.profile_section.models.User;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserApiService {
    @GET("api/users/{id}")
    Call<User> getUserById(@Path("id") int id);

    @GET("api/users/email/{email}")
    Call<User> getUserByEmail(@Path("email") String email);

    @PUT("api/users/{id}")
    Call<User> updateUser(@Path("id") int id, @Body User user);
}
