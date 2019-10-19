package dao.repositorys;


import com.sun.istack.internal.NotNull;
import modules.UserEntity;
import org.hibernate.Session;
import util.HibernateHelper;

import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.Optional;

public class PermissionCheckerDao {

    private static HibernateHelper dbConnection = HibernateHelper.getInstance();

    public Optional<UserEntity> findUserByNameAndPassword(@NotNull String userName, @NotNull String password) {
        Session theSession = dbConnection.beginTransactionIfAllowed();
        Query query = theSession.createNamedQuery("UserEntity.findUserByName");
        query.setParameter("userName", userName);
        query.setParameter("password", password);
        try {
            UserEntity users = (UserEntity) query.getSingleResult();
            theSession.close();
            return Optional.of(users);
        } catch (Throwable e) {
            e.printStackTrace();
            theSession.close();
            return Optional.empty();
        }
    }

}
