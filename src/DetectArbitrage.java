public class DetectArbitrage {

    static public void doDetectArbitrage(String tokenName) {
        switch (tokenName) {
            case "EOS":
                Utils.doRoute(tokenName,
                        Storage.EOSBTCbid, Storage.EOSBTCbidVol, Storage.EOSBTCask, Storage.EOSBTCaskVol,
                        Storage.EOSETHbid, Storage.EOSETHbidVol, Storage.EOSETHask, Storage.EOSETHaskVol);
                break;
            case "BNB":
                Utils.doRoute(tokenName,
                        Storage.BNBBTCbid, Storage.BNBBTCbidVol, Storage.BNBBTCask, Storage.BNBBTCaskVol,
                        Storage.BNBETHbid, Storage.BNBETHbidVol, Storage.BNBETHask, Storage.BNBETHaskVol);
                break;
        }

    }

}
