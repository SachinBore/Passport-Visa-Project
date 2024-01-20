package com.techwave.server.models.dao.ServiceImpl;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.techwave.server.controllers.ServerSentEventController.SSEController;
import com.techwave.server.models.dao.IServices.IAuthentication;
import com.techwave.server.models.pojo.AuthenticationService;
import com.techwave.server.models.pojo.Login;
import com.techwave.server.models.repositories.AuthenticationRepo.AuthenticationRepositoty;
import com.techwave.server.models.repositories.LoginRepo.LoginRepository;

import jakarta.annotation.PostConstruct;

@Service
public class AuthenticationImpl implements IAuthentication {
	@Autowired
	AuthenticationRepositoty authenticationRepository;
	@Autowired
	LoginRepository loginRepository;
	@Autowired
	SSEController sseController;

	@Override
	public AuthenticationService findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean verifyCredentials(String username, String password) {
		Login user = loginRepository.findById(username).orElse(null);

		if (user != null && user.getPassword().equals(password)) {
			return true;
		}

		return false;
	}

	public String login(String username, String password) {

		if (verifyCredentials(username, password)) {
			if (authenticationRepository.existsById(username)) {
				return "Session exists. Please logout from the existing session.";
			} else {
				// Create a new UserSession entity and save it to the database
				AuthenticationService session = new AuthenticationService(username, LocalDateTime.now());
				authenticationRepository.save(session);
				return "Login successful.";
			}
		} else {
			return "Invalid credentials.";
		}
	}

	public String logout(String username) {
		if (authenticationRepository.existsById(username)) {
			authenticationRepository.deleteById(username);
			return "Logout successful.";
		} else {
			return "Session not found.";
		}
	}

	// just take out the sessions which has greater than 5mins
	@Scheduled(fixedRate = 60000) // Runs every minute
	private void checkAndLogoutInactiveSessions() {
		LocalDateTime fiveMinutesAgo = LocalDateTime.now().minusMinutes(10);

		// Get all sessions older than 5 minutes
		Iterable<AuthenticationService> sessions = authenticationRepository.findAllByTimestampBefore(fiveMinutesAgo);

		// Logout users with expired sessions
		for (AuthenticationService session : sessions) {
			String userId = session.getUsername(); // Replace with the actual method to get the user's ID

			// Send an SSE event with the userId and message
			sseController.sendSSEEvent(userId, "Session Expired");
			// sseController.sendSSEEvent("Session Expired");
			authenticationRepository.delete(session);
		}
	}

	// Schedule the session check task to run at application startup
	@PostConstruct
	public void scheduleSessionCheck() {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(this::checkAndLogoutInactiveSessions, 0, 1, TimeUnit.MINUTES);
	}

	@Override
	public String adminLogin(String adminId, String password) {
		if (verifyCredentials(adminId, password)) {
			return "Login successful";
		}else {
			return "Invalid credentials.";
		}
	}
}
