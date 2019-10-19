package runnable;

import com.google.common.hash.Hashing;
import dao.repositorys.PermissionCheckerDao;
import util.HibernateHelper;

import java.nio.charset.StandardCharsets;

public class MainTEST {
    public static void main(String[] args) {
        System.out.println("Functioneaza");
        //Demo only. The below line will pe deleted.
        PermissionCheckerDao a =new PermissionCheckerDao();
        a.findUserByNameAndPassword("Emanuel", Hashing.sha256().hashString("Emanuel", StandardCharsets.UTF_8).toString());
    }
}
