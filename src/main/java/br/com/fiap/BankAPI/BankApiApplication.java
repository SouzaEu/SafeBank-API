package br.com.fiap.BankAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class BankApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(BankApiApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void onStartup() {
		System.out.println("🔥 Bank API iniciada com sucesso!");
	}
}
