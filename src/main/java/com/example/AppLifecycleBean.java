package com.example;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class AppLifecycleBean {

	@Inject
	Logger log;

	void onStart(@Observes StartupEvent ev) {
		log.debug("The application is starting...");
	}

	void onStop(@Observes ShutdownEvent ev) {
		log.debug("The application is stopping...");
	}

}
