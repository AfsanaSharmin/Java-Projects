/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aib_server;

import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.ArrayList;

/**
 *
 * @author leif
 */
public class AIB_Server {
    static ArrayList<RSAKeyPair> KeyPairs=new ArrayList<RSAKeyPair>();
    static final BigInteger e=new BigInteger("65537");
    static final String RPrimeValuesPath=System.getProperty("user.home")+"/Dropbox/AIB_server/RPrimeValues";
    static RPrimeStorage r=new RPrimeStorage(RPrimeValuesPath);
    static RSAKeyPair comKeyPair=new RSAKeyPair();
    public static void setup(){
                ArrayList<BigInteger> modulus=new ArrayList<BigInteger>();
        ArrayList<BigInteger> privKeys=new ArrayList<BigInteger>();
        modulus.add(new BigInteger("113093560088496623317240475922168807606046361565832187388991877100010337685450219502491877123491819889995704339309810715526039632256114878668792723693116644004313884326090640695657654880083669857682648945350836375435281058574566457369361502755965501347234675997935790683849761551830286074263642073605233557139"));
privKeys.add(new BigInteger("56490696599737941329526591387889559879023050982179264939897128167995764445594067254124755321644692554112934331013716886391815820094544710134757443929656007299471793434458069652734150396772889095979882108557994739298669846239804264838724544439310273837341986570890181496585911751886863337687196165344097220353"));
modulus.add(new BigInteger("94189378432726077628337810661687410444207451998092197042467101919569454572072008053927574870603168273461304529055546577794605110185554300393995284095236403039005035601946866847448641010119912979100158650640942899316634411072186368898177047619599463744955345754732109123614900428111169789297621503403812839707"));
privKeys.add(new BigInteger("23358712905184810712931236350220569784239493985458481140900831705735116730394835694347999975157747439592391817000164769960414984754349665750699686473288019599295880406276524500978605362555732162164036378050728384308676254479965771162207227431382284729865908396350277753093612218465403509471879353002591446193"));
modulus.add(new BigInteger("50408566298121866690727227249412056672411817211823141928049889398276484020469746807159693740919979307843164693748410194013142563124901302612806937629765275205482164942951659978202871758987828656903247415200925749621825229393421061140241540242425511897943077204273792412845069525399787904626656597790272651213"));
privKeys.add(new BigInteger("35406831750025846306273501258406475804524668228815092121609481036221697497814728394250304133173160313684550717111258776889497407698377735678705796113813330787855549673540240770836126748405085355685971392589389685932826665980059534276530543370609197011548319249245681305500612922583521785764002678282692734333"));
modulus.add(new BigInteger("92829008142894608267515756162974653670604342262323370893810836883876262658709933702676215125020744751657020879553420173054715193786252634932743502117518775054200133220845167223735717044248925814295459806974457844841337741304949266117859362873920667550486971437609502156250784393396502834576341915169164291757"));
privKeys.add(new BigInteger("25515689651435120211957044593433105134843929711666588389476302174743228947525836485039128114837781649394228819205568014974863657183965621949104192244762239093574106594372811540798054077292443387267368860504483488296173044588317410222714523584384231075967162291427340410754663996487696487059281901260378260865"));
modulus.add(new BigInteger("77981095518091569516946227469613264528499567347012597543455672050047360995654320759129389826729682089012231072787164752612944109390698200171736302242091730004515350145687700645360040132594658700492216682063557816244418223590298532538389139741761752074366728740584753290297140658698984351105615196622407012983"));
privKeys.add(new BigInteger("75265791796952595172107872172824313712105225026096431902761623747283913205976991006892740795120100714717925393428934898248802655591629379615532901999229614656299376713359642054392832606296001872969404809538747750020777269221043996384418709609276520749523457481828766400002133273674951158704962854075386256393"));
modulus.add(new BigInteger("143203233446578078909219630222289636971664247118085176270057990506198075186085344046309304696449501583620041471265175963955921902151196538100412169583042150186151748168808485711501302359923705647058165517705022025928080894221793281422884417987985410675813192103952264899733770650968090448898538568352865482343"));
privKeys.add(new BigInteger("12118423679672887462510216659487286977506598021223131781951288819252857545844779560871437567275110789062006957896099392649946486249455055927260721310214865369913978255174796637210102849185580789658613701976224016942175612008872489898278178130151257796465607552176552095745679005488604385123770632594561627057"));
modulus.add(new BigInteger("78968606507036400627100806847161601060184427848465037528335080512686384931092286609491123102118152989787976794936616709600176846495179149268956642969131814046721588640763327162409566561929649764512099384788304009929431120731178031742284415342313843984269795334626337273804335830914632416460671153119900694561"));
privKeys.add(new BigInteger("21621567590250715974986601127080393814546735024686156421692245368565001315341257471668045729044785956768778790734129579276829475464386448181670781412608159541266521975411468558629317757045215345212677041447416781935050796373593144404980391721502138262482651842470248269937327871275099328792589168831211340257"));
modulus.add(new BigInteger("99640568265479241140257640996102362108409327832699900825683935202213428167433861348539674190944143478585032629913391482916931610441919737143734354852214367389188175242735021578579857498982529620462790175769307182739577140098128322962370270516309211396350934907546985182129912262944368452978943503466970017519"));
privKeys.add(new BigInteger("23421318554857679017435478577673022693746215042842088777631887663306191325805554634393604847818705926234072778183557315628352403357763912762244651670023986728175401352861317102885857938607713590523095626788881423041840735871096198292932445607148750924546084840360501797346013610662679299672016841263137833673"));
modulus.add(new BigInteger("84969900270477720045523119163552020626306232131278079445167633344819942278018012928852666879578088390622829572811767762764924464464014374611762809647497123297342030290935165613901876878097907714107616124331828933885687314755143535575070911235239647533272196047268853794752480989989539327470418986308818417371"));
privKeys.add(new BigInteger("13170029860193671974951917916037679868196876664930081190838958443576620438227367370054860462986621631627122126441886826283871747410248531628031289506679823446980081076212106729509849763736866413267698559857078729474055651096945055342846723886956510094123854443329673865162290708298446298727952275204096139569"));
modulus.add(new BigInteger("61205725594934963530778383944211975734497638684814552622576693033472771206515569943998089437974304601170339233536132995086327745403042444833085971719164372758792993731559341549445994599455849047005730025349905428924009630737580078077131523400328357433162298305593361069144306567729774891613659287888231375123"));
privKeys.add(new BigInteger("53245068180478616289733555149173098746523549664118468783602621418700628725713294615517388240646185028709348165488129613025570345738493658654938897197380372642129853510193181895103897049401125883637223254267042140695618127839233383192454330702738795049261114484543052786714236597249056040199264425924014618345"));
for (int i=0; i<10; i++){
    KeyPairs.add(new RSAKeyPair());
    KeyPairs.get(i).modulus=modulus.get(i);
    KeyPairs.get(i).pub=e;
    KeyPairs.get(i).pri=privKeys.get(i);
}
comKeyPair.pri=new BigInteger("83374156446774429873694550481645812108834138335187533508679883506841478344454653407583462002728379160005936010232152845900203607261418110281030190618566505266984514447967618960101472648126527225429103019628649092001207451156000110046429132143123004788038578362511400808819284172666518163971226737327430819985");
comKeyPair.pub=e;
comKeyPair.modulus=new BigInteger("95812518035600410503994805360704581672073207036300573104181267870519734981509839211152174319605986165096863495810633205242273997599318920084305802356152031410095278243554997838911172683159778396002043381602230364061683476559432122157675368167117435777718607888823487551080217245394174274812214070625155618899");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        setup();
        ServerSocket S=new ServerSocket(5020);
        boolean running=true;
        while(running){
            Socket s=S.accept();
            (new RequestThread(s)).start();
        }
        // TODO code application logic here
    }
    public static String processTx(String s){
        return "";
    }
    public static String processRPrime(String s){
        byte[] b=Hex.decodeHex(s.toCharArray());
        int num=(int)b[0];
        System.out.print(num+" R' values requested. ");
        ArrayList<Integer> denomIDs=new ArrayList<Integer>();
        for (int i=0; i<num; i++){
            denomIDs.add(new Integer(b[i+1]));
        }
        byte[] pubKey=new byte[128];
        for (int i=0; i<128; i++){
            pubKey[i]=b[i+1+num];
        }
        BigInteger PubKey=new BigInteger(pubKey);
        System.out.print("pubkey is");
        snip(PubKey);
        
        ArrayList<BigInteger> RPrimeValues=new ArrayList<BigInteger>();
        for (int i=0; i<num; i++){
            BigInteger X=new BigInteger(1000,new SecureRandom());
            synchronized(r){
                r.RPrimeValues.add(X);
                r.denomIDs.add(denomIDs.get(i));
            }
            
            BigInteger RPrimeValue=X.modPow(e,PubKey);
            System.out.print(",");
            snip(X);
            String S=RPrimeValue.toString(16);
            
            RPrimeValues.add(RPrimeValue);
            
        }
        //System.out.println(RPrimeValues);
        String result="";
        for (int i=0; i<num; i++){
            result+=Hex.encodeHexString(to128(RPrimeValues.get(i).toByteArray()));
        }
        System.out.println();
        //System.out.println(result);
        new Thread(){
            public void run(){
                synchronized(r){
            r.save();
        }
            }
        }.start();
        
        return result;
    }
    public static byte[] to128(byte[] x){
        byte[] X=new byte[128];
        int offset=128-x.length;
        int W=0;
        if (x[0]==0){
            W++;
            offset++;
        }
        for (int i=0; i<x.length-W; i++){
            X[i+offset]=x[i];
        }
        return X;
    }
    public static void snip(BigInteger x){
        System.out.print(x.toString(16).substring(0,8)+"..."+x.toString(16).substring(x.toString(16).length()-8,x.toString(16).length()));
    }
}
