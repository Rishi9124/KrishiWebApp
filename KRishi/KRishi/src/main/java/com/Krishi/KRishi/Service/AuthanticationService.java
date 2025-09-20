package com.Krishi.KRishi.Service;

import com.Krishi.KRishi.Dto.LoginRequestDto;
import com.Krishi.KRishi.Dto.LoginResponseDto;
import com.Krishi.KRishi.Model.User;
import com.Krishi.KRishi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthanticationService {
   @Autowired
    private UserRepository userRepository ;
    public LoginResponseDto login(LoginRequestDto request){
        User user = userRepository.findByPhoneNumber(request.getPhoneNumber())
                .orElseThrow(() -> new RuntimeException("User not found with this mobile number"));

        if(!user.isIsvarified()){
            throw new RuntimeException("Session Already In Progess.");
        }
        return  new LoginResponseDto("Login Succesfull.");


    }

    public void logout(LoginRequestDto request){
        User user = userRepository.findByPhoneNumber(request.getPhoneNumber())
                .orElseThrow(()-> new RuntimeException("User not found with this mobile number."));

        user.setIsvarified(false);

        userRepository.save(user);
    }
}
