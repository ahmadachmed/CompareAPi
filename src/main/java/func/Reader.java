package func;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Reader {
    private HashMap<Object, Object> urlHash;

    public Reader(){}

    public Object[][] fileData() throws IOException {
        urlHash = new HashMap<Object,Object>();
        String File1 = "src/main/resources/file1.txt";
        String File2 = "src/main/resources/file2.txt";
        BufferedReader url11Br = new BufferedReader(new FileReader(File1));
        BufferedReader url12Br = new BufferedReader(new FileReader(File2));

        while (true) {
            String url1 = url11Br.readLine();
            String url2 = url12Br.readLine();
            if (url1 == null || url2 == null)
                break;
            urlHash.put(url1,url2);
        }

        Object[][] twoDarray = new Object[urlHash.size()][2];
        Object[] keys = urlHash.keySet().toArray();
        Object[] values = urlHash.values().toArray();

        for (int row = 0; row < twoDarray.length; row++) {
            twoDarray[row][0] = keys [row];
            twoDarray[row][1] = values[row];
        }
    return twoDarray;
    }
}
