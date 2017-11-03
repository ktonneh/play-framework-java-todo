package models;

import play.data.format.Formats;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by elkibet on 10/31/2017.
 */

@Entity
@Table(name = "tbl_users")
public class User extends Model {

    @Id
    public Long id;

    public String username;

    public String password;


    public String name;

    @Formats.DateTime(pattern = "yyyy-MM-dd hh:mm:ss")
    public Date createdOn = new Date();

    public static Finder<Long,User> finder=new Finder(Long.class,User.class);





}
