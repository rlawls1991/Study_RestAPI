package study.events.domain;


import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;


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

    @ParameterizedTest(name = "{index} => basePrice={0}, maxPrice={1}, isFree={2}")
    @CsvSource({
            "0, 0, true",
            "100, 0, falae",
            "0, 1000, falae"
    })
    public void updateFree(int basePrice, int maxPrice, boolean isFree){
        // Given
        Event event = Event.builder()
                .basePrice(basePrice)
                .maxPrice(maxPrice)
                .build();
        //When
        event.update();
        // Then
        assertThat(event.isFree()).isEqualTo(isFree);
    }

    // Junit 5 기준
    @ParameterizedTest(name = "{index} => location={0},  isOffline={1}")
    @MethodSource("updateOfflineParam")
    public void updateOffline(String location, boolean isOffline){
        System.out.println("테스트요 : " + location + " / " + isOffline);
        // Given
        Event event = Event.builder()
                .location(location)
                .build();
        //When
        event.update();
        // Then
        assertThat(event.isOffline()).isEqualTo(isOffline);
    }

    // static 있어야 동작
    private static Object[] updateOfflineParam() {
        return new Object[]{
                new Object[]{null, true},
                new Object[]{"", true},
                new Object[]{"경기도 안양시 만안구", false}
        };
    }
}
