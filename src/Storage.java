import java.math.BigDecimal;

public class Storage {

    static volatile boolean ETHBTCSS = false;
    static volatile boolean EOSBTCSS = false;
    static volatile boolean EOSETHSS = false;
    static volatile boolean BNBBTCSS = false;
    static volatile boolean BNBETHSS = false;

    //ETH/BTC
    static volatile long ETHBTCTime = 0;
    static volatile BigDecimal ETHBTCbid = BigDecimal.ZERO;
    static volatile BigDecimal ETHBTCbidVol = BigDecimal.ZERO;

    static volatile BigDecimal ETHBTCask = BigDecimal.ZERO;
    static volatile BigDecimal ETHBTCaskVol = BigDecimal.ZERO;

    //EOS/BTC
    static volatile long EOSBTCTime = 0;
    static volatile BigDecimal EOSBTCbid = BigDecimal.ZERO;
    static volatile BigDecimal EOSBTCbidVol = BigDecimal.ZERO;

    static volatile BigDecimal EOSBTCask = BigDecimal.ZERO;
    static volatile BigDecimal EOSBTCaskVol = BigDecimal.ZERO;

    //EOS/ETH
    static volatile long EOSETHTime = 0;
    static volatile BigDecimal EOSETHbid = BigDecimal.ZERO;
    static volatile BigDecimal EOSETHbidVol = BigDecimal.ZERO;

    static volatile BigDecimal EOSETHask = BigDecimal.ZERO;
    static volatile BigDecimal EOSETHaskVol = BigDecimal.ZERO;

    //BNB/BTC
    static volatile long BNBBTCTime = 0;
    static volatile BigDecimal BNBBTCbid = BigDecimal.ZERO;
    static volatile BigDecimal BNBBTCbidVol = BigDecimal.ZERO;

    static volatile BigDecimal BNBBTCask = BigDecimal.ZERO;
    static volatile BigDecimal BNBBTCaskVol = BigDecimal.ZERO;

    //BNB/ETH
    static volatile long BNBETHTime = 0;
    static volatile BigDecimal BNBETHbid = BigDecimal.ZERO;
    static volatile BigDecimal BNBETHbidVol = BigDecimal.ZERO;

    static volatile BigDecimal BNBETHask = BigDecimal.ZERO;
    static volatile BigDecimal BNBETHaskVol = BigDecimal.ZERO;


}
