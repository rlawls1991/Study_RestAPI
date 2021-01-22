package study.domain;


import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


public class EventTest {


    @Test
    public void builder() {
        Event event = Event.builder()
                .name("jinSeok Spring REST API")
                .description("REST API development with Spring")
                .build();
        assertThat(event).isNotNull();
    }

    @Test
    public void javaBean() {
        // Given
        String name = "Event";
        String description = "Spring";

        // when
        Event event = new Event();
        event.setName(name);
        event.setDescription(description);

        // Then
        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescription()).isEqualTo(description);
    }

    @Test
    public void updateFree() {
        // Given
        Event event = Event.builder()
                .basePrice(0)
                .maxPrice(0)
                .build();

        // When
        event.update();

        // Then
        assertThat(event.isFree()).isTrue();
    }

    @Test
    public void updateOffline() {
        Event event = Event.builder()
                .id(100)
                .basePrice(0)
                .maxPrice(0)
                .limitOfEnrollment(200)
                .build();
        event.update();
        assertThat(event.isOffline()).isTrue();
    }
}
