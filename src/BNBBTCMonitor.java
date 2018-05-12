import org.json.JSONException;

import javax.websocket.*;
import java.math.BigDecimal;

@ClientEndpoint
public class BNBBTCMonitor extends AbstractMonitor {
    @OnMessage
    public void onMessage(String message) throws JSONException {
        doMessage(message);
        Storage.BNBBTCSS = true;
//        System.out.println("BNBBTC bid: " +  Storage.BNBBTCbid + " " + Storage.BNBBTCbidVol+" ask: " + Storage.BNBBTCask + " " + Storage.BNBBTCaskVol);
        if (Storage.ETHBTCSS && Storage.BNBBTCSS && Storage.BNBETHSS) {
            DetectArbitrage.doDetectArbitrage("BNB");
        }
    }

    @Override
    protected void setBid(BigDecimal bidPrice, BigDecimal bidVol, long time) {
        Storage.BNBBTCbid = bidPrice;
        Storage.BNBBTCbidVol = bidVol;
        Storage.BNBBTCTime = time;
    }

    @Override
    protected void setAsk(BigDecimal askPrice, BigDecimal askVol) {
        Storage.BNBBTCask = askPrice;
        Storage.BNBBTCaskVol = askVol;
    }

    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
        Storage.BNBBTCSS = false;
        Main.messageLatch.countDown();
    }
}