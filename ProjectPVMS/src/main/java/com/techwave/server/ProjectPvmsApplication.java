package com.techwave.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.techwave.server.models.bao.AuthenticationBao.AuthenticationBao;
import com.techwave.server.models.bao.PassportBao.PassportBao;
import com.techwave.server.models.bao.RegistrationBao.RegistrationUserBao;
import com.techwave.server.models.bao.StatesCitiesBao.StatesCitiesBao;
import com.techwave.server.models.bao.VisaBao.VisaBao;

@SpringBootApplication
public class ProjectPvmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectPvmsApplication.class, args);
	}
	
	@Bean
	public RegistrationUserBao registrationUserBao() {
		return new RegistrationUserBao();
	}
	
	@Bean
	public PassportBao passportBao() {
		return new PassportBao();
	}
	
	@Bean
	public VisaBao visaBao() {
		return new VisaBao();
	}
	
	@Bean
	public StatesCitiesBao statesCitiesBao() {
		return new StatesCitiesBao();
	}
	
	@Bean
	public AuthenticationBao authenticationBao() {
		
		return new AuthenticationBao();
	}
}
