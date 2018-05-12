import org.json.JSONException;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import java.math.BigDecimal;

@ClientEndpoint
public class EOSETHMonitor extends AbstractMonitor {

    @OnMessage
    public void onMessage(String message) throws JSONException {
        doMessage(message);
        Storage.EOSETHSS = true;
//        System.out.println("EOSETH bid: " +  Storage.EOSETHbid + " " + Storage.EOSETHbidVol+" ask: " + Storage.EOSETHask + " " + Storage.EOSETHaskVol);
        if (Storage.ETHBTCSS && Storage.EOSBTCSS && Storage.EOSETHSS) {
            DetectArbitrage.doDetectArbitrage("EOS");
        }
    }

    @Override
    protected void setBid(BigDecimal bidPrice, BigDecimal bidVol, long time) {
        Storage.EOSETHbid = bidPrice;
        Storage.EOSETHbidVol = bidVol;
        Storage.EOSETHTime = time;
    }

    @Override
    protected void setAsk(BigDecimal askPrice, BigDecimal askVol) {
        Storage.EOSETHask = askPrice;
        Storage.EOSETHaskVol = askVol;
    }

    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
        Storage.EOSETHSS = false;
        Main.messageLatch.countDown();
    }
}
