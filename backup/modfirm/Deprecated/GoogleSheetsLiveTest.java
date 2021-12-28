package installer;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.google.api.services.sheets.v4.Sheets;

public class GoogleSheetsLiveTest {
    private static Sheets sheetsService;
    private static String SPREADSHEET_ID = "1e7FJRyB1rG7yctlLHcqf3nP0-CN4aaMbN2x2oIjvZSM";

    public static void setup() throws GeneralSecurityException, IOException {
        sheetsService = SheetsServiceUtil.getSheetsService();
    }
}
