package parser;

import entity.BankDeposit;
import exception.CustomException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static entity.DepositType.BEFORE_DEMAND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserUnitTest {

    private final static String DEFAULT_FILE_PATH = "bankDeposit.xml";

    @ParameterizedTest
    @MethodSource("parseData")
    public void shouldReturnListWithSixteenSize_whenBuildBankDepositsArray(BankDepositBuilder.TypeOfParser typeOfParser) throws CustomException {
        // given
        final ParserMother parser = BankDepositBuilder.buildParser(typeOfParser);

        List<BankDeposit> expectedListBankDeposit = provideExpectedListBankDeposit();
        // when
        parser.parse(getClass().getClassLoader().getResource(DEFAULT_FILE_PATH).getFile());
        Set<BankDeposit> actualBankDeposits = parser.getBankDeposits();
        // then
        assertEquals(actualBankDeposits.size(), 16);
        actualBankDeposits.forEach(bankDeposit -> {
            assertTrue(expectedListBankDeposit.contains(bankDeposit));
        });
    }

    public static Object[] parseData() {
        return BankDepositBuilder.TypeOfParser.values();
    }

    public List<BankDeposit> provideExpectedListBankDeposit() {
        BankDeposit firstBankDeposit = new BankDeposit("1", "BelInvestBank", "Belarus", "BEFORE_DEMAND", "Raman", "z3s-x8n-6q6-exw-x6p", "100000", "5", "01-01-2021 10:10:10");
        BankDeposit secondBankDeposit = new BankDeposit("2", "BelarusBank", "Belarus", "URGENT", "Antony", "827-upf-ywr-vud-9ac", "111000", "5", "02-01-2021 11:11:11");
        BankDeposit thirdBankDeposit = new BankDeposit("3", "BelAgroPromBank", "Belarus", "CALCULATED", "Ivan", "xiw-abc-h7a-o32-2qw", "123000", "5", "03-01-2021 12:12:12");
        BankDeposit fourBankDeposit = new BankDeposit("4", "BelGazPromBank", "Belarus", "CUMULATIVE", "Vasily", "crj-5ha-c8g-7ze-yhf", "130000", "7", "04-01-2021 13:13:13");
        BankDeposit fiveBankDeposit = new BankDeposit("5", "Alfa-Bank", "Russia", "SAVINGS", "Wladimir", "52t-obc-eyt-mzy-ffm", "140000", "7", "05-01-2021 14:14:14");
        BankDeposit sixBankDeposit = new BankDeposit("6", "Prior-Bank", "Russia", "METAL", "Michael", "fjj-njz-6x6-esf-v7t", "150000", "7", "06-01-2021 15:15:15");
        BankDeposit sevenBankDeposit = new BankDeposit("7", "Sberbank", "Russia", "BEFORE_DEMAND", "Oleg", "g8i-idw-qqb-xik-a7c", "160000", "9.5", "07-01-2021 16:16:16");
        BankDeposit eightBankDeposit = new BankDeposit("8", "VTB Bank", "Russia", "URGENT", "Dimitry", "m4g-ymj-qwu-tqx-ztx", "175000", "9.5", "08-01-2021 17:17:17");
        BankDeposit nineBankDeposit = new BankDeposit("9", "KFW Bankgruppe", "German", "CALCULATED", "Alexander", "zkk-cgg-bfj-iuc-pyh", "183000", "9.5", "09-01-2021 18:18:18");
        BankDeposit tenBankDeposit = new BankDeposit("10", "DZ Bank", "German", "CUMULATIVE", "Bjorn", "vwc-m93-xix-evr-9af", "197000", "11.3", "10-01-2021 19:19:19");
        BankDeposit elevenBankDeposit = new BankDeposit("11", "Landesbank Baden-Württemberg", "German", "SAVINGS", "Lukas", "6uh-rs6-azk-n8y-9q7", "210000", "11.4", "11-01-2021 20:20:20");
        BankDeposit twenteenBankDeposit = new BankDeposit("12", "Norddeutsche Landesbank", "German", "METAL", "Arne", "4ku-6mb-mjg-5bc-2o8", "212000", "11.2", "12-01-2021 21:21:21");
        BankDeposit thirteenBankDeposit = new BankDeposit("13", "HSBC Holdings", "United Kingdom", "BEFORE_DEMAND", "Barbara", "879-itd-9yn-nrz-nq5", "224000", "15.6", "13-01-2021 22:22:22");
        BankDeposit fourteenBankDeposit = new BankDeposit("14", "Close Brothers", "United Kingdom", "URGENT", "Linda", "cdf-kdg-ek6-pbu-45t", "233000", "15.7", "14-01-2021 23:23:23");
        BankDeposit fiveteenBankDeposit = new BankDeposit("15", "Santander UK", "United Kingdom", "CALCULATED", "John", "q6n-j3e-crt-iiw-c27", "245000", "15.9", "15-01-2021 00:00:00");
        BankDeposit sixteenBankDeposit = new BankDeposit("16", "Royal Bank of Scotland", "United Kingdom", "CUMULATIVE", "Steven", "wv7-ftm-zxj-e7m-zp7", "252000", "19.75", "16-01-2021 01:01:01");

        return Arrays.asList(firstBankDeposit, secondBankDeposit, thirdBankDeposit, fourBankDeposit, fiveBankDeposit, sixBankDeposit, sevenBankDeposit, eightBankDeposit, nineBankDeposit, tenBankDeposit, elevenBankDeposit, twenteenBankDeposit, thirteenBankDeposit, fourteenBankDeposit, fiveteenBankDeposit, sixteenBankDeposit);
    }
}
