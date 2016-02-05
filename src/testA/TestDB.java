package testA;

import com.company.entity.Order;
import com.company.mysql.MySQLOrderDao;
import org.junit.Test;

import java.util.List;


/**
 * Created by Ira on 29.01.2016.
 */
public class TestDB {

    @Test
    public void testAddUser(){


       // MySQLUserDao mySQLMySQLUserDao = new MySQLUserDao();
       // System.out.println(mySQLMySQLUserDao.findByLoginPass("ivan", "pass").getName());

        MySQLOrderDao mySQLOrderDao = new MySQLOrderDao();
        List<Order> basket = mySQLOrderDao.findByIdUser(9);
        System.out.println(basket.size());
       /* Order order = new Order();
        order.setId(1);
        order.initOrder(1,1,1,false);
        mySQLOrderDao.delete(1);
        */
       // mySQLOrderDao.save(order);
        /*String name = "имя";
        String surname = "фамилия";
        String login = "login";
        String password = "password";
        // TODO: save to DB new user
        User user = new User();
        user.initUser(name,surname,login,password,false);

        mySQLMySQLUserDao.save(user);
*/





    }

}


