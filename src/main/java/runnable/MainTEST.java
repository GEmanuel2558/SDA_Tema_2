package runnable;

import dao.repositorys.PermissionCheckerDao;
import util.HibernateHelper;

public class MainTEST {
    public static void main(String[] args) {
        System.out.println("Functioneaza");
        //Demo only. The below line will pe deleted.
        PermissionCheckerDao a =new PermissionCheckerDao();
        a.findUserByNameAndPassword("Emanuel", "a26e622917d97103958043fc757d1364d684e7d2eb262b1b4e64ec666b042f58");
    }
}
