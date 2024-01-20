package com.techwave.server.controllers.ServerSentEventController;

import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor .core.publisher.Flux;
import reactor.core.publisher.Sinks;
@CrossOrigin
@RestController
public class SSEController {

    private final Sinks.Many<ServerSentEvent<String>> sink;

    public SSEController() {
        this.sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    @GetMapping(path = "/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> sse() {
        return sink.asFlux();
    }

    public void sendSSEEvent(String userId, String message) {
        String eventData = "{\"userId\":\"" + userId + "\",\"message\":\"" + message + "\"}";
        sink.tryEmitNext(ServerSentEvent.builder(eventData).build());
    }

}

