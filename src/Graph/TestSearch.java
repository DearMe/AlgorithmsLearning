package Graph;

import java.io.DataInputStream;
import java.io.InputStream;

/**
 * Created by ruanqx on 2015/10/13.
 */
public class TestSearch{
    public Graph read(String path) throws Exception{
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path);
        System.out.println(path);
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int a = dataInputStream.readInt();
        System.out.println(a);
        return null;
    }
    public static void main(String[] args){
        TestSearch testSearch = new TestSearch();
        try {
            Graph G = testSearch.read("C:/Users/ruanqx/Desktop/inputFile.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
