package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.UserVO;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.login;
import views.html.register;

public class Application extends Controller {

    public static Result index() {
        return ok(login.render("Login || TODO"));
    }

	public static Result register(){
		return ok(register.render("Register || TODO"));		
	}

	public static Result doLogin(){
        DynamicForm form= Form.form().bindFromRequest();
        Logger.info(form.get("username"));
        ObjectNode result = Json.newObject();

        String username=form.get("username");
        String password=form.get("password");

        UserVO userVO=UserVO.findByUsername(username);
        if (userVO!=null){
            //check password
            if (!userVO.password.equals(password)){
                result.put("code","201");
                result.put("message","Invalid Password!!");
                return ok(result);
            }
        } else {
            result.put("code","201");
            result.put("message","Invalid Username!!");
            return ok(result);
        }
        result.put("200","Success");
        result.put("message","Login Success!!");
	    return ok(result);
    }

    public static Result doRegister(){
	    ObjectNode majibu=Json.newObject();

	    DynamicForm staney=Form.form().bindFromRequest();
	    String username = staney.get("username");
	    String password = staney.get("password");
	    //String username = frm.get("username");

//        Logger.info("");
        //check if username exists
        if (UserVO.findByUsername(username) !=null){
            majibu.put("message","User "+ username +" already exists !!");
            majibu.put("code","201");
            return  ok(majibu);
        }

        UserVO userVO=new UserVO();
        userVO.username = username.toLowerCase();
        userVO.password = password;
        userVO.save();
        //Ebean.save(userVO);

        Logger.info("Username"+username);
        majibu.put("message","User "+ username +" created successfully! Yeey");
        majibu.put("code","200");

	    return ok(majibu);
    }
	
	

}
