import java.util.Arrays;

/**
 * @描述： TODO  看 Arrays.sort方法中是否是运用了模板方法
 * @作者: Light
 * @时间: 2019/9/6  8:43
 * @版本：
 */
public class SortTest implements Comparable<SortTest>{
    private int weight ;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public SortTest(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "SortTest{" +
                "weight=" + weight +
                '}';
    }

    public static void main(String[] args) {
       SortTest [] sortTests = new SortTest [] {new SortTest(11),new SortTest(12)};
        Arrays.sort(sortTests);
        for (SortTest test : sortTests ) {
            System.out.println(test);
        }
    }

    @Override
    public int compareTo(SortTest o) {
        if (this.weight >  o.weight ) {
            return -1;
        }
        else if (this.weight < o.weight) {
            return 1;
        }
        return 0;
    }
}
