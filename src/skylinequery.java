import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * skyline query BNL算法
 * 输入:十维向量集
 * 输出：所有skyline point构成的集合
 * 
 * skyline point:不被其它任意点支配的点
 * 支配(dominate):if 向量a的每一个维度都小于等于向量b的对应维度，且不全等，则b dominates a;
 *                相等向量间互不支配
 * 
 * BNL：遍历输入集中的每一个点，与其它所有点比较，被某一个点支配，则它不是SP，否则加入输出集
 */

public class skylinequery {
    private final List<Node> nodeList = new ArrayList<>();
    private Double runTimes;
    private Long runTimem;
    private final List<Node> SPList = new ArrayList<>();

    /**
     * nodeList:点集
     * runTimes:算法运行时间 s
     * runTimem:   ms
     * SPList:输出集，SP点集
     */

    /**
     * "input\\qws_10k_10.txt"
     * @param inputFileName
     * @throws FileNotFoundException
     */
    public skylinequery(String inputFileName, String alg) throws FileNotFoundException {
        BuildFromFile(inputFileName);
        if (alg.equals("BNL"))
            BNLAlgorithm();
        else
            TestAlgorithm();

    }

    /**
     * get the size of the nodes list
     * @return
     */
    public int getListSize() {
        return nodeList.size();
    }

    /**
     * get run time (s)
     * @return
     */
    public Double getRunTimes() {
        return runTimes;
    }

    /**
     * get run time (ms)
     * @return
     */
    public Long getRunTimem() {
        return runTimem;
    }

    /**
     * get SP set
     * @return
     */
    public List<Node> getSPList() {
        return new ArrayList<>(SPList);
    }

    /**
     * 从文件构造向量集
     * 
     * @param file
     * @throws FileNotFoundException
     */
    private void BuildFromFile(String file) throws FileNotFoundException {
        String str = file;
        Scanner scanner = new Scanner(new File(str));
        while (true) {
            if (!scanner.hasNextLine())
                break;
            String strs = scanner.nextLine();
            String[] strss = strs.split(",");
            nodeList.add(new Node(Double.valueOf(strss[0]), Double.valueOf(strss[1]), Double.valueOf(strss[2]),
                    Double.valueOf(strss[3]), Double.valueOf(strss[4]), Double.valueOf(strss[5]),
                    Double.valueOf(strss[6]), Double.valueOf(strss[7]), Double.valueOf(strss[8]),
                    Double.valueOf(strss[9])));

        }
        scanner.close();

    }

    /**
     * BNL
     * 
     * 1.读入一个点到空的窗口
     * 2.读入一个点p，遍历窗口中所有的点，若存在一个点q能支配p，则p不是SP，否则将p加入窗口
     *                                 若q被p支配，则将q移出窗口
     * 3.循环2直至读完所有点
     * 
     */
    private void BNLAlgorithm() {
        long startTime = System.currentTimeMillis();

        int size = nodeList.size();
        List<Node> window = new ArrayList<>();
        int index = 0;
        window.add(nodeList.get(index++));

        while (index < size) {
            Node newnode = nodeList.get(index++);

            boolean AddNewNode = true;
            int windowsize = window.size();
            for (int i = 0; i < windowsize;) {
                if (newnode.IsDominatedBy(window.get(i))) {
                    AddNewNode = false;
                    break;
                }
                if (window.get(i).IsDominatedBy(newnode)) {
                    window.remove(window.get(i));
                    windowsize--;
                } else
                    i++;
            }
            if (AddNewNode)
                window.add(newnode);
        }
        long endTime = System.currentTimeMillis();
        runTimem = (endTime - startTime);
        runTimes = (double) runTimem / 1000;
    }

    private void TestAlgorithm() {
        long startTime = System.currentTimeMillis();

        int size = nodeList.size();
        for (int i = 0; i < size; i++) {
            boolean IsSP = true;
            for (int j = 0; j < size; j++) {
                //被支配则不是SP
                if (nodeList.get(i).IsDominatedBy(nodeList.get(j))) {
                    IsSP = false;
                    break;
                }
            }
            if (IsSP)
                SPList.add(nodeList.get(i));
        }
        long endTime = System.currentTimeMillis();
        runTimem = (endTime - startTime);
        runTimes = (double) runTimem / 1000;
    }

}

class Node {
    public final double[] fields = new double[10];

    Node(double f0, double f1, double f2, double f3, double f4, double f5, double f6, double f7, double f8, double f9) {
        fields[0] = f0;
        fields[1] = f1;
        fields[2] = f2;
        fields[3] = f3;
        fields[4] = f4;
        fields[5] = f5;
        fields[6] = f6;
        fields[7] = f7;
        fields[8] = f8;
        fields[9] = f9;
    }

    /**
     * this存在一个维度的值小于that => false
     * this == that => false
     * 否则true
     * @param that
     * @return
     */
    public boolean IsDominatedBy(Node that) {
        boolean allZero = true;//是否全等
        int size = fields.length;
        for (int i = 0; i < size; i++) {
            if (this.fields[i] < that.fields[i])
                return false;
            if (allZero)
                if (this.fields[i] > that.fields[i])
                    allZero = false;
        }
        if (allZero)
            return false;
        else
            return true;
    }
}