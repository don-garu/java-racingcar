package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.Car;
import step4.Engine;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("Car 의 default position 테스트")
    @Test
    void carPositionWhenNotCallMove() {
        Car car = Car.of(new Engine(() -> 0), "test");
        assertThat(car.getPosition())
                .isEqualTo(0);
    }

    @DisplayName("Engine 이 항상 OK 일 때, move() 동작 테스트")
    @Test
    void carPositionWhenEngineIsAlwaysOk() {
        Car car = Car.of(new Engine(() -> 5), "test");
        for (int i = 0; i < 3; i++) {
            car.move();
        }
        assertThat(car.getPosition())
                .isEqualTo(3);
    }

    @DisplayName("Engine 이 항상 Not OK 일 때, move() 동작 테스트")
    @Test
    void carPositionWhenEngineIsNeveOk() {
        Car car = Car.of(new Engine(() -> 0), "test");
        for (int i = 0; i < 3; i++) {
            car.move();
        }
        assertThat(car.getPosition())
                .isEqualTo(0);
    }
}
