import org.json.JSONException;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import java.math.BigDecimal;

@ClientEndpoint
public class ETHBTCMonitor extends AbstractMonitor {
    @OnMessage
    public void onMessage(String message) throws JSONException {
        doMessage(message);
        Storage.ETHBTCSS = true;
//        System.out.println("ETHBTC bid: " +  Storage.ETHBTCbid + " " + Storage.ETHBTCbidVol+" ask: " + Storage.ETHBTCask + " " + Storage.ETHBTCaskVol);
        if (Storage.ETHBTCSS && Storage.BNBBTCSS && Storage.BNBETHSS) {
            DetectArbitrage.doDetectArbitrage("BNB");
        }
        if (Storage.ETHBTCSS && Storage.EOSBTCSS && Storage.EOSETHSS) {
            DetectArbitrage.doDetectArbitrage("EOS");
        }
    }

    @Override
    protected void setBid(BigDecimal bidPrice, BigDecimal bidVol, long time) {
        Storage.ETHBTCbid = bidPrice;
        Storage.ETHBTCbidVol = bidVol;
        Storage.ETHBTCTime = time;
    }

    @Override
    protected void setAsk(BigDecimal askPrice, BigDecimal askVol) {
        Storage.ETHBTCask = askPrice;
        Storage.ETHBTCaskVol = askVol;
    }

    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
        Storage.ETHBTCSS = false;
        Main.messageLatch.countDown();
    }

}
