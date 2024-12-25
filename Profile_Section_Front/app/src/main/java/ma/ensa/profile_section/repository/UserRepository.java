package ma.ensa.profile_section.repository;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import ma.ensa.profile_section.api.RetrofitClient;
import ma.ensa.profile_section.api.UserApiService;
import ma.ensa.profile_section.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private static UserRepository instance;
    private final UserApiService userApiService;
    private final MutableLiveData<User> userLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    private UserRepository() {
        userApiService = RetrofitClient.getInstance().getUserApiService();
    }

    public static synchronized UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public MutableLiveData<User> getUserLiveData() {
        return userLiveData;
    }

    public MutableLiveData<String> getErrorLiveData() {
        return errorLiveData;
    }

    public void getUserByEmail(String email, RepositoryCallback<User> callback) {
        userApiService.getUserByEmail(email).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Error fetching user data");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
                Log.e("UserRepository", "Error fetching user", t);
            }
        });
    }

    public void updateUser(int id, User user, RepositoryCallback<User> callback) {
        userApiService.updateUser(id, user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Error updating user data");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
                Log.e("UserRepository", "Error updating user", t);
            }
        });
    }
}
