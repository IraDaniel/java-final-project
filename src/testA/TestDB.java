package testA;

import com.company.entity.Order;
import com.company.entity.User;
import com.company.mysql.MySQLOrderDao;
import com.company.mysql.MySQLProductDao;
import com.company.mysql.MySQLUserDao;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ira on 29.01.2016.
 */
public class TestDB {

    @Test
    public void testAddUser(){

        MySQLOrderDao mySQLOrderDao = new MySQLOrderDao();
        Order order = mySQLOrderDao.findById(14);
        System.out.println(order.getIdProduct());

       // MySQLUserDao mySQLMySQLUserDao = new MySQLUserDao();
       // System.out.println(mySQLMySQLUserDao.findByLoginPass("ivan", "pass").getName());

       /* MySQLOrderDao mySQLOrderDao = new MySQLOrderDao();
        List<Order> basket = mySQLOrderDao.findByIdUser(9);
        System.out.println(basket.size());*/
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
       /* MySQLUserDao mySQLUserDao = new MySQLUserDao();
        MySQLOrderDao mySQLOrderDao = new MySQLOrderDao();
        MySQLProductDao mySQLProductDao = new MySQLProductDao();

        List<User> userList = mySQLUserDao.findAll();
        List<Double> debtList = new ArrayList<>();
        double debt = 0.0;

        for(User user: userList){
            List<Order> orderList = mySQLOrderDao.findByIdUser(user.getId());
            for(Order order: orderList){
                debt+= (mySQLProductDao.findById(order.getIdProduct()).getPrice()*order.getNumber());
            }
            debtList.add(debt);

        }*/

    }

}


