package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery("create  table if not exists users ( " +
                " id serial not null ," +
                " name  varchar(250) not null, " +
                " lastName varchar(250) not null ," +
                " age int  not null )").executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Table created ...");

    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery("drop table if exists users").executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Table deleted ...");
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        User user = new User(name,lastName,age);
        session.save(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("Added successfully " + user);
    }


    @Override
    public void removeUserById(long id) {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("Deleted user " + user);

    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        List<User> userList = session.createQuery("from User").getResultList();
        session.getTransaction().commit();
        session.close();
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete User");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Deleted successfully...");

    }
}
