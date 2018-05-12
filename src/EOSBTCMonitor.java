import org.json.JSONException;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import java.math.BigDecimal;

@ClientEndpoint
public class EOSBTCMonitor extends AbstractMonitor {
    @OnMessage
    public void onMessage(String message) throws JSONException {
        doMessage(message);
        Storage.EOSBTCSS = true;
//        System.out.println("EOSBTC bid: " +  Storage.EOSBTCbid + " " + Storage.EOSBTCbidVol+" ask: " + Storage.EOSBTCask + " " + Storage.EOSBTCaskVol);
        if (Storage.ETHBTCSS && Storage.EOSBTCSS && Storage.EOSETHSS) {
            DetectArbitrage.doDetectArbitrage("EOS");
        }

    }

    @Override
    protected void setBid(BigDecimal bidPrice, BigDecimal bidVol, long time) {
        Storage.EOSBTCbid = bidPrice;
        Storage.EOSBTCbidVol = bidVol;
        Storage.EOSBTCTime = time;
    }

    @Override
    protected void setAsk(BigDecimal askPrice, BigDecimal askVol) {
        Storage.EOSBTCask = askPrice;
        Storage.EOSBTCaskVol = askVol;
    }

    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
        Storage.EOSBTCSS = false;
        Main.messageLatch.countDown();
    }
}
