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

        ObjectNode result = null;
        result = Json.newObject();
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

        UserVO userVO=new UserVO();
        userVO.username = username;
        userVO.password = password;
        userVO.save();
        //Ebean.save(userVO);

        Logger.info("Username"+username);

        majibu.put("message","User "+ username +" created successfully! Yeey");
        majibu.put("code","200");
	    return ok(majibu);
    }
	
	

}
