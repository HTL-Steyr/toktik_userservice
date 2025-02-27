package htl.steyr.toktik_userservice.service;

import htl.steyr.toktik_userservice.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    @NonNull
    private final UserRepository userRepository;
}
