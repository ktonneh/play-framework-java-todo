package models;

import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Elkibet on 10/31/2017.
 */
@Entity
@Table(name = "tbl_users_test")
public class UserVO extends Model {

    //ORM - object relational mapping

    @Id
    public Long id;

    //@Column(unique = true,nullable = false)
    public String username;

    public String name;

    public String email;

    public String password;

    public static Finder<Long,UserVO> find=new Finder<Long, UserVO>(Long.class,UserVO.class);


    /**
     * Check for a unique user with given username
     * @param username
     * @return
     */
    public static UserVO findByUsername(String username){
        //select 1 from tbl_users where username = username;

//        find.where()
//                .eq("username","admin")
//                .eq("password","password")
//                .and()


        return find.where().eq("username",username).findUnique();
    }


}
