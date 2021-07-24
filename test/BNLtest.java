import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

public class BNLtest {
    /**
     * TestAlgori:0.69s
     * @throws FileNotFoundException
     */
    @Test
    public void BNLTest() throws FileNotFoundException {
        skylinequery bnl = new skylinequery("D:\\FilesFromC\\code\\java\\skylinequery\\input\\qws_10k_10.txt", "BNL");
        Long runTimem = bnl.getRunTimem();
        Double runTimes = bnl.getRunTimes();
        List<Node> SPList = bnl.getSPList();
        int SPsize = SPList.size();
        int NodeListSize = bnl.getListSize();
        System.out.println("runTime(ms):" + runTimem + "\nrunTime(s):" + runTimes + "\nsize of SP set:" + SPsize
                + "\nsize of node set:" + NodeListSize);
    }
}