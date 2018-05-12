import org.json.JSONException;

import javax.websocket.*;
import java.math.BigDecimal;

@ClientEndpoint
public class BNBETHMonitor extends AbstractMonitor {
    @OnMessage
    public void onMessage(String message) throws JSONException {
        doMessage(message);
        Storage.BNBETHSS = true;
//        System.out.println("BNBETH bid: " +  Storage.BNBETHbid + " " + Storage.BNBETHbidVol+" ask: " + Storage.BNBETHask + " " + Storage.BNBETHaskVol);
        if (Storage.ETHBTCSS && Storage.BNBBTCSS && Storage.BNBETHSS) {
            DetectArbitrage.doDetectArbitrage("BNB");
        }
    }

    @Override
    protected void setBid(BigDecimal bidPrice, BigDecimal bidVol, long time) {
        Storage.BNBETHbid = bidPrice;
        Storage.BNBETHbidVol = bidVol;
        Storage.BNBETHTime = time;
    }

    @Override
    protected void setAsk(BigDecimal askPrice, BigDecimal askVol) {
        Storage.BNBETHask = askPrice;
        Storage.BNBETHaskVol = askVol;
    }

    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
        Storage.BNBETHSS = false;
        Main.messageLatch.countDown();
    }
}
