import domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LottoRankTest {

    @Test
    void 당첨번호_일치_개수_테스트(){
        final List<Integer> LottoNumber= Arrays.asList(1,2,3,4,5,6);
        final Lotto lotto= new Lotto(LottoNumber);
        final String WinNumber = "1,3,5,7,9,11";
        final LottoWin lottoWinning = new LottoWin(Collections.singletonList(lotto), WinNumber);
        List<Integer> expected=Arrays.asList(3);

        List<Integer> actual=lottoWinning.getWinCount();

        assertEquals(expected,actual);
    }

    @Test
    void 당첨등수_확인_테스트(){
        final List<Integer> LottoNumber= Arrays.asList(1,3,5,7,9,11);
        final Lotto lotto= new Lotto(LottoNumber);
        final String WinNumber = "1,3,5,7,9,11";

        LottoWin lottoWinning = new LottoWin(Collections.singletonList(lotto), WinNumber);
        LottoResult lottoResult = new LottoResult(lottoWinning.getWinCount(),1000);
        int[] expectedRankCounts={1,0,0,0};

        int[] actualRankCounts= lottoResult.getRankCounts();
        assertArrayEquals(expectedRankCounts,actualRankCounts);
    }

    @Test
    void 당첨금액_확인_테스트(){
        final List<Integer> LottoNumber= Arrays.asList(1,3,5,7,9,11);
        final Lotto lotto= new Lotto(LottoNumber);
        final String WinNumber = "1,3,5,7,9,11";

        LottoWin lottoWinning = new LottoWin(Collections.singletonList(lotto), WinNumber);
        LottoResult lottoResult = new LottoResult(lottoWinning.getWinCount(),1000);
        int expected=2000000000;

        int actual=lottoResult.getTotalPrize();
        assertEquals(expected, actual);
    }

    @Test
    void 수익률_테스트(){
        final List<Integer> LottoNumber= Arrays.asList(1,2,3,4,5,6);
        final Lotto lotto= new Lotto(LottoNumber);
        final String WinNumber = "1,3,5,7,9,11";

        LottoWin lottoWinning = new LottoWin(Collections.singletonList(lotto), WinNumber);
        LottoResult lottoResult = new LottoResult(lottoWinning.getWinCount(),1000);
        double expected=5;

        double actual=lottoResult.getProfitRate();
        assertEquals(expected,actual);
    }
}
