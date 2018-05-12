import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;

public abstract class AbstractMonitor {

    //only watches this pair and updates relevant values to this pair
    public void doMessage(String message) throws JSONException {
        JSONObject jso = new JSONObject(message);
        if (null == jso) return;
        long timeStamp = (Long) jso.get("E");

        BigDecimal bidPrice = new BigDecimal(jso.get("b").toString());
        BigDecimal bidVol = new BigDecimal(jso.get("B").toString());
        setBid(bidPrice, bidVol, timeStamp);

        BigDecimal askPrice = new BigDecimal(jso.get("a").toString());
        BigDecimal askVol = new BigDecimal(jso.get("A").toString());
        setAsk(askPrice, askVol);
    }

    protected abstract void setBid(BigDecimal bidPrice, BigDecimal bidVol, long time);

    protected abstract void setAsk(BigDecimal askPrice, BigDecimal askVol);
}
