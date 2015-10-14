package Graph;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * Created by ruanqx on 2015/10/13.
 */
public class TestSearch{
    public Graph read(String path) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(path);
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        int i;
        int ex_i = 47;
        int num = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while((i = dataInputStream.read()) != -1){
            if(i<48 || i>57) {
                if(ex_i>=48 && ex_i<=57){
                    result.add(num);
                    num = 0;
                }
            }
            else{
                num = num*10 + (i-48);
            }
            ex_i = i;
        }
        result.add(num);
        return new Graph(result);
    }
    public static void main(String[] args) throws Exception{
        TestSearch testSearch = new TestSearch();
        testSearch.read("C:\\Users\\ruanqx\\Desktop\\inputFile.txt");
    }
}
