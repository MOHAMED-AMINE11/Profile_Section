package ma.ensa.profile_section.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import ma.ensa.profile_section.models.User;
import ma.ensa.profile_section.repository.UserRepository;
import ma.ensa.profile_section.repository.RepositoryCallback;

public class UserViewModel extends ViewModel {
    private final UserRepository repository;

    public UserViewModel() {
        repository = UserRepository.getInstance();
    }

    public LiveData<User> getUser() {
        return repository.getUserLiveData();
    }

    public LiveData<String> getError() {
        return repository.getErrorLiveData();
    }

    public void loadUserByEmail(String email) {
        repository.getUserByEmail(email, new RepositoryCallback<User>() {
            @Override
            public void onSuccess(User user) {}

            @Override
            public void onError(String error) {}
        });
    }

    public void updateUser(int id, User user) {
        repository.updateUser(id, user, new RepositoryCallback<User>() {
            @Override
            public void onSuccess(User updatedUser) {}

            @Override
            public void onError(String error) {}
        });
    }
}