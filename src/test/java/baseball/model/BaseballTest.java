package baseball.model;

import model.BaseBall;
import org.junit.jupiter.api.Test;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BaseballTest {
    @Test
    void 숫자3개랜덤생성() {

        BaseBall mockBaseBall = mock(BaseBall.class);

        mockBaseBall.MakeRandomThreeDigits(1, 9);

        //  3자리 숫자인지 확인
        assertEquals(mockBaseBall.getQueue().size(), 3);

    }
}
