import java.net.URI;
import java.util.concurrent.CountDownLatch;

public class Main {

    private static final String URIbnbbtc = "wss://stream.binance.com:9443/ws/bnbbtc@ticker";
    private static final String URIbnbeth = "wss://stream.binance.com:9443/ws/bnbeth@ticker";
    private static final String URIethbtc = "wss://stream.binance.com:9443/ws/ethbtc@ticker";
    private static final String URIeosbtc = "wss://stream.binance.com:9443/ws/eosbtc@ticker";
    private static final String URIeoseth = "wss://stream.binance.com:9443/ws/eoseth@ticker";

    static CountDownLatch messageLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        try {
            Thread t_btceth = new Thread(new SpawnMonitor(ETHBTCMonitor.class, URI.create(URIethbtc)));
            Thread t_eosbtc = new Thread(new SpawnMonitor(EOSBTCMonitor.class, URI.create(URIeosbtc)));
            Thread t_eoseth = new Thread(new SpawnMonitor(EOSETHMonitor.class, URI.create(URIeoseth)));
            Thread t_bnbbtc = new Thread(new SpawnMonitor(BNBBTCMonitor.class, URI.create(URIbnbbtc)));
            Thread t_bnbeth = new Thread(new SpawnMonitor(BNBETHMonitor.class, URI.create(URIbnbeth)));


            t_btceth.start();
            t_eosbtc.start();
            t_eoseth.start();
            t_bnbbtc.start();
            t_bnbeth.start();
            messageLatch.await();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}