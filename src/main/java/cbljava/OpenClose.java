package cbljava;

import com.couchbase.lite.CouchbaseLite;
import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.DatabaseConfiguration;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class OpenClose {
    public static void main (String [] args) throws CouchbaseLiteException, IOException {
        CouchbaseLite.init();
        int i = 0;

        while (true) {
            String uuid = UUID.randomUUID().toString();
            String path = "/tmp/cbljava/";
            DatabaseConfiguration config = new DatabaseConfiguration().setDirectory(path);
            Database db = new Database(uuid, config);
            db.close();
            FileUtils.deleteDirectory(new File(path + uuid));
            if (i % 100 == 0) {
                System.out.println(i);
            }
            i++;
        }
    }
}
