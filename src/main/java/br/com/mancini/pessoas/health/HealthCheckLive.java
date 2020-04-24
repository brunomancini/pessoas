package br.com.mancini.pessoas.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness
public class HealthCheckLive implements HealthCheck {

	@Override
	public HealthCheckResponse call() {
        return HealthCheckResponse.named("meetup").up().build();
	}

}