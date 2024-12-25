package ma.ensa.profile_section.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import ma.ensa.profile_section.R;
import ma.ensa.profile_section.databinding.FragmentUserProfileBinding;
import ma.ensa.profile_section.models.User;
import ma.ensa.profile_section.repository.RepositoryCallback;
import ma.ensa.profile_section.repository.UserRepository;

public class UserProfileFragment extends Fragment {

    private FragmentUserProfileBinding binding;
    private UserRepository userRepository;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userRepository = UserRepository.getInstance();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUserProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String userEmail = "mohamedamine@example.com";

        loadUserData(userEmail);
        setupClickListeners();
    }

    private void loadUserData(String email) {
        if (email != null && !email.isEmpty()) {
            userRepository.getUserByEmail(email, new RepositoryCallback<User>() {
                @Override
                public void onSuccess(User user) {
                    updateUI(user);
                }

                @Override
                public void onError(String error) {
                    showError(error);
                }
            });
        } else {
            showError("Email is missing.");
        }
    }

    private void setupClickListeners() {
        binding.editProfileButton.setOnClickListener(v -> {
            // Naviguer vers le fragment EditProfileFragment
            Navigation.findNavController(v).navigate(R.id.action_userProfileFragment_to_editProfileFragment);
        });
    }

    private void updateUI(User user) {
        if (user != null) {
            binding.userName.setText(user.getNom());
            binding.userEmail.setText(user.getEmail());
            binding.userPhone.setText(user.getNumero());
        }
    }

    private void showError(String error) {
        if (error != null && !error.isEmpty()) {
            Toast.makeText(requireContext(), error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
