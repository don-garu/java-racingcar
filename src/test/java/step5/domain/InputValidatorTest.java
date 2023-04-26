package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.InputValidator;

import static org.assertj.core.api.Assertions.assertThat;

class InputValidatorTest {

    @DisplayName("정상적인 차 이름 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobby", "pobby,ruppy", "pobby,ruppy,teddy,bear1"})
    void inputValidatorReturnsFalseWhenNamesAreValid(String validNames) {
        assertThat(InputValidator.isInvalidNames(validNames))
                .isFalse();
    }

    @DisplayName("허용되지 않는 이름 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"test123", ",", "  ", "", ",name"})
    void inputValidatorReturnsTrueWhenNamesAreInvalid(String invalidNames) {
        assertThat(InputValidator.isInvalidNames(invalidNames))
                .isTrue();
    }
}