package model;

public class MonopolyBoardSpaces {
    private static final int NR_OF_BOARDSPACES = 40;

    public static final int SPACENR_START = 0;
    public static final int SPACENR_DORPSSTRAAT = 1;
    public static final int SPACENR_ALGEMEEN_FONDS_1 = 2;
    public static final int SPACENR_BRINK = 3;
    public static final int SPACENR_INKOMSTENBELASTING = 4;
    public static final int SPACENR_STATION_ZUID = 5;
    public static final int SPACENR_STEENSTRAAT = 6;
    public static final int SPACENR_KANS_1 = 7;
    public static final int SPACENR_KETELSTRAAT = 8;
    public static final int SPACENR_VELPERPLEIN = 9;
    public static final int SPACENR_GEVANGENIS = 10;
    public static final int SPACENR_BARTELJORISSTRAAT = 11;
    public static final int SPACENR_ELEKTRICITEITSBEDRIJF = 12;
    public static final int SPACENR_ZIJLWEG = 13;
    public static final int SPACENR_GROTE_HOUTSTRAAT = 14;
    public static final int SPACENR_STATION_WEST = 15;
    public static final int SPACENR_NEUDE = 16;
    public static final int SPACENR_ALGEMEEN_FONDS_2 = 17;
    public static final int SPACENR_BILTSTRAAT = 18;
    public static final int SPACENR_VREEBURG = 19;
    public static final int SPACENR_VRIJ_PARKEREN = 20;
    public static final int SPACENR_A_KERKHOF = 21;
    public static final int SPACENR_KANS_2 = 22;
    public static final int SPACENR_GROTE_MARKT = 23;
    public static final int SPACENR_HEERESTRAAT = 24;
    public static final int SPACENR_STATION_NOORD = 25;
    public static final int SPACENR_SPUI = 26;
    public static final int SPACENR_PLEIN = 27;
    public static final int SPACENR_WATERLEIDING = 28;
    public static final int SPACENR_LANGE_POTEN = 29;
    public static final int SPACENR_GA_NAAR_DE_GEVANGENIS = 30;
    public static final int SPACENR_HOFPLEIN = 31;
    public static final int SPACENR_BLAAK = 32;
    public static final int SPACENR_ALGEMEEN_FONDS_3 = 33;
    public static final int SPACENR_COOLSINGEL = 34;
    public static final int SPACENR_STATION_OOST = 35;
    public static final int SPACENR_KANS_3 = 36;
    public static final int SPACENR_LEIDSE_PLEIN = 37;
    public static final int SPACENR_LUXE_BELASTING = 38;
    public static final int SPACENR_KALVERSTRAAT = 39;

    public static final String MESSAGE_RESOURCE_START = "monopolyBoardSpaces.start";
    public static final String MESSAGE_RESOURCE_DORPSSTRAAT = "monopolyBoardSpaces.dorpstraat";
    public static final String MESSAGE_RESOURCE_BRINK = "monopolyBoardSpaces.brink";
    public static final String MESSAGE_RESOURCE_INKOMSTENBELASTING = "monopolyBoardSpaces.inkomensBelasting";
    public static final String MESSAGE_RESOURCE_STATION_ZUID = "monopolyBoardSpaces.stationZuid";
    public static final String MESSAGE_RESOURCE_STEENSTRAAT = "monopolyBoardSpaces.steenstraat";
    public static final String MESSAGE_RESOURCE_KETELSTRAAT = "monopolyBoardSpaces.ketelstraat";
    public static final String MESSAGE_RESOURCE_VELPERPLEIN = "monopolyBoardSpaces.velperplein";
    public static final String MESSAGE_RESOURCE_GEVANGENIS = "monopolyBoardSpaces.gevangenis";
    public static final String MESSAGE_RESOURCE_BARTELJORISSTRAAT = "monopolyBoardSpaces.barteljorisstraat";
    public static final String MESSAGE_RESOURCE_ELEKTRICITEITSBEDRIJF = "monopolyBoardSpaces.elektriciteitsbedrijf";
    public static final String MESSAGE_RESOURCE_ZIJLWEG = "monopolyBoardSpaces.zijlweg";
    public static final String MESSAGE_RESOURCE_GROTE_HOUTSTRAAT = "monopolyBoardSpaces.groteHoutStraat";
    public static final String MESSAGE_RESOURCE_STATION_WEST = "monopolyBoardSpaces.stationWest";
    public static final String MESSAGE_RESOURCE_NEUDE = "monopolyBoardSpaces.neude";
    public static final String MESSAGE_RESOURCE_BILTSTRAAT = "monopolyBoardSpaces.biltstraat";
    public static final String MESSAGE_RESOURCE_VREEBURG = "monopolyBoardSpaces.vreeburg";
    public static final String MESSAGE_RESOURCE_VRIJ_PARKEREN = "monopolyBoardSpaces.vrijParkeren";
    public static final String MESSAGE_RESOURCE_A_KERKHOF = "monopolyBoardSpaces.aKerkhof";
    public static final String MESSAGE_RESOURCE_GROTE_MARKT = "monopolyBoardSpaces.groteMarkt";
    public static final String MESSAGE_RESOURCE_HEERESTRAAT = "monopolyBoardSpaces.heerestraat";
    public static final String MESSAGE_RESOURCE_STATION_NOORD = "monopolyBoardSpaces.stationNoord";
    public static final String MESSAGE_RESOURCE_SPUI = "monopolyBoardSpaces.spui";
    public static final String MESSAGE_RESOURCE_PLEIN = "monopolyBoardSpaces.plein";
    public static final String MESSAGE_RESOURCE_WATERLEIDING = "monopolyBoardSpaces.waterleiding";
    public static final String MESSAGE_RESOURCE_LANGE_POTEN = "monopolyBoardSpaces.langePoten";
    public static final String MESSAGE_RESOURCE_GA_NAAR_DE_GEVANGENIS = "monopolyBoardSpaces.gaNaarDeGevangenis";
    public static final String MESSAGE_RESOURCE_HOFPLEIN = "monopolyBoardSpaces.hofplein";
    public static final String MESSAGE_RESOURCE_BLAAK = "monopolyBoardSpaces.blaak";
    public static final String MESSAGE_RESOURCE_COOLSINGEL = "monopolyBoardSpaces.coolsingel";
    public static final String MESSAGE_RESOURCE_STATION_OOST = "monopolyBoardSpaces.stationOost";
    public static final String MESSAGE_RESOURCE_LEIDSE_PLEIN = "monopolyBoardSpaces.leidsePlein";
    public static final String MESSAGE_RESOURCE_LUXE_BELASTING = "monopolyBoardSpaces.luxeBelasting";
    public static final String MESSAGE_RESOURCE_KALVERSTRAAT = "monopolyBoardSpaces.kalverstraat";
    public static final String MESSAGE_RESOURCE_KANS = "monopolyBoardSpaces.kans";
    public static final String MESSAGE_RESOURCE_ALGEMEEN_FONDS = "monopolyBoardSpaces.algemeenFonds";

    public static String[] getBoardNames() {
        String[] boardNames = new String[NR_OF_BOARDSPACES];
        boardNames[SPACENR_START] = MESSAGE_RESOURCE_START;
        boardNames[SPACENR_DORPSSTRAAT] = MESSAGE_RESOURCE_DORPSSTRAAT;
        boardNames[SPACENR_ALGEMEEN_FONDS_1] = MESSAGE_RESOURCE_ALGEMEEN_FONDS;
        boardNames[SPACENR_BRINK] = MESSAGE_RESOURCE_BRINK;
        boardNames[SPACENR_INKOMSTENBELASTING] = MESSAGE_RESOURCE_INKOMSTENBELASTING;
        boardNames[SPACENR_KANS_1] = MESSAGE_RESOURCE_KANS;
        boardNames[SPACENR_KETELSTRAAT] = MESSAGE_RESOURCE_KETELSTRAAT;
        boardNames[SPACENR_VELPERPLEIN] = MESSAGE_RESOURCE_VELPERPLEIN;
        boardNames[SPACENR_GEVANGENIS] = MESSAGE_RESOURCE_GEVANGENIS;
        boardNames[SPACENR_BARTELJORISSTRAAT] = MESSAGE_RESOURCE_BARTELJORISSTRAAT;
        boardNames[SPACENR_ELEKTRICITEITSBEDRIJF] = MESSAGE_RESOURCE_ELEKTRICITEITSBEDRIJF;
        boardNames[SPACENR_ZIJLWEG] = MESSAGE_RESOURCE_ZIJLWEG;
        boardNames[SPACENR_GROTE_HOUTSTRAAT] = MESSAGE_RESOURCE_GROTE_HOUTSTRAAT;
        boardNames[SPACENR_STATION_WEST] = MESSAGE_RESOURCE_STATION_WEST;
        boardNames[SPACENR_NEUDE] = MESSAGE_RESOURCE_NEUDE;
        boardNames[SPACENR_ALGEMEEN_FONDS_2] = MESSAGE_RESOURCE_ALGEMEEN_FONDS;
        boardNames[SPACENR_BILTSTRAAT] = MESSAGE_RESOURCE_BILTSTRAAT;
        boardNames[SPACENR_VREEBURG] = MESSAGE_RESOURCE_VREEBURG;
        boardNames[SPACENR_VRIJ_PARKEREN] = MESSAGE_RESOURCE_VRIJ_PARKEREN;
        boardNames[SPACENR_A_KERKHOF] = MESSAGE_RESOURCE_A_KERKHOF;
        boardNames[SPACENR_KANS_2] = MESSAGE_RESOURCE_KANS;
        boardNames[SPACENR_GROTE_MARKT] = MESSAGE_RESOURCE_GROTE_MARKT;
        boardNames[SPACENR_HEERESTRAAT] = MESSAGE_RESOURCE_HEERESTRAAT;
        boardNames[SPACENR_STATION_NOORD] = MESSAGE_RESOURCE_STATION_NOORD;
        boardNames[SPACENR_SPUI] = MESSAGE_RESOURCE_SPUI;
        boardNames[SPACENR_PLEIN] = MESSAGE_RESOURCE_PLEIN;
        boardNames[SPACENR_WATERLEIDING] = MESSAGE_RESOURCE_WATERLEIDING;
        boardNames[SPACENR_LANGE_POTEN] = MESSAGE_RESOURCE_LANGE_POTEN;
        boardNames[SPACENR_GA_NAAR_DE_GEVANGENIS] = MESSAGE_RESOURCE_GA_NAAR_DE_GEVANGENIS;
        boardNames[SPACENR_HOFPLEIN] = MESSAGE_RESOURCE_HOFPLEIN;
        boardNames[SPACENR_BLAAK] = MESSAGE_RESOURCE_BLAAK;
        boardNames[SPACENR_ALGEMEEN_FONDS_3] = MESSAGE_RESOURCE_ALGEMEEN_FONDS;
        boardNames[SPACENR_COOLSINGEL] = MESSAGE_RESOURCE_COOLSINGEL;
        boardNames[SPACENR_STATION_OOST] = MESSAGE_RESOURCE_STATION_OOST;
        boardNames[SPACENR_KANS_3] = MESSAGE_RESOURCE_KANS;
        boardNames[SPACENR_LEIDSE_PLEIN] = MESSAGE_RESOURCE_LEIDSE_PLEIN;
        boardNames[SPACENR_LUXE_BELASTING] = MESSAGE_RESOURCE_LUXE_BELASTING;
        boardNames[SPACENR_KALVERSTRAAT] = MESSAGE_RESOURCE_KALVERSTRAAT;
        return boardNames;
    }
}
