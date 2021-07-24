import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

public class BNLtest {
    /**
    SFS:
    runTime(ms):438
    runTime(s):0.438
    size of SP set:5073
    size of node set:10000
    
    BNL:
    runTime(ms):653
    runTime(s):0.653
    size of SP set:5073
    size of node set:10000
    
    violent:
    runTime(ms):1400
    runTime(s):1.4
    size of SP set:5073
    size of node set:10000
    
     * @throws FileNotFoundException
     */
    @Test
    public void BNLTest() throws FileNotFoundException {
        skylinequery sfs = new skylinequery("C:\\Users\\xr\\Desktop\\Code\\java\\skylinequery\\input\\qws_10k_10.txt",
                "SFS");
        Long runTimem = sfs.getRunTimem();
        Double runTimes = sfs.getRunTimes();
        List<Node> SPList = sfs.getSPList();
        int SPsize = SPList.size();
        int NodeListSize = sfs.getListSize();
        System.out.println("SFS:\nrunTime(ms):" + runTimem + "\nrunTime(s):" + runTimes + "\nsize of SP set:" + SPsize
                + "\nsize of node set:" + NodeListSize + "\n");

        skylinequery bnl = new skylinequery("C:\\Users\\xr\\Desktop\\Code\\java\\skylinequery\\input\\qws_10k_10.txt",
                "BNL");
        Long runTimemb = bnl.getRunTimem();
        Double runTimesb = bnl.getRunTimes();
        List<Node> SPListb = bnl.getSPList();
        int SPsizeb = SPListb.size();
        int NodeListSizeb = bnl.getListSize();
        System.out.println("BNL:\nrunTime(ms):" + runTimemb + "\nrunTime(s):" + runTimesb + "\nsize of SP set:"
                + SPsizeb + "\nsize of node set:" + NodeListSizeb + "\n");

        skylinequery violent = new skylinequery(
                "C:\\Users\\xr\\Desktop\\Code\\java\\skylinequery\\input\\qws_10k_10.txt", " ");
        Long runTimemv = violent.getRunTimem();
        Double runTimesv = violent.getRunTimes();
        List<Node> SPListv = violent.getSPList();
        int SPsizev = SPListv.size();
        int NodeListSizev = violent.getListSize();
        System.out.println("violent:\nrunTime(ms):" + runTimemv + "\nrunTime(s):" + runTimesv + "\nsize of SP set:"
                + SPsizev + "\nsize of node set:" + NodeListSizev + "\n");
    }
}