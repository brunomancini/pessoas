package br.com.mancini.pessoas.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
public class HealthCheckReady implements HealthCheck {

	@Override
	public HealthCheckResponse call() {
		return HealthCheckResponse.named("teste").down().build();
	}

}